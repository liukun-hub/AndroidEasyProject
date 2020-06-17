package com.liukun.androideasyproject;

import androidx.appcompat.app.AppCompatActivity;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import android.os.Bundle;
import android.util.Log;

import com.liukun.androideasyproject.aop.Permissions;
import com.liukun.androideasyproject.net.Api;
import com.liukun.androideasyproject.ui.bean.ChaptersBean;
import com.liukun.androideasyproject.ui.bean.ChaptersDetailBean;
import com.liukun.base.net.BaseObserver;
import com.liukun.base.net.BaseResponse;
import com.liukun.base.net.BaseSubscriber;
import com.liukun.base.net.RetrofitFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Permissions({"android.permission.INTERNET"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RetrofitFactory.getInstance().create(Api.class)
                .getChapters()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<List<ChaptersBean>>(MainActivity.this) {
                    @Override
                    public void onSuccess(BaseResponse<List<ChaptersBean>> baseResponse) {
//                        Log.d("MainActivityTAG", "onSuccess: " + baseResponse.getData().toString());

                        RetrofitFactory.getInstance().create(Api.class)
                                .getChaptersDetail(baseResponse.getData().get(0).getId(), 1)
                                .subscribeOn(Schedulers.io())
                                .unsubscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new BaseSubscriber<ChaptersDetailBean>(MainActivity.this) {

                                    @Override
                                    public void onSuccess(BaseResponse<ChaptersDetailBean> baseResponse) {

                                    }

                                    @Override
                                    public void onCodeError(BaseResponse baseResponse) {

                                    }

                                    @Override
                                    public void onFailure(Throwable e, String message)  {

                                    }
                                });
                    }

                    @Override
                    public void onCodeError(BaseResponse baseResponse) {

                    }

                    @Override
                    public void onFailure(Throwable e, String message) {

                    }
                });


    }
}