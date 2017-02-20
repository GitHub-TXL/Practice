package com.bwf.practice.glidetest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bwf.practice.R;

/**
 * Created by Administrator on 2017/1/23.
 */

public class MyGlideRvAdapter extends RecyclerView.Adapter<MyGlideRvAdapter.MyViewHolder> {
    private Context context;

    public MyGlideRvAdapter(Context context) {
        this.context = context;
    }

    private int[] gifs = {R.drawable.banlun, R.drawable.banxie, R.drawable.kakaxi, R.drawable.quanlai, R.drawable.you, R.drawable.zhishui, R.drawable.zhuozhu};

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_glide, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(context).load(gifs[position]).asGif().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return gifs.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_glide);
        }
    }
}
