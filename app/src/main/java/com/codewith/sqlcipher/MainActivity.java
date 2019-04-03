package com.codewith.sqlcipher;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.codewith.sqlcipher.db.CustomerDbHelper;
import com.codewith.sqlcipher.db.CustomerTable;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitializeSQLCipher();
    }

    private void InitializeSQLCipher() {
        SQLiteDatabase.loadLibs(this);
        SQLiteDatabase db = CustomerDbHelper.getInstance(this).getWritableDatabase("somePass");
        ContentValues values = new ContentValues();
        values.put(CustomerTable.CustomerEntity.COLUMN_CUS_ID, 1);
        values.put(CustomerTable.CustomerEntity.COLUMN_NAME, "Test");
        values.put(CustomerTable.CustomerEntity.COLUMN_ADDRESS, "Test Address");
        db.insert(CustomerTable.CustomerEntity.TABLE_NAME, null, values);

        Cursor cursor = db.rawQuery("SELECT * FROM '" + CustomerTable.CustomerEntity.TABLE_NAME + "';", null);
        if (cursor.moveToFirst())
            Log.d(MainActivity.class.getSimpleName(), "Rows count: " + cursor.getString(cursor.getColumnIndex("name")));
        cursor.close();
        db.close();

    }
}
