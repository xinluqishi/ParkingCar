package com.xinluqishi.parkingcar.view.fragment;

import android.os.Bundle;
import android.view.View;

import com.xinluqishi.parkingcar.base.view.BaseFragment;
import com.xinluqishi.parkingcar.model.entity.HotSite;

import java.util.ArrayList;
import java.util.List;

/**
 * 主页碎片基类
 * Created by shikeyue on 17/4/30.
 */

public class MainFragment extends BaseFragment {

    @Override
    public void initFragmentView(View view, Bundle bundle) {
        initRoomsNumber();
    }

    /**
     * 初始化房间数，输入几间房间就会要求输入几个人姓名
     */
    protected void initRoomsNumber() {
        List<HotSite> list = new ArrayList<>();
    }

}
