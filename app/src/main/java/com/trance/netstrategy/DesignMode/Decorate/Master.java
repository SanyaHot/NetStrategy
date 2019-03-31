package com.trance.netstrategy.DesignMode.Decorate;

public abstract class Master extends Swordman {

    private Swordman swordman;

    public Master(Swordman swordman) {
        this.swordman = swordman;
    }

    @Override
    public void attachMagic() {
        swordman.attachMagic();
    }
}
