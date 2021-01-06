package com.example.shoptext.contract;

import com.example.mylibrary.utils.NetCallBack;
import com.example.shoptext.bean.ClassificationBean;
import com.example.shoptext.bean.HomeBean;
import com.example.shoptext.bean.RefreshTokenBean;
import com.example.shoptext.bean.ShoppingDataBean;
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
        String userName();
        String passWord();
        void onMineSuccess();
        void onMineFail(String error);
    }
    public interface iMinePresenter{
        void getData(String name,String pwd);
    }
    public interface iMineModel{
        <T> void getMineData(String url, HashMap<String,String> map, NetCallBack<T> netCallBack);
    }

    public interface iRefreshTokenView{
        void onRefreshTokenSuccess(RefreshTokenBean redata);
        void onRefreshTokenFail(String error);
    }
    public interface iRefreshTokenPresenter{
        void getData();
    }
    public interface iRefreshTokenModel{
        <T> void getRefreshTokenData(String url, HashMap<String,String> map, NetCallBack<T> netCallBack);
    }

    public interface iShopDataView{
        void onShopDataSuccess(List<ShoppingDataBean.DataBean.CartListBean> cartListDTOS);
        void onShopDataFail(String error);
    }
    public interface iShopDataPresenter{
        void getData();
    }
    public interface iShopDataModel{
        <T> void getShopData(String url, HashMap<String,String> header, NetCallBack<T> netCallBack);
    }
}
