package com.example.jek.myvkappforme.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.example.jek.myvkappforme.MyApplication;
import com.example.jek.myvkappforme.common.utils.VkListHelper;
import com.example.jek.myvkappforme.model.view.BaseViewModel;
import com.example.jek.myvkappforme.model.view.NewsItemBodyViewModel;
import com.example.jek.myvkappforme.model.view.NewsItemFooterViewModel;
import com.example.jek.myvkappforme.model.view.NewsItemHeaderViewModel;
import com.example.jek.myvkappforme.mvp.view.BaseFeedView;
import com.example.jek.myvkappforme.rest.api.WallApi;
import com.example.jek.myvkappforme.rest.model.request.WallGetRequestModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

@InjectViewState
public class NewsFeedPresenter extends BaseFeedPresenter<BaseFeedView> {

    @Inject
    WallApi mWallApi;


    public NewsFeedPresenter() {
        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public Observable<BaseViewModel> onCreateLoadDataObservable(int count, int offset) {
        return mWallApi.get(new WallGetRequestModel(-86529522).toMap())
                .flatMap(full -> Observable.fromIterable(VkListHelper.getWallList(full.response)))
                .flatMap(wallItem -> {
                    List<BaseViewModel> baseItems = new ArrayList<>();
                    baseItems.add(new NewsItemHeaderViewModel(wallItem));
                    baseItems.add(new NewsItemBodyViewModel(wallItem));
                    baseItems.add(new NewsItemFooterViewModel(wallItem));
                    return Observable.fromIterable(baseItems);
                });
    }
}

