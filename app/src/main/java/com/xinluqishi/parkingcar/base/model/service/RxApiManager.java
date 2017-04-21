package com.xinluqishi.parkingcar.base.model.service;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.ArrayMap;

import rx.Subscription;

/**
 * Created by shikeyue on 17/4/20.
 */

public class RxApiManager implements IRxApiManager<Object> {

    private static RxApiManager rxInstance = null;

    private ArrayMap<Object, ArrayMap<Object, Subscription>> maps;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private RxApiManager() {
        maps = new ArrayMap<>();
    }

    public static RxApiManager getRxInstance() {
        if (rxInstance == null) {
            synchronized (RxApiManager.class) {
                if (rxInstance == null) {
                    rxInstance = new RxApiManager();
                }
            }
        }
        return rxInstance;
    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void add(Object tag, Object id, Subscription subscription) {
        if (!maps.containsKey(tag)) {
            maps.put(tag, new ArrayMap<Object, Subscription>());
        }
        maps.get(tag).put(id, subscription);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void remove(Object tag, Object id) {

    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void cancel(Object tag) {

    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void cancel(Object tag, Object id) {

    }
}
