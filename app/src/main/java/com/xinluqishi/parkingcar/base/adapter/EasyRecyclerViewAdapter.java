package com.xinluqishi.parkingcar.base.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import com.xinluqishi.parkingcar.base.BaseApplication;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shikeyue on 17/5/9.
 */

public abstract class EasyRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEAD = 0;
    private static final int TYPE_BODY = 1;
    private static final int TYPE_FOOT = 2;

    private View myHeaderView;
    private View myFooterView;

    private OnItemClickListener myItemClickListener;
    private OnItemLongClickListener myItemLongClickListerner;

    private List<T> myDataList = null;          //数据集

    private Context context;                //当前页面

    public EasyRecyclerViewAdapter(Context context, List<T> myDataList) {
        this.context = BaseApplication.context;
        this.myDataList = new ArrayList<>();
    }

    public interface OnItemClickListener<T> {
        public void OnItemClick(View view, int position, T data);
    }

    interface OnItemLongClickListener<T> {
        public void OnItemLongClick(View view, int position, T data);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEAD) {
            return new EasyViewHolder(myHeaderView);
        }
        if (viewType == TYPE_FOOT) {
            return new EasyViewHolder(myFooterView);
        }
        return onCreate(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEAD || getItemViewType(position) == TYPE_FOOT) {
            return;
        }

        final int dataPosition = getDataPosition(holder);
        final T data = myDataList.get(dataPosition);
        onBind(holder, dataPosition, data);

        if (myItemClickListener != null) {
            holder.itemView.setOnClickListener((View v) -> myItemClickListener.OnItemClick(v, dataPosition, data));
        }

        if (myItemLongClickListerner != null) {
            holder.itemView.setOnLongClickListener((View v) -> {
                myItemLongClickListerner.OnItemLongClick(v, dataPosition, data);
                return true;});
        }

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        final RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            ((GridLayoutManager) layoutManager).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int type = getItemViewType(position);
                    if (type == TYPE_HEAD || type == TYPE_FOOT) {
                        return ((GridLayoutManager) layoutManager).getSpanCount();
                    }
                    return 1;
                }
            });
        }
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) layoutParams;

        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (myFooterView == null && myHeaderView == null) {
            return TYPE_BODY;
        }

        if (myHeaderView != null && position == 0) {
            return TYPE_HEAD;
        }

        if (myFooterView != null && myHeaderView == null && position == myDataList.size()) {
            return TYPE_FOOT;
        }

        if (myFooterView != null && myHeaderView != null && position == myDataList.size() + 1) {
            return TYPE_FOOT;
        }
        return TYPE_BODY;
    }

    private int getDataPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return myHeaderView == null ? position : position - 1;
    }

    /**
     * 抽象方法
     **/

    public abstract RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType);

    public abstract void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, T data);

    /**
     * Setter Getter方法
     */
    public View getMyHeaderView() {
        return myHeaderView;
    }

    public void setMyHeaderView(View myHeaderView) {
        this.myHeaderView = myHeaderView;
    }

    public View getMyFooterView() {
        return myFooterView;
    }

    public void setMyFooterView(View myFooterView) {
        this.myFooterView = myFooterView;
    }

    public List<T> getMyDataList() {
        return myDataList;
    }

    public void setMyDataList(List<T> myDataList) {
        this.myDataList = myDataList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
