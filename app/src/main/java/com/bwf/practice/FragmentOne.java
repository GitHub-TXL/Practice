package com.bwf.practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.practice.eyes.AndroidGifActivity;
import com.bwf.practice.eyes.BanL;
import com.bwf.practice.eyes.BanX;
import com.bwf.practice.eyes.KaKaXi;
import com.bwf.practice.eyes.Quan;
import com.bwf.practice.eyes.Zhi;
import com.bwf.practice.eyes.Zuo;
import com.bwf.practice.recyclerview.Product;
import com.bwf.practice.recyclerview.RecyclerViewAdapter;
import com.bwf.practice.recyclerview.SpacesItemDecoration;
import com.cjj.refresh.BeautifulRefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/18.
 */

public class FragmentOne extends Fragment{
    private RecyclerView recyclerView;
    private List<Product> products;
    private Product product;
    private int[] images = {R.mipmap.a1, R.mipmap.a2, R.mipmap.a3, R.mipmap.a4,
            R.mipmap.a5, R.mipmap.a6, R.mipmap.a7, R.mipmap.a8,
            R.mipmap.a9, R.mipmap.a10, R.mipmap.a11,
    };
    private RecyclerViewAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(
                R.layout.recycler_beau, container, false);
        BeautifulRefreshLayout beautifulRefreshLayout = (BeautifulRefreshLayout) v.findViewById(R.id.refresh);
        beautifulRefreshLayout.setBuautifulRefreshListener(new BeautifulRefreshLayout.BuautifulRefreshListener() {
            @Override
            public void onRefresh(final BeautifulRefreshLayout refreshLayout) {
                refreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishRefreshing();
                    }
                }, 6000);
            }
        });

        initData();
        adapter=new RecyclerViewAdapter(products);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler);
        setupRecyclerView(recyclerView);
        //设置item之间的间隔
        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        recyclerView.addItemDecoration(decoration);
        adapter.setOnItemClickListener(new RecyclerViewAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, Product data) {
                switch (data.getImg()) {
                    case R.mipmap.a1:
                        startActivity(new Intent(getActivity(), AndroidGifActivity.class));
                        break;
                    case R.mipmap.a2:
                        startActivity(new Intent(getActivity(), BanL.class));
                        break;
                    case R.mipmap.a3:
                        startActivity(new Intent(getActivity(), ItemDecorationActivity.class));
                        break;
                    case R.mipmap.a4:
                        startActivity(new Intent(getActivity(), KaKaXi.class));
                        break;
                    case R.mipmap.a5:
                        startActivity(new Intent(getActivity(), Quan.class));
                        break;
                    case R.mipmap.a6:
                        startActivity(new Intent(getActivity(), Zhi.class));
                        break;
                    case R.mipmap.a7:
                        startActivity(new Intent(getActivity(), Zuo.class));
                        break;
                    case R.mipmap.a8:
                        startActivity(new Intent(getActivity(), VideoPlayActivity.class));
                        break;
                    case R.mipmap.a9:
                        startActivity(new Intent(getActivity(), VideoPlayActivity.class));
                        break;
                    case R.mipmap.a10:
                        startActivity(new Intent(getActivity(), VideoPlayActivity.class));
                        break;
                    case R.mipmap.a11:
                        startActivity(new Intent(getActivity(), VideoPlayActivity.class));
                        break;
                }

            }
        });
        return v;
    }
    private void initData() {
        products = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            product = new Product(images[i], "拉克丝" + i);
            products.add(product);
        }
    }
    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

}
