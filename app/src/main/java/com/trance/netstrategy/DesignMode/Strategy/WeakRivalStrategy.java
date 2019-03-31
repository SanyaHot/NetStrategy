package com.trance.netstrategy.DesignMode.Strategy;

import com.trance.netstrategy.DesignMode.o;

public class WeakRivalStrategy implements FightStrategy {
    @Override
    public void fight() {
        o.p("遇到了较弱的对手，张无忌使用太极剑");
    }
}
