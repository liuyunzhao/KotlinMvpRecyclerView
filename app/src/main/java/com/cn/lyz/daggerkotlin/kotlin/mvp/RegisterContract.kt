package com.cn.lyz.daggerkotlin.kotlin.mvp

import com.cn.lyz.daggerkotlin.dagger.mvp.OnListener

/**
 * Created by yunzhao.liu on 2018/3/7
 */
interface RegisterContract {
    interface View {
        fun loginSuccess(info: String)

        fun loginFailure(msg: String)
    }

    interface Presenter {
        fun submitLoginInfo(info: UserInfo)

    }

    interface Model {
        fun getLoginInfo(info: UserInfo, listener: OnListener)
    }
}