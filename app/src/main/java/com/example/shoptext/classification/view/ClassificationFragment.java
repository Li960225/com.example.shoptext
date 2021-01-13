package com.example.shoptext.classification.view;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mylibrary.base.BaseFragment;
import com.example.mylibrary.base.BaseView;
import com.example.shoptext.R;
import com.example.shoptext.classification.adapter.ClassificationOneAdapter;
import com.example.shoptext.classification.adapter.ClassificationTwoAdapter;
import com.example.shoptext.classification.bean.ClassificationOneBean;
import com.example.shoptext.classification.bean.ClassificationTwoBean;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.classification.presenter.ClassificationOnePresenterImp;

import java.util.ArrayList;
import java.util.List;

public class ClassificationFragment extends BaseFragment<ClassificationOnePresenterImp> implements HomeContract.iClassificationView, BaseView, ClassificationOneAdapter.OnClickItemOneListener, ClassificationTwoAdapter.OnClickItemTwoListener {

    private RecyclerView rv_classification_first;
    private RecyclerView rv_classification_second;
    private ImageView iv_classification_img;
    private TextView tv_classification_title;
    private ArrayList<ClassificationOneBean.DataBean.CategoryListBean> categoryListBeans;
    private ClassificationOneAdapter classificationOneAdapter;
    private ArrayList<ClassificationTwoBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryListBeans;
    private ClassificationTwoAdapter classificationTwoAdapter;

    @Override
    protected void initData() {
        presenter.getOneData();
    }

    @Override
    protected void initView(View view) {
        presenter.attachView(this);
        rv_classification_first = view.findViewById(R.id.rv_classification_first);
        rv_classification_second = view.findViewById(R.id.rv_classification_second);
        iv_classification_img = view.findViewById(R.id.iv_classification_img);
        tv_classification_title = view.findViewById(R.id.tv_classification_title);

        categoryListBeans = new ArrayList<>();
        rv_classification_first.setLayoutManager(new LinearLayoutManager(getActivity()));
        classificationOneAdapter = new ClassificationOneAdapter(getActivity(), categoryListBeans);
        rv_classification_first.setAdapter(classificationOneAdapter);

        subCategoryListBeans = new ArrayList<>();
        rv_classification_second.setLayoutManager(new GridLayoutManager(getActivity(),3));
        classificationTwoAdapter = new ClassificationTwoAdapter(getActivity(), subCategoryListBeans);
        rv_classification_second.setAdapter(classificationTwoAdapter);
        presenter.getTwoData(1005000);

        initListener();
    }

    private void initListener() {
        classificationOneAdapter.setOnClickItemOneListener(this);
        classificationTwoAdapter.setOnClickItemTwoListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_classification;
    }

    @Override
    protected ClassificationOnePresenterImp getPresenter() {
        return new ClassificationOnePresenterImp();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void onClassificationOneSuccess(List<ClassificationOneBean.DataBean.CategoryListBean> data) {
        categoryListBeans.addAll(data);
        classificationOneAdapter.notifyDataSetChanged();
        Glide.with(getActivity()).load(categoryListBeans.get(0).getWapBannerUrl()).into(iv_classification_img);
        tv_classification_title.setText("————"+categoryListBeans.get(0).getName()+"分类————");
    }

    @Override
    public void onClassificationOneFail(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClassificationTwoSuccess(List<ClassificationTwoBean.DataBean.CurrentCategoryBean.SubCategoryListBean> data) {
        if (subCategoryListBeans!=null&&subCategoryListBeans.size()>0){
            subCategoryListBeans.clear();
            subCategoryListBeans.addAll(data);
        }else {
            subCategoryListBeans.addAll(data);
        }
        classificationTwoAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClassificatioTwoFail(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickOne(int position) {
        Glide.with(getActivity()).load(categoryListBeans.get(position).getWapBannerUrl()).into(iv_classification_img);
        tv_classification_title.setText("————"+categoryListBeans.get(position).getName()+"分类————");
        int id = categoryListBeans.get(position).getId();
        presenter.getTwoData(id);
    }

    @Override
    public void onClickTwo(int position) {
        startActivity(new Intent(getActivity(),ClassificationListActivity.class));
    }
}