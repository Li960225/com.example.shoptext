package com.example.shoptext.register.presenter;

import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetConstant;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.register.bean.RegisterBean;
import com.example.shoptext.register.model.RegisterModelImp;
import com.example.shoptext.register.view.RegisterActivity;

import java.util.HashMap;

public class RegisterPresenterImp extends BasePresenter<RegisterActivity, RegisterModelImp> implements HomeContract.iRegisterPresenter {
    @Override
    public RegisterModelImp getModel() {
        return new RegisterModelImp(this);
    }

    @Override
    public void getData(String name,String password,String isPassword) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("nickname",name);
        stringStringHashMap.put("password",password);
        stringStringHashMap.put("verify",isPassword);
        stringStringHashMap.put("username",name);
        getModel().getRegisterData(NetConstant.registerAllUrl,stringStringHashMap, new NetCallBack<RegisterBean>() {
            @Override
            public void onSuccess(RegisterBean registerBean) {
                iView.onRegisterSuccess(registerBean);
            }

            @Override
            public void onFail(String error) {
                iView.onRegisterFail(error);
            }
        });
    }
}
