package com.example.shoptext.shopping.presenter;

import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetConstant;
import com.example.shoptext.shopping.bean.ShoppingDataBean;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.shopping.view.ShoppingFragment;
import com.example.shoptext.shopping.model.ShoppingModel;
import com.tencent.mmkv.MMKV;

import java.util.HashMap;
import java.util.List;

public class ShoppingPresenterImp extends BasePresenter<ShoppingFragment, ShoppingModel> implements HomeContract.iShopDataPresenter {
    @Override
    public ShoppingModel getModel() {
        return new ShoppingModel(this);
    }

    @Override
    public void getData() {
        MMKV mmkv = MMKV.defaultMMKV();
        String token = mmkv.decodeString("token");
        HashMap<String, String> headerhashmap = new HashMap<>();
        if (token!=null){
            headerhashmap.put("X-Nideshop-Token",token);
        }
        iModel.getShopData(NetConstant.shoppingDataAllUrl, headerhashmap, new NetCallBack<ShoppingDataBean>() {
            @Override
            public void onSuccess(ShoppingDataBean shoppingDataBean) {
                List<ShoppingDataBean.DataBean.CartListBean> cartList = shoppingDataBean.getData().getCartList();
                iView.onShopDataSuccess(cartList);
            }

            @Override
            public void onFail(String error) {
                iView.onShopDataFail(error);
            }
        });
    }
}
