package com.qxf.archer.cookman.ui.main;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.qxf.archer.cookman.entity.CookTypeEntity;

import java.util.ArrayList;

/**
 * 类描述：
 * <p>
 * 作者：Administrator on 2017/8/28 0028 10:58
 * 邮箱：377289596@qq.com
 */

public interface MainView extends MvpView {

    void showDialog();

    void dismissDialog();

    void updateTab(ArrayList<CookTypeEntity.ResultBean.ChildsBeanX.ChildsBean.CategoryInfoBeanXX> categoryInfoBeanXXes);

}
