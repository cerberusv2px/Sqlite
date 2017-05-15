package com.sujin.sqlitetest.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sujin on 5/14/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TBL_NAME = "tbl_user";
    public static final String USER_ID = "id";
    public static final String USER_NAME = "name";
    public static final String USER_EMAIL = "email";
    public static final String USER_ADDRESS = "address";

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + TBL_NAME + "("
            + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + USER_NAME + " STRING, "
            + USER_EMAIL + " STRING UNIQUE,"
            + USER_ADDRESS + " STRING)";


    public DatabaseHelper(Context context) {
        super(context, "db_user", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
