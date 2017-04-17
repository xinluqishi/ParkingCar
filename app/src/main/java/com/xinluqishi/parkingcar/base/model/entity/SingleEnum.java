package com.xinluqishi.parkingcar.base.model.entity;

import com.xinluqishi.parkingcar.ParkingCarApplication;
import com.xinluqishi.parkingcar.base.BaseApplication;

/**
 * Created by shikeyue on 17/4/14.
 */

public enum SingleEnum {

    INSTANCE;

    private BaseApplication baseApplicationSingle;

    private SingleEnum() {
        baseApplicationSingle = new ParkingCarApplication();
    }

    public BaseApplication getInstance() {
        return baseApplicationSingle;
    }

}
