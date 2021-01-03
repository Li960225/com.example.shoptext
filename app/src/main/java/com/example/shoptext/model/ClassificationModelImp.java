package com.example.shoptext.model;

import com.example.mylibrary.base.BaseModel;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetUtil;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.presenter.ClassificationPresenterImp;

public class ClassificationModelImp extends BaseModel implements HomeContract.iClassificationModel {
    private ClassificationPresenterImp classificationPresenterImp;

    public ClassificationModelImp(ClassificationPresenterImp classificationPresenterImp) {
        this.classificationPresenterImp = classificationPresenterImp;
    }

    @Override
    public <T> void getClassificationData(String url, NetCallBack<T> netCallBack) {
        NetUtil.getNetUtil().get(url,netCallBack);
    }
}
