package com.bwf.practice;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

/**
 * Created by Administrator on 2017/1/17.
 */

public class VideoPlayActivity extends AppCompatActivity implements View.OnClickListener {
    private VideoView mVideo;
    /**
     * 播放
     */
    private Button mBtnPlay;
    /**
     * 暂停
     */
    private Button mBtnPause;
    /**
     * 停止
     */
    private Button mBtnStop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initView();
        initData();
    }

    private void initView() {
        mVideo = (VideoView) findViewById(R.id.video);
        mBtnPlay = (Button) findViewById(R.id.btn_play);
        mBtnPlay.setOnClickListener(this);
        mBtnPause = (Button) findViewById(R.id.btn_pause);
        mBtnPause.setOnClickListener(this);
        mBtnStop = (Button) findViewById(R.id.btn_stop);
        mBtnStop.setOnClickListener(this);
    }

    private void initData() {
//        mVideo.setVideoPath(Environment.getExternalStorageDirectory() + "/mnt/shell/emulated/0/Download/other/脸.mp4");
//        mVideo.requestFocus();
        MediaController med=new MediaController(this);
//        mVideo.setVideoURI(Uri.parse("/mnt/shell/emulated/0/Download/other/脸.mp4"));
        mVideo.setMediaController(med);
        med.setMediaPlayer(mVideo);
        mVideo.requestFocus();
        mVideo.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_play:
                mVideo.start();
                break;
            case R.id.btn_pause:
                if(mVideo.isPlaying()){
                    mVideo.pause();
                }else{
                    mVideo.start();
                }
                break;
            case R.id.btn_stop:
                mVideo.stopPlayback();
                break;
        }
    }
}
