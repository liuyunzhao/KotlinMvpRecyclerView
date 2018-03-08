package com.cn.lyz.daggerkotlin.dagger.mvp;

/**
 * Created by yunzhao.liu on 2018/3/7
 */
 public interface OnListener {
    void onSuccess(String response);

    void onFailure(String msg);
}
