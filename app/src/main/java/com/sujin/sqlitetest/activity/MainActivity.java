package com.sujin.sqlitetest.activity;

import android.os.Bundle;
import android.util.Log;

import com.sujin.sqlitetest.R;
import com.sujin.sqlitetest.entity.Users;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mApp.getDatabaseManager().insertUser(new Users(null,"Ram","ram@gmail.com","Kathmandu"));
//        mApp.getDatabaseManager().insertUser(new Users(null,"Rama","rama@gmail.com","Kathmandu"));
//        mApp.getDatabaseManager().insertUser(new Users(null,"Ramaa","ramaa@gmail.com","Kathmandu"));
        ArrayList<Users> userList = mApp.getDatabaseManager().getAll();

        //mApp.getDatabaseManager().updateUser(4,"Shyam");
        //mApp.getDatabaseManager().deleteUser(4);
        Log.e("Users", String.valueOf(userList.size()));
        for (Users u : userList) {
            Log.e("ID Name", u.getId() + "\t" + u.getName());
        }

    }
}
