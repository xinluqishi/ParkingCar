package com.xinluqishi.parkingcar.base;

import android.app.Application;

import com.xinluqishi.parkingcar.base.model.entity.SingleEnum;

/**
 * Created by shikeyue on 17/4/14.
 */

public class BaseApplication extends Application {

    public static BaseApplication getBaseApplication() {
        return SingleEnum.INSTANCE.getInstance();
    }

}
