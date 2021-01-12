package com.example.shoptext.register.model;

import com.example.mylibrary.base.BaseModel;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetUtil;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.register.presenter.RegisterPresenterImp;

import java.util.HashMap;

public class RegisterModelImp extends BaseModel implements HomeContract.iRegisterModel {
    private RegisterPresenterImp registerPresenterImp;

    public RegisterModelImp(RegisterPresenterImp registerPresenterImp) {
        this.registerPresenterImp = registerPresenterImp;
    }

    @Override
    public <T> void getRegisterData(String url, HashMap<String,String> map, NetCallBack<T> netCallBack) {
        NetUtil.getNetUtil().post(url,map,netCallBack);
    }
}
