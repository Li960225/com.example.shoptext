package com.example.shoptext;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.shoptext.classification.view.ClassificationFragment;
import com.example.shoptext.home.view.HomeFragment;
import com.example.shoptext.mine.view.fragment.MineFragment;
import com.example.shoptext.shopping.view.ShoppingFragment;
import com.example.shoptext.special.view.SpecialFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvSearch;
    private RadioButton btnHome;
    private RadioButton btnSpecial;
    private RadioButton btnClassification;
    private RadioButton btnShoping;
    private RadioButton btnMine;
    private HomeFragment homeFragment;
    private SpecialFragment specialFragment;
    private ClassificationFragment classificationFragment;
    private ShoppingFragment shoppingFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDefultView();
        initView();
    }

    private void initView() {
        tvSearch = findViewById(R.id.tv_search);
        btnHome = findViewById(R.id.btn_home);
        btnSpecial = findViewById(R.id.btn_special);
        btnClassification = findViewById(R.id.btn_classification);
        btnShoping = findViewById(R.id.btn_shoping);
        btnMine = findViewById(R.id.btn_mine);

        btnHome.setOnClickListener(this);
        btnSpecial.setOnClickListener(this);
        btnClassification.setOnClickListener(this);
        btnShoping.setOnClickListener(this);
        btnMine.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = manager.beginTransaction();
        hidtFragment(beginTransaction);
        switch (v.getId()){
            case R.id.btn_home:
                if (homeFragment == null){
                    homeFragment = new HomeFragment();
                    beginTransaction
                            .add(R.id.fl_main,homeFragment);
                }else {
                    beginTransaction
                            .show(homeFragment);
                }
                break;
            case R.id.btn_special:
                if (specialFragment == null){
                    specialFragment = new SpecialFragment();
                    beginTransaction.add(R.id.fl_main,specialFragment);
                }else {
                    beginTransaction
                            .show(specialFragment);
                }
                break;
            case R.id.btn_classification:
                if (classificationFragment == null){
                    classificationFragment = new ClassificationFragment();
                    beginTransaction.add(R.id.fl_main, classificationFragment);
                }else {
                    beginTransaction
                            .show(classificationFragment);
                }
                break;
            case R.id.btn_shoping:
                if (shoppingFragment == null){
                    shoppingFragment = new ShoppingFragment();
                    beginTransaction.add(R.id.fl_main, shoppingFragment);
                }else {
                    beginTransaction
                            .show(shoppingFragment);
                }
                break;
            case R.id.btn_mine:
                if (mineFragment == null){
                    mineFragment = new MineFragment();
                    beginTransaction.add(R.id.fl_main, mineFragment);
                }else {
                    beginTransaction
                            .show(mineFragment);
                }
                break;
        }
        beginTransaction.commit();
    }

    private void hidtFragment(FragmentTransaction beginTransaction) {
        if (homeFragment != null){
            beginTransaction.hide(homeFragment);
        }
        if (specialFragment != null){
            beginTransaction.hide(specialFragment);
        }
        if (classificationFragment != null){
            beginTransaction.hide(classificationFragment);
        }
        if (shoppingFragment != null){
            beginTransaction.hide(shoppingFragment);
        }
        if (mineFragment != null){
            beginTransaction.hide(mineFragment);
        }
    }

    private void initDefultView() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        homeFragment = new HomeFragment();
        ft.add(R.id.fl_main, homeFragment);
        ft.commit();
    }
}