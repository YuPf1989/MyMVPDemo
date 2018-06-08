package com.rain.mymvpdemo.ui.fragment;

import android.os.Bundle;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.base.BaseFragment;
import com.rain.mymvpdemo.base.BaseListFragment;

import java.util.List;

/**
 * Author:rain
 * Date:2018/5/15 9:33
 * Description:
 */
public class MineTabView extends BaseFragment {


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    public static MineTabView newInstance() {
        return new MineTabView();
    }
}
