package com.xinluqishi.parkingcar.adapter;


import com.camnter.easyrecyclerview.adapter.EasyRecyclerViewAdapter;
import com.camnter.easyrecyclerview.holder.EasyRecyclerViewHolder;
import com.camnter.easyrecyclerview.widget.EasyRecyclerView;

/**
 * 按照网上的架构写
 * Created by shikeyue on 17/5/9.
 */

public class ParkingCarTypeAdapter extends EasyRecyclerViewAdapter {



    @Override
    public int[] getItemLayouts() {
        return new int[0];
    }

    @Override
    public void onBindRecycleViewHolder(EasyRecyclerViewHolder viewHolder, int position) {
        int itemType = this.getRecycleViewItemType(position);
//        T t = this.getItem(position);
    }

    @Override
    public int getRecycleViewItemType(int position) {
        return 0;
    }
}
