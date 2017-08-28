package com.qxf.archer.cookman.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qxf.archer.cookman.constant.Constant;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 类描述：
 * <p>
 * 作者：Administrator on 2017/8/24 0024 10:49
 * 邮箱：377289596@qq.com
 */

public class NetClient {

    private static NetClient instance;

    private Retrofit retrofit;

    private OkHttpClient okHttpClient;


    private NetClient() {

        // 非严格模式
        Gson gson = new GsonBuilder().setLenient().create();

        okHttpClient = new OkHttpClient();

        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    public static NetClient getInstance(){
        if (instance == null) {
            instance = new NetClient();
        }
        return instance;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }

}
