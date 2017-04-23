package com.xinluqishi.parkingcar.base.model.service;

/**
 * 通用接口
 * 适用于方法传参，回调方法时
 */

public interface CommonCallback<T> {
    void onCallBack(T data);
}
