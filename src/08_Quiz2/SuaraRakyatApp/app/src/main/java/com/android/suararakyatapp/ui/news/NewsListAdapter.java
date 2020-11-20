package com.android.suararakyatapp.ui.news;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.android.suararakyatapp.R;
import com.android.suararakyatapp.data.NewsItem;
import com.android.suararakyatapp.databinding.ItemNewsImageBinding;
import com.android.suararakyatapp.databinding.ItemNewsTextBinding;

public class NewsListAdapter extends ListAdapter<NewsItem, BaseViewHolder> {

    OnNewsItemClikEvent listener;
    public static final int VIEWTYPE_NEWS_TEXT = 0;
    public static final int VIEWTYPE_NEWS_IMAGE = 1;
    public static final int VIEWTYPE_NEWS_VIDEO = 2;

    public interface OnNewsItemClikEvent{
        void onItemTextClick();
        void onItemImageClick();
        void onItemLongClick();
    }

    public void  setOnNewsItemClikEventListener(OnNewsItemClikEvent listener){
        this.listener = listener;
    }

    public NewsListAdapter(@NonNull DiffUtil.ItemCallback<NewsItem> diffCallback) {
        super(diffCallback);
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getViewType();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType){
            case VIEWTYPE_NEWS_TEXT:
                ItemNewsTextBinding itemNewsTextBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_news_text,parent,false);
                return new TextViewHolder(itemNewsTextBinding);

            case VIEWTYPE_NEWS_IMAGE:
                ItemNewsImageBinding itemNewsImageBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_news_image,parent,false);
                return new ImagViewHolder(itemNewsImageBinding);

            default:
                ItemNewsTextBinding defaultItemNewsTextBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_news_text,parent,false);
                return new TextViewHolder(defaultItemNewsTextBinding);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {

        holder.bindData(getItem(position));
    }
}
