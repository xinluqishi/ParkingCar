package com.xinluqishi.parkingcar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xinluqishi.parkingcar.base.view.ParkingCarAppActivity;

public class MainAppActivity extends ParkingCarAppActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.image_view);
    }

    public void loadImage(View view) {
//        String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
        String url = "http://p1.pstatp.com/large/166200019850062839d3";
//        Glide.with(this).load(url).placeholder(R.drawable.ico_address_home).into(imageView);
        Glide.with(this).load(url).placeholder(R.drawable.ico_address_home).into(imageView);
    }

}
