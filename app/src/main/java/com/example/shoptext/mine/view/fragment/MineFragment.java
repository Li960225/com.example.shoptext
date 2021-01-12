package com.example.shoptext.mine.view.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylibrary.base.BaseFragment;
import com.example.mylibrary.base.BasePresenter;
import com.example.shoptext.R;
import com.example.shoptext.mine.adapter.MineAdapter;
import com.example.shoptext.mine.view.activity.LoginHomeActivity;

import java.util.ArrayList;

public class MineFragment extends BaseFragment implements View.OnClickListener, MineAdapter.OnClickItemListener {

    private ImageView iv_mine_header_img;
    private TextView tv_mine_header_longin;
    private ImageView iv_mine_header_forward;
    private RecyclerView rv_mine;
    private ArrayList<String> strings;

    @Override
    protected void initData() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(R.drawable.a3);
        integers.add(R.drawable.a4);
        integers.add(R.drawable.a5);
        integers.add(R.drawable.a6);
        integers.add(R.drawable.a7);
        integers.add(R.drawable.a3);
        integers.add(R.drawable.a4);
        integers.add(R.drawable.a5);
        integers.add(R.drawable.a6);
        integers.add(R.drawable.a7);
        integers.add(R.drawable.a3);
        strings = new ArrayList<>();
        strings.add("我的订单");
        strings.add("优惠券");
        strings.add("礼品卡");
        strings.add("我的收藏");
        strings.add("我的足迹");
        strings.add("会员福利");
        strings.add("地址管理");
        strings.add("账号安全");
        strings.add("联系客服");
        strings.add("帮助中心");
        strings.add("意见反馈");
        MineAdapter mineAdapter = new MineAdapter(getActivity(), integers, strings);
        rv_mine.setLayoutManager(new GridLayoutManager(getActivity(),3));
        rv_mine.setAdapter(mineAdapter);

        mineAdapter.setOnClickItemListener(this);
    }

    @Override
    protected void initView(View view) {
        iv_mine_header_img = view.findViewById(R.id.iv_mine_header_img);
        tv_mine_header_longin = view.findViewById(R.id.tv_mine_header_longin);
        iv_mine_header_forward = view.findViewById(R.id.iv_mine_header_forward);
        rv_mine = view.findViewById(R.id.rv_mine);

        tv_mine_header_longin.setText("点击登录");
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

    @Override
    public void onClick(int position) {
        Toast.makeText(getActivity(), strings.get(position), Toast.LENGTH_SHORT).show();
    }
}