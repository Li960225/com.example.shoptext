package com.example.shoptext.detailslist.presenter;

import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetConstant;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.detailslist.bean.AddShopBean;
import com.example.shoptext.detailslist.bean.DetailsContentBean;
import com.example.shoptext.detailslist.model.DetailsContentModel;
import com.example.shoptext.detailslist.view.DetailsContentActivity;

import java.util.List;

public class DetailsContentPresenter extends BasePresenter<DetailsContentActivity, DetailsContentModel> implements HomeContract.iDetailsContentPresenter {
    @Override
    public DetailsContentModel getModel() {
        return new DetailsContentModel(this);
    }

    @Override
    public void getData(int id) {
        getModel().getDetailsContentData(NetConstant.detailsContentAllUrl + "?id=" + id, new NetCallBack<DetailsContentBean>() {
            @Override
            public void onSuccess(DetailsContentBean detailsContentBean) {
                DetailsContentBean.DataBean dataBean = detailsContentBean.getData();
                iView.onDetailsContentSuccess(dataBean);
            }

            @Override
            public void onFail(String error) {
                iView.onDetailsContentFail(error);
            }
        });
    }

    @Override
    public void getAddData() {
        getModel().getAddShopData(NetConstant.addShopAllUrl, new NetCallBack<AddShopBean>() {
            @Override
            public void onSuccess(AddShopBean addShopBean) {
                List<AddShopBean.DataBean.CartListBean> cartList = addShopBean.getData().getCartList();
                iView.onAddShopSuccess(cartList);
            }

            @Override
            public void onFail(String error) {
                iView.onAddShopFail(error);
            }
        });
    }
}
