package com.example.shoptext.mine.presenter;

import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetConstant;
import com.example.shoptext.mine.bean.RefreshTokenBean;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.mine.model.RefreshTokenModelImp;
import com.example.shoptext.mine.view.activity.RefreshTokenActivity;
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
        if (token==null){
            iView.onRefreshTokenFail("token为空");
            return;
        }else {
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
