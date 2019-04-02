package com.trance.netstrategy.Reflect;

import com.trance.netstrategy.DesignMode.o;

public class Person {
    private String name;
    private int age;
    private String msg = "hello wrold";

    public Person() {
    }

    private Person(String name) {
        this.name = name;
        o.p(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void fun() {
        o.p("fun");
    }

    public void fun(String name, int age) {
        o.p("我叫" + name + ",今年" + age + "岁");
    }
}
