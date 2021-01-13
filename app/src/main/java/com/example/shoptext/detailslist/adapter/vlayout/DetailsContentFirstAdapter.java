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

import java.util.ArrayList;
import java.util.List;

public class DetailsContentFirstAdapter extends DelegateAdapter.Adapter<DetailsContentFirstAdapter.ViewHolder> {
    private Context mContext;
    private LinearLayoutHelper linearLayoutHelper;
    private List<DetailsContentBean.DataBean.GalleryBean> gallery;

    public DetailsContentFirstAdapter(Context mContext, LinearLayoutHelper linearLayoutHelper, List<DetailsContentBean.DataBean.GalleryBean> gallery) {
        this.mContext = mContext;
        this.linearLayoutHelper = linearLayoutHelper;
        this.gallery = gallery;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public DetailsContentFirstAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_details_content_first, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsContentFirstAdapter.ViewHolder holder, int position) {
        holder.banner_details_content_first.setImages(gallery)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        DetailsContentBean.DataBean.GalleryBean db = (DetailsContentBean.DataBean.GalleryBean) path;
                        Glide.with(context).load(db.getImgUrl()).into(imageView);
                    }
                }).start();
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private Banner banner_details_content_first;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            banner_details_content_first = itemView.findViewById(R.id.banner_details_content_first);
        }
    }
}
