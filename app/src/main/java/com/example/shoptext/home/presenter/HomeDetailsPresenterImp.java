package com.example.shoptext.home.presenter;

import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetConstant;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.home.bean.HomeDetailsBean;
import com.example.shoptext.home.homelistener.HomeDetailsFifthActivity;
import com.example.shoptext.home.model.HomeDetailsModelImp;

public class HomeDetailsPresenterImp extends BasePresenter<HomeDetailsFifthActivity, HomeDetailsModelImp> implements HomeContract.iHomeDetailsPresenter {
    @Override
    public HomeDetailsModelImp getModel() {
        return new HomeDetailsModelImp(this);
    }

    @Override
    public void getData(int id) {
        getModel().getHomeDetailsData(NetConstant.homedetailsAllUrl + "?id=" + id, new NetCallBack<HomeDetailsBean>() {
            @Override
            public void onSuccess(HomeDetailsBean homeDetailsBean) {
                HomeDetailsBean.DataBean.BrandBean brand = homeDetailsBean.getData().getBrand();
                iView.onHomeDetailsSuccess(brand);
            }

            @Override
            public void onFail(String error) {
                iView.onHomeDetailsFail(error);
            }
        });
    }
}
