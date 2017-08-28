package com.qxf.archer.cookman.ui.splash;

import android.util.Log;

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
 * 作者：Administrator on 2017/8/24 0024 15:56
 * 邮箱：377289596@qq.com
 */

public class SplashPresenter extends MvpBasePresenter<SplashView> {

    private static final String TAG = "SplashPresenter";

    public void getData() {

        NetClient
                .getInstance()
                .getApi()
                .getCookType(Constant.KEY)
                .map(function)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(consumer);

    }

    /**
     * 订阅执行
     */
    private Consumer<ArrayList<String>> consumer = new Consumer<ArrayList<String>>() {
        @Override
        public void accept(ArrayList<String> strings) throws Exception {
            Log.e(TAG, "accept: " + strings.toString());
            getView().openMain();
        }
    };

    /**
     * 数据类型转化
     */
    private Function<CookTypeEntity, ArrayList<String>> function = new Function<CookTypeEntity, ArrayList<String>>() {
        @Override
        public ArrayList<String> apply(@NonNull CookTypeEntity cookTypeEntity) throws Exception {
            Log.e(TAG, "apply: " + cookTypeEntity.toString());
            ArrayList<String> strings = new ArrayList<>();
            for (int i = 0; i < cookTypeEntity.getResult().getChilds().size(); i++) {
                strings.add(cookTypeEntity.getResult().getChilds().get(i).getCategoryInfo().getName());
                Log.e(TAG, "apply: " + cookTypeEntity.getResult().getChilds().get(i).getCategoryInfo().getName());
            }
            return strings;
        }
    };

}
