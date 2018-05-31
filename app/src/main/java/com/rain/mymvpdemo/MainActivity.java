package com.rain.mymvpdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.rain.mymvpdemo.base.BaseActivity;
import com.rain.mymvpdemo.ui.fragment.DiscoveryTabView;
import com.rain.mymvpdemo.ui.fragment.HomeTabView;
import com.rain.mymvpdemo.ui.fragment.MineTabView;
import com.rain.mymvpdemo.util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.content)
    FrameLayout content;
    @BindView(R.id.bottom_navigation)
    BottomNavigationViewEx bottomNavigation;

    private static final int HOME_TAB = 0;
    private static final int DISCOVERY_TAB = 1;
    private static final int MY_TAB = 2;
    private int position = 0;
    private static final String POSITION = "position";
    private static final String SELECT_ITEM = "navigation_select_item";

    private HomeTabView homeTabView;
    private DiscoveryTabView discoveryTabView;
    private MineTabView myTabView;
    private long firstClickTime = 0;
    private long existTime = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        initBottomNavigation();
        initListener();
        if (savedInstanceState != null) {
            homeTabView = (HomeTabView) getSupportFragmentManager().findFragmentByTag(HomeTabView.class.getSimpleName());
            discoveryTabView = (DiscoveryTabView) getSupportFragmentManager().findFragmentByTag(DiscoveryTabView.class.getSimpleName());
            myTabView = (MineTabView) getSupportFragmentManager().findFragmentByTag(MineTabView.class.getSimpleName());
            showFragment(savedInstanceState.getInt(POSITION));
            bottomNavigation.setSelectedItemId(savedInstanceState.getInt(SELECT_ITEM));
        } else {
            showFragment(HOME_TAB);
        }
    }

    // 主要是为了处理屏幕旋转或者程序异常恢复时候用
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(POSITION, position);
        outState.putInt(SELECT_ITEM, bottomNavigation.getCurrentItem());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    private void showFragment(int index) {
        position = index;
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        hideFragment(ft);
        switch (index) {
            case HOME_TAB:
//                toolbar.setTitle("新闻");
                if (homeTabView == null) {
                    homeTabView = HomeTabView.newInstance();
                    ft.add(R.id.container, homeTabView, HomeTabView.class.getSimpleName());
                } else {
                    ft.show(homeTabView);
                }
                break;

            case DISCOVERY_TAB:
//                toolbar.setTitle("图片");
                if (discoveryTabView == null) {
                    discoveryTabView = DiscoveryTabView.newInstance();
                    ft.add(R.id.container, discoveryTabView, DiscoveryTabView.class.getSimpleName());
                } else {
                    ft.show(discoveryTabView);
                }
                break;

            case MY_TAB:
//                toolbar.setTitle("视频");
                if (myTabView == null) {
                    myTabView = MineTabView.newInstance();
                    ft.add(R.id.container, myTabView, MineTabView.class.getSimpleName());
                } else {
                    ft.show(myTabView);
                }
                break;
        }
        ft.commit();
    }

    private void hideFragment(FragmentTransaction ft) {
        if (homeTabView != null) {
            ft.hide(homeTabView);
        }

        if (discoveryTabView != null) {
            ft.hide(discoveryTabView);
        }

        if (myTabView != null) {
            ft.hide(myTabView);
        }
    }

    private void initBottomNavigation() {
        bottomNavigation.enableShiftingMode(false);
    }

    private void initListener() {
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_build:
                        showFragment(HOME_TAB);
                        break;
                    case R.id.action_check:
                        showFragment(DISCOVERY_TAB);
                        break;
                    case R.id.action_my:
                        showFragment(MY_TAB);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - existTime > 2000) {
            ToastUtil.showToast("再次点击退出程序！");
            existTime = currentTime;
        } else {
            super.onBackPressed();
        }
    }
}
