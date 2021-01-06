package com.example.shoptext;

import android.app.Application;

import androidx.multidex.MultiDex;

import com.tencent.mmkv.MMKV;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        String initialize = MMKV.initialize(this);
        MultiDex.install(this);
    }
}
