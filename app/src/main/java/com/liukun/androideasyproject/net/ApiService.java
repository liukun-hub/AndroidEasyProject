package com.liukun.androideasyproject.net;


import com.liukun.androideasyproject.ui.bean.ChaptersBean;
import com.liukun.androideasyproject.ui.bean.ChaptersDetailBean;
import com.liukun.base.net.BaseResponse;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;


/**
 * Author: liukun on 2020/6/7.
 * Mail  : 3266817262@qq.com
 * Description: 接口地址
 */
public interface ApiService {

//    /**
//     * get请求方式
//     * @Query
//     * 形成单个查询参数, 将接口url中追加类似于"page=1"的字符串,形成提交给服务器端的参数,
//     * 主要用于Get请求数据，用于拼接在拼接在url路径后面的查询参数，一个@Query相当于拼接一个参数
//     */
//    String HOST = "https://api.apiopen.top";        //接口地址
//    @GET("/musicDetails")
//    Observable<BaseReponse<List<MeiZiResponse>>> getMeiZi(@Query("id") String id);
//
//    /**
//     * post请求方式
//     */
//    @FormUrlEncoded         //post请求必须要申明该注解
//    @POST("musicDetails")   //方法名
//    Observable<BaseReponse<List<MeiZiResponse>>> getInfo(@Field("id") String data);//请求参数

    String HOST = "http://jianyunkeji.oss-cn-beijing.aliyuncs.com";        //接口地址

    @GET("http://jianyun-public.oss-cn-beijing.aliyuncs.com/config/soldier/remotever.json")
    Observable<BaseResponse<Object>> getChapters();

    ///405/1/json?k=Java
    @GET("wxarticle/list/{id}/{page}/json?k=Java")
    Observable<BaseResponse<ChaptersDetailBean>> getChaptersDetail(@Path("id") int id, @Path("page") int page);
}
