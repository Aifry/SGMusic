package com.example.a97263.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;


import java.util.ArrayList;

public class RollActivity extends AppCompatActivity {

    private ViewPager ViewPage_Detail;
    private LinearLayout point_detail;
    private Context context;
    private View view;
    //轮播图图片资源
    private final int[] viewpage_images = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four};
    private ArrayList<ImageView> viewpage_imageList;
    //判断是否自动滚动ViewPage
    private boolean isRunning = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll);
        Instantiation();

    }

    public void Instantiation() {

        ViewPage_Detail = (ViewPager)findViewById(R.id.ViewPage_Detail);
        point_detail = (LinearLayout)findViewById(R.id.point_detail);

        //初始化图片资源
        viewpage_imageList = new ArrayList<ImageView>();
        for (int i : viewpage_images) {
            // 初始化图片资源
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(i);
            viewpage_imageList.add(imageView);

            // 添加指示小点
            ImageView point = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(15,
                    15);
            params.rightMargin = 10;
            params.bottomMargin = 15;
            point.setLayoutParams(params);
            point.setBackgroundResource(R.drawable.one);
            if (i == R.drawable.one) {
                //默认聚焦在第一张
                point.setBackgroundResource(R.drawable.two);
                point.setEnabled(true);
            } else {
                point.setEnabled(false);
            }

            point_detail.addView(point);

        }

        //首页轮播
        CarouselShow carouselShow = new CarouselShow(context, viewpage_imageList);
        carouselShow.CarouselShow_Info_Detail(this);
        handler.sendEmptyMessageDelayed(0, 3000);

    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            // 执行滑动到下一个页面
            ViewPage_Detail.setCurrentItem(ViewPage_Detail.getCurrentItem() + 1);
            if (isRunning) {
                // 在发一个handler延时
                handler.sendEmptyMessageDelayed(0, 3000);
            }
        }
    };


    @Override
    public void onDestroy() {
        // 停止滚动
        isRunning = false;
        super.onDestroy();
    }

    public void ppp(View view)
    {
        Intent intentToChooseNet=new Intent();
        intentToChooseNet.setClass(RollActivity.this,PlayActivity.class);
        startActivity(intentToChooseNet);
        Toast.makeText(getApplicationContext(),"Start playback",Toast.LENGTH_SHORT).show();
    }


}
