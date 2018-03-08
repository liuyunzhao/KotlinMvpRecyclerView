package com.cn.lyz.daggerkotlin.kotlin.mvp

import android.os.Handler
import com.cn.lyz.daggerkotlin.dagger.mvp.OnListener

/**
 * Created by yunzhao.liu on 2018/3/7
 */
class RegisterMode : RegisterContract.Model {

    override fun getLoginInfo(info: UserInfo, listener: OnListener) {
        listener.onSuccess("姓名：${info.name} "
                + "- 年龄：${info.age}"
                + "- 身高：${info.height}"
                + "- 性别：${info.sex}"
                + "- 班号：${info.num}")
        Handler().postDelayed(Runnable {
            listener.onFailure("failure")
        }, 3000)
    }
}