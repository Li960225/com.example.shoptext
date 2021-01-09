package com.example.shoptext.classification.presenter;

import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetConstant;
import com.example.shoptext.classification.bean.ClassificationOneBean;
import com.example.shoptext.classification.bean.ClassificationTwoBean;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.classification.view.ClassificationFragment;
import com.example.shoptext.classification.model.ClassificationOneModelImp;

import java.util.List;

public class ClassificationOnePresenterImp extends BasePresenter<ClassificationFragment, ClassificationOneModelImp> implements HomeContract.iClassificationPresenter {
    @Override
    public ClassificationOneModelImp getModel() {
        return new ClassificationOneModelImp(this);
    }

    @Override
    public void getOneData() {
        getModel().getClassificationOneData(NetConstant.classificationOneAllUrl, new NetCallBack<ClassificationOneBean>() {
            @Override
            public void onSuccess(ClassificationOneBean classificationBean) {
                List<ClassificationOneBean.DataBean.CategoryListBean> categoryList = classificationBean.getData().getCategoryList();
                iView.onClassificationOneSuccess(categoryList);
            }

            @Override
            public void onFail(String error) {
                iView.onClassificationOneFail(error);
            }
        });
    }

    @Override
    public void getTwoData(int id) {
        getModel().getClassificationTwoData(NetConstant.classificationTwoAllUrl+"?id="+id, new NetCallBack<ClassificationTwoBean>() {
            @Override
            public void onSuccess(ClassificationTwoBean classificationTwoBean) {
                List<ClassificationTwoBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList = classificationTwoBean.getData().getCurrentCategory().getSubCategoryList();
                iView.onClassificationTwoSuccess(subCategoryList);
            }

            @Override
            public void onFail(String error) {
                iView.onClassificatioTwoFail(error);
            }
        });
    }
}
