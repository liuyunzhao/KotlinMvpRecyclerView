package com.cn.lyz.daggerkotlin.kotlin.interface1;

/**
 * Created by yunzhao.liu on 2018/3/8
 */

public interface Car {
    void run();

    default void color(){
        System.out.println("red");
    }
}
