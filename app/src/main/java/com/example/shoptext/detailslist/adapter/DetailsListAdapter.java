package com.example.shoptext.detailslist.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.shoptext.detailslist.bean.DetailsListBean;

import java.util.List;

public class DetailsListAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private List<DetailsListBean.DataBean.BrotherCategoryBean> mData;

    public DetailsListAdapter(@NonNull FragmentManager fm, List<Fragment> fragments, List<DetailsListBean.DataBean.BrotherCategoryBean> mData) {
        super(fm);
        this.fragments = fragments;
        this.mData = mData;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mData.get(position).getName();
    }
}
