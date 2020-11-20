
# 1. Hasil
# __________________________________________________________


## Data Binding

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

## Navigation(Bottom Menu)

        <?xml version="1.0" encoding="utf-8"?>
        <navigation xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:app="http://schemas.android.com/apk/res-auto"
            xmlns:tools="http://schemas.android.com/tools"
            android:id="@+id/nav_graph"
            app:startDestination="@id/newsListFragment">

            <fragment
                android:id="@+id/newsListFragment"
                android:name="com.android.suararakyatapp.ui.NewsListFragment"
                android:label="fragment_news_list"
                tools:layout="@layout/fragment_news_details" />
            <fragment
                android:id="@+id/newsListBook"
                android:name="com.android.suararakyatapp.ui.NewsBookmarkFragment"
                android:label="fragment_news_bookmark"
                tools:layout="@layout/fragment_news_bookmark" />
            <fragment
                android:id="@+id/newsListSetting"
                android:name="com.android.suararakyatapp.ui.SettingFragment"
                android:label="fragment_setting"
                tools:layout="@layout/fragment_setting" />
            <fragment
                android:id="@+id/newsListSearch"
                android:name="com.android.suararakyatapp.ui.SearchFragment"
                android:label="fragment_search"
                tools:layout="@layout/fragment_search" />
            <fragment
                android:id="@+id/newsDetailsFragment"
                android:name="com.android.suararakyatapp.ui.NewsDetailsFragment"
                android:label="NewsDetailsFragment" />

        </navigation>


## Fragment (News)

        <?xml version="1.0" encoding="utf-8"?>
        <layout xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:app="http://schemas.android.com/apk/res-auto"
            xmlns:tools="http://schemas.android.com/tools">

            <data>
                <variable
                    name="NewsItemData"
                    type="com.android.suararakyatapp.data.NewsItem" />
            </data>

            <androidx.core.widget.NestedScrollView
                android:layout_width="match_parent"
                android:layout_height="match_parent">

                <androidx.constraintlayout.widget.ConstraintLayout
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:background="?attr/background_color"
                    tools:context=".ui.NewsDetailsFragment">

                    <ImageView
                        glide_url="@{NewsItemData.newsImg}"
                        android:id="@+id/detail_img_news"
                        android:layout_width="0dp"
                        android:layout_height="210dp"
                        android:scaleType="centerCrop"
                        app:layout_constraintEnd_toEndOf="parent"
                        app:layout_constraintStart_toStartOf="parent"
                        app:layout_constraintTop_toTopOf="parent"
                        tools:srcCompat="@tools:sample/backgrounds/scenic" />

                    <ImageView
                        glide_circular="@{NewsItemData.userImg}"
                        android:id="@+id/detail_img_user"
                        android:layout_width="48dp"
                        android:layout_height="48dp"
                        android:layout_marginStart="24dp"
                        app:layout_constraintBottom_toBottomOf="@+id/detail_img_news"
                        app:layout_constraintStart_toStartOf="parent"
                        app:layout_constraintTop_toBottomOf="@+id/detail_img_news"
                        tools:srcCompat="@tools:sample/avatars" />

                    <TextView
                        android:id="@+id/detail_title"
                        android:layout_width="0dp"
                        android:layout_height="wrap_content"
                        android:layout_marginStart="16dp"
                        android:layout_marginTop="16dp"
                        android:layout_marginEnd="16dp"
                        android:lineSpacingExtra="4sp"
                        android:text="@{NewsItemData.title}"
                        android:textColor="?attr/text_color"
                        android:textSize="36sp"
                        app:layout_constraintEnd_toEndOf="parent"
                        app:layout_constraintStart_toStartOf="parent"
                        app:layout_constraintTop_toBottomOf="@+id/detail_img_user" />

                    <TextView
                        android:textColor="@color/blue"
                        android:id="@+id/detail_username_date"
                        android:layout_width="0dp"
                        android:layout_height="wrap_content"
                        android:layout_marginStart="16dp"
                        android:text="@{NewsItemData.username}"
                        app:layout_constraintStart_toStartOf="parent"
                        app:layout_constraintTop_toBottomOf="@+id/detail_title" />

                    <ImageView
                        set_checked="@{NewsItemData.book}"
                        android:id="@+id/detail_img_book"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_marginStart="8dp"
                        app:layout_constraintBottom_toBottomOf="@+id/detail_username_date"
                        app:layout_constraintStart_toEndOf="@+id/detail_username_date"
                        app:layout_constraintTop_toTopOf="@+id/detail_username_date"
                        app:srcCompat="@drawable/ic_baseline_bookmark_24" />

                    <TextView
                        android:textColor="?attr/text_color"
                        android:textSize="36sp"
                        android:id="@+id/detail_content"
                        android:layout_width="0dp"
                        android:layout_height="wrap_content"
                        android:layout_marginStart="16dp"
                        android:layout_marginTop="16dp"
                        android:layout_marginEnd="16dp"
                        android:text="@{NewsItemData.content}"
                        app:layout_constraintEnd_toEndOf="parent"
                        app:layout_constraintStart_toStartOf="parent"
                        app:layout_constraintTop_toBottomOf="@+id/detail_username_date" />

                </androidx.constraintlayout.widget.ConstraintLayout>

            </androidx.core.widget.NestedScrollView>
        </layout>


## Run App (gif)
![1](img/image.gif)

# __________________________________________________________
# Pertanyaan 2 


Data Binding merupakan suatu library untuk menulis layout deklaratif sehingga kita tidak lagi menggunakan class interface yang terlalu banyak juga tidak perlu lagi melakukan OnClick atau setText misalnya.

ViewModel merupakan class yang disediakan di dalam AAC, yang mana kita sebagai developer dapat menggunakan class ini untuk menyimpan state dan juga data yang dibutuhkan oleh User Interface kita.



# __________________________________________________________
# Pertanyaan 3

Activity merupakan salah satu komponen yang ada di Android Studio yang berfungsi untuk menampilkan user interface (UI) dari aplikasi yang akan dibuat,Bukan hanya menampilkan UI, activity juga digunakan untuk melakukan berbagai kegiatan yang diperlukan di dalam aplikasi tersebut seperti berpindah dari satu tampilan ke tampilan lainnya, menjalankan program lain.

Fragment merupakan salah satu komponen pada Android Studio dengan fungsi yang hampir sama seperti activity tetapi memiliki “lifecycle” yang berbeda. Fragment merupakan bagian dari sebuah activity yang mana sebuah fragment tidak akan ada bila tidak ada sebuah activity karena fragment membutuhkan akses dari activity untuk dapat dijalankan.


