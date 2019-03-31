package com.trance.netstrategy.DesignMode.Flyweight;

import com.trance.netstrategy.DesignMode.o;

public class Goods implements IShop {

    private String name;
    private String version;

    public Goods(String name) {
        this.name = name;
    }

    @Override
    public void showGoodsPrice(String version) {
        if (version.equals("32G")) {
            o.p("价格为5199元");
        } else if (version.equals("128G")) {
            o.p("价格为5999元");
        }
    }
}
