package com.xinluqishi.parkingcar.base.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xinluqishi.parkingcar.ParkingCarApplication;
import com.xinluqishi.parkingcar.base.BaseApplication;

/**
 * Created by shikeyue on 17/4/14.
 */

public class BaseActivity extends AppCompatActivity {

    protected BaseApplication application = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (BaseApplication) getApplication();
        application.addActivity(this);
    }


    public BaseApplication getBaseApplication() {
        return application;
    }


}
