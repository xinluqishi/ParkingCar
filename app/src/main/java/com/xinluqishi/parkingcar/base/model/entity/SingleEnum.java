package com.xinluqishi.parkingcar.base.model.entity;

import com.xinluqishi.parkingcar.base.BaseApplication;

/**
 * Created by shikeyue on 17/4/14.
 */

public enum SingleEnum {

    INSTANCE;

    private BaseApplication baseApplicationSingle;

    private SingleEnum() {
        baseApplicationSingle = new BaseApplication();
    }

    public BaseApplication getInstance() {
        return baseApplicationSingle;
    }

}
