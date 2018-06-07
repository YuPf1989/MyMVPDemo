package com.rain.mymvpdemo.ui.fragment;

import android.os.Bundle;

import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.base.LazyLoadFragment;

/**
 * Author:rain
 * Date:2018/6/6 9:48
 * Description:
 */
public class CategoryFragment extends LazyLoadFragment {
    public static CategoryFragment newInstance() {
        return new CategoryFragment();
    }

    @Override
    public void fetchData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_recyclerview;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }
}
