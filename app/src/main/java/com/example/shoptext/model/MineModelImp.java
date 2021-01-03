package com.example.shoptext.model;

import com.example.mylibrary.base.BaseModel;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetUtil;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.presenter.MinePresenterImp;

import java.util.HashMap;

public class MineModelImp extends BaseModel implements HomeContract.iMineModel {
    private MinePresenterImp minePresenterImp;

    public MineModelImp(MinePresenterImp minePresenterImp) {
        this.minePresenterImp = minePresenterImp;
    }

    @Override
    public <T> void getMineData(String url, HashMap<String, String> map, NetCallBack<T> netCallBack) {
        NetUtil.getNetUtil().post(url,map,netCallBack);
    }
}
