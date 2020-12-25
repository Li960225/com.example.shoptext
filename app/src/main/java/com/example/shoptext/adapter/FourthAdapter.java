package com.example.shoptext.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.shoptext.R;
import com.example.shoptext.bean.HomeBean;

import java.util.List;

public class FourthAdapter extends DelegateAdapter.Adapter {
    private Context mContext;
    private SingleLayoutHelper singleLayoutHelper;

    public FourthAdapter(Context mContext, SingleLayoutHelper singleLayoutHelper) {
        this.mContext = mContext;
        this.singleLayoutHelper = singleLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_home_fourth, parent, false);
        return new ViewHolder_o(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder_o extends RecyclerView.ViewHolder {
        private TextView tv_title_o;

        public ViewHolder_o(@NonNull View itemView) {
            super(itemView);
            tv_title_o = itemView.findViewById(R.id.tv_fourth_one_title);
        }
    }
}
