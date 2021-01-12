package com.example.shoptext.mine.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoptext.R;

import java.util.List;

public class MineAdapter extends RecyclerView.Adapter<MineAdapter.ViewHolder> {
    private Context mContext;
    private List<Integer> integers;
    private List<String> strings;
    private OnClickItemListener onClickItemListener;

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    public MineAdapter(Context mContext, List<Integer> integers, List<String> strings) {
        this.mContext = mContext;
        this.integers = integers;
        this.strings = strings;
    }

    @NonNull
    @Override
    public MineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_mine_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MineAdapter.ViewHolder holder, int position) {
        holder.iv_mine_img.setImageResource(integers.get(position));
        holder.tv_mine_title.setText(strings.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return integers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_mine_img;
        private TextView tv_mine_title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_mine_img = itemView.findViewById(R.id.iv_mine_img);
            tv_mine_title = itemView.findViewById(R.id.tv_mine_title);
        }
    }

    public interface OnClickItemListener{
        void onClick(int position);
    }
}
