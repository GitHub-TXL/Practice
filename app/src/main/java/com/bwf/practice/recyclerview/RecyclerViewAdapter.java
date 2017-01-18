package com.bwf.practice.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.practice.R;

import java.util.List;

/**
 * Created by Administrator on 2016/12/29.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MasonryView> implements View.OnClickListener {
    private List<Product> products;

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v, (Product) v.getTag());
        }
    }

    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, Product data);
    }

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public RecyclerViewAdapter(List<Product> list) {
        products = list;
    }

    @Override
    public MasonryView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.waterfall_item, viewGroup, false);
        //将创建的View注册点击事件
        view.setOnClickListener(this);
        return new MasonryView(view);
    }

    @Override
    public void onBindViewHolder(MasonryView masonryView, int position) {
        masonryView.imageView.setImageResource(products.get(position).getImg());
        masonryView.textView.setText(products.get(position).getTitle());
//将数据保存在itemView的Tag中，以便点击时进行获取
        masonryView.itemView.setTag(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class MasonryView extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public MasonryView(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.masonry_item_img);
            textView = (TextView) itemView.findViewById(R.id.masonry_item_title);
        }

    }

}