package com.example.shoptext.detailslist.view;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylibrary.base.BaseActivity;
import com.example.mylibrary.base.BaseView;
import com.example.shoptext.R;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.detailslist.bean.AddShopBean;
import com.example.shoptext.detailslist.bean.DetailsContentBean;
import com.example.shoptext.detailslist.presenter.DetailsContentPresenter;
import com.youth.banner.Banner;

import java.util.List;

public class DetailsContentActivity extends BaseActivity<DetailsContentPresenter> implements HomeContract.iDetailsContentView, BaseView {

    private Banner bannerDetailsContent;
    private LinearLayout llDetailsContent;
    private TextView tvDetailsContentTitle;
    private TextView tvDetailsContentSubtitle;
    private TextView tvDetailsContentPrice;
    private TextView tv_details_content_add;

    @Override
    protected void initData() {
        int detailsId = getIntent().getIntExtra("detailsId", 0);
        presenter.getData(detailsId);
    }

    @Override
    protected void initView() {
        presenter.attachView(this);
        bannerDetailsContent = findViewById(R.id.banner_details_content);
        llDetailsContent = findViewById(R.id.ll_details_content);
        tvDetailsContentTitle = findViewById(R.id.tv_details_content_title);
        tvDetailsContentSubtitle = findViewById(R.id.tv_details_content_subtitle);
        tvDetailsContentPrice = findViewById(R.id.tv_details_content_price);
        tv_details_content_add = findViewById(R.id.tv_details_content_add);

        tv_details_content_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getAddData();
                Toast.makeText(DetailsContentActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_details_content;
    }

    @Override
    protected DetailsContentPresenter getPresenter() {
        return new DetailsContentPresenter();
    }

    @Override
    public void onDetailsContentSuccess(DetailsContentBean.DataBean.InfoBean infoBeans) {
        tvDetailsContentTitle.setText(infoBeans.getName());
        tvDetailsContentSubtitle.setText(infoBeans.getGoodsBrief());
        tvDetailsContentPrice.setText("￥"+infoBeans.getRetailPrice());
    }

    @Override
    public void onDetailsContentFail(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAddShopSuccess(List<AddShopBean.DataBean.CartListBean> cartListBeans) {

    }

    @Override
    public void onAddShopFail(String error) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}