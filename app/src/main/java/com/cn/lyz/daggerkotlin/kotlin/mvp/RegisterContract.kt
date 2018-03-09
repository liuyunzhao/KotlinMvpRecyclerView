package com.cn.lyz.daggerkotlin.kotlin.mvp

import com.cn.lyz.daggerkotlin.dagger.mvp.OnListener

/**
 * Created by yunzhao.liu on 2018/3/7
 */
interface RegisterContract {

    /**
     * 负责更新Activity的UI
     */
    interface View {
        fun registerSuccess(info: String)

        fun registerFailure(msg: String)
    }

    /**
     * 连接View和Model的桥梁
     */
    interface Presenter {
        fun submitRegisterInfo(info: UserInfo)
    }

    /**
     * 负责提供数据
     */
    interface Model {
        fun getRegisterInfo(info: UserInfo, listener: OnListener)
    }
}