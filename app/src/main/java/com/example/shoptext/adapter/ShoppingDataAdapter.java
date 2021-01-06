package com.example.shoptext.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shoptext.R;
import com.example.shoptext.bean.ShoppingDataBean;

import java.util.List;

public class ShoppingDataAdapter extends RecyclerView.Adapter<ShoppingDataAdapter.ViewHolder> {
    private Context mContext;
    private List<ShoppingDataBean.DataBean.CartListBean> mData;
    private OnChoiceItemListener onChoiceItemListener;

    public void setOnChoiceItemListener(OnChoiceItemListener onChoiceItemListener) {
        this.onChoiceItemListener = onChoiceItemListener;
    }

    public ShoppingDataAdapter(Context mContext, List<ShoppingDataBean.DataBean.CartListBean> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ShoppingDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_shop_data_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingDataAdapter.ViewHolder holder, int position) {
        Glide.with(mContext).load(mData.get(position).getListPicUrl()).into(holder.iv_shop_data_img);
        holder.tv_shop_data_title.setText(mData.get(position).getGoodsName());
        holder.tv_shop_data_price.setText("￥"+mData.get(position).getRetailPrice());
        holder.tv_shop_data_number.setText(mData.get(position).getNumber());
        holder.cb_shop_data_choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mData.get(position).isIschecked()){
                    holder.cb_shop_data_choice.setChecked(false);
                    mData.get(position).setIschecked(false);
                }else {
                    holder.cb_shop_data_choice.setChecked(true);
                    mData.get(position).setIschecked(true);
                }
                onChoiceItemListener.onChoice();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CheckBox cb_shop_data_choice;
        private ImageView iv_shop_data_img;
        private TextView tv_shop_data_title;
        private TextView tv_shop_data_price;
        private TextView tv_shop_data_number;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cb_shop_data_choice = itemView.findViewById(R.id.cb_shop_data_choice);
            iv_shop_data_img = itemView.findViewById(R.id.iv_shop_data_img);
            tv_shop_data_title = itemView.findViewById(R.id.tv_shop_data_title);
            tv_shop_data_price = itemView.findViewById(R.id.tv_shop_data_price);
            tv_shop_data_number = itemView.findViewById(R.id.tv_shop_data_number);
        }
    }

    public interface OnChoiceItemListener{
        void onChoice();
    }
}
