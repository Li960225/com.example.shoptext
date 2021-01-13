package com.example.shoptext.detailslist.view;

import android.graphics.Color;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.mylibrary.base.BaseActivity;
import com.example.mylibrary.base.BaseView;
import com.example.shoptext.R;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.detailslist.adapter.vlayout.DetailsContentFirstAdapter;
import com.example.shoptext.detailslist.adapter.vlayout.DetailsContentFourthAdapter;
import com.example.shoptext.detailslist.adapter.vlayout.DetailsContentSecondAdapter;
import com.example.shoptext.detailslist.adapter.vlayout.DetailsContentThirdAdapter;
import com.example.shoptext.detailslist.bean.AddShopBean;
import com.example.shoptext.detailslist.bean.DetailsContentBean;
import com.example.shoptext.detailslist.presenter.DetailsContentPresenter;
import com.example.shoptext.home.adapter.SecondAdapter;

import java.util.ArrayList;
import java.util.List;

public class DetailsContentActivity extends BaseActivity<DetailsContentPresenter> implements HomeContract.iDetailsContentView, BaseView {

    private DelegateAdapter delegateAdapter;
    private ArrayList<DetailsContentBean.DataBean.GalleryBean> galleryBeans;
    private DetailsContentFirstAdapter detailsContentFirstAdapter;
    private DetailsContentSecondAdapter detailsContentSecondAdapter;
    private DetailsContentThirdAdapter detailsContentThirdAdapter;
    private ArrayList<DetailsContentBean.DataBean.InfoBean> infoBeans;
    private DetailsContentFourthAdapter detailsContentFourthAdapter;

    @Override
    protected void initData() {
        int detailsId = getIntent().getIntExtra("detailsId", 0);
        presenter.getData(detailsId);
    }

    @Override
    protected void initView() {
        presenter.attachView(this);
        RecyclerView rv_details_content = findViewById(R.id.rv_details_content);
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        rv_details_content.setLayoutManager(layoutManager);
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rv_details_content.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 20);
        firstlayout();
        secondlayout();
        thirdlayout();
        fourthlayout();
        fifthlayout();
        delegateAdapter = new DelegateAdapter(layoutManager, false);
        delegateAdapter.addAdapter(detailsContentFirstAdapter);
        delegateAdapter.addAdapter(detailsContentSecondAdapter);
        delegateAdapter.addAdapter(detailsContentThirdAdapter);
        delegateAdapter.addAdapter(detailsContentFourthAdapter);
        rv_details_content.setAdapter(delegateAdapter);
    }

    private void fifthlayout() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        // 创建对应的LayoutHelper对象

        // 所有布局的公共属性（属性会在下面详细说明）
        linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色

        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(1); // 设置每行Item的距离
    }

    private void fourthlayout() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        // 创建对应的LayoutHelper对象

        // 所有布局的公共属性（属性会在下面详细说明）
        linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色

        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(1); // 设置每行Item的距离
        detailsContentFourthAdapter = new DetailsContentFourthAdapter(this, linearLayoutHelper);
    }

    private void thirdlayout() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        // 创建对应的LayoutHelper对象

        // 所有布局的公共属性（属性会在下面详细说明）
        linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色

        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(1); // 设置每行Item的距离
        infoBeans = new ArrayList<>();
        detailsContentThirdAdapter = new DetailsContentThirdAdapter(this, linearLayoutHelper, infoBeans);
    }

    private void secondlayout() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        // 创建对应的LayoutHelper对象

        // 所有布局的公共属性（属性会在下面详细说明）
        linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色

        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(1); // 设置每行Item的距离
        detailsContentSecondAdapter = new DetailsContentSecondAdapter(this, linearLayoutHelper);
    }

    private void firstlayout() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        // 创建对应的LayoutHelper对象

        // 所有布局的公共属性（属性会在下面详细说明）
        linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色

        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(1); // 设置每行Item的距离
        galleryBeans = new ArrayList<>();
        detailsContentFirstAdapter = new DetailsContentFirstAdapter(this, linearLayoutHelper, galleryBeans);
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
    public void onDetailsContentSuccess(DetailsContentBean.DataBean dataBean) {
        List<DetailsContentBean.DataBean.GalleryBean> gallery = dataBean.getGallery();
        galleryBeans.addAll(gallery);
        detailsContentFirstAdapter.notifyDataSetChanged();
        infoBeans.add(dataBean.getInfo());
        detailsContentThirdAdapter.notifyDataSetChanged();
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