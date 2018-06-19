package com.rain.mymvpdemo.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.base.BaseFragment;
import com.rain.mymvpdemo.ui.activity.ProfileHomePageActivity;
import com.rain.mymvpdemo.util.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Author:rain
 * Date:2018/5/15 9:33
 * Description:
 */
public class MineTabView extends BaseFragment {

    @BindView(R.id.iv_about)
    ImageView ivAbout;
    @BindView(R.id.iv_avatar)
    CircleImageView ivAvatar;
    @BindView(R.id.tv_nickname)
    TextView tvNickname;
    @BindView(R.id.tv_view_homepage)
    TextView tvViewHomepage;
    @BindView(R.id.tv_collection)
    TextView tvCollection;
    @BindView(R.id.tv_comment)
    TextView tvComment;
    @BindView(R.id.tv_mine_message)
    TextView tvMineMessage;
    @BindView(R.id.tv_mine_attention)
    TextView tvMineAttention;
    @BindView(R.id.tv_mine_cache)
    TextView tvMineCache;
    @BindView(R.id.tv_watch_history)
    TextView tvWatchHistory;
    @BindView(R.id.tv_feedback)
    TextView tvFeedback;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        // 状态栏透明和间距处理
        StatusBarUtil.darkMode(getActivity());
        StatusBarUtil.setPaddingSmart(getActivity(), toolbar);
    }

    public static MineTabView newInstance() {
        return new MineTabView();
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

    @OnClick({R.id.iv_about, R.id.iv_avatar, R.id.tv_nickname, R.id.tv_view_homepage, R.id.tv_mine_message, R.id.tv_mine_attention, R.id.tv_mine_cache, R.id.tv_watch_history, R.id.tv_feedback})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_about:
                break;
            case R.id.iv_avatar:
            case R.id.tv_nickname:
            case R.id.tv_view_homepage:
                startActivity(new Intent(getActivity(), ProfileHomePageActivity.class));
                break;
            case R.id.tv_mine_message:
                break;
            case R.id.tv_mine_attention:
                break;
            case R.id.tv_mine_cache:
                break;
            case R.id.tv_watch_history:
                break;
            case R.id.tv_feedback:
                break;
        }
    }
}
