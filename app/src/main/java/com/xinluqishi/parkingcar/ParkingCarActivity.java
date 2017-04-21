package com.xinluqishi.parkingcar;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.xinluqishi.parkingcar.ParkingCarApplication;
import com.xinluqishi.parkingcar.base.BaseApplication;
import com.xinluqishi.parkingcar.base.model.entity.ApiResult;
import com.xinluqishi.parkingcar.base.model.service.ApiServiceFactory;
import com.xinluqishi.parkingcar.base.model.service.IApiReturn;
import com.xinluqishi.parkingcar.base.view.BaseActivity;

import rx.Observable;

/**
 * Created by shikeyue on 17/4/14.
 */

public class ParkingCarActivity extends BaseActivity {

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

        public <T> void subscribe(final Observable<ApiResult<T>> observable, final IApiReturn<T> apiReturn) {}

}
