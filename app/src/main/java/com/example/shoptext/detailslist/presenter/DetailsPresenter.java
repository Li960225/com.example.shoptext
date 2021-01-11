package com.example.shoptext.detailslist.presenter;

import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetConstant;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.detailslist.bean.DetailsBean;
import com.example.shoptext.detailslist.fragment.DetailsFragment;
import com.example.shoptext.detailslist.model.DetailsModel;

import java.util.HashMap;
import java.util.List;

public class DetailsPresenter extends BasePresenter<DetailsFragment,DetailsModel> implements HomeContract.iDetailsPresenter {
    @Override
    public DetailsModel getModel() {
        return new DetailsModel(this);
    }

    @Override
    public void getData(int id, int page, int sizes) {
        HashMap<String, String> map = new HashMap<>();
        map.put("categoryId",id+"");
        map.put("page",page+"");
        map.put("size",sizes+"");
        getModel().getDetailsData(NetConstant.detailsDataAllUrl, map, new NetCallBack<DetailsBean>() {
            @Override
            public void onSuccess(DetailsBean detailsBean) {
                List<DetailsBean.DataBean.DataBeans> data = detailsBean.getData().getData();
                iView.onDetailsSuccess(data);
            }

            @Override
            public void onFail(String error) {
                iView.onDetailsFail(error);
            }
        });
    }
}
