package com.cn.lyz.daggerkotlin.kotlin.mvp.recyclerView

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.LayoutInflater.from
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import com.cn.lyz.daggerkotlin.R
import kotlinx.android.synthetic.main.recycler_item_one.view.*
import java.util.*

/**
 * Created by yunzhao.liu on 2018/3/7
 */
class RegisterAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private var context: Context
    private var list: ArrayList<Product>
    private var inflater: LayoutInflater

    constructor(context: Context, list: ArrayList<Product>) {
        this.context = context
        this.list = list
        this.inflater = from(context)
    }

    /**
     * 条目数
     */
    override fun getItemCount(): Int {
        //为空就返回0
        return list?.size
    }

    /**
     * 获取布局类型
     */
    override fun getItemViewType(position: Int): Int {
        val product: Product = list.get(position)
        when (product.type) {
            2 -> return 2
            4, 5, 8 -> return 2
            else -> {
                return 1
            }
        }
    }

    /**
     * 创建多布局ViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> {
                OneViewHolder(inflater.inflate(R.layout.recycler_item_one, parent, false))
            }
            2 -> {
                TwoViewHolder(inflater.inflate(R.layout.recycler_item_two, parent, false))
            }
            else -> {
                OneViewHolder(inflater.inflate(R.layout.recycler_item_one, parent, false))
            }
        }
    }

    /**
     * 绑定ViewHolder
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val product = list[position]
        //获取条目类型
        when(getItemViewType(position)){
            2,4,5,8->{
                //强势转换 as ,安全转换 as?, 类型判断：is
                var twoViewHolder:TwoViewHolder = holder as TwoViewHolder
                twoViewHolder.name.text = product.name
                twoViewHolder.price.text = "${product.price}"
                twoViewHolder.item_root.setOnClickListener {
                    itemClick!!.onItemClick(position)
                }
            }
            else ->{
                var oneViewHolder:OneViewHolder = holder as OneViewHolder
                oneViewHolder.name.text = product.name
                oneViewHolder.price.text = product.price.toString()
                oneViewHolder.item_root.setOnClickListener {
                    itemClick!!.onItemClick(position)
                }
            }
        }
    }

    /**
     * 获取控件ID --> 一种方式
     */
    class OneViewHolder(view:View):RecyclerView.ViewHolder(view){
        var item_root:LinearLayout = view.item_root
        var name:Button = view.name
        var price:Button = view.price
    }

    /**
     * 获取控件ID --> 一种方式
     */
    class TwoViewHolder : RecyclerView.ViewHolder{
        var item_root:LinearLayout
        var name:Button
        var price:Button

        constructor(view: View) : super(view){
            name = view.name
            price = view.price
            item_root= view.item_root
        }
    }

    /**
     * 条目点击 --> 接口回调
     */
    private var itemClick: OnItemClickListener?=null

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickLitener(itemClick: OnItemClickListener) {
        this.itemClick = itemClick
    }

}