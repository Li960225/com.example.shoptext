package com.example.shoptext.mine.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mylibrary.base.BaseActivity;
import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.base.BaseView;
import com.example.shoptext.MainActivity;
import com.example.shoptext.R;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.mine.presenter.LoginHomePresenterImp;
import com.example.shoptext.register.view.RegisterActivity;

public class LoginHomeActivity extends BaseActivity<LoginHomePresenterImp> implements HomeContract.iLoginHomeView, BaseView, View.OnClickListener {
    private EditText et_mine_name;
    private EditText et_mine_pwd;
    private Button btn_mine_login;
    private Button btn_mine_register;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        presenter.attachView(this);
        et_mine_name = findViewById(R.id.et_mine_name);
        et_mine_pwd = findViewById(R.id.et_mine_pwd);
        btn_mine_login = findViewById(R.id.btn_mine_login);
        btn_mine_register = findViewById(R.id.btn_mine_register);
        btn_mine_login.setOnClickListener(this);
        btn_mine_register.setOnClickListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login_home;
    }

    @Override
    protected LoginHomePresenterImp getPresenter() {
        return new LoginHomePresenterImp();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_mine_login){
            if (!TextUtils.isEmpty(userName())&&!TextUtils.isEmpty(passWord())){
                presenter.getData(userName(),passWord());
            }else {
                Toast.makeText(this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
            }
        }
        if (v.getId()==R.id.btn_mine_register){
            startActivity(new Intent(LoginHomeActivity.this, RegisterActivity.class));
        }
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
    public void onLoginHomeSuccess() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void onLoginHomeFail(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}