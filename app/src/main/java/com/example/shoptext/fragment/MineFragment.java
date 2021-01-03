package com.example.shoptext.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mylibrary.base.BaseFragment;
import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.base.BaseView;
import com.example.shoptext.R;

public class MineFragment extends BaseFragment implements BaseView {

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }
}