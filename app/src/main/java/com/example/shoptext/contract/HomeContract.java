package com.example.shoptext.contract;

import com.example.mylibrary.utils.NetCallBack;
import com.example.shoptext.bean.HomeBean;

import java.util.List;

public class HomeContract {
    public interface iHomeView{
        void onHomeSuccess(HomeBean.DataBean data);
        void onHomeFail(String error);
    }
    public interface iHomePresenter{
        void getData();
    }
    public interface iHomeModel{
        <T> void getHomeData(String url, NetCallBack<T> netCallBack);
    }
}
