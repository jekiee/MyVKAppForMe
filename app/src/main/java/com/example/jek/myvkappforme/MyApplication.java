package com.example.jek.myvkappforme;

import android.app.Application;

import com.vk.sdk.VKSdk;

/**
 * Created by jek on 26.02.2018.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(this);
    }
}
