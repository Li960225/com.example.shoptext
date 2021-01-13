package com.example.shoptext.detailslist.adapter.vlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.shoptext.R;
import com.example.shoptext.detailslist.bean.DetailsContentBean;

import java.util.List;

public class DetailsContentThirdAdapter extends DelegateAdapter.Adapter<DetailsContentThirdAdapter.ViewHolder> {
    private Context mContext;
    private LinearLayoutHelper linearLayoutHelper;
    private List<DetailsContentBean.DataBean.InfoBean> infoBean;

    public DetailsContentThirdAdapter(Context mContext, LinearLayoutHelper linearLayoutHelper, List<DetailsContentBean.DataBean.InfoBean> infoBean) {
        this.mContext = mContext;
        this.linearLayoutHelper = linearLayoutHelper;
        this.infoBean = infoBean;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public DetailsContentThirdAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_details_content_third, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsContentThirdAdapter.ViewHolder holder, int position) {
        holder.tv_details_content_third_title.setText(infoBean.get(position).getName());
        holder.tv_details_content_third_subtitle.setText(infoBean.get(position).getGoodsBrief());
        holder.tv_details_content_third_price.setText("￥"+infoBean.get(position).getRetailPrice());
    }

    @Override
    public int getItemCount() {
        return infoBean.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_details_content_third_title;
        private TextView tv_details_content_third_subtitle;
        private TextView tv_details_content_third_price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_details_content_third_title = itemView.findViewById(R.id.tv_details_content_third_title);
            tv_details_content_third_subtitle = itemView.findViewById(R.id.tv_details_content_third_subtitle);
            tv_details_content_third_price = itemView.findViewById(R.id.tv_details_content_third_price);
        }
    }
}
