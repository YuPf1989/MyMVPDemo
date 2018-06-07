package com.rain.mymvpdemo.mvp.model.api;



import com.rain.mymvpdemo.mvp.model.entity.CategoryBean;
import com.rain.mymvpdemo.mvp.model.entity.HomeBean;
import com.rain.mymvpdemo.mvp.model.entity.TabInfoBean;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Author:rain
 * Date:2017/11/13 11:08
 * Description:该类封装了各种接口
 */

public interface RetrofitService {
    /**
     * 首页精选
     */
    @GET("v2/feed?")
    Observable<HomeBean> getFirstHomeData(@Query("num") int num);

    /**
     * 根据 nextPageUrl 请求数据下一页数据
     */
    @GET
    Observable<HomeBean> getMoreHomeData(@Url String url);

//    /**
//     * 根据item id获取相关视频
//     */
//    @GET("v4/video/related?")
//    fun getRelatedData(@Query("id") id: Long): Observable<HomeBean.Issue>
//

    /**
     * 获取分类
     */
    @GET("v4/categories")
    Observable<ArrayList<CategoryBean>> getCategory();

    /**
     * 获取分类详情List
     */
    @GET("v4/categories/videoList?")
    Observable<HomeBean.IssueListBean> getCategoryDetailList(@Query("id") Long id);

    /**
     * 获取更多的 Issue
     */
    @GET
    Observable<HomeBean.IssueListBean> getIssueData(@Url String url );

    /**
     * 获取全部排行榜的Info（包括，title 和 Url）
     */
    @GET("v4/rankList")
    Observable<TabInfoBean> getRankList();
//
//    /**
//     * 获取搜索信息
//     */
//    @GET("v1/search?&num=10&start=10")
//    fun getSearchData(@Query("query") query :String) : Observable<HomeBean.Issue>
//
//    /**
//     * 热门搜索词
//     */
//    @GET("v3/queries/hot")
//    fun getHotWord():Observable<ArrayList<String>>
//
    /**
     * 关注
     */
    @GET("v4/tabs/follow")
    Observable<HomeBean.IssueListBean> getFollowInfo();
//
//    /**
//     * 作者信息
//     */
//    @GET("v4/pgcs/detail/tab?")
//    fun getAuthorInfo(@Query("id") id: Long):Observable<AuthorInfoBean>
}
