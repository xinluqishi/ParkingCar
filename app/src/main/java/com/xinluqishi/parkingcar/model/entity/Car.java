package com.xinluqishi.parkingcar.model.entity;

import com.xinluqishi.parkingcar.base.model.entity.BaseEntity;

import java.util.UUID;

/**
 * 车辆实体
 * Created by shikeyue on 2017/5/14.
 */

public class Car extends BaseEntity{

    private UUID carUUID;

    private String carType;

    private String carColor;

    private String carLabel;

    private String carImage;

    public UUID getCarUUID() {
        return carUUID;
    }

    public void setCarUUID(UUID carUUID) {
        this.carUUID = carUUID;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarLabel() {
        return carLabel;
    }

    public void setCarLabel(String carLabel) {
        this.carLabel = carLabel;
    }

    public String getCarImage() {
        return carImage;
    }

    public void setCarImage(String carImage) {
        this.carImage = carImage;
    }
}
