package com.xinluqishi.parkingcar.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.xinluqishi.parkingcar.ParkingCarApplication;
import com.xinluqishi.parkingcar.base.BaseApplication;
import com.xinluqishi.parkingcar.base.model.service.ApiServiceFactory;

/**
 * Created by shikeyue on 17/4/14.
 */

public class ParkingCarAppActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected ParkingCarApplication getParkingCarApplication() {
        return (ParkingCarApplication) BaseApplication.getBaseApplication();
    }

    protected ApiServiceFactory getApi() {
        return new ApiServiceFactory(this);
    }

}
