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
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.shoptext.R;
import com.example.shoptext.bean.HomeBean;

import java.util.List;

public class NinthAdapter extends DelegateAdapter.Adapter<NinthAdapter.ViewHolder> {
    private Context mContext;
    private LinearLayoutHelper linearLayoutHelper;
    private List<HomeBean.DataBean.HotGoodsListBean> mData;
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public NinthAdapter(Context mContext, LinearLayoutHelper linearLayoutHelper, List<HomeBean.DataBean.HotGoodsListBean> mData) {
        this.mContext = mContext;
        this.linearLayoutHelper = linearLayoutHelper;
        this.mData = mData;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public NinthAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_home_ninth, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NinthAdapter.ViewHolder holder, int position) {
        String list_pic_url = mData.get(position).getList_pic_url();
        StringBuffer stringBuffer = new StringBuffer().append(list_pic_url).insert(4, "s");
        Glide.with(mContext).load(stringBuffer.toString()).into(holder.ivninthimg);
        holder.tvninthname.setText(mData.get(position).getName());
        holder.tvninthbrief.setText(mData.get(position).getGoods_brief());
        holder.tvninthprice.setText("￥"+mData.get(position).getRetail_price());
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
        private ImageView ivninthimg;
        private TextView tvninthname;
        private TextView tvninthbrief;
        private TextView tvninthprice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivninthimg = itemView.findViewById(R.id.iv_ninth_img);
            tvninthname = itemView.findViewById(R.id.tv_ninth_name);
            tvninthbrief = itemView.findViewById(R.id.tv_ninth_brief);
            tvninthprice = itemView.findViewById(R.id.tv_ninth_price);
        }
    }

    public interface OnClickListener{
        void onClick(int position);
    }
}
