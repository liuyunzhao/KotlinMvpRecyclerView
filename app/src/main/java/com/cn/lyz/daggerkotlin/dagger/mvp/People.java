package com.cn.lyz.daggerkotlin.dagger.mvp;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by yunzhao.liu on 2018/3/7
 */

//在某个作用域内是单例（可以看做在程序中实例化Component的生命周期的长短，
// 如果在Application里build的那它的作用域就是整个App的生命周期，
// 如果是在Acitivity中build的那它的作用域就是此Acitivity的生命周期）
@Singleton
public class People {
    private String name;

    @Inject
    public People() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
