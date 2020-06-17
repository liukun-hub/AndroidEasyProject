package com.liukun.androideasyproject.ui.frament;

import com.liukun.androideasyproject.R;
import com.liukun.androideasyproject.commom.MyFragment;
import com.liukun.androideasyproject.ui.activity.CopyActivity;
import com.liukun.androideasyproject.ui.activity.HomeActivity;

/**
 *
 */
public final class FragmentD extends MyFragment<HomeActivity> {

    public static FragmentD newInstance() {
        return new FragmentD();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_d;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}