package com.rain.mymvpdemo.presenter;

import android.os.Handler;

import com.rain.mymvpdemo.base.BasePresenter;
import com.rain.mymvpdemo.base.IBaseView;
import com.rain.mymvpdemo.contract.MyContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:rain
 * Date:2018/5/29 18:18
 * Description:
 */
public class MyPresenter extends BasePresenter implements MyContract.Presenter {
    private static final String TAG  = "MyPresenter";

    private final MyContract.View view;
    private List<String> data = new ArrayList<>();

    public MyPresenter(MyContract.View view) {
        this.view = view;
}

    @Override
    public void doLoadData() {
        view.onSetAdapterData(null);
        initData();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                view.onHideLoading();
                view.onSetAdapterData(data);
            }
        }, 2000);
    }

    @Override
    public void doRefresh() {
        doLoadData();
    }

    // 这是模拟数据
    private void initData() {
        data.clear();
        for (int i = 0; i < 20; i++) {
            data.add("第" + i + "个条目");
        }
    }

    @Override
    public void attachView(IBaseView view) {
        super.attachView(view);

    }

    @Override
    public void detachView() {
        super.detachView();

    }
}
