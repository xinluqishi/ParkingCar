package com.xinluqishi.parkingcar.base.model.service;


import com.xinluqishi.parkingcar.ParkingCarActivity;

/**
 * Retrofit OkHttp Service Class
 * Get the data from server side left in the back
 * Created by shikeyue on 17/4/14.
 */
public class ApiServiceFactory {

    private ParkingCarActivity parkingCarActivity;

    public ApiServiceFactory(ParkingCarActivity parkingCarActivity) {
        this.parkingCarActivity = parkingCarActivity;
    }

    public ApiUserService getUserService() {
        return null;
    }

}
