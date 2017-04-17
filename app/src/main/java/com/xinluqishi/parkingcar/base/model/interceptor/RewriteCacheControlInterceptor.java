package com.xinluqishi.parkingcar.base.model.interceptor;

import com.xinluqishi.parkingcar.base.BaseApplication;
import com.xinluqishi.parkingcar.base.utils.NetUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by shikeyue on 17/4/17.
 */

public class RewriteCacheControlInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        CacheControl.Builder cacheBuilder = new CacheControl.Builder();
        cacheBuilder.maxAge(0, TimeUnit.SECONDS);   //这个是控制缓存的最大生命时间
        cacheBuilder.maxStale(365, TimeUnit.DAYS);  //这个是控制缓存的过时时间
        CacheControl cacheControl = cacheBuilder.build();

        Request request = chain.request();
        if (!NetUtils.checkNetWorkIsAvailable(BaseApplication.context)) {
            request = request.newBuilder().cacheControl(cacheControl).build();
        }

        Response originalResponse = chain.proceed(request);
        if (NetUtils.checkNetWorkIsAvailable(BaseApplication.context)) {
            //read from cache
            int maxAge = 0;
            return originalResponse.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, max-age = " + maxAge)
                    .build();
        } else {
            // tolerate 4-weeks stale
            int maxStale = 60 * 60 * 24 * 28;
            return originalResponse.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }
    }
}
