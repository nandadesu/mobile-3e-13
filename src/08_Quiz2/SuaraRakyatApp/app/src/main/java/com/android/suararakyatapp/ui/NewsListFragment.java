package com.android.suararakyatapp.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.suararakyatapp.R;
import com.android.suararakyatapp.data.FakeDataSource;
import com.android.suararakyatapp.ui.news.DiffUtilNewsItemCallback;
import com.android.suararakyatapp.ui.news.NewsListAdapter;


public class NewsListFragment extends Fragment {


    RecyclerView recyclerView;
    NewsListAdapter adapter;

    public NewsListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_list_news);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        adapter = new NewsListAdapter(new DiffUtilNewsItemCallback());
        recyclerView.setAdapter(adapter);

        FakeDataSource fakeDataSource = new FakeDataSource();
        adapter.submitList(fakeDataSource.getFakeListNews());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_list, container, false);
    }
}