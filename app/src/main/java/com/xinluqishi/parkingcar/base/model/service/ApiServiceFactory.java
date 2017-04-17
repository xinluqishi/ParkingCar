package com.xinluqishi.parkingcar.base.model.service;


import com.xinluqishi.parkingcar.base.view.ParkingCarAppActivity;

/**
 * Retrofit OkHttp Service Class
 * Get the data from server side left in the back
 * Created by shikeyue on 17/4/14.
 */
public class ApiServiceFactory {

    private ParkingCarAppActivity parkingCarAppActivity;

    public ApiServiceFactory(ParkingCarAppActivity parkingCarAppActivity) {
        this.parkingCarAppActivity = parkingCarAppActivity;
    }

    public ApiUserService getUserService() {
        return null;
    }

}
