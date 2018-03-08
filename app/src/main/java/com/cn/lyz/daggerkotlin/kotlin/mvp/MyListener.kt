package com.cn.lyz.daggerkotlin.kotlin.mvp

/**
 * Created by yunzhao.liu on 2018/3/7
 */
interface MyListener{

    fun onSuccess(response: String)

    fun onFailure(msg: String)
}
