package com.xinluqishi.parkingcar.base.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by shikeyue on 17/4/30.
 */

public abstract class BaseFragment extends Fragment{


    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initFragmentView(view, bundle);
    }

    /**
     * 初始化碎片视图
     * @param view
     * @param bundle
     */
    public abstract void initFragmentView(View view, Bundle bundle);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }



}
