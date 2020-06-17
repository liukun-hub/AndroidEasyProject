package com.liukun.androideasyproject.aop;

/**
 * Author: liukun on 2020/6/7.
 * Mail  : 3266817262@qq.com
 * Description:权限申请注解
 */
public @interface Permissions {

    /**
     * 需要申请权限的集合
     */
    String[] value();
}
