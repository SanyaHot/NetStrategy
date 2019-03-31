package com.trance.netstrategy.DesignMode.Facade;

public class Client {
    public static void main(String[] args) {
        ZhangWuJi zhangWuJi = new ZhangWuJi();
        //张无忌使用乾坤大挪移
        zhangWuJi.QianKun();
        //张无忌使用七伤拳
        zhangWuJi.QiShang();
    }
}
