package com.trance.netstrategy.DesignMode.Strategy;

import com.trance.netstrategy.DesignMode.o;

public class CommonRivalStrategy implements FightStrategy {
    @Override
    public void fight() {
        o.p("遇到了实力普通的对手，张无忌使用圣火令神功");
    }
}
