package com.cn.lyz.daggerkotlin.dagger.mvp;

/**
 * Created by yunzhao.liu on 2018/3/7
 */

public interface LoginContract {
    interface View {

        void loginSuccess(String info);

        void loginFailure(String msg);
    }


    interface Presenter{
        void submitLoginInfo(LoginInfo info);
    }

    interface Model{
        void getLoginInfo(LoginInfo info, OnListener listener);
    }
}
