package com.xinluqishi.parkingcar.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.xinluqishi.parkingcar.base.adapter.EasyRecyclerViewAdapter;
import com.xinluqishi.parkingcar.model.entity.HotCarType;

import java.util.List;

/**
 * 按照网上的架构写
 * Created by shikeyue on 17/5/9.
 */

public class ParkingCarTypeAdapter extends EasyRecyclerViewAdapter<HotCarType> {


    public ParkingCarTypeAdapter(Context context, List<HotCarType> myDataList) {
        super(context, myDataList);
    }

    /**
     * 使用网络新的写法
//    @Override
//    public int[] getItemLayouts() {
//        return new int[0];
//    }
//
//    @Override
//    public void onBindRecycleViewHolder(EasyRecyclerViewHolder viewHolder, int position) {
//        int itemType = this.getRecycleViewItemType(position);
////        T t = this.getItem(position);
//    }
//
//    @Override
//    public int getRecycleViewItemType(int position) {
//        return 0;
//    }
     **/



    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, HotCarType data) {

    }


}
