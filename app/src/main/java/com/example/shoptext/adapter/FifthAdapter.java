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

public class FifthAdapter extends DelegateAdapter.Adapter {
    private Context mContext;
    private GridLayoutHelper gridLayoutHelper;
    private List<HomeBean.DataBean.BrandListBean> mData;
    private FifthAdapter.OnClickListener onClickListener;

    public void setOnClickListener(FifthAdapter.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public FifthAdapter(Context mContext, GridLayoutHelper gridLayoutHelper, List<HomeBean.DataBean.BrandListBean> mData) {
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
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_home_fifth, parent, false);
        return new FifthAdapter.ViewHolder_t(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FifthAdapter.ViewHolder_t viewHolder_t = (FifthAdapter.ViewHolder_t) holder;
        String new_pic_url = mData.get(position).getNew_pic_url();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new_pic_url);
        stringBuffer.insert(4,"s");
        Glide.with(mContext).load(stringBuffer.toString()).into(viewHolder_t.iv_img_t);
        viewHolder_t.tv_name.setText(mData.get(position).getName());
        viewHolder_t.tv_price.setText(mData.get(position).getFloor_price()+"");
        viewHolder_t.itemView.setOnClickListener(new View.OnClickListener() {
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

    public class ViewHolder_t extends RecyclerView.ViewHolder {
        private ImageView iv_img_t;
        private TextView tv_name;
        private TextView tv_price;
        public ViewHolder_t(@NonNull View itemView) {
            super(itemView);
            iv_img_t = itemView.findViewById(R.id.iv_fourth_two_img);
            tv_name = itemView.findViewById(R.id.tv_make_name);
            tv_price = itemView.findViewById(R.id.tv_make_price);
        }
    }

    public interface OnClickListener {
        void onClick(int position);
    }
}
