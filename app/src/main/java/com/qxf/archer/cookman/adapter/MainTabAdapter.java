package com.qxf.archer.cookman.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.qxf.archer.cookman.utils.FragmentRepo;

/**
 * 类描述：
 * <p>
 * 作者：Administrator on 2017/8/28 0028 17:20
 * 邮箱：377289596@qq.com
 */

public class MainTabAdapter extends FragmentPagerAdapter{

    public MainTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentRepo.getInstance().getDatas().get(position).getFragment();
    }

    @Override
    public int getCount() {
        return FragmentRepo.getInstance().getDatas().size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return FragmentRepo.getInstance().getDatas().get(position).getTitle();
    }
}
