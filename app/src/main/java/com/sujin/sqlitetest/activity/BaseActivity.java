package com.sujin.sqlitetest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.sujin.sqlitetest.MyApplication;

/**
 * Created by Sujin on 5/14/2017.
 */

public class BaseActivity extends AppCompatActivity {

    public MyApplication mApp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApp = (MyApplication) getApplication();
    }
}
