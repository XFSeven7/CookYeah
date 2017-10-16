package com.qxf.archer.cookman.fragment.type;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.qxf.archer.cookman.R;
import com.qxf.archer.cookman.adapter.TypeAdapter;
import com.qxf.archer.cookman.constant.Constant;
import com.qxf.archer.cookman.entity.CookLableEntity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 类描述：
 * <p>
 * 作者：Administrator on 2017/8/28 0028 17:52
 * 邮箱：377289596@qq.com
 */

public class TypeFragment extends MvpFragment<TypeView, TypePresenter> implements TypeView {

    private static final String TAG = "TypeFragment";

    @BindView(R.id.root)
    LinearLayout root;
    Unbinder unbinder;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.swipe)
    SwipeRefreshLayout swipe;

    private TypeAdapter adapter;

    private String cid;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.type_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        initWidget();
        initView();
    }

    private void initWidget() {
        if (adapter == null) {
            adapter = new TypeAdapter(getActivity());
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true));
        recyclerView.setAdapter(adapter);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().loadData(cid, 1);
            }
        });
    }

    private void initView() {
        cid = getArguments().getString(Constant.FRAGMENT_CID);
        Log.e(TAG, "initView: " + cid);
        getPresenter().loadData(cid, 1);
    }

    @Override
    public TypePresenter createPresenter() {
        return new TypePresenter();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showRefresh() {
        swipe.setRefreshing(true);
    }

    @Override
    public void dissmissRefresh() {
        swipe.setRefreshing(false);
    }

    @Override
    public void showDatas(ArrayList<CookLableEntity.ResultBean.ListBean> listBeen) {
        adapter.setDatas(listBeen);
        adapter.notifyDataSetChanged();
        recyclerView.scrollToPosition(listBeen.size() - 1);
    }
}
