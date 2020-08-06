package com.liukun.base.net.baseconfig;

import com.liukun.base.net.BaseResponse;
import com.liukun.base.net.model.ConfigBean;
import com.liukun.base.net.model.ConfigUrlVerBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Author: liukun on 2020/7/20.
 * Mail  : 3266817262@qq.com
 * Description:
 */
public interface BaseConfigServer {

    public static final String[] configUrl = {"https://test.jianyunkeji.net/soldier/api/app.php?c=zhconfig&platform=android",
            "http://h5.jianyunkeji.cn/wine/api/app.php?c=wineconfig&platform=android"};
    public static final String configUrlVer = "http://jianyunkeji.oss-cn-beijing.aliyuncs.com";
    public static final String configUrl3 = "http://jianyunkeji.oss-cn-beijing.aliyuncs.com";
    public static final String configUrl4 = "http://jianyun-public.oss-cn-beijing.aliyuncs.com";


    @GET("/config/soldier/remotever.json")
    Observable<BaseResponse<ConfigUrlVerBean>> getConfigUrlVer();

    @GET("/config/soldier/config_{ver}.json")
    Observable<BaseResponse<ConfigBean>> getConfigUrl(@Path("ver") String ver);

}
