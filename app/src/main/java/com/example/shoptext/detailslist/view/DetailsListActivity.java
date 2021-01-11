package com.example.shoptext.detailslist.view;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mylibrary.base.BaseActivity;
import com.example.mylibrary.base.BaseView;
import com.example.shoptext.R;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.detailslist.adapter.DetailsListAdapter;
import com.example.shoptext.detailslist.bean.DetailsListBean;
import com.example.shoptext.detailslist.fragment.DetailsFragment;
import com.example.shoptext.detailslist.presenter.DetailsListPresenterImp;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class DetailsListActivity extends BaseActivity<DetailsListPresenterImp> implements HomeContract.iDetailsListView, BaseView {

    private TabLayout tabDetailsList;
    private ViewPager vpDetailsList;
    private TextView tv_details_home_title;
    private TextView tv_details_home_subtitle;
    private int homeId;

    @Override
    protected void initData() {
        homeId = getIntent().getIntExtra("homeId", 0);
        presenter.getData(homeId);
    }

    @Override
    protected void initView() {
        presenter.attachView(this);
        tabDetailsList = findViewById(R.id.tab_details_list);
        vpDetailsList = findViewById(R.id.vp_details_list);
        tv_details_home_title = findViewById(R.id.tv_details_home_title);
        tv_details_home_subtitle = findViewById(R.id.tv_details_home_subtitle);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_details_list;
    }

    @Override
    protected DetailsListPresenterImp getPresenter() {
        return new DetailsListPresenterImp();
    }

    @Override
    public void onDetailsListSuccess(List<DetailsListBean.DataBean.BrotherCategoryBean> brotherCategoryBeans) {
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < brotherCategoryBeans.size(); i++) {
            DetailsFragment detailsFragment = new DetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("detailId",brotherCategoryBeans.get(i).getId());
            detailsFragment.setArguments(bundle);
            fragments.add(detailsFragment);
        }
        DetailsListAdapter detailsListAdapter = new DetailsListAdapter(getSupportFragmentManager(), fragments, brotherCategoryBeans);
        vpDetailsList.setAdapter(detailsListAdapter);
        tabDetailsList.setupWithViewPager(vpDetailsList);

        vpDetailsList.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tv_details_home_title.setText(brotherCategoryBeans.get(position).getName());
                tv_details_home_subtitle.setText(brotherCategoryBeans.get(position).getFrontDesc());
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onDetailsListFail(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}