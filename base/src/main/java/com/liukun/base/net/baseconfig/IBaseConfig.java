package com.liukun.base.net.baseconfig;


import com.liukun.base.net.model.ConfigBean;
import com.liukun.base.net.model.ConfigInfoBean;

/**
 * Author: liukun on 2020/6/26.
 * Mail  : 3266817262@qq.com
 * Description: 获取基本配置信息的接口
 */
public interface IBaseConfig {
    void getBaseConfigSuccess(ConfigInfoBean configInfo);

    void getBaseConfigFail(String message);
}
