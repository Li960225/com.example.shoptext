package com.example.shoptext.contract;

import com.example.mylibrary.utils.NetCallBack;
import com.example.shoptext.classification.bean.ClassificationOneBean;
import com.example.shoptext.classification.bean.ClassificationTwoBean;
import com.example.shoptext.detailslist.bean.AddShopBean;
import com.example.shoptext.detailslist.bean.DetailsBean;
import com.example.shoptext.detailslist.bean.DetailsContentBean;
import com.example.shoptext.detailslist.bean.DetailsListBean;
import com.example.shoptext.home.bean.HomeBean;
import com.example.shoptext.home.bean.HomeDetailsBean;
import com.example.shoptext.mine.bean.RefreshTokenBean;
import com.example.shoptext.register.bean.RegisterBean;
import com.example.shoptext.shopping.bean.ShoppingDataBean;
import com.example.shoptext.special.bean.SpecialBean;

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
        void onClassificationOneSuccess(List<ClassificationOneBean.DataBean.CategoryListBean> data);
        void onClassificationOneFail(String error);
        void onClassificationTwoSuccess(List<ClassificationTwoBean.DataBean.CurrentCategoryBean.SubCategoryListBean> data);
        void onClassificatioTwoFail(String error);
    }
    public interface iClassificationPresenter{
        void getOneData();
        void getTwoData(int id);
    }
    public interface iClassificationModel{
        <T> void getClassificationOneData(String url, NetCallBack<T> netCallBack);
        <T> void getClassificationTwoData(String url, NetCallBack<T> netCallBack);
    }

    public interface iLoginHomeView{
        String userName();
        String passWord();
        void onLoginHomeSuccess();
        void onLoginHomeFail(String error);
    }
    public interface iLoginHomePresenter{
        void getData(String name,String pwd);
    }
    public interface iLoginHomeModel{
        <T> void getLoginHomeData(String url, HashMap<String,String> map, NetCallBack<T> netCallBack);
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

    public interface iDetailsListView{
        void onDetailsListSuccess(List<DetailsListBean.DataBean.BrotherCategoryBean> brotherCategoryBeans);
        void onDetailsListFail(String error);
    }
    public interface iDetailsListPresenter{
        void getData(int id);
    }
    public interface iDetailsListModel{
        <T> void getDetailsList(String url, NetCallBack<T> netCallBack);
    }

    public interface iDetailsView{
        void onDetailsSuccess(List<DetailsBean.DataBean.DataBeans> cartListDTOS);
        void onDetailsFail(String error);
    }
    public interface iDetailsPresenter{
        void getData(int id,int page,int sizes);
    }
    public interface iDetailsModel{
        <T> void getDetailsData(String url, HashMap<String,String> map, NetCallBack<T> netCallBack);
    }

    public interface iDetailsContentView{
        void onDetailsContentSuccess(DetailsContentBean.DataBean dataBean);
        void onDetailsContentFail(String error);
        void onAddShopSuccess(List<AddShopBean.DataBean.CartListBean> cartListBeans);
        void onAddShopFail(String error);
    }
    public interface iDetailsContentPresenter{
        void getData(int id);
        void getAddData();
    }
    public interface iDetailsContentModel{
        <T> void getDetailsContentData(String url, NetCallBack<T> netCallBack);
        <T> void getAddShopData(String url, NetCallBack<T> netCallBack);
    }

    public interface iRegisterView{
        void onRegisterSuccess(RegisterBean registerBean);
        void onRegisterFail(String error);
    }
    public interface iRegisterPresenter{
        void getData(String name,String password,String isPassword);
    }
    public interface iRegisterModel{
        <T> void getRegisterData(String url,HashMap<String,String> map, NetCallBack<T> netCallBack);
    }

    public interface iHomeDetailsView{
        void onHomeDetailsSuccess(HomeDetailsBean.DataBean.BrandBean brandBean);
        void onHomeDetailsFail(String error);
    }
    public interface iHomeDetailsPresenter{
        void getData(int id);
    }
    public interface iHomeDetailsModel{
        <T> void getHomeDetailsData(String url, NetCallBack<T> netCallBack);
    }
}
