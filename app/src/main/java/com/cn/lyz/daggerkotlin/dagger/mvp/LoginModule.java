package com.cn.lyz.daggerkotlin.dagger.mvp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yunzhao.liu on 2018/3/7
 */
@Module
public class LoginModule {

    private LoginContract.View loginView;

    public LoginModule(LoginContract.View loginView) {
        this.loginView = loginView;
    }

//    使用Provides标注，并返回构造中传入的对象
    @Provides
    LoginContract.View providesLoginView() {
        return loginView;
    }


}
