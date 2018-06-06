package com.rain.mymvpdemo.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.glide.GlideApp;
import com.rain.mymvpdemo.mvp.model.entity.HomeBean;
import com.rain.mymvpdemo.util.TimeUtils;
import com.rain.mymvpdemo.util.ToastUtil;

import java.util.List;

/**
 * Author:rain
 * Date:2018/6/1 17:40
 * Description:
 */
public class HomeAdapter extends BaseMultiItemQuickAdapter<HomeBean.IssueListBean.ItemListBean, BaseViewHolder> {
    public HomeAdapter(List<HomeBean.IssueListBean.ItemListBean> data) {
        super(data);
        addItemType(HomeBean.IssueListBean.ItemListBean.type_video, R.layout.item_home_content);
        addItemType(HomeBean.IssueListBean.ItemListBean.type_textHeader, R.layout.item_home_header);
    }



    @Override
    protected void convert(BaseViewHolder helper, HomeBean.IssueListBean.ItemListBean item) {
        HomeBean.IssueListBean.ItemListBean.DataBean itemData = item.getData();
        switch (item.getItemType()) {
            case HomeBean.IssueListBean.ItemListBean.type_textHeader:
                helper.setText(R.id.tvHeader, itemData.getText());
                break;

            case HomeBean.IssueListBean.ItemListBean.type_video:
                // 加载封页
                GlideApp.with(mContext)
                        .load(itemData.getCover().getFeed())
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
                        ToastUtil.showToast("点击了！");
                    }
                });
                break;
        }

    }

    @Override
    public int addHeaderView(View header) {
        return super.addHeaderView(header);
    }

    private void goToActivity() {

    }
}
