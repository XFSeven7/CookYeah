package com.qxf.archer.cookman.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.qxf.archer.cookman.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 类描述：
 * <p>
 * 作者：Administrator on 2017/8/28 0028 17:52
 * 邮箱：377289596@qq.com
 */

public class TypeFragment extends Fragment {

    @BindView(R.id.root)
    LinearLayout root;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.type_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        int color = getArguments().getInt("color");
        if (color % 2 == 0) {
            root.setBackgroundColor(Color.RED);
        } else {
            root.setBackgroundColor(Color.GREEN);
        }

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
