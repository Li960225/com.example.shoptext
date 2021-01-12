package com.example.shoptext.register.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylibrary.base.BaseActivity;
import com.example.mylibrary.base.BaseView;
import com.example.shoptext.MainActivity;
import com.example.shoptext.R;
import com.example.shoptext.contract.HomeContract;
import com.example.shoptext.mine.view.activity.LoginHomeActivity;
import com.example.shoptext.register.bean.RegisterBean;
import com.example.shoptext.register.presenter.RegisterPresenterImp;

import java.util.List;

public class RegisterActivity extends BaseActivity<RegisterPresenterImp> implements HomeContract.iRegisterView, BaseView, View.OnClickListener {

    private EditText etRegisterName;
    private EditText etRegisterPassword;
    private EditText etRegisterIspassword;
    private Button btnRegister;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        presenter.attachView(this);
        etRegisterName = findViewById(R.id.et_register_name);
        etRegisterPassword = findViewById(R.id.et_register_password);
        etRegisterIspassword = findViewById(R.id.et_register_ispassword);
        btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected RegisterPresenterImp getPresenter() {
        return new RegisterPresenterImp();
    }

    @Override
    public void onRegisterSuccess(RegisterBean registerBean) {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, LoginHomeActivity.class));
        finish();
    }

    @Override
    public void onRegisterFail(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register:
                presenter.getData(etRegisterName.getText().toString(),etRegisterPassword.getText().toString(),etRegisterIspassword.getText().toString());
                break;
        }
    }
}