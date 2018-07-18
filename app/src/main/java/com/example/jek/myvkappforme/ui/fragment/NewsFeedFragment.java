package com.example.jek.myvkappforme.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.jek.myvkappforme.MyApplication;
import com.example.jek.myvkappforme.R;
import com.example.jek.myvkappforme.common.utils.VkListHelper;
import com.example.jek.myvkappforme.model.WallItem;
import com.example.jek.myvkappforme.model.view.BaseViewModel;
import com.example.jek.myvkappforme.model.view.NewsItemBodyViewModel;
import com.example.jek.myvkappforme.model.view.NewsItemFooterViewModel;
import com.example.jek.myvkappforme.model.view.NewsItemHeaderViewModel;
import com.example.jek.myvkappforme.mvp.presenter.BaseFeedPresenter;
import com.example.jek.myvkappforme.mvp.presenter.NewsFeedPresenter;
import com.example.jek.myvkappforme.rest.api.WallApi;
import com.example.jek.myvkappforme.rest.model.request.WallGetRequestModel;
import com.example.jek.myvkappforme.rest.model.response.GetWallResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeedFragment extends BaseFeedFragment {

    @InjectPresenter
    NewsFeedPresenter mPresenter;

    @Inject
    WallApi mWallApi;

    public NewsFeedFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }

    @Override
    protected BaseFeedPresenter onCreateFeedPresenter() {
        return mPresenter;
    }
}
