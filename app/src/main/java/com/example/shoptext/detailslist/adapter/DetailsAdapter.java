package com.example.shoptext.detailslist.adapter;

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
import com.example.shoptext.detailslist.bean.DetailsBean;

import java.util.List;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {
    private Context mContext;
    private List<DetailsBean.DataBean.DataBeans> mData;
    private OnClickItemListener onClickItemListener;

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    public DetailsAdapter(Context mContext, List<DetailsBean.DataBean.DataBeans> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public DetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_details, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsAdapter.ViewHolder holder, int position) {
        Glide.with(mContext).load(mData.get(position).getListPicUrl()).into(holder.iv_details_img);
        holder.tv_details_title.setText(mData.get(position).getName());
        holder.tv_details_price.setText("￥"+mData.get(position).getRetailPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_details_img;
        private TextView tv_details_title;
        private TextView tv_details_price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_details_img = itemView.findViewById(R.id.iv_details_img);
            tv_details_title = itemView.findViewById(R.id.tv_details_title);
            tv_details_price = itemView.findViewById(R.id.tv_details_price);
        }
    }

    public interface OnClickItemListener{
        void onClick(int position);
    }
}
