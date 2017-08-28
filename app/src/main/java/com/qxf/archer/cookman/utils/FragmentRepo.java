package com.qxf.archer.cookman.utils;

import com.qxf.archer.cookman.entity.FragmentEntity;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 类描述：
 * <p>
 * 作者：Administrator on 2017/8/28 0028 16:11
 * 邮箱：377289596@qq.com
 */

public class FragmentRepo {

    private ArrayList<FragmentEntity> fragmentList;

    private static FragmentRepo instance;

    private FragmentRepo() {
        fragmentList = new ArrayList<>();
    }

    public static FragmentRepo getInstance() {
        if (instance == null) {
            instance = new FragmentRepo();
        }
        return instance;
    }

    public void add(FragmentEntity entity) {
        fragmentList.add(entity);
    }

    public void addAll(ArrayList<FragmentEntity> fs) {
        fragmentList.addAll(fs);
    }

    public void replace(ArrayList<FragmentEntity> fs) {
        fragmentList.clear();
        addAll(fs);
    }

    public void clear() {
        fragmentList.clear();
    }

    public void addFrist(FragmentEntity entity) {
        fragmentList.add(0, entity);
    }

    public void addEnd(FragmentEntity entity) {
        fragmentList.add(fragmentList.size() - 1, entity);
    }

    public void swap(int position1, int position2) {

        try {
            Collections.swap(fragmentList, position1, position2);
        } catch (Exception e) {
        }

        fragmentList.get(position1).setPosition(position2);
        fragmentList.get(position2).setPosition(position1);

    }

    public ArrayList<FragmentEntity> getDatas() {
        return fragmentList;
    }

}
