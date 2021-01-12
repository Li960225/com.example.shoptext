package com.example.shoptext.mine.presenter;

import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.utils.NetCallBack;
import com.example.mylibrary.utils.NetConstant;
import com.example.shoptext.mine.bean.LoginBean;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.mine.view.activity.LoginHomeActivity;
import com.example.shoptext.mine.view.fragment.MineFragment;
import com.example.shoptext.mine.model.LoginHomeModelImp;
import com.tencent.mmkv.MMKV;

import java.util.HashMap;

public class LoginHomePresenterImp extends BasePresenter<LoginHomeActivity, LoginHomeModelImp> implements HomeContract.iLoginHomePresenter {

    @Override
    public LoginHomeModelImp getModel() {
        return new LoginHomeModelImp(this);
    }

    @Override
    public void getData(String name, String pwd) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("username",name);
        hashMap.put("password",pwd);
        iModel.getLoginHomeData(NetConstant.loginAllUrl, hashMap, new NetCallBack<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                if (loginBean.getData().getCode()==200){
                    MMKV mmkv = MMKV.defaultMMKV();
                    mmkv.encode("token",loginBean.getData().getToken());
                    mmkv.encode("uid",loginBean.getData().getUserInfo().getUid());
                    mmkv.encode("username",loginBean.getData().getUserInfo().getUsername());
                    mmkv.encode("nickname",loginBean.getData().getUserInfo().getNickname());
                    mmkv.encode("gender",loginBean.getData().getUserInfo().getGender());
                    mmkv.encode("avatar",loginBean.getData().getUserInfo().getAvatar());
                    mmkv.encode("birthday",loginBean.getData().getUserInfo().getBirthday());
                    iView.onLoginHomeSuccess();
                }else {
                    iView.onLoginHomeFail("token请求失败");
                }

            }

            @Override
            public void onFail(String error) {
                iView.onLoginHomeFail(error);
            }
        });
    }
}