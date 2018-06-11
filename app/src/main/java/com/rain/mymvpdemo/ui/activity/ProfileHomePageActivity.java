package com.rain.mymvpdemo.ui.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.base.BaseActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.scwang.smartrefresh.layout.util.DensityUtil;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author:rain
 * Date:2018/6/8 9:38
 * Description:
 */
public class ProfileHomePageActivity extends BaseActivity {
    @BindView(R.id.mWebView)
    WebView mWebView;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.buttonBarLayout)
    ButtonBarLayout buttonBarLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.parallax)
    ImageView parallax;

    private int mOffset = 0;
    private float mScrollY = 0;
    private static final String TAG = "ProfileHomePageActivity";

    @Override
    protected void loadData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_profile_homepage;
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void initViews(Bundle savedInstanceState) {

        refreshLayout.setOnMultiPurposeListener(new SimpleMultiPurposeListener() {
            @Override
            public void onHeaderPulling(RefreshHeader header, float percent, int offset, int headerHeight, int extendHeight) {
                mOffset = offset / 2;
                parallax.setTranslationY((mOffset - mScrollY));
                toolbar.setAlpha(1 - Math.min(percent, 1f));
            }

            @Override
            public void onHeaderReleasing(RefreshHeader header, float percent, int offset, int footerHeight, int extendHeight) {
                mOffset = offset / 2;
                parallax.setTranslationY((mOffset - mScrollY));
                toolbar.setAlpha(1 - Math.min(percent, 1f));
            }
        });

        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {

            int h = DensityUtil.dp2px(170f);

            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                // 向上滑，数值为正，递增，向下滑，递减，没有负值
                Log.e(TAG, "onScrollChange: scrollY" + scrollY);
                Log.e(TAG, "onScrollChange: h" + h);
                mScrollY = scrollY;
                if (mScrollY < h) {
                    mScrollY = scrollY;
                } else {
                    mScrollY = h;
                }
                float alpha = (mScrollY / h) * 255;
                toolbar.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
                // 关于透明度，值越大，越不透明
                buttonBarLayout.setAlpha(1f * mScrollY / h);
                parallax.setTranslationY((mOffset - scrollY));
            }
        });
        buttonBarLayout.setAlpha(0f);
        toolbar.setBackgroundColor(0);
        //返回
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mWebView.loadUrl("https://xuhaoblog.com/KotlinMvp");
            }
        });
        refreshLayout.autoRefresh();

        mWebView.getSettings().setJavaScriptEnabled(true);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                refreshLayout.finishRefresh();
                view.loadUrl(String.format(Locale.CHINA, "javascript:document.body.style.paddingTop='%fpx'; void 0", DensityUtil.px2dp(mWebView.getPaddingTop())));
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }
}
