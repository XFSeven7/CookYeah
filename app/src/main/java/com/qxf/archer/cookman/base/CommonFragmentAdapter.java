package com.qxf.archer.cookman.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * 类描述：
 * <p>
 * 作者：Administrator on 2017/8/28 0028 11:37
 * 邮箱：377289596@qq.com
 */

public abstract class CommonFragmentAdapter<T> extends FragmentPagerAdapter {

    private ArrayList<T> arrayList;

    public void add(T t) {
        arrayList.add(t);
    }

    public void addAll(ArrayList<T> ts) {
        arrayList.clear();
        arrayList.addAll(ts);
    }

    public void clear() {
        arrayList.clear();
    }

    public CommonFragmentAdapter(FragmentManager fm) {
        this(fm, null);
    }

    public CommonFragmentAdapter(FragmentManager fm, ArrayList<T> arrayList) {
        super(fm);
        this.arrayList = arrayList;
    }

    @Override
    public abstract Fragment getItem(int position);

    @Override
    public int getCount() {
        return arrayList.size();
    }

}
