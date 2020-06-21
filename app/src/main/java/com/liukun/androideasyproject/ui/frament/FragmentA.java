package com.liukun.androideasyproject.ui.frament;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.liukun.androideasyproject.R;
import com.liukun.androideasyproject.commom.MyFragment;
import com.liukun.androideasyproject.net.Api;
import com.liukun.androideasyproject.ui.activity.HomeActivity;
import com.liukun.base.net.BaseResponse;
import com.liukun.base.net.RetrofitFactory;

import butterknife.BindView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 *
 */
public final class FragmentA extends MyFragment<HomeActivity> implements View.OnClickListener {

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
    public void onClick(View v) {
        Log.d("ssss", "sssss: ");
        //网络请求
        RetrofitFactory.getInstance()
                .create(Api.class)
                .getChapters()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseResponse<Object>>() {
                    @Override
                    public void onCompleted() {
                        Log.d("ssss", "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("ssss", "e" + e.getMessage());
                    }

                    @Override
                    public void onNext(BaseResponse<Object> objectBaseResponse) {
                        mText.setText("ss" + objectBaseResponse.toString());
                        Log.d("ssss", "onCompleted:ww ");
                    }
                });

    }

    @Override
    protected void initData() {
        mText.setOnClickListener(this);
//        mText.setOnClickListener(v -> {
//
//
////            ChaptersBean chaptersBean = new ChaptersBean();
////            chaptersBean.setName("我是从FragmentA来的");
////            MessageWrap<ChaptersBean> chaptersBeanMessageWrap = new MessageWrap.Builder<ChaptersBean>()
////                    .setMessage(chaptersBean)
////                    .setCode(0)
////                    .create();
////            EventBusHelper.postStickyMessage(chaptersBeanMessageWrap);
//        });
    }
}