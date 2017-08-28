package com.qxf.archer.cookman.utils;

import android.content.Context;
import android.content.Intent;

/**
 * 类描述：
 * <p>
 * 作者：Administrator on 2017/8/28 0028 10:45
 * 邮箱：377289596@qq.com
 */

public class ActivityUtils {

    public static void openActivity(Context context, Class clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }

}
