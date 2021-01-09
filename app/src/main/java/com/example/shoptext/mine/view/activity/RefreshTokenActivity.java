package com.example.shoptext.mine.view.activity;

import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import com.example.mylibrary.base.BaseActivity;
import com.example.mylibrary.base.BaseView;
import com.example.shoptext.MainActivity;
import com.example.shoptext.R;
import com.example.shoptext.mine.bean.RefreshTokenBean;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.mine.presenter.RefreshTokenPresenteerImp;
import com.tencent.mmkv.MMKV;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class RefreshTokenActivity extends BaseActivity<RefreshTokenPresenteerImp> implements HomeContract.iRefreshTokenView,BaseView {

    private TextView tvRefreshTime;
    private Disposable disposable;

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    protected void initView() {
        presenter.attachView(this);
        tvRefreshTime = findViewById(R.id.tv_refresh_time);

        disposable = Observable.interval(1, 1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if (aLong<=3){
                            tvRefreshTime.setText((3-aLong)+"");
                        }else {
                            disposable.dispose();
                        }
                    }
                });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_refresh_token;
    }

    @Override
    protected RefreshTokenPresenteerImp getPresenter() {
        return new RefreshTokenPresenteerImp();
    }

    @Override
    public void onRefreshTokenSuccess(RefreshTokenBean redata) {
        MMKV mmkv = MMKV.defaultMMKV();
        mmkv.encode("token",redata.getData());
        startActivity(new Intent(this, MainActivity.class));
        Log.e("tag",redata.getData());
    }

    @Override
    public void onRefreshTokenFail(String error) {
        Log.e("TAG", error );
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}