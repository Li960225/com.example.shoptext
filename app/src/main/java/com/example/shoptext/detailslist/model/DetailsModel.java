package com.example.shoptext.detailslist.model;

import com.example.mylibrary.base.BaseModel;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetUtil;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.detailslist.presenter.DetailsPresenter;

import java.util.HashMap;

public class DetailsModel extends BaseModel implements HomeContract.iDetailsModel {
    private DetailsPresenter detailsPresenter;

    public DetailsModel(DetailsPresenter detailsPresenter) {
        this.detailsPresenter = detailsPresenter;
    }

    @Override
    public <T> void getDetailsData(String url, HashMap<String, String> map, NetCallBack<T> netCallBack) {
        NetUtil.getNetUtil().get(url,map,netCallBack);
    }
}
