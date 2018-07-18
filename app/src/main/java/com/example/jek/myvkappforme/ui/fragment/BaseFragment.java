package com.example.jek.myvkappforme.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.example.jek.myvkappforme.ui.activity.BaseActivity;

/**
 * Created by jek on 04.03.2018.
 */

public abstract class BaseFragment extends MvpAppCompatFragment{

    @LayoutRes
    protected abstract int getMainContentLayout();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getMainContentLayout(), container, false);
    }

    public String createToolbarTitle(Context context){
        return context.getString(onCreateToolbarTitle());
    }

    public BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }

    @StringRes
    public abstract int onCreateToolbarTitle();
}
