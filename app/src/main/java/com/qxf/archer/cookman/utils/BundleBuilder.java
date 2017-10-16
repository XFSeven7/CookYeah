package com.qxf.archer.cookman.utils;

import android.os.Bundle;

import java.util.HashMap;

/**
 * 类描述：
 * <p>
 * 作者：Administrator on 2017/8/29 0029 10:36
 * 邮箱：377289596@qq.com
 */

public class BundleBuilder {

    private HashMap<String, String> map;

    private Bundle bundle;

    public BundleBuilder(){
        map = new HashMap<>();
        bundle = new Bundle();
    }

    public BundleBuilder putString(String key, String value) {
        bundle.putString(key, value);
        return this;
    }

    public BundleBuilder putInt(String key, int value) {
        bundle.putInt(key, value);
        return this;
    }

    public Bundle build(){
        return bundle;
    }

}
