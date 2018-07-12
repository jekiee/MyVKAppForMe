package com.example.jek.myvkappforme.di.module;

import com.example.jek.myvkappforme.common.manager.MyFragmentManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ManagerModule {
    @Provides
    @Singleton
    MyFragmentManager provideMyFragmentManager() {
        return new MyFragmentManager();
    }
}