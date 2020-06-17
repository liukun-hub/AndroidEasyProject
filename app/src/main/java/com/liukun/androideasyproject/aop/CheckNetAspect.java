package com.liukun.androideasyproject.aop;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.hjq.toast.ToastUtils;
import com.liukun.androideasyproject.R;
import com.liukun.base.helper.ActivityStackManager;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import androidx.core.content.ContextCompat;

/**
 * Author: liukun on 2020/6/7.
 * Mail  : 3266817262@qq.com
 * Description:网络检测
 */
@Aspect
public class CheckNetAspect {
    /**
     * 方法切入点
     */
    @Pointcut("execution(@com.hjq.demo.aop.CheckNet * *(..))")
    public void method() {}

    /**
     * 在连接点进行方法替换
     */
    @Around("method() && @annotation(checkNet)")
    public void aroundJoinPoint(ProceedingJoinPoint joinPoint, CheckNet checkNet) throws Throwable {
        Application application = ActivityStackManager.getInstance().getApplication();
        if (application != null) {
            ConnectivityManager manager = ContextCompat.getSystemService(application, ConnectivityManager.class);
            if (manager != null) {
                NetworkInfo info = manager.getActiveNetworkInfo();
                // 判断网络是否连接
                if (info == null || !info.isConnected()) {
                    ToastUtils.show(R.string.common_network);
                    return;
                }
            }
        }
        //执行原方法
        joinPoint.proceed();
    }
}
