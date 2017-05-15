package com.sujin.sqlitetest.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sujin.sqlitetest.entity.Users;

import java.util.ArrayList;

/**
 * Created by Sujin on 5/14/2017.
 */

public class DatabaseManager {

    SQLiteDatabase db;
    public static DatabaseManager INSTANCE;

    public DatabaseManager(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        this.db = dbHelper.getWritableDatabase();
    }

    public DatabaseManager getNewInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseManager(context);
        }
        return INSTANCE;
    }

    public void insertUser(Users users) {
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.USER_ID, users.getId());
        cv.put(DatabaseHelper.USER_NAME, users.getName());
        cv.put(DatabaseHelper.USER_EMAIL, users.getEmail());
        cv.put(DatabaseHelper.USER_ADDRESS, users.getAddress());
        db.insert(DatabaseHelper.TBL_NAME, null, cv);
    }

    public void deleteUser(int id) {
        db.delete(DatabaseHelper.TBL_NAME, DatabaseHelper.USER_ID + "=" + id, null);
    }

    public void updateUser(int id, String uName) {
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.USER_NAME, uName);
        db.update(DatabaseHelper.TBL_NAME, cv, DatabaseHelper.USER_ID + "=" + id, null);
    }

    public ArrayList<Users> getAll() {
        String query = "SELECT * FROM " + DatabaseHelper.TBL_NAME;
        Cursor cursor = db.rawQuery(query, null);
        ArrayList<Users> userList = new ArrayList<>();
        while (cursor.moveToNext()) {
            userList.add(new Users(
                    cursor.getInt(cursor.getColumnIndex(DatabaseHelper.USER_ID)),
                    cursor.getString(cursor.getColumnIndex(DatabaseHelper.USER_NAME)),
                    cursor.getString(cursor.getColumnIndex(DatabaseHelper.USER_EMAIL)),
                    cursor.getString(cursor.getColumnIndex(DatabaseHelper.USER_ADDRESS))
            ));
        }
        return userList;
    }
}
