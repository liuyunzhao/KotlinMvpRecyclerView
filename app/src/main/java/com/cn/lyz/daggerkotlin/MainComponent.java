package com.cn.lyz.daggerkotlin;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by yunzhao.liu on 2018/3/7
 */
@Singleton
@Component
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
