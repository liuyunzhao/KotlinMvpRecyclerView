package com.cn.lyz.daggerkotlin.dagger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cn.lyz.daggerkotlin.R;
import com.cn.lyz.daggerkotlin.dagger.mvp.ContextModule;
import com.cn.lyz.daggerkotlin.dagger.mvp.DaggerLoginActivityComponent;
import com.cn.lyz.daggerkotlin.dagger.mvp.LoginContract;
import com.cn.lyz.daggerkotlin.dagger.mvp.LoginInfo;
import com.cn.lyz.daggerkotlin.dagger.mvp.LoginModule;
import com.cn.lyz.daggerkotlin.dagger.mvp.LoginPresenter;
import com.cn.lyz.daggerkotlin.dagger.mvp.People;

import javax.inject.Inject;

/**
 * Created by yunzhao.liu on 2018/3/7
 */

public class Dagger2Activity extends AppCompatActivity implements LoginContract.View {

    @Inject
    LoginPresenter mLoginPresenter;

    @Inject
    LoginInfo mLoginInfo;

    //用Singleton修饰的类,在作用域内是单例
    @Inject
    People p1;

    @Inject
    People p2;

    private Button mBtn1, mBtn2, mBtn3, mBtn4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2);
        initView();
        initClick();
        initDagger();
    }

    private void initView() {
        mBtn1 = findViewById(R.id.btn1);
        mBtn2 = findViewById(R.id.btn2);
        mBtn3 = findViewById(R.id.btn3);
        mBtn4 = findViewById(R.id.btn4);
    }

    private void initClick() {

        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click1();
            }
        });

        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        mBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click4();
            }
        });
    }

    private void click4() {
        Log.d("liuyz", p1.hashCode() + "--" + p2.hashCode() + "--"+p1.equals(p2));
    }

    private void initDagger() {
        DaggerLoginActivityComponent.builder()
                .loginModule(new LoginModule(this))
                .contextModule(new ContextModule(this))
                .build()
                .inject(this);
    }

    private void click1() {
        mLoginInfo.setPhone("123456789");
        mLoginInfo.setCode("6543");
        mLoginPresenter.submitLoginInfo(mLoginInfo);
    }

    @Override
    public void loginSuccess(String info) {
        Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailure(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
