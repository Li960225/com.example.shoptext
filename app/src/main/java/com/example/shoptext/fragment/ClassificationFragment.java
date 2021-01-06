package com.example.shoptext.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mylibrary.base.BaseFragment;
import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.base.BaseView;
import com.example.shoptext.R;
import com.example.shoptext.bean.ClassificationBean;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.presenter.ClassificationPresenterImp;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ClassificationFragment extends BaseFragment<ClassificationPresenterImp> implements HomeContract.iClassificationView,BaseView {

    private TabLayout tab_classification;
    private RecyclerView rv_classification_first;
    private RecyclerView rv_classification_second;
    private ImageView iv_classification_img;
    private ImageView tv_classification_title;

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    protected void initView(View view) {
        presenter.attachView(this);
        rv_classification_first = view.findViewById(R.id.rv_classification_first);
        rv_classification_second = view.findViewById(R.id.rv_classification_second);
        iv_classification_img = view.findViewById(R.id.iv_classification_img);
        tv_classification_title = view.findViewById(R.id.tv_classification_title);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_classification;
    }

    @Override
    protected ClassificationPresenterImp getPresenter() {
        return new ClassificationPresenterImp();
    }

    @Override
    public void onClassificationSuccess(List<ClassificationBean.DataBean.CategoryListBean> data) {

    }

    @Override
    public void onClassificationFail(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}