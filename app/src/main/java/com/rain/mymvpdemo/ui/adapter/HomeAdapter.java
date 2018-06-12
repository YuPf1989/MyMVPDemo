package com.rain.mymvpdemo.ui.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rain.mymvpdemo.Constants;
import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.glide.GlideApp;
import com.rain.mymvpdemo.mvp.model.entity.HomeBean;
import com.rain.mymvpdemo.ui.activity.VideoDetailActivity;
import com.rain.mymvpdemo.util.TimeUtils;
import com.rain.mymvpdemo.util.ToastUtil;

import java.util.List;

/**
 * Author:rain
 * Date:2018/6/1 17:40
 * Description:
 */
public class HomeAdapter extends BaseMultiItemQuickAdapter<HomeBean.IssueListBean.ItemListBean, BaseViewHolder> {

    private final Activity activity;

    public HomeAdapter(List<HomeBean.IssueListBean.ItemListBean> data, Activity activity) {
        super(data);
        this.activity = activity;
        addItemType(HomeBean.IssueListBean.ItemListBean.type_video, R.layout.item_home_content);
        addItemType(HomeBean.IssueListBean.ItemListBean.type_textHeader, R.layout.item_home_header);
    }
    @Override
    protected void convert(BaseViewHolder helper, final HomeBean.IssueListBean.ItemListBean item) {
        HomeBean.IssueListBean.ItemListBean.DataBean itemData = item.getData();
        switch (item.getItemType()) {
            case HomeBean.IssueListBean.ItemListBean.type_textHeader:
                helper.setText(R.id.tvHeader, itemData.getText());
                break;

            case HomeBean.IssueListBean.ItemListBean.type_video:
                // 加载封页
                GlideApp.with(mContext)
                        .load(itemData.getCover().getFeed())
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .placeholder(R.drawable.placeholder_banner)
                        .into((ImageView) helper.getView(R.id.iv_cover_feed));
                // 加载用户图标
                GlideApp.with(mContext)
                        .load(itemData.getAuthor().getIcon())
                        .placeholder(R.drawable.default_avatar).circleCrop()
                        .into((ImageView) helper.getView(R.id.iv_avatar));
                // 设置标题
                helper.setText(R.id.tv_title, itemData.getTitle());
                // 设置tag
                List<HomeBean.IssueListBean.ItemListBean.DataBean.TagsBean> tags = itemData.getTags();
                StringBuffer tag_buf = new StringBuffer("#");
                for (HomeBean.IssueListBean.ItemListBean.DataBean.TagsBean tag :
                        tags) {
                    tag_buf.append(tag.getName()).append("/");
                }
                tag_buf.append(TimeUtils.durationFormat(itemData.getDuration()));
                helper.setText(R.id.tv_tag, tag_buf);
                // 设置类别
                helper.setText(R.id.tv_category, "#" + itemData.getCategory());
                helper.getView(R.id.iv_cover_feed).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goToVideoActivity(v,item);
                    }
                });
                break;
        }

    }

    @Override
    public int addHeaderView(View header) {
        return super.addHeaderView(header);
    }

    private void goToVideoActivity(View view,HomeBean.IssueListBean.ItemListBean item) {
        Intent intent = new Intent(mContext, VideoDetailActivity.class);
        intent.putExtra(Constants.BUNDLE_VIDEO_DATA, item);
        // 开启共享元素
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(((Activity) mContext), view, VideoDetailActivity.IMG_TRANSITION);
            ActivityCompat.startActivity(mContext, intent, options.toBundle());
        } else {
            mContext.startActivity(intent);
            ((Activity) mContext).overridePendingTransition(R.anim.anim_in,R.anim.anim_out);
        }
    }
}
