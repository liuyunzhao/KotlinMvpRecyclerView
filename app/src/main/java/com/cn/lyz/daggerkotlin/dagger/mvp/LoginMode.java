package com.cn.lyz.daggerkotlin.dagger.mvp;

import android.os.Handler;

import javax.inject.Inject;

/**
 * Created by yunzhao.liu on 2018/3/7
 */

public class LoginMode implements LoginContract.Model {

    @Inject
    public LoginMode() {
    }

    @Override
    public void getLoginInfo(LoginInfo info, final OnListener listener) {
        listener.onSuccess("手机号："+info.getPhone()+"-验证码："+info.getCode());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onFailure("failure");
            }
        }, 5000);
    }
}
