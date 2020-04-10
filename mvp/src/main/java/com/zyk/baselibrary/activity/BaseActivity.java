package com.zyk.baselibrary.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    protected Context context;

    protected  abstract int initLayoutResID();

    // 初始化控件
    protected abstract void initView();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayoutResID());
        context = this;
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
