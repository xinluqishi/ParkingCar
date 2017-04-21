package com.xinluqishi.parkingcar.base.model.service;

import rx.Subscription;

/**
 * Created by shikeyue on 17/4/20.
 */

public interface IRxApiManager<T> {

    /**
     * 向容器中添加
     * @param tag 标签
     * @param subscription
     */
    void add(T tag, Object id, Subscription subscription);

    /**
     * 删除
     * @param tag
     */
    void remove(T tag, Object id);

    /**
     * 取消
     * @param tag
     */
    void cancel(T tag);

    void cancel(T tag, Object id);

}
