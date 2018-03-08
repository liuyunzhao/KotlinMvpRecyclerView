package com.cn.lyz.daggerkotlin.kotlin.constructor

import android.util.Log

/**
 * Created by yunzhao.liu on 2018/3/8
 */
//所有车都共有的属性
interface Car{

    //接口中的属性只能是抽象的，不允许初始化值,实现接口时，必须重写属性
    var manufacturer:String //制造商

    fun run()//不具体实现，接口成员属性默认是open的

    fun price(msg:String){//具体实现
        Log.d("liuyz", msg)
    }
}