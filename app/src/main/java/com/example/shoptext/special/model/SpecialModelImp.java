package com.example.shoptext.special.model;

import com.example.mylibrary.base.BaseModel;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetUtil;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.special.presenter.SpecialPresenterImp;

public class SpecialModelImp extends BaseModel implements HomeContract.iSpecialModel {
    private SpecialPresenterImp specialPresenterImp;

    public SpecialModelImp(SpecialPresenterImp specialPresenterImp) {
        this.specialPresenterImp = specialPresenterImp;
    }

    @Override
    public <T> void getSpecialData(String url, NetCallBack<T> netCallBack) {
        NetUtil.getNetUtil().get(url,netCallBack);
    }
}
