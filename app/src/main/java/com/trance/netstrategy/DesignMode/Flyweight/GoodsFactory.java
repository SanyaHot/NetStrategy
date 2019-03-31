package com.trance.netstrategy.DesignMode.Flyweight;

import com.trance.netstrategy.DesignMode.o;

import java.util.HashMap;
import java.util.Map;

import retrofit2.http.POST;

public class GoodsFactory {
    private static Map<String, Goods> pool = new HashMap<>();

    public static Goods getGoods(String name) {
        if (pool.containsKey(name)) {
            o.p("使用缓存,key为" + name);
            return pool.get(name);
        } else {
            Goods goods = new Goods(name);
            pool.put(name, goods);
            o.p("创建商品,key为" + name);
            return goods;
        }
    }
}
