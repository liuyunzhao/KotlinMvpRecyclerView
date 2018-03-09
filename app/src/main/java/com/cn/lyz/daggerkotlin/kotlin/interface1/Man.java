package com.cn.lyz.daggerkotlin.kotlin.interface1;

/**
 * Created by yunzhao.liu on 2018/3/8
 */

public class Man {


    private People1 people1;

    interface People1{
        void setPeople();
    }

    public void setSex1(People1 people) {
        this.people1 = people;
    }


    private People2 people2;

    interface People2{
        void setPeople(String sex);
    }

    public void setSex2(People2 people) {
        this.people2 = people;
    }

    private People3 people3;

    interface People3{
        void setPeople(String sex, String name);
    }

    public void setSex3(People3 people) {
        this.people3= people;
    }

    public void startRun1() {
        people1.setPeople();
    }
    public void startRun2(String sex) {
        people2.setPeople(sex);
    }

    public void startRun3(String sex, String name) {
        people3.setPeople(sex, name);
    }


}
