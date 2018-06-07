package com.rain.mymvpdemo.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.base.BaseFragment;
import com.rain.mymvpdemo.ui.adapter.DiscoveryTabAdapter;
import com.rain.mymvpdemo.ui.widget.TabLayoutHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author:rain
 * Date:2018/5/15 9:33
 * Description:
 */
public class DiscoveryTabView extends BaseFragment {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    Unbinder unbinder;

    ArrayList<Fragment> fragments = new ArrayList<>();
    List<String> titles = Arrays.asList("关注", "分类");

    @Override
    public void fetchData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_discovery_tab;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        title.setText("发现");
        fragments.add(FollowFragment.newInstance());
        fragments.add(CategoryFragment.newInstance());
        DiscoveryTabAdapter tabAdapter = new DiscoveryTabAdapter(getChildFragmentManager(), fragments, titles);
        viewpager.setAdapter(tabAdapter);
        tab.setupWithViewPager(viewpager);
        TabLayoutHelper.setUpIndicatorWidth(tab);
    }

    public static DiscoveryTabView newInstance() {
        return new DiscoveryTabView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
