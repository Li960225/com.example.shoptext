package com.example.shoptext.detailslist.adapter.vlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.shoptext.R;

public class DetailsContentFourthAdapter extends DelegateAdapter.Adapter<DetailsContentFourthAdapter.ViewHolder> {
    private Context mContext;
    private LinearLayoutHelper linearLayoutHelper;

    public DetailsContentFourthAdapter(Context mContext, LinearLayoutHelper linearLayoutHelper) {
        this.mContext = mContext;
        this.linearLayoutHelper = linearLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public DetailsContentFourthAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_details_content_fourth, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsContentFourthAdapter.ViewHolder holder, int position) {

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
