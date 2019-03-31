package com.trance.netstrategy.DesignMode.Proxy;

public class Purchasing implements IShop {

    IShop iShop;

    public Purchasing(IShop iShop) {
        this.iShop = iShop;
    }

    @Override
    public void buy() {
        iShop.buy();
    }
}
