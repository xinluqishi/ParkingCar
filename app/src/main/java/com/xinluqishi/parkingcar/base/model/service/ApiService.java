package com.xinluqishi.parkingcar.base.model.service;

import com.xinluqishi.parkingcar.base.BaseApplication;
import com.xinluqishi.parkingcar.base.model.interceptor.RewriteCacheControlInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shikeyue on 17/4/17.
 */

public class ApiService {

    private static ApiService apiService;

    private Retrofit retrofit;

    /**
     * Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = chain -> {

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
     };
     */

    public ApiService(String baseUrl) {

        /* 初始化手机中的缓存 */
        File httpCacheDirectory = new File(BaseApplication.context.getCacheDir(), "responses");
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(httpCacheDirectory, cacheSize);

        /* 设置日志拦截器 */
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(45, TimeUnit.SECONDS)
                .readTimeout(45, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new RewriteCacheControlInterceptor())
                .cache(cache)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

    }
}
