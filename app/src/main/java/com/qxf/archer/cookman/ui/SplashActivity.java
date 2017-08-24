package com.qxf.archer.cookman.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.Window;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.qxf.archer.cookman.R;
import com.qxf.archer.cookman.ui.splash.SplashPresenter;
import com.qxf.archer.cookman.ui.splash.SplashView;

public class SplashActivity extends MvpActivity<SplashView, SplashPresenter> {

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

    }

    @NonNull
    @Override
    public SplashPresenter createPresenter() {
        return new SplashPresenter();
    }
}
