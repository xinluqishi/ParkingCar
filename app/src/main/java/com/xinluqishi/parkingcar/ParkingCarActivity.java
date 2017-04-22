package com.xinluqishi.parkingcar;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.xinluqishi.parkingcar.ParkingCarApplication;
import com.xinluqishi.parkingcar.base.BaseApplication;
import com.xinluqishi.parkingcar.base.model.entity.ApiResult;
import com.xinluqishi.parkingcar.base.model.service.ApiServiceFactory;
import com.xinluqishi.parkingcar.base.model.service.IApiReturn;
import com.xinluqishi.parkingcar.base.model.service.RxApiManager;
import com.xinluqishi.parkingcar.base.view.BaseActivity;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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

    /**
     * ApiService工厂方法
     * @return
     */
    protected ApiServiceFactory getApi() {
        return new ApiServiceFactory(this);
    }

    public <T> void subscribe(final Observable<ApiResult<T>> observable, final IApiReturn<T> apiReturn) {
        int hashCode = this.hashCode();
        RxApiManager.getRxInstance()
                        .add(hashCode, observable.hashCode(), observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<ApiResult<T>>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(ApiResult<T> tApiResult) {

                            }
                        })
                );

























    }

}
