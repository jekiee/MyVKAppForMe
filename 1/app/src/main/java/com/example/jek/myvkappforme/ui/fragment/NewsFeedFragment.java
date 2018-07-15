package com.example.jek.myvkappforme.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.jek.myvkappforme.MyApplication;
import com.example.jek.myvkappforme.R;
import com.example.jek.myvkappforme.common.BaseAdapter;
import com.example.jek.myvkappforme.common.utils.VkListHelper;
import com.example.jek.myvkappforme.model.WallItem;
import com.example.jek.myvkappforme.model.view.BaseViewModel;
import com.example.jek.myvkappforme.model.view.NewsItemBodyViewModel;
import com.example.jek.myvkappforme.model.view.NewsItemHeaderViewModel;
import com.example.jek.myvkappforme.rest.api.WallApi;
import com.example.jek.myvkappforme.rest.model.request.WallGetRequestModel;
import com.example.jek.myvkappforme.rest.model.response.GetWallResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeedFragment extends BaseFragment {

    @Inject
    WallApi mWallApi;

    RecyclerView mRecyclerView;

    BaseAdapter mAdapter;

    public NewsFeedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpRecyclerView(view);
        setUpAdapter(mRecyclerView);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mWallApi.get(new WallGetRequestModel(-86529522).toMap()).enqueue(new Callback<GetWallResponse>() {
            @Override
            public void onResponse(Call<GetWallResponse> call, Response<GetWallResponse> response) {
                List<WallItem> wallItems = VkListHelper.getWallList(response.body().response);
                List<BaseViewModel> list = new ArrayList<>();
                for (WallItem item : wallItems) {
                    list.add(new NewsItemHeaderViewModel(item));
                    list.add(new NewsItemBodyViewModel(item));
                }
                mAdapter.addItems(list);
            }

            @Override
            public void onFailure(Call<GetWallResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void setUpRecyclerView(View rootView) {
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    protected void setUpAdapter(RecyclerView rv) {
        mAdapter = new BaseAdapter();
        rv.setAdapter(mAdapter);
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }
}