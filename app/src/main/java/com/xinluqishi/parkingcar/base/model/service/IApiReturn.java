package com.xinluqishi.parkingcar.base.model.service;

import com.xinluqishi.parkingcar.base.model.entity.ApiResult;

/**
 * Created by shikeyue on 17/4/20.
 */

public interface IApiReturn<T>{
    void run(ApiResult<T> apiResult);
}
