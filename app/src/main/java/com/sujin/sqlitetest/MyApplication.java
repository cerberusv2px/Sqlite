package com.sujin.sqlitetest;

import android.app.Application;

import com.sujin.sqlitetest.database.DatabaseManager;

/**
 * Created by Sujin on 5/14/2017.
 */

public class MyApplication extends Application {

    private DatabaseManager databaseManager;

    @Override
    public void onCreate() {
        super.onCreate();
        databaseManager = new DatabaseManager(this);
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }
}
