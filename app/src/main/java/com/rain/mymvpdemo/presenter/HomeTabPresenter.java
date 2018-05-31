package com.rain.mymvpdemo.presenter;

import com.rain.mymvpdemo.base.BasePresenter;
import com.rain.mymvpdemo.contract.HomeTabContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:rain
 * Date:2018/5/31 11:57
 * Description:
 */
public class HomeTabPresenter extends BasePresenter implements HomeTabContract.Presenter {

    private static final String TAG  = "MyPresenter";

    private List<String> data = new ArrayList<>();

    @Override
    public void doLoadData() {

    }

    @Override
    public void doRefresh() {
        doLoadData();
    }
}
