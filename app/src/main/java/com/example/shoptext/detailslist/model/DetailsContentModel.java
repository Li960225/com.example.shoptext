package com.example.shoptext.detailslist.model;

import com.example.mylibrary.base.BaseModel;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetUtil;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.detailslist.presenter.DetailsContentPresenter;

import java.util.HashMap;

public class DetailsContentModel extends BaseModel implements HomeContract.iDetailsContentModel {
    private DetailsContentPresenter detailsContentPresenter;

    public DetailsContentModel(DetailsContentPresenter detailsContentPresenter) {
        this.detailsContentPresenter = detailsContentPresenter;
    }

    @Override
    public <T> void getDetailsContentData(String url, NetCallBack<T> netCallBack) {
        NetUtil.getNetUtil().get(url,netCallBack);
    }

    @Override
    public <T> void getAddShopData(String url, NetCallBack<T> netCallBack) {
        NetUtil.getNetUtil().get(url,netCallBack);
    }
}
