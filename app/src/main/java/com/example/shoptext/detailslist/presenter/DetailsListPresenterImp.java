package com.example.shoptext.detailslist.presenter;

import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetConstant;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.detailslist.bean.DetailsListBean;
import com.example.shoptext.detailslist.model.DetailsListModelImp;
import com.example.shoptext.detailslist.view.DetailsListActivity;

import java.util.List;

public class DetailsListPresenterImp extends BasePresenter<DetailsListActivity, DetailsListModelImp> implements HomeContract.iDetailsListPresenter {
    @Override
    public void getData(int id) {
        getModel().getDetailsList(NetConstant.detailsListDataAllUrl+"?id="+id, new NetCallBack<DetailsListBean>() {
            @Override
            public void onSuccess(DetailsListBean detailsBean) {
                List<DetailsListBean.DataBean.BrotherCategoryBean> brotherCategory = detailsBean.getData().getBrotherCategory();
                iView.onDetailsListSuccess(brotherCategory);
            }

            @Override
            public void onFail(String error) {
                iView.onDetailsListFail(error);
            }
        });
    }

    @Override
    public DetailsListModelImp getModel() {
        return new DetailsListModelImp(this);
    }
}
