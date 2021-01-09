package com.example.shoptext.special.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;

import com.example.mylibrary.base.BaseFragment;
import com.example.mylibrary.base.BaseView;
import com.example.shoptext.R;
import com.example.shoptext.special.adapter.SpecialAdapter;
import com.example.shoptext.special.bean.SpecialBean;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.special.presenter.SpecialPresenterImp;

import java.util.ArrayList;
import java.util.List;

public class SpecialFragment extends BaseFragment<SpecialPresenterImp> implements HomeContract.iSpecialView,BaseView {

    private RecyclerView rv_special;
    private ArrayList<SpecialBean.DataBean.DataBeans> list;
    private SpecialAdapter specialAdapter;

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    protected void initView(View view) {
        presenter.attachView(this);
        rv_special = view.findViewById(R.id.rv_special);
        list = new ArrayList<>();
        rv_special.setLayoutManager(new LinearLayoutManager(getActivity()));
        specialAdapter = new SpecialAdapter(getActivity(), list);
        rv_special.setAdapter(specialAdapter);
        initListener();
    }

    private void initListener() {
        specialAdapter.setOnClickListener(new SpecialAdapter.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_special_two_up:
                        Toast.makeText(getActivity(), "上一页", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.btn_special_two_dpwn:
                        Toast.makeText(getActivity(), "下一页", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onClick(int position) {
                Toast.makeText(getActivity(), list.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_special;
    }

    @Override
    protected SpecialPresenterImp getPresenter() {
        return new SpecialPresenterImp();
    }

    @Override
    public void onSpecialSuccess(List<SpecialBean.DataBean.DataBeans> data) {
        list.addAll(data);
        specialAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSpecialFail(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}