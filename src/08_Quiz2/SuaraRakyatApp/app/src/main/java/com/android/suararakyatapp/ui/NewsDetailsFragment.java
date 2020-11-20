package com.android.suararakyatapp.ui;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.suararakyatapp.R;
import com.android.suararakyatapp.data.FakeDataSource;
import com.android.suararakyatapp.data.NewsItem;
import com.android.suararakyatapp.databinding.FragmentNewsDetailsBinding;

public class NewsDetailsFragment extends Fragment {


    public NewsDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        FragmentNewsDetailsBinding fragmentNewsDetailsBinding =
                DataBindingUtil.inflate(LayoutInflater.from(getContext()),R.layout.fragment_news_details,container,false);


        FakeDataSource fakeDataSource = new FakeDataSource();
        NewsItem item = fakeDataSource.generateRandomNewsItem();

        item.setBook(true);
        fragmentNewsDetailsBinding.setNewsItemData(item);

        return fragmentNewsDetailsBinding.getRoot();
    }
}