package com.trance.netstrategy.DesignMode.Flyweight;

public class Client {
    public static void main(String[] args) {
        Goods goods1 = GoodsFactory.getGoods("iPhone7");
        goods1.showGoodsPrice("32G");
        Goods goods2 = GoodsFactory.getGoods("iPhone7");
        goods2.showGoodsPrice("32G");
        Goods goods3 = GoodsFactory.getGoods("iPhone7");
        goods1.showGoodsPrice("128G");
    }
}
