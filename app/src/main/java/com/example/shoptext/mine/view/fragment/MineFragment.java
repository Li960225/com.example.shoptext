package com.example.shoptext.mine.view.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.mylibrary.base.BaseFragment;
import com.example.mylibrary.base.BasePresenter;
import com.example.shoptext.R;
import com.example.shoptext.mine.view.activity.LoginHomeActivity;

public class MineFragment extends BaseFragment implements View.OnClickListener {

    private ImageView iv_mine_header_img;
    private TextView tv_mine_header_longin;
    private ImageView iv_mine_header_forward;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        iv_mine_header_img = view.findViewById(R.id.iv_mine_header_img);
        tv_mine_header_longin = view.findViewById(R.id.tv_mine_header_longin);
        iv_mine_header_forward = view.findViewById(R.id.iv_mine_header_forward);

        tv_mine_header_longin.setOnClickListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(getActivity(), LoginHomeActivity.class));
    }
}