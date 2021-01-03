package com.example.shoptext.presenter;

import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetConstant;
import com.example.shoptext.bean.ClassificationBean;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.fragment.ClassificationFragment;
import com.example.shoptext.model.ClassificationModelImp;

import java.util.List;

public class ClassificationPresenterImp extends BasePresenter<ClassificationFragment, ClassificationModelImp> implements HomeContract.iClassificationPresenter {
    @Override
    public ClassificationModelImp getModel() {
        return new ClassificationModelImp(this);
    }

    @Override
    public void getData() {
        getModel().getClassificationData(NetConstant.classificationAllUrl, new NetCallBack<ClassificationBean>() {
            @Override
            public void onSuccess(ClassificationBean classificationBean) {
                List<ClassificationBean.DataBean.CategoryListBean> categoryList = classificationBean.getData().getCategoryList();
                iView.onClassificationSuccess(categoryList);
            }

            @Override
            public void onFail(String error) {
                iView.onClassificationFail(error);
            }
        });
    }
}
