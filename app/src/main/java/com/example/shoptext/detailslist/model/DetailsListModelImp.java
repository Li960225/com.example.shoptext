package com.example.shoptext.detailslist.model;

import com.example.mylibrary.base.BaseModel;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetUtil;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.detailslist.presenter.DetailsListPresenterImp;

public class DetailsListModelImp extends BaseModel implements HomeContract.iDetailsListModel {
    private DetailsListPresenterImp detailsPresenterImp;

    public DetailsListModelImp(DetailsListPresenterImp detailsPresenterImp) {
        this.detailsPresenterImp = detailsPresenterImp;
    }

    @Override
    public <T> void getDetailsList(String url, NetCallBack<T> netCallBack) {
        NetUtil.getNetUtil().get(url,netCallBack);
    }
}
