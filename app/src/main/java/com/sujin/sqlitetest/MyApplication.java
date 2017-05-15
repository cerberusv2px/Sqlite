package com.sujin.sqlitetest;

import android.app.Application;

import com.sujin.sqlitetest.database.DatabaseManager;



public class MyApplication extends Application {

    private DatabaseManager databaseManager;

    @Override
    public void onCreate() {
        super.onCreate();
        databaseManager = DatabaseManager.getNewInstance(this);
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }
}
