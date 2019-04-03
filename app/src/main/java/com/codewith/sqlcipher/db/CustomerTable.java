package com.codewith.sqlcipher.db;

import android.provider.BaseColumns;

public final class CustomerTable {
    public CustomerTable() {
    }

    /* Inner class that defines the table contents */
    public static abstract class CustomerEntity implements BaseColumns {
        public static final String TABLE_NAME = "customer";
        public static final String COLUMN_CUS_ID = "cus_id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_ADDRESS = "address";
    }
}