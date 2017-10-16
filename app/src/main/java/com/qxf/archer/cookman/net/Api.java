package com.qxf.archer.cookman.net;

import com.qxf.archer.cookman.constant.Constant;
import com.qxf.archer.cookman.entity.CookLableEntity;
import com.qxf.archer.cookman.entity.CookSearchEntity;
import com.qxf.archer.cookman.entity.CookTypeEntity;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 类描述：
 * <p>
 * 作者：Administrator on 2017/8/24 0024 11:36
 * 邮箱：377289596@qq.com
 */

public interface Api {

    /**
     * 获取种类
     *
     * @param key
     * @return
     */
    @GET(Constant.TYPE_F)
    Flowable<CookTypeEntity> getCookType(@Query("key") String key);

    /**
     * 根据标签查询
     *
     * @param key
     * @param cid
     * @param page
     * @param size
     * @return
     */
    @GET(Constant.TYPE_URL)
    Flowable<CookLableEntity> getCookLable(
            @Query("key") String key, @Query("cid") String cid, @Query("page") int page, @Query("size") int size
    );

    /**
     * 获取查询后的菜谱
     * @return
     */
    @GET(Constant.SREARCH_URL)
    Flowable<CookSearchEntity> getSearch(@Query("key") String key, @Query("id") String cid );


}

