package com.qxf.archer.cookman.ui.main;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.qxf.archer.cookman.constant.Constant;
import com.qxf.archer.cookman.entity.CookTypeEntity;
import com.qxf.archer.cookman.net.NetClient;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 类描述：
 * <p>
 * 作者：Administrator on 2017/8/28 0028 10:58
 * 邮箱：377289596@qq.com
 */

public class MainPresenter extends MvpBasePresenter<MainView> {

    public void uploadData() {

        getView().showDialog();
        NetClient
                .getInstance()
                .getApi()
                .getCookType(Constant.KEY)
                .map(map1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ArrayList<CookTypeEntity.ResultBean.ChildsBeanX.ChildsBean.CategoryInfoBeanXX>>() {
                    @Override
                    public void accept(ArrayList<CookTypeEntity.ResultBean.ChildsBeanX.ChildsBean.CategoryInfoBeanXX> categoryInfoBeanXXes) throws Exception {
                        getView().dismissDialog();
                        getView().updateTab(categoryInfoBeanXXes);
                    }
                });

    }

    Function<CookTypeEntity, ArrayList<CookTypeEntity.ResultBean.ChildsBeanX.ChildsBean.CategoryInfoBeanXX>> map1 =
            new Function<CookTypeEntity, ArrayList<CookTypeEntity.ResultBean.ChildsBeanX.ChildsBean.CategoryInfoBeanXX>>() {
                @Override
                public ArrayList<CookTypeEntity.ResultBean.ChildsBeanX.ChildsBean.CategoryInfoBeanXX> apply(@NonNull CookTypeEntity cookTypeEntity) throws Exception {
                    ArrayList<CookTypeEntity.ResultBean.ChildsBeanX.ChildsBean.CategoryInfoBeanXX> dataList = new ArrayList<>();
                    for (int i = 0; i < cookTypeEntity.getResult().getChilds().size(); i++) {
                        for (int j = 0; j < cookTypeEntity.getResult().getChilds().get(i).getChilds().size(); j++) {
                            CookTypeEntity.ResultBean.ChildsBeanX.ChildsBean.CategoryInfoBeanXX categoryInfo =
                                    cookTypeEntity.getResult().getChilds().get(i).getChilds().get(j).getCategoryInfo();
                            dataList.add(categoryInfo);
                        }
                    }
                    return dataList;
                }
            };

}
