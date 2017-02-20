package com.bwf.practice.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;


import com.bwf.practice.R;
import com.bwf.practice.glidetest.ChActivity;
import com.bwf.practice.glidetest.SlidingMenu;
import com.facebook.drawee.backends.pipeline.Fresco;


public class MainActivity extends AppCompatActivity {
    private SlidingMenu slidingMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Fresco.initialize(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch);
        slidingMenu = (SlidingMenu) findViewById(R.id.slidingMenu);

    }

    public void my_OnClick(View v) {
        slidingMenu.toggle();
    }
    /**
     * 切换Activity动画效果
     * overridePendingTransition(R.anim.fade, R.anim.hold);//淡入淡出
     * overridePendingTransition(R.anim.my_scale_action,R.anim.my_alpha_action);//放大淡出
     * overridePendingTransition(R.anim.scale_rotate,R.anim.my_alpha_action);//转动淡出1
     * overridePendingTransition(R.anim.scale_translate_rotate,R.anim.my_alpha_action);//转动淡出2
     * overridePendingTransition(R.anim.scale_translate,R.anim.my_alpha_action);//左上角展开淡出效果
     * overridePendingTransition(R.anim.hyperspace_in,R.anim.hyperspace_out);//压缩变小淡出效果
     * overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);//右往左推出效果
     * overridePendingTransition(R.anim.push_up_in,R.anim.push_up_out);//下往上推出效果
     * overridePendingTransition(R.anim.slide_left,R.anim.slide_right);//左右交叉效果
     * overridePendingTransition(R.anim.zoom_enter,R.anim.zoom_exit);//缩小效果
     * overridePendingTransition(R.anim.slide_up_in,R.anim.slide_down_out);//上下文交错
     */
    public void my_MOnClick(View v) {
        startActivity(new Intent(this, ChActivity.class));
        overridePendingTransition(R.anim.fade, R.anim.hold);
    }

}
