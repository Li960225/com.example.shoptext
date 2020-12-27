package com.example.shoptext.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.shoptext.R;
import com.example.shoptext.bean.HomeBean;

import java.util.List;

public class EleventhAdapter extends DelegateAdapter.Adapter<EleventhAdapter.ViewHolder> {
    private Context mContext;
    private LinearLayoutHelper linearLayoutHelper;
    private List<HomeBean.DataBean.TopicListBean> mData;
    private OnClickListener onClickListener;
    private int position;
    private int xOffset;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public EleventhAdapter(Context mContext, LinearLayoutHelper linearLayoutHelper, List<HomeBean.DataBean.TopicListBean> mData) {
        this.mContext = mContext;
        this.linearLayoutHelper = linearLayoutHelper;
        this.mData = mData;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public EleventhAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_home_eleventh, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EleventhAdapter.ViewHolder holder, int position) {
        RecyclerView rveleventh = holder.rveleventh;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        rveleventh.setLayoutManager(linearLayoutManager);
        EleventhHoziAdapter eleventhHoziAdapter = new EleventhHoziAdapter(mContext, mData);
        rveleventh.setAdapter(eleventhHoziAdapter);
        eleventhHoziAdapter.setOnClickListener(new EleventhHoziAdapter.OnClickListener() {
            @Override
            public void onClick(int position) {
                onClickListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView rveleventh;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rveleventh = itemView.findViewById(R.id.rv_eleventh);
        }
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if (holder.itemView instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) holder.itemView;
            LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
            position = manager.findFirstVisibleItemPosition();
            View view = manager.findViewByPosition(position);
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (view != null) {
                xOffset = view.getLeft() - lp.leftMargin; //如果你设置了margin则减去
            }
        }
    }

    @Override
    public void onViewAttachedToWindow(@NonNull ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        if (holder.itemView instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) holder.itemView;
            LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
            manager.scrollToPositionWithOffset(position,xOffset);
        }
    }

    public interface OnClickListener{
        void onClick(int position);
    }
}
