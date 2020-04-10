package com.zyk.baselibrary;

import android.content.Context;

import androidx.multidex.MultiDexApplication;

import com.blankj.utilcode.util.Utils;

public class App extends MultiDexApplication {

    private static Context mApplicationContext;

    public static Context getInstance() {
        return mApplicationContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationContext = getApplicationContext();
        Utils.init(this);
    }
}
