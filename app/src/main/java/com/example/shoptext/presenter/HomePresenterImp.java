package com.example.shoptext.presenter;

import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetConstant;
import com.example.shoptext.bean.HomeBean;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.fragment.HomeFragment;
import com.example.shoptext.model.HomeModelImp;

public class HomePresenterImp extends BasePresenter<HomeFragment, HomeModelImp> implements HomeContract.iHomePresenter {
    @Override
    public void getData() {
        getModel().getHomeData(NetConstant.homeAllUrl, new NetCallBack<HomeBean>() {
            @Override
            public void onSuccess(HomeBean homeBean) {
                HomeBean.DataBean data = homeBean.getData();
                iView.onHomeSuccess(data);
            }

            @Override
            public void onFail(String error) {
                iView.onHomeFail(error);
            }
        });
    }

    @Override
    public HomeModelImp getModel() {
        return new HomeModelImp(this);
    }
}
