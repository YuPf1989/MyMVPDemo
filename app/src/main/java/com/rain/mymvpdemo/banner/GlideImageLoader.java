package com.rain.mymvpdemo.banner;

import android.content.Context;
import android.widget.ImageView;

import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.glide.GlideApp;
import com.youth.banner.loader.ImageLoader;

/**
 * Author:rain
 * Date:2018/6/4 12:02
 * Description:
 */
public class GlideImageLoader extends ImageLoader{
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        GlideApp.with(context)
                .load(((String) path))
                .placeholder(R.drawable.placeholder_banner)
                .into(imageView);
    }
}
