package com.example.shoptext.shopping.model;

import com.example.mylibrary.base.BaseModel;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetUtil;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.shopping.presenter.ShoppingPresenterImp;

import java.util.HashMap;

public class ShoppingModel extends BaseModel implements HomeContract.iShopDataModel {
    private ShoppingPresenterImp shoppingPresenterImp;

    public ShoppingModel(ShoppingPresenterImp shoppingPresenterImp) {
        this.shoppingPresenterImp = shoppingPresenterImp;
    }

    @Override
    public <T> void getShopData(String url, HashMap<String,String> header, NetCallBack<T> netCallBack) {
        NetUtil.getNetUtil().get(url,header,null,netCallBack);
    }
}
