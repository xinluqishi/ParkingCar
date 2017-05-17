package com.xinluqishi.parkingcar.base.view.compnent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.xinluqishi.parkingcar.ParkingCarActivity;

/**
 * 自定义线性布局
 * Created by huangzhe on 2016/12/26.
 */

public abstract class BaseLinearLayout extends LinearLayout {
    private ParkingCarActivity ctx;

    /**
     * 加载的布局
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化
     */
    protected abstract void init(Context context, AttributeSet attrs);

    /**
     * 构造函数
     * @param context
     * @param attrs
     */
    public BaseLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (isInEditMode()) { return; }
        ctx=(ParkingCarActivity) context;
        LayoutInflater.from(context).inflate(getLayoutId(),this);
        init(context,attrs);
    }

    /**
     * 得到当前Activity
     * @return
     */
    protected ParkingCarActivity getActivity(){
        return ctx;
    }
}
