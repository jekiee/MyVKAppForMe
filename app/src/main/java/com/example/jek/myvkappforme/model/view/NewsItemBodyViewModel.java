package com.example.jek.myvkappforme.model.view;

import android.view.View;

import com.example.jek.myvkappforme.model.WallItem;
import com.example.jek.myvkappforme.ui.holder.BaseViewHolder;
import com.example.jek.myvkappforme.ui.holder.NewsItemBodyHolder;

public class NewsItemBodyViewModel extends BaseViewModel {

    private int mId;

    private String mText;

    public NewsItemBodyViewModel(WallItem wallItem) {
        this.mId = wallItem.getId();
        this.mText = wallItem.getText();
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.NewsFeedItemBody;
    }

    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new NewsItemBodyHolder(view);
    }

    public int getId() {
        return mId;
    }

    public String getText() {
        return mText;
    }
}
