package com.qxf.archer.cookman.fragment.type;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.qxf.archer.cookman.entity.CookLableEntity;

import java.util.ArrayList;

/**
 * 类描述：
 * <p>
 * 作者：Administrator on 2017/8/29 0029 10:59
 * 邮箱：377289596@qq.com
 */

public interface TypeView extends MvpView {

    void showRefresh();

    void dissmissRefresh();

    void showDatas(ArrayList<CookLableEntity.ResultBean.ListBean> listBeen);

}
