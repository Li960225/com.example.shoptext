package com.example.shoptext.special.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shoptext.R;
import com.example.shoptext.special.bean.SpecialBean;

import java.util.List;

public class SpecialAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<SpecialBean.DataBean.DataBeans> mData;
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public SpecialAdapter(Context mContext, List<SpecialBean.DataBean.DataBeans> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==1){
            View view = LayoutInflater.from(mContext).inflate(R.layout.layout_special_two, parent, false);
            return new ViewHolder_t(view);
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_special_one, parent, false);
        return new ViewHolder_o(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType==1){
            ViewHolder_t viewHolder_t = (ViewHolder_t) holder;
            viewHolder_t.btnspecialup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClick(viewHolder_t.btnspecialup);
                }
            });
            viewHolder_t.btnspecialdown.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClick(viewHolder_t.btnspecialdown);
                }
            });
        }
        if (viewType==2){
            ViewHolder_o viewHolder_o = (ViewHolder_o) holder;
            Glide.with(mContext).load(mData.get(position).getScenePicUrl()).into(viewHolder_o.ivspecialimg);
            viewHolder_o.tvspecialtitle.setText(mData.get(position).getTitle());
            viewHolder_o.tvspecialsubtitle.setText(mData.get(position).getSubtitle());
            viewHolder_o.tvspecialprice.setText(mData.get(position).getPriceInfo().toString()+"元起");
            viewHolder_o.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mData.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==mData.size()){
            return 1;
        }
        return 2;
    }

    class ViewHolder_t extends RecyclerView.ViewHolder{
        private Button btnspecialup;
        private Button btnspecialdown;
        public ViewHolder_t(@NonNull View itemView) {
            super(itemView);
            btnspecialup = itemView.findViewById(R.id.btn_special_two_up);
            btnspecialdown = itemView.findViewById(R.id.btn_special_two_dpwn);
        }
    }

    class ViewHolder_o extends RecyclerView.ViewHolder{
        private ImageView ivspecialimg;
        private TextView tvspecialtitle;
        private TextView tvspecialsubtitle;
        private TextView tvspecialprice;
        public ViewHolder_o(@NonNull View itemView) {
            super(itemView);
            ivspecialimg = itemView.findViewById(R.id.iv_special_img);
            tvspecialtitle = itemView.findViewById(R.id.tv_specila_title);
            tvspecialsubtitle = itemView.findViewById(R.id.tv_specila_subtitle);
            tvspecialprice = itemView.findViewById(R.id.tv_specila_price);
        }
    }

    public interface OnClickListener{
        void onClick(View v);
        void onClick(int position);
    }
}
