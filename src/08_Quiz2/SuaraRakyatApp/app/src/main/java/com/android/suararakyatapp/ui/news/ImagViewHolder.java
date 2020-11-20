package com.android.suararakyatapp.ui.news;

import android.view.View;

import androidx.annotation.NonNull;

import com.android.suararakyatapp.data.NewsItem;
import com.android.suararakyatapp.databinding.ItemNewsImageBinding;
import com.android.suararakyatapp.databinding.ItemNewsTextBinding;

public class ImagViewHolder extends BaseViewHolder{

    ItemNewsImageBinding itemNewsImageBinding;

    public ImagViewHolder(@NonNull ItemNewsImageBinding itemNewsImageBinding) {
        super(itemNewsImageBinding.getRoot());
        this.itemNewsImageBinding = itemNewsImageBinding;
    }

    @Override
    public void bindData(NewsItem item) {
        itemNewsImageBinding.setNewsItemImage(item);
    }

    @Override
    public ItemNewsTextBinding getItemNewsTextBinding() {
        return null;
    }

    @Override
    public ItemNewsImageBinding getItemNewsImageBinding() {
        return null;
    }
}
