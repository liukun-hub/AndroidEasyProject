package com.liukun.androideasyproject.ui.frament;

import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.liukun.androideasyproject.R;
import com.liukun.androideasyproject.commom.MessageWrap;
import com.liukun.androideasyproject.commom.MyFragment;
import com.liukun.androideasyproject.helper.EventBusHelper;
import com.liukun.androideasyproject.ui.activity.HomeActivity;
import com.liukun.androideasyproject.ui.bean.ChaptersBean;
import com.liukun.base.net.RetrofitFactory;

import butterknife.BindView;

/**
 *
 */
public final class FragmentA extends MyFragment<HomeActivity> {

    @BindView(R.id.text)
    TextView mText;

    public static FragmentA newInstance() {
        return new FragmentA();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_a;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mText.setOnClickListener(this);
        mText.setOnClickListener(v -> {
            ChaptersBean chaptersBean = new ChaptersBean();
            chaptersBean.setName("我是从FragmentA来的");
            MessageWrap<ChaptersBean> chaptersBeanMessageWrap = new MessageWrap.Builder<ChaptersBean>()
                    .setMessage(chaptersBean)
                    .setCode(0)
                    .create();
            EventBusHelper.postStickyMessage(chaptersBeanMessageWrap);
//            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment, FragmentB.newInstance()).commit();
//            getActivity().
            BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bv_home_navigation);
            bottomNavigationView.setSelectedItemId(R.id.home_message);
        });
    }
}