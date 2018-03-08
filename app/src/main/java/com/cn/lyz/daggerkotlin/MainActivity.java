package com.cn.lyz.daggerkotlin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cn.lyz.daggerkotlin.dagger.Dagger2Activity;
import com.cn.lyz.daggerkotlin.dagger.mvp.People;
import com.cn.lyz.daggerkotlin.kotlin.mvp.RegisterActivity;

import javax.inject.Inject;

/**
 * Created by yunzhao.liu on 2018/3/7
 */

public class MainActivity extends AppCompatActivity {

    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;

    @Inject
    People p1;

    @Inject
    People p2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                click2();
            }
        });
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click3();
            }
        });
        mBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click4();
            }
        });
    }

    private void initDagger() {
        DaggerMainComponent.create().inject(this);
    }

    private void click1() {
        startActivity(new Intent(this, Dagger2Activity.class));
    }

    private void click2() {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    private void click3() {

    }

    private void click4() {
        Log.d("liuyz", p1.hashCode() + "--" + p2.hashCode() + "--"+p1.equals(p2));
    }

}
