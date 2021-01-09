package com.example.shoptext.classification.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoptext.R;
import com.example.shoptext.classification.bean.ClassificationOneBean;
import com.google.android.material.transition.Hold;

import java.util.List;

public class ClassificationOneAdapter extends RecyclerView.Adapter<ClassificationOneAdapter.ViewHolder> {
    private Context mContext;
    private List<ClassificationOneBean.DataBean.CategoryListBean> mData;
    private OnClickItemOneListener onClickItemOneListener;
    int expandPosition = -1;

    public void setOnClickItemOneListener(OnClickItemOneListener onClickItemOneListener) {
        this.onClickItemOneListener = onClickItemOneListener;
    }

    public ClassificationOneAdapter(Context mContext, List<ClassificationOneBean.DataBean.CategoryListBean> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ClassificationOneAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_classification_one, parent, false);
        return new ViewHolder(view);
    }

    public void togglePosition(int position) {
        if (expandPosition != position) {//如果闪屏就用notifydatasetchange
            notifyItemChanged(expandPosition);
            expandPosition = position;
        } else {
            expandPosition = -1;
        }
        notifyItemChanged(position);
    }

        @Override
    public void onBindViewHolder(@NonNull ClassificationOneAdapter.ViewHolder holder, int position) {
        holder.tv_class_title_one.setText(mData.get(position).getName());
        holder.v.setVisibility(position == expandPosition ? View.VISIBLE : View.GONE);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemOneListener.onClickOne(position);
                togglePosition(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_class_title_one;
        private TextView v;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_class_title_one = itemView.findViewById(R.id.tv_class_title_one);
            v = itemView.findViewById(R.id.v);
        }
    }

    public interface OnClickItemOneListener{
        void onClickOne(int position);
    }
}
