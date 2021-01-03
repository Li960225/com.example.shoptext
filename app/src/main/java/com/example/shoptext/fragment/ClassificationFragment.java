package com.example.shoptext.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.View;

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

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    protected void initView(View view) {
        presenter.attachView(this);
        tab_classification = view.findViewById(R.id.tab_classification);
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
        FragmentManager manager = getActivity().getSupportFragmentManager();
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            ClassificationChildFragment classificationChildFragment = new ClassificationChildFragment();
            tab_classification.addTab(tab_classification.newTab().setText(data.get(i).getName()));
            Bundle bundle = new Bundle();
            bundle.putInt("id",data.get(i).getId());
            classificationChildFragment.setArguments(bundle);
            fragments.add(classificationChildFragment);
            manager.beginTransaction()
                    .replace(R.id.fl_classification,fragments.get(0))
                    .commit();
        }
    }

    @Override
    public void onClassificationFail(String error) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}