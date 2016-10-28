package com.example.angel.moon_text.network;

import com.example.angel.moon_text.info.PhoneInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lenovo on 2016/9/8.
 */
public interface NetApi {

    /**
     * 请求示例:http://apis.juhe.cn/mobile/get?phone=13429667914&key=您申请的KEY
     */
    //分类菜谱详情
    @GET("index")
        Call<PhoneInfo> getClassify(@Query("phone") String phone,
                                    @Query("key") String AppKey);
}
