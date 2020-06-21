package com.liukun.base.net;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Author: liukun on 2020/6/7.
 * Mail  : 3266817262@qq.com
 * Description: 一个拦截器工具类,用于日志拦截和添加头部相关信息
 */
public class InterceptorUtil {
    public static final String TAG="okHttp";
    public static HttpLoggingInterceptor LogInterceptor() {     //日志拦截器,用于打印返回请求的结果
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d(TAG,"log:"+message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    public static Interceptor HeaderInterceptor(){      //头部添加请求头信息
        return new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request request=chain.request().newBuilder()
                        .addHeader("Content-Type","application/json;charSet=UTF-8")
                        .build();
                return chain.proceed(request);
            }
        };
    }
}
