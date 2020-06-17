package com.liukun.androideasyproject.ui.frament;

import com.liukun.androideasyproject.R;
import com.liukun.androideasyproject.commom.MyFragment;
import com.liukun.androideasyproject.ui.activity.CopyActivity;
import com.liukun.androideasyproject.ui.activity.HomeActivity;

/**
 *
 */
public final class FragmentB extends MyFragment<HomeActivity> {

    public static FragmentB newInstance() {
        return new FragmentB();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_b;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}