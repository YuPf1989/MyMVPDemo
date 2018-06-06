package com.rain.mymvpdemo.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.classic.common.MultipleStatusView;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author:rain
 * Time:2017/6/14 10:13
 * Description:This is BaseActivity
 */

public abstract class BaseActivity extends AppCompatActivity {

    private static final String TAG  = BaseActivity.class.getSimpleName();
    private Unbinder bind;
    protected MultipleStatusView mLayoutStatusView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//设制竖屏

        setContentView(getLayoutId());

        bind = ButterKnife.bind(this);

        initViews(savedInstanceState);
        initListener();
    }

    private void initListener() {
        if (mLayoutStatusView != null) {
            mLayoutStatusView.setOnRetryClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadData();
                }
            });
        }
    }

    // 开始请求数据
    protected abstract void loadData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    public abstract int getLayoutId();

    public abstract void initViews(Bundle savedInstanceState);

    protected void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUpEnabled);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}
