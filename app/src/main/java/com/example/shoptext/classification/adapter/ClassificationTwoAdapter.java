package com.example.shoptext.classification.adapter;

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
import com.example.shoptext.classification.bean.ClassificationOneBean;
import com.example.shoptext.classification.bean.ClassificationTwoBean;

import java.util.List;

public class ClassificationTwoAdapter extends RecyclerView.Adapter<ClassificationTwoAdapter.ViewHolder> {
    private Context mContext;
    private List<ClassificationTwoBean.DataBean.CurrentCategoryBean.SubCategoryListBean> mData;
    private OnClickItemTwoListener onClickItemTwoListener;

    public void setOnClickItemTwoListener(OnClickItemTwoListener onClickItemTwoListener) {
        this.onClickItemTwoListener = onClickItemTwoListener;
    }

    public ClassificationTwoAdapter(Context mContext, List<ClassificationTwoBean.DataBean.CurrentCategoryBean.SubCategoryListBean> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ClassificationTwoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_classification_two, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassificationTwoAdapter.ViewHolder holder, int position) {
        holder.tv_class_title_two.setText(mData.get(position).getName());
        Glide.with(mContext).load(mData.get(position).getWapBannerUrl()).into(holder.iv_class_img_two);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemTwoListener.onClickTwo(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_class_img_two;
        private TextView tv_class_title_two;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_class_img_two = itemView.findViewById(R.id.iv_class_img_two);
            tv_class_title_two = itemView.findViewById(R.id.tv_class_title_two);
        }
    }

    public interface OnClickItemTwoListener{
        void onClickTwo(int position);
    }
}
