package com.liukun.androideasyproject.ui.frament;

import android.widget.TextView;

import com.liukun.androideasyproject.R;
import com.liukun.androideasyproject.commom.MyFragment;
import com.liukun.androideasyproject.net.ApiService;
import com.liukun.androideasyproject.ui.activity.HomeActivity;
import com.liukun.base.net.BaseResponse;
import com.liukun.base.net.RetrofitFactory;

import butterknife.BindView;
import io.reactivex.Observer;
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
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResponse<Object>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        showDialog();
                    }

                    @Override
                    public void onNext(BaseResponse<Object> objectBaseResponse) {
                        mText.setText(objectBaseResponse.getData().toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        hideDialog();
                    }
                });
    }
}