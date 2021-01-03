package com.example.shoptext.contract;

import com.example.mylibrary.utils.NetCallBack;
import com.example.shoptext.bean.ClassificationBean;
import com.example.shoptext.bean.HomeBean;
import com.example.shoptext.bean.LoginBean;
import com.example.shoptext.bean.SpecialBean;

import java.util.HashMap;
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

    public interface iSpecialView{
        void onSpecialSuccess(List<SpecialBean.DataBean.DataBeans> data);
        void onSpecialFail(String error);
    }
    public interface iSpecialPresenter{
        void getData();
    }
    public interface iSpecialModel{
        <T> void getSpecialData(String url, NetCallBack<T> netCallBack);
    }

    public interface iClassificationView{
        void onClassificationSuccess(List<ClassificationBean.DataBean.CategoryListBean> data);
        void onClassificationFail(String error);
    }
    public interface iClassificationPresenter{
        void getData();
    }
    public interface iClassificationModel{
        <T> void getClassificationData(String url, NetCallBack<T> netCallBack);
    }

    public interface iMineView{
        void onMineSuccess(List<LoginBean.DataBean> data);
        void onMineFail(String error);
    }
    public interface iMinePresenter{
        void getData();
    }
    public interface iMineModel{
        <T> void getMineData(String url, HashMap<String,String> map, NetCallBack<T> netCallBack);
    }
}
