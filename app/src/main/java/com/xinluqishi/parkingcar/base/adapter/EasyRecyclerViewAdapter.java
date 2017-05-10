package com.xinluqishi.parkingcar.base.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by shikeyue on 17/5/9.
 */

public abstract class EasyRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEAD = 0;
    private static final int TYPE_BODY = 1;
    private static final int TYPE_FOOT = 2;

    private View mHeaderView;
    private View mFooterView;

    private List<T> mDatas = null;//数据集

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEAD) {
            return new EasyViewHolder(mHeaderView);
        }
        if (viewType == TYPE_FOOT) {
            return new EasyViewHolder(mFooterView);
        }
        return onCreate(parent, viewType);
    }

    public abstract RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEAD || getItemViewType(position) == TYPE_FOOT) {
            return;
        }


    }

    private int getDataPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return position;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (mFooterView == null && mHeaderView == null) {
            return TYPE_BODY;
        }

        if (mHeaderView != null && position == 0) {
            return TYPE_HEAD;
        }

        if (mFooterView != null && mHeaderView == null && position == mDatas.size()) {
            return TYPE_FOOT;
        }

        if (mFooterView != null && mHeaderView != null && position == mDatas.size() + 1) {
            return TYPE_FOOT;
        }
        return TYPE_BODY;
    }


}
