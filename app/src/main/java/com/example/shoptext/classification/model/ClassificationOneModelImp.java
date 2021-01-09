package com.example.shoptext.classification.model;

import com.example.mylibrary.base.BaseModel;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetUtil;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.classification.presenter.ClassificationOnePresenterImp;

public class ClassificationOneModelImp extends BaseModel implements HomeContract.iClassificationModel {
    private ClassificationOnePresenterImp classificationPresenterImp;

    public ClassificationOneModelImp(ClassificationOnePresenterImp classificationPresenterImp) {
        this.classificationPresenterImp = classificationPresenterImp;
    }

    @Override
    public <T> void getClassificationOneData(String url, NetCallBack<T> netCallBack) {
        NetUtil.getNetUtil().get(url,netCallBack);
    }

    @Override
    public <T> void getClassificationTwoData(String url, NetCallBack<T> netCallBack) {
        NetUtil.getNetUtil().get(url,netCallBack);
    }
}
