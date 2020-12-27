package com.example.shoptext.adapter;

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
import com.example.shoptext.bean.HomeBean;

import java.util.List;

public class EleventhHoziAdapter extends RecyclerView.Adapter<EleventhHoziAdapter.ViewHolder> {
    private Context mContext;
    private List<HomeBean.DataBean.TopicListBean> mData;
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public EleventhHoziAdapter(Context mContext, List<HomeBean.DataBean.TopicListBean> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public EleventhHoziAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_home_eleventhhozi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EleventhHoziAdapter.ViewHolder holder, int position) {
        HomeBean.DataBean.TopicListBean topicListBean = mData.get(position);
        Glide.with(mContext).load(topicListBean.getItem_pic_url()).into(holder.iveleventhimg);
        holder.tveleventhtitle.setText(topicListBean.getTitle());
        holder.tveleventhprice.setText("    ￥"+topicListBean.getPrice_info()+"元起");
        holder.tveleventhsubtitle.setText(topicListBean.getSubtitle());
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
        private ImageView iveleventhimg;
        private TextView tveleventhtitle;
        private TextView tveleventhprice;
        private TextView tveleventhsubtitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iveleventhimg = itemView.findViewById(R.id.iv_eleventh_img);
            tveleventhtitle = itemView.findViewById(R.id.tv_eleventh_title);
            tveleventhprice = itemView.findViewById(R.id.tv_eleventh_price);
            tveleventhsubtitle = itemView.findViewById(R.id.tv_eleventh_subtitle);
        }
    }

    public interface OnClickListener{
        void onClick(int position);
    }
}
