package com.liukun.base.net.baseconfig;

import android.annotation.SuppressLint;
import android.util.Log;

import com.liukun.base.net.BaseObserver;
import com.liukun.base.net.BaseResponse;
import com.liukun.base.net.RetrofitFactory;
import com.liukun.base.net.model.ConfigBean;
import com.liukun.base.net.model.ConfigInfoBean;
import com.liukun.base.net.model.ConfigUrlVerBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Author: liukun on 2020/6/26.
 * Mail  : 3266817262@qq.com
 * Description:
 */
public class BaseConfigHelper {
    private static BaseConfigHelper mBaseConfigHelper;

    private IBaseConfig mIBaseConfig;

    public BaseConfigHelper() {
        getBaseConfig(true);
    }


    public void setBaseConfig(boolean isProd, IBaseConfig mIBaseConfig) {
        this.mIBaseConfig = mIBaseConfig;
        getBaseConfig(isProd);
    }

    public static BaseConfigHelper getInstance() {
        if (mBaseConfigHelper == null) {
            return new BaseConfigHelper();
        }
        return mBaseConfigHelper;
    }


    @SuppressLint("CheckResult")
    public void getBaseConfig(boolean isProd) {
        RetrofitFactory.getInstance().init(BaseConfigServer.configUrlVer);
        RetrofitFactory.getInstance().create(BaseConfigServer.class)
                .getConfigUrlVer()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<ConfigUrlVerBean>() {
                    @Override
                    public void onSuccess(BaseResponse<ConfigUrlVerBean> baseResponse) {
                        Log.d("ssssss", "onSuccess: " + baseResponse.toString());
                        String ver = baseResponse.getData().getVer();
                        RetrofitFactory.getInstance().init(BaseConfigServer.configUrl4);
                        RetrofitFactory.getInstance().create(BaseConfigServer.class)
                                .getConfigUrl(ver)
                                .subscribeOn(Schedulers.io())
                                .unsubscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new BaseObserver<ConfigBean>() {
                                    @Override
                                    public void onSuccess(BaseResponse<ConfigBean> baseResponse) {
                                        Log.d("ssssss", "onSuccess: " + baseResponse.toString());
                                        if (isProd) {
                                            ConfigInfoBean infoBean = new ConfigInfoBean();
                                            infoBean.setBaseCDN(baseResponse.getData().getOn_cdn());
                                            infoBean.setBaseUrl(baseResponse.getData().getOn_baseUrl());
                                            infoBean.setShare_title(baseResponse.getData().getShare_title());
                                            infoBean.setShare_subtitle(baseResponse.getData().getShare_subtitle());
                                            infoBean.setPlatform_logo(baseResponse.getData().getPlatform_logo());
                                            infoBean.setQrcode_wechat(baseResponse.getData().getQrcode_wechat());
                                            mIBaseConfig.getBaseConfigSuccess(infoBean);
                                        } else {
                                            ConfigInfoBean infoBean = new ConfigInfoBean();
                                            infoBean.setBaseCDN(baseResponse.getData().getCdn_domain());
                                            infoBean.setBaseUrl(baseResponse.getData().getTest_baseUrl());
                                            infoBean.setShare_title(baseResponse.getData().getShare_title());
                                            infoBean.setShare_subtitle(baseResponse.getData().getShare_subtitle());
                                            infoBean.setPlatform_logo(baseResponse.getData().getPlatform_logo());
                                            infoBean.setQrcode_wechat(baseResponse.getData().getQrcode_wechat());
                                            mIBaseConfig.getBaseConfigSuccess(infoBean);
                                        }

                                    }

                                    @Override
                                    public void onFailure(Throwable e, String errorMessage, boolean netWork) {
                                        Log.d("ssssss", "errorMessage: " + errorMessage.toString());
                                        RetrofitFactory.getInstance().init(BaseConfigServer.configUrl3);
                                        RetrofitFactory.getInstance().create(BaseConfigServer.class)
                                                .getConfigUrl(ver)
                                                .subscribeOn(Schedulers.io())
                                                .unsubscribeOn(Schedulers.io())
                                                .observeOn(AndroidSchedulers.mainThread())
                                                .subscribe(new BaseObserver<ConfigBean>() {
                                                    @Override
                                                    public void onSuccess(BaseResponse<ConfigBean> baseResponse) {
                                                        if (isProd) {
                                                            ConfigInfoBean infoBean = new ConfigInfoBean();
                                                            infoBean.setBaseCDN(baseResponse.getData().getOn_cdn());
                                                            infoBean.setBaseUrl(baseResponse.getData().getOn_baseUrl());
                                                            infoBean.setShare_title(baseResponse.getData().getShare_title());
                                                            infoBean.setShare_subtitle(baseResponse.getData().getShare_subtitle());
                                                            infoBean.setPlatform_logo(baseResponse.getData().getPlatform_logo());
                                                            infoBean.setQrcode_wechat(baseResponse.getData().getQrcode_wechat());
                                                            mIBaseConfig.getBaseConfigSuccess(infoBean);
                                                        } else {
                                                            ConfigInfoBean infoBean = new ConfigInfoBean();
                                                            infoBean.setBaseCDN(baseResponse.getData().getCdn_domain());
                                                            infoBean.setBaseUrl(baseResponse.getData().getTest_baseUrl());
                                                            infoBean.setShare_title(baseResponse.getData().getShare_title());
                                                            infoBean.setShare_subtitle(baseResponse.getData().getShare_subtitle());
                                                            infoBean.setPlatform_logo(baseResponse.getData().getPlatform_logo());
                                                            infoBean.setQrcode_wechat(baseResponse.getData().getQrcode_wechat());
                                                            mIBaseConfig.getBaseConfigSuccess(infoBean);
                                                        }
                                                    }

                                                    @Override
                                                    public void onFailure(Throwable e, String errorMessage, boolean netWork) {
                                                        Log.d("ssssss", "errorMessage: " + errorMessage.toString());
                                                        mIBaseConfig.getBaseConfigFail(errorMessage);
                                                    }

                                                });
                                    }

                                });

                    }

                    @Override
                    public void onFailure(Throwable e, String errorMessage, boolean netWork) {
                        mIBaseConfig.getBaseConfigFail(errorMessage);
                    }

                });
    }
}
