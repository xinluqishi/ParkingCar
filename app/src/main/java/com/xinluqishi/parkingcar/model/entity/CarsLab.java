package com.xinluqishi.parkingcar.model.entity;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 存储所有车的数据集合
 * Created by shikeyue on 2017/5/14.
 */

public class CarsLab {

    private static CarsLab sCarsLab;

    private List<Car> myCars;

    private CarsLab(Context context) {
        myCars = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Car car = new Car();
            car.setCarLabel("Car #" + i);
            car.setCarType("Middle Type");
            myCars.add(car);
        }
    }

    public static CarsLab get(Context context) {
        if (sCarsLab == null) {
            sCarsLab = new CarsLab(context);
        }
        return sCarsLab;
    }

    public List<Car> getMyCars() {
        return myCars;
    }

    public Car getMyCar(UUID uuid) {
        for (Car car : myCars) {
            if (car.getCarUUID().equals(uuid)) {
                return car;
            }
        }
        return null;
    }
}
