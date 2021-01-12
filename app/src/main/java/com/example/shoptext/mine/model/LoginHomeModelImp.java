package com.example.shoptext.mine.model;

import com.example.mylibrary.base.BaseModel;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetUtil;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.mine.presenter.LoginHomePresenterImp;

import java.util.HashMap;

public class LoginHomeModelImp extends BaseModel implements HomeContract.iLoginHomeModel {
    private LoginHomePresenterImp minePresenterImp;

    public LoginHomeModelImp(LoginHomePresenterImp minePresenterImp) {
        this.minePresenterImp = minePresenterImp;
    }

    @Override
    public <T> void getLoginHomeData(String url, HashMap<String, String> map, NetCallBack<T> netCallBack) {
        NetUtil.getNetUtil().post(url,map,netCallBack);
    }
}
