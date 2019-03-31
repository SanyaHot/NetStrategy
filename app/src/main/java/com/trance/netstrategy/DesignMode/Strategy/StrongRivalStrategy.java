package com.trance.netstrategy.DesignMode.Strategy;

import com.trance.netstrategy.DesignMode.o;

public class StrongRivalStrategy implements FightStrategy {
    @Override
    public void fight() {
        o.p("遇到了强大的对手，张无忌使用乾坤大挪移");
    }
}
