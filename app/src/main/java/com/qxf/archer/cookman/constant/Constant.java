package com.qxf.archer.cookman.constant;

/**
 * 类描述：
 * <p>
 * 作者：Administrator on 2017/8/24 0024 15:15
 * 邮箱：377289596@qq.com
 */

public class Constant {

    public static final String KEY = "520520test";

    public static final String BASE_URL = "http://apicloud.mob.com/v1/cook/";

    public static final String TYPE_F = "category/query";

    public static final String TYPE_URL = "menu/search";

    public static final String SREARCH_URL = "menu/query";

    public static final int DB_VERSION = 1;

    public static final String DB_NAME = "cook.db";

    public static final String CREATE_TYPE_TABLE =
            "CREATE TABLE type" +
                "(" +
                    "id int," +
                    "name varchar(255)" +
                ")";



}
