package com.liukun.androideasyproject.ui.frament;

import com.liukun.androideasyproject.R;
import com.liukun.androideasyproject.commom.MyFragment;
import com.liukun.androideasyproject.ui.activity.CopyActivity;
import com.liukun.androideasyproject.ui.activity.HomeActivity;

/**
 *
 */
public final class FragmentC extends MyFragment<HomeActivity> {

    public static FragmentC newInstance() {
        return new FragmentC();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_c;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}