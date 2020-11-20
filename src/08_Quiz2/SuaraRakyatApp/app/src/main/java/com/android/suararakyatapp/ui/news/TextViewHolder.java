package com.android.suararakyatapp.ui.news;

import android.view.View;

import androidx.annotation.NonNull;

import com.android.suararakyatapp.data.NewsItem;
import com.android.suararakyatapp.databinding.ItemNewsImageBinding;
import com.android.suararakyatapp.databinding.ItemNewsTextBinding;

public class TextViewHolder extends BaseViewHolder{

    ItemNewsTextBinding itemNewsTextBinding;

    public TextViewHolder(@NonNull ItemNewsTextBinding itemNewsTextBinding) {
        super(itemNewsTextBinding.getRoot());
        this.itemNewsTextBinding = itemNewsTextBinding;
    }

    @Override
    public void bindData(NewsItem item) {
        itemNewsTextBinding.setNewsItemText(item);
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
