package com.cn.lyz.daggerkotlin.kotlin.mvp

import android.content.Context
import com.cn.lyz.daggerkotlin.dagger.mvp.OnListener

/**
 * Created by yunzhao.liu on 2018/3/7
 */
class RegisterPresenter : RegisterContract.Presenter {

//.lazy{} 只能用在val类型, lateinit 只能用在var类型
//.lateinit不能用在可空的属性上和Java的基本类型上
//.lateinit可以在任何位置初始化并且可以初始化多次,因为其衔接的是var变量。而lazy在第一次被调用时就被初始化，其衔接的是val常量，想要被改变只能重新定义

    private var view: RegisterContract.View
    private var context: Context
    private var mode: RegisterMode

    /**
     * Presenter的构造函数
     */
    constructor(view: RegisterContract.View, context: Context) {
        this.view = view
        this.context = context
        //创建RegisterMode对象
        this.mode = RegisterMode()
    }

    /**
     * 提交注册信息
     */
    override fun submitRegisterInfo(info: UserInfo) {
        mode.getRegisterInfo(
                info, object : OnListener {
            //匿名接口
            override fun onSuccess(response: String?) {
                //!!为空判断，如果是null就返回null
                view.registerSuccess(response!!)
            }

            override fun onFailure(msg: String?) {
                if (msg != null) {
                    view.registerFailure(msg)
                }
            }
        }
        )
    }
}
