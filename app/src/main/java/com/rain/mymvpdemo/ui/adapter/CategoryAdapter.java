package com.rain.mymvpdemo.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.glide.GlideApp;
import com.rain.mymvpdemo.mvp.model.entity.CategoryBean;

import java.util.List;

/**
 * Author:rain
 * Date:2018/6/7 10:54
 * Description:
 */
public class CategoryAdapter extends BaseQuickAdapter<CategoryBean,BaseViewHolder> {
    public CategoryAdapter(int layoutResId, @Nullable List<CategoryBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CategoryBean item) {
        helper.setText(R.id.tv_category_name, "#"+item.getName());
        GlideApp.with(mContext)
                .load(item.getBgPicture())
                .placeholder(R.color.textColor_light)
                .transition(DrawableTransitionOptions.withCrossFade())
                .thumbnail(0.5f)
                .into((ImageView) helper.getView(R.id.iv_category));
    }
}
