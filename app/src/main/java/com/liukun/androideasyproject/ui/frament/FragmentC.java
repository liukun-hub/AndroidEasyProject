package com.liukun.androideasyproject.ui.frament;

import android.util.Log;
import android.widget.TextView;

import com.liukun.androideasyproject.R;
import com.liukun.androideasyproject.commom.MyFragment;
import com.liukun.androideasyproject.net.ApiService;
import com.liukun.androideasyproject.ui.activity.HomeActivity;
import com.liukun.base.net.BaseObserver;
import com.liukun.base.net.BaseResponse;
import com.liukun.base.net.RetrofitFactory;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 *
 */
public final class FragmentC extends MyFragment<HomeActivity> {

    @BindView(R.id.text)
    TextView mText;

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
        RetrofitFactory.getInstance().create(ApiService.class)
                .getChapters()
                .compose(RetrofitFactory.rxStream())
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<Object>(getContext()) {
                    @Override
                    public void onSuccess(BaseResponse<Object> baseResponse) {
                        Log.d("ssssss", "onSuccess: " + baseResponse.toString());
                        mText.setText(baseResponse.getData().toString());
                    }

                    @Override
                    public void onFailure(Throwable e, String errorMessage, boolean netWork) {
                        Log.d("ssssss", "errorMessage: " + errorMessage.toString());
                    }

                });
    }
}