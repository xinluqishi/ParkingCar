package com.xinluqishi.parkingcar.base;

import android.app.Application;
import android.content.Context;

import com.xinluqishi.parkingcar.base.model.entity.SingleEnum;

/**
 * Created by shikeyue on 17/4/14.
 */

public abstract class BaseApplication extends Application {

    public static Context context;

    public abstract String getApiUrl();

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static BaseApplication getBaseApplication() {
        return SingleEnum.INSTANCE.getInstance();
    }

}
