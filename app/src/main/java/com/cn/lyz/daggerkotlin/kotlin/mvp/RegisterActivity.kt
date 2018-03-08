package com.cn.lyz.daggerkotlin.kotlin.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import android.view.View
import com.cn.lyz.daggerkotlin.R
import com.cn.lyz.daggerkotlin.kotlin.constructor.BMW_X5_Car
import com.cn.lyz.daggerkotlin.kotlin.mvp.recyclerView.Product
import com.cn.lyz.daggerkotlin.kotlin.mvp.recyclerView.RegisterAdapter
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener, RegisterContract.View {

    //延迟加载
    private lateinit var presenter: RegisterContract.Presenter

    //Kotlin的空安全设计对于声明可为空的参数，在使用时要进行空判断处理，
    //有两种处理方式，字段后加!!像Java一样抛出空异常，
    //另一种字段后加?可不做处理返回值为 null或配合?:做空判断处理
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initView()
        initData()
    }

    fun initView() {
        btn1.setOnClickListener {
            click1()
        }
        btn2.setOnClickListener(this)

        et1.setTextChangedListener {
            if (!TextUtils.isEmpty(it)) {
                toast(it)
            }
        }

    }

    fun initData() {
        presenter = RegisterPresenter(this, this)
        val list = getList()
        var adapter = RegisterAdapter(this, list)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = (LinearLayoutManager(this))

        //条目点击
        adapter.setOnItemClickLitener(object : RegisterAdapter.OnItemClickLitener{
            override fun onItemClick(position: Int) {
                toast("点击位置是：$position")
            }
        })
    }

    fun getList(): ArrayList<Product> {
        var product: Product
        var list: ArrayList<Product> = ArrayList()
        for (i in 1..15) {
            product = Product()
            product.name = "xiaoming:$i"
            product.price = "$i".toFloat()
            product.type = "$i".toInt()
            list.add(product)
        }
        return list
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn2 -> click2()
            else -> {
//                失败处理
            }
        }
    }

    fun click1() {
        var userInfo = UserInfo()
        userInfo.name = "xiaoming"
        userInfo.sex = "woman"
        userInfo.num = 25
        userInfo.height = 178
        presenter.submitLoginInfo(userInfo)
    }

    fun click2() {
        toast("click2")
        var bmwx5 = BMW_X5_Car("宝马X5", 200, "red")
        bmwx5.run()
    }

    override fun loginSuccess(info: String) {
        toast(info)
    }

    override fun loginFailure(msg: String) {
        toast(msg)
    }

}
