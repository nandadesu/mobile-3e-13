package com.android.suararakyatapp.util;

import android.view.View;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

import com.android.suararakyatapp.R;
import com.bumptech.glide.Glide;

public class BindingAdapters {


    @BindingAdapter("glide_url")
    public static void loadImg(ImageView imageView, String url){
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    @BindingAdapter("glide_circular")
    public static void loadUserImg(ImageView view, String url){
        Glide.with(view.getContext()).load(url).circleCrop().into(view);
    }

    @BindingAdapter("set_background")
    public static void setBackgorund(ImageView view, String color){
        switch (color){
            case "RED" : view.setBackgroundColor(view.getContext().getResources().getColor(R.color.red));
                break;
            case "BLACK" : view.setBackgroundColor(view.getContext().getResources().getColor(R.color.black));
                break;
            case "BLUE" : view.setBackgroundColor(view.getContext().getResources().getColor(R.color.blue));
                break;
            case "YELLOW" : view.setBackgroundColor(view.getContext().getResources().getColor(R.color.yellow));
                break;
            case "PURPLE" : view.setBackgroundColor(view.getContext().getResources().getColor(R.color.purple));
                break;
            default: view.setBackgroundColor(view.getContext().getResources().getColor(R.color.red));
        }
    }

    @BindingAdapter("set_checked")
    public static void toggleFav(ImageView view,boolean isFav){
        if (isFav){
            view.setColorFilter(ContextCompat.getColor(view.getContext(),R.color.red));
        }
        else
            view.setColorFilter(ContextCompat.getColor(view.getContext(),R.color.dark_icon_tint_color));
    }

}
