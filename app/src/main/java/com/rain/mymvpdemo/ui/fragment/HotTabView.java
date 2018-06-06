package com.rain.mymvpdemo.ui.fragment;

import android.os.Bundle;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.base.BaseListFragment;

import java.util.List;

/**
 * Author:rain
 * Date:2018/5/15 9:33
 * Description:
 */
public class HotTabView extends BaseListFragment {
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

    public static HotTabView newInstance() {
        return new HotTabView();
    }

    @Override
    public BaseQuickAdapter setAdapter() {
        return null;
    }

    @Override
    public void setLoadMoreData(List<?> list) {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onShowNetError(String err_msg, int err_code) {

    }
}
