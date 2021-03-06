package com.example.jek.myvkappforme.di.component;

import com.example.jek.myvkappforme.common.manager.NetworkManager;
import com.example.jek.myvkappforme.di.module.ApplicationModule;
import com.example.jek.myvkappforme.di.module.ManagerModule;
import com.example.jek.myvkappforme.di.module.RestModule;
import com.example.jek.myvkappforme.mvp.presenter.NewsFeedPresenter;
import com.example.jek.myvkappforme.ui.activity.BaseActivity;
import com.example.jek.myvkappforme.ui.activity.MainActivity;
import com.example.jek.myvkappforme.ui.fragment.NewsFeedFragment;
import com.example.jek.myvkappforme.ui.holder.NewsItemBodyHolder;
import com.example.jek.myvkappforme.ui.holder.NewsItemFooterHolder;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {

    //activities
    void inject(BaseActivity activity);
    void inject(MainActivity activity);

    //fragments
    void inject(NewsFeedFragment fragment);

    //holders
    void inject(NewsItemBodyHolder holder);

    void inject(NewsItemFooterHolder holder);

    //presenters
    void inject(NewsFeedPresenter presenter);

    //managers
    void inject(NetworkManager manager);
}
