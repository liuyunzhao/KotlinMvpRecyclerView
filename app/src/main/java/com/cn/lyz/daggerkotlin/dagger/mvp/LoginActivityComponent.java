package com.cn.lyz.daggerkotlin.dagger.mvp;

import com.cn.lyz.daggerkotlin.dagger.Dagger2Activity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by yunzhao.liu on 2018/3/7
 */
//因ContextModule中使用管理singleton，所以这里也需要使用
@Singleton
@Component(modules = {LoginModule.class, ContextModule.class})
public interface LoginActivityComponent {
    void inject(Dagger2Activity dagger2Activity);
}
