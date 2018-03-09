package com.cn.lyz.daggerkotlin.kotlin.mvp

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.Toast

/**
 * Created by yunzhao.liu on 2018/3/7
 */

/**
 * 对Context的扩展函数
 */
fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
}

/**
 * 对Log的扩展函数
 */
fun Log.log(message: String) {
    Log.d("liuyz", message)
}

/**
 * 对Log的扩展函数
 */
fun Log.log(tag: String = "liuyz", message: String) {
    Log.d(tag, message)
}

/**
 * 对EditText监听的扩展
 */
fun EditText.setTextChangedListener(body: (key: String) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            body(s.toString())
        }
    })
}