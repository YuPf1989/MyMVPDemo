package com.rain.mymvpdemo.ui.fragment;

import android.os.Bundle;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.base.BaseListFragment;

/**
 * Author:rain
 * Date:2018/5/15 9:33
 * Description:
 */
public class DiscoveryTabView extends BaseListFragment {
    @Override
    public void fetchData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_tab;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    public static DiscoveryTabView newInstance() {
        return new DiscoveryTabView();
    }

    @Override
    public BaseQuickAdapter setAdapter() {
        return null;
    }

    @Override
    public void onRefresh() {

    }
}
