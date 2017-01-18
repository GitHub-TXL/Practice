package com.bwf.practice.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.bwf.practice.VideoPlayActivity;
import com.bwf.practice.eyes.AndroidGifActivity;
import com.bwf.practice.R;
import com.bwf.practice.eyes.BanL;
import com.bwf.practice.eyes.BanX;
import com.bwf.practice.eyes.KaKaXi;
import com.bwf.practice.eyes.Quan;
import com.bwf.practice.eyes.Zhi;
import com.bwf.practice.eyes.Zuo;
import com.cjj.refresh.BeautifulRefreshLayout;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Product> products;
    private Product product;
    private int[] images = {R.mipmap.a1, R.mipmap.a2, R.mipmap.a3, R.mipmap.a4,
            R.mipmap.a5, R.mipmap.a6, R.mipmap.a7, R.mipmap.a8,
            R.mipmap.a9, R.mipmap.a10, R.mipmap.a11,
    };
    private RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Fresco.initialize(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BeautifulRefreshLayout beautifulRefreshLayout = (BeautifulRefreshLayout) findViewById(R.id.refresh);
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
        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        //设置layoutManager
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        //设置adapter
        initData();
        adapter = new RecyclerViewAdapter(products);
//        recyclerView.setAdapter(adapter);
        setupRecyclerView(recyclerView);
        //设置item之间的间隔
        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        recyclerView.addItemDecoration(decoration);
        adapter.setOnItemClickListener(new RecyclerViewAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, Product data) {
                switch (data.getImg()) {
                    case R.mipmap.a1:
                        startActivity(new Intent(MainActivity.this, AndroidGifActivity.class));
                        break;
                    case R.mipmap.a2:
                        startActivity(new Intent(MainActivity.this, BanL.class));
                        break;
                    case R.mipmap.a3:
                        startActivity(new Intent(MainActivity.this, BanX.class));
                        break;
                    case R.mipmap.a4:
                        startActivity(new Intent(MainActivity.this, KaKaXi.class));
                        break;
                    case R.mipmap.a5:
                        startActivity(new Intent(MainActivity.this, Quan.class));
                        break;
                    case R.mipmap.a6:
                        startActivity(new Intent(MainActivity.this, Zhi.class));
                        break;
                    case R.mipmap.a7:
                        startActivity(new Intent(MainActivity.this, Zuo.class));
                        break;
                    case R.mipmap.a8:
                        startActivity(new Intent(MainActivity.this, VideoPlayActivity.class));
                        break;
                    case R.mipmap.a9:
                        startActivity(new Intent(MainActivity.this, VideoPlayActivity.class));
                        break;
                    case R.mipmap.a10:
                        startActivity(new Intent(MainActivity.this, VideoPlayActivity.class));
                        break;
                    case R.mipmap.a11:
                        startActivity(new Intent(MainActivity.this, VideoPlayActivity.class));
                        break;
                }

            }
        });

    }
    private void setupRecyclerView(RecyclerView recyclerView) {
//        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
    private void initData() {
        products = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            product = new Product(images[i], "拉克丝" + i);
            products.add(product);
        }
    }
}
