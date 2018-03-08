package com.cn.lyz.daggerkotlin.dagger.mvp;

import javax.inject.Inject;

/**
 * Created by yunzhao.liu on 2018/3/7
 */

public class LoginInfo {

    @Inject
    public LoginInfo() {
    }

    private String phone;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
