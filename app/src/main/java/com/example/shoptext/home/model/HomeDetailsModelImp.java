package com.example.shoptext.home.model;

import com.example.mylibrary.base.BaseModel;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetUtil;
import com.example.shoptext.home.presenter.HomeDetailsPresenterImp;
import com.example.shoptext.contract.HomeContract;

public class HomeDetailsModelImp extends BaseModel implements HomeContract.iHomeDetailsModel {
    private HomeDetailsPresenterImp homeDetailsPresenter;

    public HomeDetailsModelImp(HomeDetailsPresenterImp homeDetailsPresenter) {
        this.homeDetailsPresenter = homeDetailsPresenter;
    }

    @Override
    public <T> void getHomeDetailsData(String url, NetCallBack<T> netCallBack) {
        NetUtil.getNetUtil().get(url,netCallBack);
    }
}
