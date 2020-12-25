package com.example.shoptext.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.mylibrary.base.BaseFragment;
import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.base.BaseView;
import com.example.shoptext.R;
import com.example.shoptext.adapter.FirstAdapter;
import com.example.shoptext.adapter.SecondAdapter;
import com.example.shoptext.adapter.ThirdAdapter;
import com.example.shoptext.bean.HomeBean;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.presenter.HomePresenterImp;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment<HomePresenterImp> implements HomeContract.iHomeView,BaseView {

    private FirstAdapter firstAdapter;
    private ArrayList<HomeBean.DataBean.BannerBean> bannerBeans;
    private SecondAdapter secondAdapter;
    private ArrayList<HomeBean.DataBean.ChannelBean> channelBeans;
    private ThirdAdapter thirdAdapter;

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    protected void initView(View view) {
        presenter.attachView(this);
        RecyclerView rv_home = view.findViewById(R.id.rv_home);
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getActivity());
        rv_home.setLayoutManager(layoutManager);
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rv_home.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0,10);
        firstlayout();
        secondlayout();
        thirdlayout();
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);
        delegateAdapter.addAdapter(firstAdapter);
        delegateAdapter.addAdapter(secondAdapter);
        delegateAdapter.addAdapter(thirdAdapter);
        rv_home.setAdapter(delegateAdapter);
    }

    private void thirdlayout() {
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        // 创建对象

        // 公共属性
        columnLayoutHelper.setItemCount(5);// 设置布局里Item个数
        columnLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        columnLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        columnLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        columnLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比

        // columnLayoutHelper特有属性
        columnLayoutHelper.setWeights(new float[]{20, 20, 20, 20, 20});// 设置该行每个Item占该行总宽度的比例
        channelBeans = new ArrayList<>();
        thirdAdapter = new ThirdAdapter(getActivity(), columnLayoutHelper, channelBeans);
    }

    private void secondlayout() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        // 创建对应的LayoutHelper对象

        // 所有布局的公共属性（属性会在下面详细说明）
        linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色

        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(1); // 设置每行Item的距离
        bannerBeans = new ArrayList<>();
        secondAdapter = new SecondAdapter(getActivity(), linearLayoutHelper, bannerBeans);
    }

    private void firstlayout() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        // 创建对应的LayoutHelper对象

        // 所有布局的公共属性（属性会在下面详细说明）
        linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色

        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(1); // 设置每行Item的距离
        firstAdapter = new FirstAdapter(getActivity(), linearLayoutHelper);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected HomePresenterImp getPresenter() {
        return new HomePresenterImp();
    }

    @Override
    public void onHomeSuccess(HomeBean.DataBean data) {
        List<HomeBean.DataBean.BannerBean> banner = data.getBanner();
        bannerBeans.addAll(banner);
        secondAdapter.notifyDataSetChanged();
        List<HomeBean.DataBean.ChannelBean> channel = data.getChannel();
        channelBeans.addAll(channel);
        thirdAdapter.notifyDataSetChanged();
    }

    @Override
    public void onHomeFail(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}