package com.xinluqishi.parkingcar;

import android.os.Bundle;
import com.xinluqishi.parkingcar.base.BaseApplication;
import com.xinluqishi.parkingcar.base.model.EnumObject.ApiCodeEnum;
import com.xinluqishi.parkingcar.base.model.entity.ApiResult;
import com.xinluqishi.parkingcar.base.model.service.ApiServiceFactory;
import com.xinluqishi.parkingcar.base.model.service.ApiUserService;
import com.xinluqishi.parkingcar.base.model.service.IApiReturn;
import com.xinluqishi.parkingcar.base.model.service.RxApiManager;
import com.xinluqishi.parkingcar.base.utils.view.DialogUtil;
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
    protected void onCreate(Bundle savedInstanceState) {
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

    /**
     * 处理返回数据
     * @param observable
     * @param apiReturn
     * @param <T>
     */
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
                            public void onNext(ApiResult<T> apiResult) {
                                apiReturn.run(apiResult);
                            }
                        })
                );
    }

    public static void main(String[] args) {
        System.out.println("main");
        ParkingCarActivity activity = new ParkingCarActivity();
        activity.subscribe(activity.getBaseApplication()
                .getApiService(ApiUserService.class).getCode("13132230866", "register"),
                (ApiResult<String> apiResult) -> {
                    if (apiResult.getCode() != ApiCodeEnum.SUCCESS.getCode()) {
                        DialogUtil.showToastCust(activity, apiResult.getMessage());
                    }
                });
    }

}
