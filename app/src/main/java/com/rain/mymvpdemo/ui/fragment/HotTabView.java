package com.rain.mymvpdemo.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.classic.common.MultipleStatusView;
import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.base.BaseFragment;
import com.rain.mymvpdemo.base.BaseMvpFragment;
import com.rain.mymvpdemo.mvp.contract.HotContract;
import com.rain.mymvpdemo.mvp.model.entity.TabInfoBean;
import com.rain.mymvpdemo.mvp.presenter.HotPresenter;
import com.rain.mymvpdemo.net.Exception.ErrorStatus;
import com.rain.mymvpdemo.ui.adapter.DiscoveryTabAdapter;
import com.rain.mymvpdemo.util.StatusBarUtil;
import com.rain.mymvpdemo.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author:rain
 * Date:2018/5/15 9:33
 * Description:
 */
public class HotTabView extends BaseMvpFragment<HotPresenter> implements HotContract.View {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.multipleStatusView)
    MultipleStatusView multipleStatusView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    Unbinder unbinder;

    ArrayList<String> titles = new ArrayList<>();
    ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hot_tab;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        // 状态栏透明和间距处理
        StatusBarUtil.darkMode(getActivity());
        StatusBarUtil.setPaddingSmart(getActivity(), toolbar);
        mLayoutStatusView = multipleStatusView;
        title.setText("热门");
    }

    @Override
    public void start() {
        onShowLoading();
        presenter.doLoadData();
    }

    @Override
    protected void refreshData() {
        start();
    }

    public static HotTabView newInstance() {
        return new HotTabView();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected HotPresenter creatPresenter() {
        return new HotPresenter();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onShowLoading() {
        multipleStatusView.showLoading();
    }

    @Override
    public void onHideLoading() {
        multipleStatusView.showContent();
    }

    @Override
    public void onShowNetError(String msg, int err_code) {
        ToastUtil.showToast(msg + ":" + err_code);
        if (err_code == ErrorStatus.NETWORK_ERROR) {
            mLayoutStatusView.showNoNetwork();
        } else {
            mLayoutStatusView.showError();
        }
    }

    @Override
    public void onSetData(TabInfoBean infoBean) {
        onHideLoading();
        List<TabInfoBean.TabInfo.TabListBean> tabList = infoBean.getTabInfo().getTabList();
        for (TabInfoBean.TabInfo.TabListBean bean : tabList) {
            titles.add(bean.getName());
            fragments.add(RankFragment.newInstance(bean.getApiUrl()));
        }
        DiscoveryTabAdapter tabAdapter = new DiscoveryTabAdapter(getChildFragmentManager(), fragments, titles);
        viewpager.setOffscreenPageLimit(2);
        viewpager.setAdapter(tabAdapter);
        tab.setupWithViewPager(viewpager);
    }
}
