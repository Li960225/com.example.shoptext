package com.example.shoptext.mine.model;

import com.example.mylibrary.base.BaseModel;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetUtil;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.mine.presenter.RefreshTokenPresenteerImp;

import java.util.HashMap;

public class RefreshTokenModelImp extends BaseModel implements HomeContract.iRefreshTokenModel {
    private RefreshTokenPresenteerImp refreshTokenPresenteerImp;

    public RefreshTokenModelImp(RefreshTokenPresenteerImp refreshTokenPresenteerImp) {
        this.refreshTokenPresenteerImp = refreshTokenPresenteerImp;
    }

    @Override
    public <T> void getRefreshTokenData(String url, HashMap<String, String> map, NetCallBack<T> netCallBack) {
        NetUtil.getNetUtil().post(url,map,null,netCallBack);
    }
}
