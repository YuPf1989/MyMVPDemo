package com.rain.mymvpdemo.model.api;


import com.rain.mymvpdemo.model.api.MyGsonConverter.MyGsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Author:rain
 * Date:2017/11/13 10:48
 * Description:retrofit工具类
 */

public class RetrofitHelper {


    public static final int DEFAULT_TIMEOUT = 5;

    private static RetrofitHelper retrofitHelper = new RetrofitHelper();

    private static final String TAG = "RetrofitHelper";

    // 调用接口中的网络请求方法的对象
    private  RetrofitService retrofitService;
    private  Retrofit retrofit;

    public static RetrofitHelper getInstance() {
        return retrofitHelper;
    }

    private RetrofitHelper() {
        retrofit = new Retrofit.Builder()
//                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(MyGsonConverterFactory.create())         // 自定义gson解析
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())  // rxjava支持
                .client(getOkHttpClient())                                  // okhttpClient
                .build();

        retrofitService = retrofit.create(RetrofitService.class);
    }

    private OkHttpClient getOkHttpClient() {


        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder
                .addInterceptor(new Interceptor() {     // 添加token公共请求头
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request originalRequest = chain.request();

                        Request authorised = originalRequest.newBuilder()
                                .header("token", "123456")//userInfoDao.getToken()
                                .build();
                        return chain.proceed(authorised);
                    }
                })
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);


        // 由于cookie 30min就会过期，所以持久化失去了意义
        builder.cookieJar(new CookieJar() {

            final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                cookieStore.put(url.host(), cookies);
            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl url) {
                List<Cookie> cookies = cookieStore.get(url.host());
                return cookies != null ? cookies : new ArrayList<Cookie>();
            }
        });
        return builder.build();
    }

    /**
     * 获取retrofitService接口对象，进行网络请求方法的调用
     */
    public RetrofitService getRetrofitService() {
        return retrofitService;
    }
}
