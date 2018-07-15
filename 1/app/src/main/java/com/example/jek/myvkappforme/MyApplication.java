package com.example.jek.myvkappforme;

import android.app.Application;
import android.util.Log;

import com.example.jek.myvkappforme.di.component.ApplicationComponent;
import com.example.jek.myvkappforme.di.component.DaggerApplicationComponent;
import com.example.jek.myvkappforme.di.module.ApplicationModule;
import com.vk.sdk.VKSdk;

/**
 * Created by jek on 26.02.2018.
 */

public class MyApplication extends Application {

    private static ApplicationComponent sApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
        VKSdk.initialize(this);
    }

    private void initComponent() {
        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return sApplicationComponent;
    }
}
