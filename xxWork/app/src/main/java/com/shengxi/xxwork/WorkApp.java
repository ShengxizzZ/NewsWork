package com.shengxi.xxwork;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

public class WorkApp extends Application {

    public static WorkApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance =this;
        init();
    }

    private void init() {

        LeakCanary.install(this);

    }

    public static WorkApp getInstance(){

        return mInstance;
    }
}