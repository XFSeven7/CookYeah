package com.qxf.archer.cookman.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * 类描述：
 * <p>
 * 作者：Administrator on 2017/8/28 0028 11:09
 * 邮箱：377289596@qq.com
 */

public abstract class CommonAdapter<T> extends BaseAdapter {

    private ArrayList<T> arrayList;

    public CommonAdapter(ArrayList<T> arrayList) {
        this.arrayList = arrayList;
    }

    public void addItem(T t) {
        arrayList.add(t);
    }

    public void addAll(ArrayList<T> ts) {
        arrayList.clear();
        arrayList.addAll(ts);
    }

    public void addFirst(T t) {
        arrayList.add(0, t);
    }

    public void addEnd(T t) {
        arrayList.add(arrayList.size() - 1, t);
    }

    public void clear() {
        arrayList.clear();
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public T getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public abstract View getView(int i, View view, ViewGroup viewGroup);

}
