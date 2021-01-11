package com.example.shoptext.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shoptext.R;
import com.example.shoptext.home.bean.HomeBean;

import java.util.List;

public class ThirteenthAdapter extends RecyclerView.Adapter<ThirteenthAdapter.ViewHolder> {
    private Context mContext;
    private List<HomeBean.DataBean.CategoryListBean.GoodsListBean> mData;
    private OnClickListener1 onClickListener1;

    public void setOnClickListener(OnClickListener1 onClickListener1) {
        this.onClickListener1 = onClickListener1;
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
                onClickListener1.onClick(position);
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

    public interface OnClickListener1{
        void onClick(int positio);
    }
}
