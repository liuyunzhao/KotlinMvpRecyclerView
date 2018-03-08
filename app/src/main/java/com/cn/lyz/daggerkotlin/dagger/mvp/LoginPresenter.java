package com.cn.lyz.daggerkotlin.dagger.mvp;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

/**
 * Created by yunzhao.liu on 2018/3/7
 */

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mLoginView;
    private Context mContext;

    //注入
    @Inject
    LoginMode mLoginMode;

    //注入
    @Inject
    public LoginPresenter(LoginContract.View view, Context context) {
        this.mLoginView = view;
        this.mContext = context;

    }

    @Override
    public void submitLoginInfo(LoginInfo info) {
        Log.d("liuyz", "---context:" + mContext);
        mLoginMode.getLoginInfo(info, new OnListener(){

            @Override
            public void onSuccess(String response) {
                mLoginView.loginSuccess(response);
            }

            @Override
            public void onFailure(String msg) {
                mLoginView.loginFailure(msg);
            }
        });

    }
}
