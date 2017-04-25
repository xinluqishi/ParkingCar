package com.xinluqishi.parkingcar.base.model.service;

import com.xinluqishi.parkingcar.base.model.entity.ApiResult;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 用户
 * Created by shikeyue on 17/4/17.
 */
public interface ApiUserService {

    /**
     * 根据手机号获取验证码
     * @param phone
     * @param type
     * @return
     */
    @GET("users/{phone}/code")
    Observable<ApiResult<String>> getCode(@Path("phone") String phone, @Query("type") String type);

}
