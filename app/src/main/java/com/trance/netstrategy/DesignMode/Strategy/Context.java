package com.trance.netstrategy.DesignMode.Strategy;

public class Context {
    private FightStrategy fightStrategy;

    public Context(FightStrategy fightStrategy) {
        this.fightStrategy = fightStrategy;
    }

    public void fighting() {
        fightStrategy.fight();
    }
}
