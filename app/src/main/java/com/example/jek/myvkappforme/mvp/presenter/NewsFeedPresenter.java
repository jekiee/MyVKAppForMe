package com.example.jek.myvkappforme.mvp.presenter;


import com.arellomobile.mvp.InjectViewState;
import com.example.jek.myvkappforme.MyApplication;
import com.example.jek.myvkappforme.common.utils.VkListHelper;
import com.example.jek.myvkappforme.model.WallItem;
import com.example.jek.myvkappforme.model.view.BaseViewModel;
import com.example.jek.myvkappforme.model.view.NewsItemBodyViewModel;
import com.example.jek.myvkappforme.model.view.NewsItemFooterViewModel;
import com.example.jek.myvkappforme.model.view.NewsItemHeaderViewModel;
import com.example.jek.myvkappforme.mvp.view.BaseFeedView;
import com.example.jek.myvkappforme.rest.api.WallApi;
import com.example.jek.myvkappforme.rest.model.request.WallGetRequestModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

@InjectViewState
public class NewsFeedPresenter extends BaseFeedPresenter<BaseFeedView> {

    @Inject
    WallApi mWallApi;


    public NewsFeedPresenter() {
        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public Observable<BaseViewModel> onCreateLoadDataObservable(int count, int offset) {
        return mWallApi.get(new WallGetRequestModel(-86529522, count, offset).toMap())
                .flatMap(full -> Observable.fromIterable(VkListHelper.getWallList(full.response)))
                .doOnNext(this::saveToDb)
                .flatMap(wallItem -> {
                    List<BaseViewModel> baseItems = new ArrayList<>();
                    baseItems.add(new NewsItemHeaderViewModel(wallItem));
                    baseItems.add(new NewsItemBodyViewModel(wallItem));
                    baseItems.add(new NewsItemFooterViewModel(wallItem));
                    return Observable.fromIterable(baseItems);
                });
    }

    @Override
    public Observable<BaseViewModel> onCreateRestoreDataObservable() {
        return Observable.fromCallable(getListFromRealmCallable())
                .flatMap(Observable::fromIterable)
                .flatMap(wallItem -> Observable.fromIterable(parsePojoModel(wallItem)));
    }


    private List<BaseViewModel> parsePojoModel(WallItem wallItem) {
        List<BaseViewModel> baseItems = new ArrayList<>();
        baseItems.add(new NewsItemHeaderViewModel(wallItem));
        baseItems.add(new NewsItemBodyViewModel(wallItem));
        baseItems.add(new NewsItemFooterViewModel(wallItem));
        return baseItems;
    }

    public Callable<List<WallItem>> getListFromRealmCallable() {
        return () -> {
            String[] sortFields = {"date"};
            Sort[] sortOrder = {Sort.DESCENDING};
            Realm realm = Realm.getDefaultInstance();
            RealmResults<WallItem> realmResults = realm.where(WallItem.class)
                    .findAllSorted(sortFields, sortOrder);
            return realm.copyFromRealm(realmResults);
        };
    }
}