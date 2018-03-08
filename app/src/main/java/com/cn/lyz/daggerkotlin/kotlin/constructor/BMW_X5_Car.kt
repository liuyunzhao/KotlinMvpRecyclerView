package com.cn.lyz.daggerkotlin.kotlin.constructor

import android.util.Log

/**
 * Created by yunzhao.liu on 2018/3/8
 */
//具体车——宝马x5
//如果子类没有主构造函数，则必须在每一个二级构造函数中用 super 关键字初始化基类(当基类有构造时)
//或者代理另一个构造函数。初始化基类时，可以调用基类的不同构造方法。
class BMW_X5_Car(name: String) : BMWCar(), Car {//主构造器

    private lateinit var name: String
    private var speed: Int? = 0
    private lateinit var color: String

    //数组
    var int_array: IntArray = intArrayOf(1, 2, 3)
    var long_array: LongArray = longArrayOf(4, 5, 6)

    //String数组
    var string_array: Array<String> = arrayOf("1", "2", "3")
    var float_array: Array<Float> = arrayOf(1f, 2f, 3f)

    //直接定义类型
    var int_1_array: ArrayList<Int> = ArrayList()

    //返回一个列表
    var list: List<String> = "hello-world".split("-")

    constructor(name: String, speed: Int) : this(name)//次构造器

    constructor(name: String, speed: Int, color: String) : this(name, speed) {//次构造器
        this.name = name
        this.speed = speed
        this.color = color
    }

    constructor(name: String, color: String) : this(name)//次构造器

    override var manufacturer: String = "我也不知道"

    override fun run() {
        price("都特别贵...")
        Log.d("liuyz", "车名：$name -车速：$speed -车颜色：$color -厂商：$manufacturer")
    }

    override fun setName(name: String) {
        Log.d("liuyz", "车名：$name")
    }

    override fun setSpeed(speed: Int) {
        Log.d("liuyz", "车速：$speed")
    }

    override fun setColor(color: String) {
        Log.d("liuyz", "车颜色：$color")
    }

}