package com.trance.netstrategy.DesignMode.Template;

import com.trance.netstrategy.DesignMode.o;

public class ZhangSanFeng extends AbstractSwordman {
    @Override
    protected void neigong() {
        o.p("运行纯阳无极功");
    }

    @Override
    protected void weapons() {
        o.p("使用真武剑");
    }

    @Override
    protected void moves() {
        o.p("使用招式神门十三剑");
    }

    @Override
    protected void hook() {
        o.p("突然肚子不舒服，老夫先去趟厕所");
    }
}
