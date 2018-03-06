package com.example.jek.myvkappforme.di.component;

import com.example.jek.myvkappforme.di.module.ApplicationModule;
import com.example.jek.myvkappforme.di.module.ManagerModule;
import com.example.jek.myvkappforme.di.module.RestModule;
import com.example.jek.myvkappforme.ui.activity.BaseActivity;
import com.example.jek.myvkappforme.ui.activity.MainActivity;
import com.example.jek.myvkappforme.ui.fragment.NewsFeedFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jek on 06.03.2018.
 */

@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {

    //activities
    void inject(BaseActivity activity);

    void inject(MainActivity activity);

    //fragments
    void inject(NewsFeedFragment fragment);
}
