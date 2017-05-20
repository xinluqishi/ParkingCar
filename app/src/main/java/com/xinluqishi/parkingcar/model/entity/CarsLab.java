package com.xinluqishi.parkingcar.model.entity;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * 存储所有车的数据集合
 * Created by shikeyue on 2017/5/14.
 */

public class CarsLab {

    private static CarsLab sCarsLab;

    private List<Car> myCars;

    private CarsLab(Context context) {
        myCars = new ArrayList<>();
    }

    public static CarsLab get(Context context) {
        if (sCarsLab == null) {
            sCarsLab = new CarsLab(context);
        }
        return sCarsLab;
    }
}
