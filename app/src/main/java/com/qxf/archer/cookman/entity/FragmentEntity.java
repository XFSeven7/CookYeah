package com.qxf.archer.cookman.entity;

import android.support.v4.app.Fragment;

/**
 * 类描述：
 * <p>
 * 作者：Administrator on 2017/8/28 0028 16:20
 * 邮箱：377289596@qq.com
 */

public class FragmentEntity {

    private Fragment fragment;
    private String title;
    private int position;
    private String cid;

    public FragmentEntity() {
    }

    public FragmentEntity(Fragment fragment, String title, int position, String cid) {
        this.fragment = fragment;
        this.title = title;
        this.position = position;
        this.cid = cid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
