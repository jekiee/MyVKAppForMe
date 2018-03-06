package com.example.jek.myvkappforme.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.jek.myvkappforme.CurrentUser;
import com.example.jek.myvkappforme.mvp.view.MainView;

/**
 * Created by jek on 27.02.2018.
 */

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    public void checkAuth(){
        if(!CurrentUser.authorized()){
            getViewState().startSignIn();
        } else{
            getViewState().signedIn();
        }
    }
}
