package com.trance.netstrategy.DesignMode.Template;

public class Client {
    public static void main(String[] args) {
        ZhangWuJi zhangWuJi = new ZhangWuJi();
        zhangWuJi.fighting();
        ZhangSanFeng zhangSanFeng = new ZhangSanFeng();
        zhangSanFeng.fighting();
    }
}
