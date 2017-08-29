package com.qxf.archer.cookman.ui.main;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.qxf.archer.cookman.R;
import com.qxf.archer.cookman.adapter.MainTabAdapter;
import com.qxf.archer.cookman.entity.CookTypeEntity;
import com.qxf.archer.cookman.entity.FragmentEntity;
import com.qxf.archer.cookman.fragment.TypeFragment;
import com.qxf.archer.cookman.utils.FragmentRepo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends MvpActivity<MainView, MainPresenter> implements MainView {

    @BindView(R.id.toolbar)
    Toolbar toolBar;
    @BindView(R.id.tablayout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private ProgressDialog progressDialog;

    private MainTabAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        adapter = new MainTabAdapter(getSupportFragmentManager());
        getPresenter().uploadData();
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void showDialog() {
        progressDialog = ProgressDialog.show(this, "", "加载中...");
    }

    @Override
    public void dismissDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    private static final String TAG = "MainActivity";

    @Override
    public void updateTab(ArrayList<CookTypeEntity.ResultBean.ChildsBeanX.ChildsBean.CategoryInfoBeanXX> categoryInfoBeanXXes) {

        ArrayList<FragmentEntity> fragmentEntities = new ArrayList<>();

        for (int i = 0; i < categoryInfoBeanXXes.size(); i++) {
            TypeFragment typeFragment = new TypeFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("color", i);
            typeFragment.setArguments(bundle);
            // TODO: 2017/8/28 0028 设置参数
            fragmentEntities.add(new FragmentEntity(typeFragment, categoryInfoBeanXXes.get(i).getName(), i));
        }

        FragmentRepo.getInstance().replace(fragmentEntities);

        toolBar.setTitle("CookYeah");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

}
