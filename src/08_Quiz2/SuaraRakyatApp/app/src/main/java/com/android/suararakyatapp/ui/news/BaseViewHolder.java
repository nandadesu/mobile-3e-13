package com.android.suararakyatapp.ui.news;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.suararakyatapp.data.NewsItem;
import com.android.suararakyatapp.databinding.ItemNewsImageBinding;
import com.android.suararakyatapp.databinding.ItemNewsTextBinding;

abstract public class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void bindData(NewsItem item);

    public abstract ItemNewsTextBinding getItemNewsTextBinding();
    public abstract ItemNewsImageBinding getItemNewsImageBinding();
}
