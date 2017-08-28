package com.qxf.archer.cookman;

import android.app.Application;
import android.content.Context;

/**
 * 类描述：
 * <p>
 * 作者：Administrator on 2017/8/25 0025 14:13
 * 邮箱：377289596@qq.com
 */

public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext(){
        return context;
    }

}
