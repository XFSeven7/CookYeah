package com.qxf.archer.cookman.fragment.type;

import android.text.TextUtils;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.qxf.archer.cookman.constant.Constant;
import com.qxf.archer.cookman.entity.CookLableEntity;
import com.qxf.archer.cookman.net.NetClient;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 类描述：
 * <p>
 * 作者：Administrator on 2017/8/29 0029 10:59
 * 邮箱：377289596@qq.com
 */

public class TypePresenter extends MvpBasePresenter<TypeView> {

    private static final String TAG = "TypePresenter";

    public void loadData(String cid, int page) {

        NetClient
                .getInstance()
                .getApi()
                .getCookLable(Constant.KEY, cid, page, 20)
                .map(new Function<CookLableEntity, ArrayList<CookLableEntity.ResultBean.ListBean>>() {
                    @Override
                    public ArrayList<CookLableEntity.ResultBean.ListBean> apply(@NonNull CookLableEntity cookLableEntity) throws Exception {
                        List<CookLableEntity.ResultBean.ListBean> list = cookLableEntity.getResult().getList();
                        ArrayList<CookLableEntity.ResultBean.ListBean> data = new ArrayList<>();
                        for (int i = 0; i < list.size(); i++) {
                            if (!TextUtils.isEmpty(list.get(i).getThumbnail())) {
                                data.add(list.get(i));
                            }
                        }
                        return data;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<ArrayList<CookLableEntity.ResultBean.ListBean>>() {
                    @Override
                    public void accept(ArrayList<CookLableEntity.ResultBean.ListBean> listBeen) throws Exception {
                        getView().showDatas(listBeen);
                        getView().dissmissRefresh();
                    }
                });

    }

}
