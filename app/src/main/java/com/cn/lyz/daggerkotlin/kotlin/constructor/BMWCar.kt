package com.cn.lyz.daggerkotlin.kotlin.constructor

/**
 * Created by yunzhao.liu on 2018/3/8
 */
//抽象类，代表宝马车
abstract class BMWCar {
    //子类继承方法需要用open修饰
    open fun setName(name: String) {}

    abstract fun setSpeed(speed: Int)

    abstract fun setColor(color: String)
}