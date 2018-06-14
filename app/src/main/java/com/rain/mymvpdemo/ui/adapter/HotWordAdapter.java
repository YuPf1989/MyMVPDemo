package com.rain.mymvpdemo.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rain.mymvpdemo.R;

import java.util.List;

/**
 * Author:rain
 * Date:2018/6/14 9:43
 * Description:
 */
public class HotWordAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public HotWordAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_title, item);
    }
}
