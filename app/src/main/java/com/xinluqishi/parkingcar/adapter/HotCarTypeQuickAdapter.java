package com.xinluqishi.parkingcar.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xinluqishi.parkingcar.R;
import com.xinluqishi.parkingcar.model.entity.Car;

import java.util.List;

/**
 * Created by shikeyue on 17/5/17.
 */

public class HotCarTypeQuickAdapter extends BaseQuickAdapter<Car, BaseViewHolder> {

    public HotCarTypeQuickAdapter(List<Car> data) {
        super(R.layout.activity_car_type_list, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, Car data) {
    }
}
