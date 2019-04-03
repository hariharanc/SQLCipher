package com.codewith.sqlcipher.db;


import android.content.Context;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

public class CustomerDbHelper extends SQLiteOpenHelper {
    private static CustomerDbHelper instance;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "customer.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + CustomerTable.CustomerEntity.TABLE_NAME + " (" +
                    CustomerTable.CustomerEntity._ID + " INTEGER PRIMARY KEY," +
                    CustomerTable.CustomerEntity.COLUMN_CUS_ID + TEXT_TYPE + "," +
                    CustomerTable.CustomerEntity.COLUMN_NAME + TEXT_TYPE + "," +
                    CustomerTable.CustomerEntity.COLUMN_ADDRESS + TEXT_TYPE +
                    " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + CustomerTable.CustomerEntity.TABLE_NAME;

    public CustomerDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    static public synchronized CustomerDbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new CustomerDbHelper(context);
        }
        return instance;
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}

