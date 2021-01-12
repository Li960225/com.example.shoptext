package com.example.shoptext.detailslist.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mylibrary.base.BaseFragment;
import com.example.shoptext.R;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.detailslist.adapter.DetailsAdapter;
import com.example.shoptext.detailslist.bean.DetailsBean;
import com.example.shoptext.detailslist.presenter.DetailsPresenter;
import com.example.shoptext.detailslist.view.DetailsContentActivity;

import java.util.ArrayList;
import java.util.List;

public class DetailsFragment extends BaseFragment<DetailsPresenter> implements HomeContract.iDetailsView {

    private RecyclerView rv_details;
    private ArrayList<DetailsBean.DataBean.DataBeans> list;
    private DetailsAdapter detailsAdapter;

    @Override
    protected void initData() {
        int detailId = getArguments().getInt("detailId");
        presenter.getData(detailId,1,100);
    }

    @Override
    protected void initView(View view) {
        presenter.attachView(this);
        rv_details = view.findViewById(R.id.rv_details);

        list = new ArrayList<>();
        rv_details.setLayoutManager(new GridLayoutManager(getActivity(),2));
        detailsAdapter = new DetailsAdapter(getActivity(), list);
        rv_details.setAdapter(detailsAdapter);

        initListener();
    }

    private void initListener() {
        detailsAdapter.setOnClickItemListener(new DetailsAdapter.OnClickItemListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), DetailsContentActivity.class);
                intent.putExtra("detailsId",list.get(position).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_details;
    }

    @Override
    protected DetailsPresenter getPresenter() {
        return new DetailsPresenter();
    }

    @Override
    public void onDetailsSuccess(List<DetailsBean.DataBean.DataBeans> dataBeans) {
        list.addAll(dataBeans);
        detailsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDetailsFail(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}