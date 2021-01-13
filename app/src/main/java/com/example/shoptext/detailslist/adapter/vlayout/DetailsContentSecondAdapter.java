package com.example.shoptext.detailslist.adapter.vlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.shoptext.R;
import com.example.shoptext.detailslist.bean.DetailsContentBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

public class DetailsContentSecondAdapter extends DelegateAdapter.Adapter<DetailsContentSecondAdapter.ViewHolder> {
    private Context mContext;
    private LinearLayoutHelper linearLayoutHelper;

    public DetailsContentSecondAdapter(Context mContext, LinearLayoutHelper linearLayoutHelper) {
        this.mContext = mContext;
        this.linearLayoutHelper = linearLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public DetailsContentSecondAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_details_content_second, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsContentSecondAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
