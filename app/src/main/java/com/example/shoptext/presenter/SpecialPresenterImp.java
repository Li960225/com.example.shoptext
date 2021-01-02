package com.example.shoptext.presenter;

import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetConstant;
import com.example.shoptext.bean.SpecialBean;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.fragment.SpecialFragment;
import com.example.shoptext.model.SpecialModelImp;

import java.util.List;

public class SpecialPresenterImp extends BasePresenter<SpecialFragment, SpecialModelImp> implements HomeContract.iSpecialPresenter {
    @Override
    public void getData() {
        getModel().getSpecialData(NetConstant.SpecialAllUrl, new NetCallBack<SpecialBean>() {
            @Override
            public void onSuccess(SpecialBean specialBean) {
                List<SpecialBean.DataBean.DataBeans> data = specialBean.getData().getData();
                iView.onSpecialSuccess(data);
            }

            @Override
            public void onFail(String error) {
                iView.onSpecialFail(error);
            }
        });
    }

    @Override
    public SpecialModelImp getModel() {
        return new SpecialModelImp(this);
    }
}
