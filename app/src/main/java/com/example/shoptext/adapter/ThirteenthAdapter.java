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
import com.bumptech.glide.Glide;
import com.example.shoptext.R;
import com.example.shoptext.bean.HomeBean;

import java.util.List;

public class ThirteenthAdapter extends RecyclerView.Adapter<ThirteenthAdapter.ViewHolder> {
    private Context mContext;
    private List<HomeBean.DataBean.CategoryListBean.GoodsListBean> mData;
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public ThirteenthAdapter(Context mContext, List<HomeBean.DataBean.CategoryListBean.GoodsListBean> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ThirteenthAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_home_thirteenth, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThirteenthAdapter.ViewHolder holder, int position) {
        HomeBean.DataBean.CategoryListBean.GoodsListBean goodsListBean = mData.get(position);
        StringBuffer stringBuffer = new StringBuffer().append(goodsListBean.getList_pic_url()).insert(4, "s");
        Glide.with(mContext).load(stringBuffer.toString()).into(holder.ivthirteenthimg);
        holder.tvthirteenthname.setText(goodsListBean.getName());
        holder.tvthirteenthprice.setText("￥"+goodsListBean.getRetail_price());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivthirteenthimg;
        private TextView tvthirteenthname;
        private TextView tvthirteenthprice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivthirteenthimg = itemView.findViewById(R.id.iv_thirteenth_img);
            tvthirteenthname = itemView.findViewById(R.id.tv_thirteenth_name);
            tvthirteenthprice = itemView.findViewById(R.id.tv_thirteenth_price);
        }
    }

    public interface OnClickListener{
        void onClick(int position);
    }
}
