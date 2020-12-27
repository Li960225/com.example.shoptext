package com.example.shoptext.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.shoptext.R;
import com.example.shoptext.bean.HomeBean;

import java.util.List;

public class TwelfthAdapter extends DelegateAdapter.Adapter {
    private Context mContext;
    private SingleLayoutHelper singleLayoutHelper;
    private List<HomeBean.DataBean.CategoryListBean> mData;
    private OnClickListener onClickListener;
    private int pos;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public TwelfthAdapter(Context mContext, SingleLayoutHelper singleLayoutHelper, List<HomeBean.DataBean.CategoryListBean> mData) {
        this.mContext = mContext;
        this.singleLayoutHelper = singleLayoutHelper;
        this.mData = mData;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_home_twelfth, parent, false);
        return new ViewHolder_o(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder_o viewHolder_o = (ViewHolder_o) holder;
        viewHolder_o.tv_title_o.setText(mData.get(position).getName());
        RecyclerView rvtwelfth = viewHolder_o.rvtwelfth;
        rvtwelfth.setLayoutManager(new GridLayoutManager(mContext,2));
        ThirteenthAdapter thirteenthAdapter = new ThirteenthAdapter(mContext, mData.get(position).getGoodsList());
        rvtwelfth.setAdapter(thirteenthAdapter);
        pos = position;
        thirteenthAdapter.setOnClickListener(new ThirteenthAdapter.OnClickListener1() {
            @Override
            public void onClick(int position) {
                onClickListener.onClick(pos,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder_o extends RecyclerView.ViewHolder {
        private TextView tv_title_o;
        private RecyclerView rvtwelfth;
        public ViewHolder_o(@NonNull View itemView) {
            super(itemView);
            tv_title_o = itemView.findViewById(R.id.tv_fourth_one_title);
            rvtwelfth = itemView.findViewById(R.id.rv_twelfth);
        }
    }

    public interface OnClickListener{
        void onClick(int pos,int position);
    }
}
