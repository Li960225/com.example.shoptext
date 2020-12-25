package com.example.shoptext.model;

import com.example.mylibrary.base.BaseModel;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetConstant;
import com.example.mylibrary.utils.NetUtil;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.presenter.HomePresenterImp;

public class HomeModelImp extends BaseModel implements HomeContract.iHomeModel {
    private HomePresenterImp homePresenterImp;

    public HomeModelImp(HomePresenterImp homePresenterImp) {
        this.homePresenterImp = homePresenterImp;
    }

    @Override
    public <T> void getHomeData(String url, NetCallBack<T> netCallBack) {
        NetUtil.getNetUtil().get(url,netCallBack);
    }
}
