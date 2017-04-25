package com.xinluqishi.parkingcar.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.xinluqishi.parkingcar.base.model.EnumObject.SingleEnum;
import com.xinluqishi.parkingcar.base.model.service.ApiService;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by shikeyue on 17/4/14.
 */

public abstract class BaseApplication extends Application {

    public static Context context;

    private List<Activity> activityList = new LinkedList<>();

    public abstract String getApiUrl();

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static BaseApplication getBaseApplication() {
        return SingleEnum.INSTANCE.getInstance();
    }

    /** add activity **/
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }
    /** remove activity **/
    public void popupActivity(Activity activity) {
        activityList.remove(activity);
    }

    public <T> T getApiService(Class<T> service) {
        return ApiService.getInstance(getApiUrl()).create(service);
    }

}
