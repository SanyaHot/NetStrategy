package com.trance.netstrategy.DesignMode.Decorate;

public class Client {
    public static void main(String[] args) {
        YangGuo yangGuo = new YangGuo();
        HongQiGong hongQiGong = new HongQiGong(yangGuo);
        hongQiGong.attachMagic();
        OuYangFeng ouYangFeng = new OuYangFeng(yangGuo);
        ouYangFeng.attachMagic();
    }
}
