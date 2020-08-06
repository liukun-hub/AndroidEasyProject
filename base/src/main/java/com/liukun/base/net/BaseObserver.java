package com.liukun.base.net;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.liukun.base.BaseDialog;
import com.liukun.base.widget.dialog.WaitDialog;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Author: liukun on 2020/6/7.
 * Mail  : 3266817262@qq.com
 * Description:主要是请求成功失败、网络异常时的回调,它实现的Observer类,其中成功失败主要在Onext方法里处理
 */
public abstract class BaseObserver<T> implements Observer<BaseResponse<T>> {
    private Context mContext;
    /**
     * 加载对话框
     */
    private BaseDialog mDialog;
    /**
     * 对话框数量
     */
    private int mDialogTotal;
    private Disposable mDisposable;

    public BaseObserver(Context mContext) {
        this.mContext = mContext;
    }

    public BaseObserver() {
    }

    @Override
    public void onSubscribe(Disposable d) {
        mDisposable = d;
        if (mContext != null) {
            showDialog();
        }
    }

    @Override
    public void onComplete() {
        if (mContext != null) {
            hideDialog();
        }
        if (mDisposable != null) {
            if (mDisposable.isDisposed()) {
                mDisposable.dispose();
            }
        }
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof ConnectException ||
                e instanceof TimeoutException ||
                e instanceof NetworkErrorException ||
                e instanceof UnknownHostException) {
            try {
                onFailure(e, e.getMessage(), false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {
            try {
                onFailure(e, e.getMessage(), true);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void onNext(BaseResponse<T> baseResponse) {
        if (baseResponse.isSuccess()) {
            onSuccess(baseResponse);
        } else {
//            onCodeError(baseResponse);
            if (mContext != null) {
                Toast.makeText(mContext, baseResponse.getMessage() + "s", Toast.LENGTH_LONG).show();
            }
            onFailure(null, baseResponse.toString(), true);
        }
//        onSuccess(baseResponse);
    }

    /**
     * 显示加载对话框
     */
    public void showDialog() {
        if (mDialog == null) {
            mDialog = new WaitDialog.Builder(mContext)
                    .setCancelable(false)
                    .create();
        }
        if (!mDialog.isShowing()) {
            mDialog.show();

        }
        mDialogTotal++;
    }

    /**
     * 隐藏加载对话框
     */
    public void hideDialog() {
        if (mDialogTotal == 1) {
            if (mDialog != null && mDialog.isShowing()) {
                mDialog.dismiss();
            }
        }
        if (mDialogTotal > 0) {
            mDialogTotal--;
        }
    }

    //请求成功且返回码为200的回调方法,这里抽象方法申明
    public abstract void onSuccess(BaseResponse<T> baseResponse);

//    //请求成功但返回的code码不是200的回调方法,这里抽象方法申明
//    public abstract void onCodeError(BaseResponse<T> baseResponse);

    //请求失败回调方法,这里抽象方法申明
    public abstract void onFailure(Throwable e, String errorMessage, boolean netWork);
}