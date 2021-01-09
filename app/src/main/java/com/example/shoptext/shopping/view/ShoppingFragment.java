package com.example.shoptext.shopping.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mylibrary.base.BaseFragment;
import com.example.mylibrary.base.BaseView;
import com.example.shoptext.R;
import com.example.shoptext.shopping.adapter.ShoppingDataAdapter;
import com.example.shoptext.shopping.bean.ShoppingDataBean;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.shopping.presenter.ShoppingPresenterImp;

import java.util.ArrayList;
import java.util.List;

public class ShoppingFragment extends BaseFragment<ShoppingPresenterImp> implements HomeContract.iShopDataView, BaseView, ShoppingDataAdapter.OnChoiceItemListener, View.OnClickListener {

    private RecyclerView rv_shop_cart;
    private ArrayList<ShoppingDataBean.DataBean.CartListBean> cartListDTOS;
    private ShoppingDataAdapter shoppingDataAdapter;
    private CheckBox cb_shop_all_choice;
    private TextView tv_shop_number_sum;
    private TextView tv_shop_price_sum;
    private TextView tv_shop_edit;
    private TextView tv_shop_commit;
    private int shop_sum = 0;
    private double price_sum = 0;

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    protected void initView(View view) {
        presenter.attachView(this);
        rv_shop_cart = view.findViewById(R.id.rv_shop_cart);
        cb_shop_all_choice = view.findViewById(R.id.cb_shop_all_choice);
        tv_shop_number_sum = view.findViewById(R.id.tv_shop_number_sum);
        tv_shop_price_sum = view.findViewById(R.id.tv_shop_price_sum);
        tv_shop_edit = view.findViewById(R.id.tv_shop_edit);
        tv_shop_commit = view.findViewById(R.id.tv_shop_commit);

        cartListDTOS = new ArrayList<>();
        rv_shop_cart.setLayoutManager(new LinearLayoutManager(getActivity()));
        shoppingDataAdapter = new ShoppingDataAdapter(getActivity(), cartListDTOS);
        rv_shop_cart.setAdapter(shoppingDataAdapter);
        initListener();
    }

    private void initListener() {
        shoppingDataAdapter.setOnChoiceItemListener(this);
        cb_shop_all_choice.setOnClickListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_shopping;
    }

    @Override
    protected ShoppingPresenterImp getPresenter() {
        return new ShoppingPresenterImp();
    }

    @Override
    public void onShopDataSuccess(List<ShoppingDataBean.DataBean.CartListBean> cartListDTOS) {
        this.cartListDTOS.addAll(cartListDTOS);
        shoppingDataAdapter.notifyDataSetChanged();
    }

    @Override
    public void onShopDataFail(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void onChoice() {
        for (int i = 0; i < cartListDTOS.size(); i++) {

            if(cartListDTOS.get(i).isIschecked()){
                price_sum+= cartListDTOS.get(i).getRetailPrice();
                shop_sum +=1;
            }
        }
        tv_shop_price_sum.setText("￥"+cartListDTOS);
        tv_shop_number_sum.setText("全选("+shop_sum+")");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cb_shop_all_choice:
                if (cb_shop_all_choice.isChecked()){
                    cb_shop_all_choice.setChecked(false);
                    for (int i = 0; i < cartListDTOS.size(); i++) {
                        cartListDTOS.get(i).setIschecked(false);
                    }
                }else {
                    cb_shop_all_choice.setChecked(true);
                    for (int i = 0; i < cartListDTOS.size(); i++) {
                        cartListDTOS.get(i).setIschecked(true);
                    }
                }
                break;
        }
    }
}