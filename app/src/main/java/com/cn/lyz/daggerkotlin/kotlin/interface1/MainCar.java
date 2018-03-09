package com.cn.lyz.daggerkotlin.kotlin.interface1;

/**
 * Created by yunzhao.liu on 2018/3/8
 */

public class MainCar {
    public static void main(String[] args) {
//        defalutClass();
        test();
    }

    private static void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread--run");
            }
        }).start();

        new Thread(() -> System.out.println("---runnable")).start();
    }

    public static void defalutClass() {
        Man man = new Man();
/*
基本语法:
(parameters) -> expression 或 (parameters) ->{ statements; }
即: 参数 -> 带返回值的表达式/无返回值的陈述

函数式接口：Functional Interface.
定义的一个接口，接口里面必须 有且只有一个抽象方法 ，这样的接口就成为函数式接口。
在可以使用lambda表达式的地方，方法声明时必须包含一个函数式的接口。
（JAVA8的接口可以有多个default方法）
* */
//D:\AndroidStudio3.0\studio3.0\jre
        man.setSex1(() -> {
            System.out.println("sex1");
        });

        //一行代码简写
        man.setSex2(sex -> System.out.println("sex: "+sex));

        //String 写不写都可以
        man.setSex3((String sex, String name) -> {
            System.out.println("sex: "+sex+"  name: "+name);
        });

        man.startRun1();
        man.startRun2("man");
        man.startRun3("woman", "ming");

    }
}
