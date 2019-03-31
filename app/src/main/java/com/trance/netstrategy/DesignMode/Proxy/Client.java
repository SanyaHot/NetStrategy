package com.trance.netstrategy.DesignMode.Proxy;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
//        staticProxy();
        dynamicProxy();
    }

    public static void staticProxy() {
        IShop shop = new WSF();
        Purchasing purchasing = new Purchasing(shop);
        purchasing.buy();
    }

    public static void dynamicProxy() {
        //创建WSF
        IShop wsf = new WSF();
        //创建动态代理
        DynamicPurchasing dynamicPurchasing = new DynamicPurchasing(wsf);
        //创建WSF的ClassLoader
        ClassLoader loader = wsf.getClass().getClassLoader();
        IShop purchasing = (IShop) Proxy.newProxyInstance(loader, new Class[]{IShop.class}, dynamicPurchasing);
        purchasing.buy();
    }
}
