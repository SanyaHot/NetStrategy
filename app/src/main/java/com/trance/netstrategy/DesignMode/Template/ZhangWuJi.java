package com.trance.netstrategy.DesignMode.Template;

import com.trance.netstrategy.DesignMode.o;

public class ZhangWuJi extends AbstractSwordman {
    @Override
    protected void neigong() {
        o.p("运行九阳神功");
    }

    @Override
    protected void weapons() {

    }

    @Override
    protected void moves() {
        o.p("使用招式乾坤大挪移");
    }

    @Override
    protected boolean hasWeapons() {
        return false;
    }
}
