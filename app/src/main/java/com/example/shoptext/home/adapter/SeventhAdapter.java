package com.example.shoptext.home.adapter;

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
import com.example.shoptext.home.bean.HomeBean;

import java.util.List;

public class SeventhAdapter extends DelegateAdapter.Adapter<SeventhAdapter.ViewHolder> {
    private Context mContext;
    private GridLayoutHelper gridLayoutHelper;
    private List<HomeBean.DataBean.NewGoodsListBean> mData;
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public SeventhAdapter(Context mContext, GridLayoutHelper gridLayoutHelper, List<HomeBean.DataBean.NewGoodsListBean> mData) {
        this.mContext = mContext;
        this.gridLayoutHelper = gridLayoutHelper;
        this.mData = mData;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public SeventhAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_home_seventh, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SeventhAdapter.ViewHolder holder, int position) {
        String list_pic_url = mData.get(position).getList_pic_url();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(list_pic_url);
        stringBuffer.insert(4,"s");
        Glide.with(mContext).load(stringBuffer.toString()).into(holder.ivseventhimg);
        holder.tvsevenname.setText(mData.get(position).getName());
        holder.tvseventhprice.setText("￥"+mData.get(position).getRetail_price());
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
        private ImageView ivseventhimg;
        private TextView tvsevenname;
        private TextView tvseventhprice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivseventhimg = itemView.findViewById(R.id.iv_seventh_img);
            tvsevenname = itemView.findViewById(R.id.tv_seventh_name);
            tvseventhprice = itemView.findViewById(R.id.tv_seventh_price);
        }
    }

    public interface OnClickListener{
        void onClick(int position);
    }
}
