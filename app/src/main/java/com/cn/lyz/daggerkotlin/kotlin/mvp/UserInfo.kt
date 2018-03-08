package com.cn.lyz.daggerkotlin.kotlin.mvp

import kotlin.properties.Delegates

/**
 * Created by yunzhao.liu on 2018/3/7
 */
class UserInfo {
    //延迟初始化 只能修饰var
    lateinit var name: String

    //Kotlin 中类不能有字段。提供了 Backing Fields(后端变量) 机制
//备用字段使用field关键字声明,field 关键词只能用于属性的访问器
    var sex: String = "man"
        get() = field.toUpperCase()//转换成大写

    //班号
    var num: Int = 0
        set(value) {
            if (value > 10) {
                field = 40
            } else {
                field = 3
            }
        }

    //notNull 适用于无法在初始化阶段就确定属性值的场合，但使用之前必须先赋值，否则会报错
    var height: Int by Delegates.notNull<Int>()


    //延迟初始化 只能修饰val
    val age: Int by lazy {
        112
    }

}