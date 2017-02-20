package com.bwf.practice.glidetest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bwf.practice.R;

/**
 * Created by Administrator on 2017/1/23.
 */

public class GlideExample extends Activity {
    private ImageView mIv;
    private RecyclerView mRecyclerGlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        initView();
        initData();
    }

    private void initView() {
        mIv = (ImageView) findViewById(R.id.iv);
        mRecyclerGlide = (RecyclerView) findViewById(R.id.recycler_glide);
    }

    private void initData() {
//        Glide.with(this).load(R.raw.banlun).into(mIv);
//        Glide.with(this).load(url).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(mIv);
        Glide.with(this).load(R.drawable.zhuozhu).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(mIv);
    }

}
