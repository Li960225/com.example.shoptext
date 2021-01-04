package com.example.shoptext.fragment;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mylibrary.base.BaseFragment;
import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.base.BaseView;
import com.example.shoptext.MainActivity;
import com.example.shoptext.R;
import com.example.shoptext.bean.LoginBean;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.presenter.MinePresenterImp;

import java.util.List;

public class MineFragment extends BaseFragment<MinePresenterImp> implements HomeContract.iMineView, BaseView, View.OnClickListener {

    private EditText et_mine_name;
    private EditText et_mine_pwd;
    private Button btn_mine_login;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        presenter.attachView(this);
        et_mine_name = view.findViewById(R.id.et_mine_name);
        et_mine_pwd = view.findViewById(R.id.et_mine_pwd);
        btn_mine_login = view.findViewById(R.id.btn_mine_login);
        btn_mine_login.setOnClickListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected MinePresenterImp getPresenter() {
        return new MinePresenterImp();
    }

    @Override
    public String userName() {
        return et_mine_name.getText().toString();
    }

    @Override
    public String passWord() {
        return et_mine_pwd.getText().toString();
    }

    @Override
    public void onMineSuccess() {
        startActivity(new Intent(getActivity(), MainActivity.class));
    }

    @Override
    public void onMineFail(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_mine_login){
            if (!TextUtils.isEmpty(userName())&&!TextUtils.isEmpty(passWord())){
                presenter.getData(userName(),passWord());
            }else {
                Toast.makeText(getActivity(), "账号密码不能为空", Toast.LENGTH_SHORT).show();
            }
        }
    }
}