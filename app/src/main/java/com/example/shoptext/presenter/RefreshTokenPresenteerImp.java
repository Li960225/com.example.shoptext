package com.example.shoptext.presenter;

import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetConstant;
import com.example.shoptext.bean.HomeBean;
import com.example.shoptext.bean.LoginBean;
import com.example.shoptext.bean.RefreshTokenBean;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.model.RefreshTokenModelImp;
import com.example.shoptext.view.RefreshTokenActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.tencent.mmkv.MMKV;

import java.util.HashMap;

public class RefreshTokenPresenteerImp extends BasePresenter<RefreshTokenActivity, RefreshTokenModelImp> implements HomeContract.iRefreshTokenPresenter {
    @Override
    public RefreshTokenModelImp getModel() {
        return new RefreshTokenModelImp(this);
    }

    @Override
    public void getData() {
        HashMap<String, String> hashMap = new HashMap<>();
        MMKV mmkv = MMKV.defaultMMKV();
        String token = mmkv.decodeString("token");
        if (token!=null){
            hashMap.put("X-Nideshop-Token",token);
        }
        iModel.getRefreshTokenData(NetConstant.refreshtokenAllUrl, hashMap, new NetCallBack<RefreshTokenBean>() {
            @Override
            public void onSuccess(RefreshTokenBean refreshTokenBean) {
                iView.onRefreshTokenSuccess(refreshTokenBean);
            }

            @Override
            public void onFail(String error) {
                iView.onRefreshTokenFail(error);
            }
        });
    }
}
