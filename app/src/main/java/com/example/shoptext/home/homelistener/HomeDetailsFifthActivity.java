package com.example.shoptext.home.homelistener;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mylibrary.base.BaseActivity;
import com.example.mylibrary.base.BaseView;
import com.example.shoptext.R;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.home.bean.HomeDetailsBean;
import com.example.shoptext.home.presenter.HomeDetailsPresenterImp;

public class HomeDetailsFifthActivity extends BaseActivity<HomeDetailsPresenterImp> implements HomeContract.iHomeDetailsView, BaseView {

    private ImageView ivHomeDetailsFifthImg;
    private TextView tvHomeDetailsFifthTitle;
    private TextView tvHomeDetailsFifthDesc;

    @Override
    protected void initData() {
        int homedetailsId = getIntent().getIntExtra("homedetailsId",0);
        presenter.getData(homedetailsId);
    }

    @Override
    protected void initView() {
        presenter.attachView(this);
        ivHomeDetailsFifthImg = findViewById(R.id.iv_home_details_fifth_img);
        tvHomeDetailsFifthTitle = findViewById(R.id.tv_home_details_fifth_title);
        tvHomeDetailsFifthDesc = findViewById(R.id.tv_home_details_fifth_desc);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_home_details_fifth;
    }

    @Override
    protected HomeDetailsPresenterImp getPresenter() {
        return new HomeDetailsPresenterImp();
    }

    @Override
    public void onHomeDetailsSuccess(HomeDetailsBean.DataBean.BrandBean brandBean) {
        Glide.with(this).load(brandBean.getPicUrl()).into(ivHomeDetailsFifthImg);
        tvHomeDetailsFifthTitle.setText(brandBean.getName());
        tvHomeDetailsFifthDesc.setText(brandBean.getSimpleDesc());
    }

    @Override
    public void onHomeDetailsFail(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}