package com.gscc.adv4_s1;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends ActionBarActivity {

    //@@@@@全區宣告start
    VideoView vvVideoView1;
    TextView tvTextView1, tvTextView2;
    ImageView ivImageView1;
    Thread countToLoop;
    int i;
    //@@@@@全區宣告

    //@@@@@
    public Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int a = msg.getData().getInt("count", 0);

            if (a == 1) {
//@@
                //musle test
                VideoPlayer1();
                //tx1.setText("影片1");
            }
            if (a == 61) {
                VideoPlayer2();
                //marquee.setText("影片2");
            }
            if (a == 121) {
                //marquee.setText("影片3");
                VideoPlayer3();
            }
            if (a == 181) {
                //marquee.setText("影片4");
                VideoPlayer4();
            }
            if (a == 241) {
                //marquee.setText("影片5");
                VideoPlayer5();
            }
        }
    };
    //@@@@@

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //@@@@@全螢幕start
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
        //@@@@@全螢幕
        countToLoop = new countToLoop();
        countToLoop.start();
    }

    //@@@@@播放器start
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void VideoPlayer1() {
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
        Uri video1 = Uri.parse("sdcard/test.m4v");
        vvVideoView1 = (VideoView) findViewById(R.id.videoView1);
        vvVideoView1.setVideoURI(video1);
        vvVideoView1.start();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void VideoPlayer2() {
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
        Uri video1 = Uri.parse("sdcard/test2.mp4");
        vvVideoView1 = (VideoView) findViewById(R.id.videoView1);
        vvVideoView1.setVideoURI(video1);
        vvVideoView1.start();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void VideoPlayer3() {
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
        Uri video1 = Uri.parse("sdcard/test3.mp4");
        vvVideoView1 = (VideoView) findViewById(R.id.videoView1);
        vvVideoView1.setVideoURI(video1);
        vvVideoView1.start();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void VideoPlayer4() {
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
        Uri video1 = Uri.parse("sdcard/test4.mp4");
        vvVideoView1 = (VideoView) findViewById(R.id.videoView1);
        vvVideoView1.setVideoURI(video1);
        vvVideoView1.start();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void VideoPlayer5() {
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
        Uri video1 = Uri.parse("sdcard/test5.mp4");
        vvVideoView1 = (VideoView) findViewById(R.id.videoView1);
        vvVideoView1.setVideoURI(video1);
        vvVideoView1.start();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void ImagePlayer() {
        setContentView(R.layout.image_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
        Uri image1 = Uri.parse("sdcard/test1.jpg");
        ivImageView1 = (ImageView) findViewById(R.id.imageView);
        ivImageView1.setImageURI(image1);
    }
    //@@@@@播放器

    //@@@@@@計時器
    class countToLoop extends Thread {
        @Override
        public void run() {
            super.run();
            goPlay();
        }

        public void goPlay() {
            try {
                while (true) {
                    for (i = 0; i < 50; i++) {
                        Thread.sleep(1000);
                        Bundle countBundle = new Bundle();
                        countBundle.putInt("count", i + 1);

                        Message msg = new Message();
                        msg.setData(countBundle);

                        mHandler.sendMessage(msg);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //@@@@@計時器

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
