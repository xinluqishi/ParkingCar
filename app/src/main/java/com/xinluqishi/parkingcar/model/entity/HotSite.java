package com.xinluqishi.parkingcar.model.entity;

import com.xinluqishi.parkingcar.base.model.entity.BaseListView;

/**
 * 热门景点
 * Created by shikeyue on 17/4/30.
 */

public class HotSite extends BaseListView {

    private String price;               //单价

    private String hadSoldNumber;       //已经销售了多少个

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHadSoldNumber() {
        return hadSoldNumber;
    }

    public void setHadSoldNumber(String hadSoldNumber) {
        this.hadSoldNumber = hadSoldNumber;
    }
}
