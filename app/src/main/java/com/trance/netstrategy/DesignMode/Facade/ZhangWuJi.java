package com.trance.netstrategy.DesignMode.Facade;

public class ZhangWuJi {
    private JingMai jingMai;
    private NeiGong neiGong;
    private ZhaoShi zhaoShi;

    public ZhangWuJi() {
        this.jingMai = new JingMai();
        this.neiGong = new NeiGong();
        this.zhaoShi = new ZhaoShi();
    }

    /**
     * 使用乾坤大挪移
     */
    public void QianKun() {
        jingMai.jingmai();      //开启经脉
        neiGong.QianKun();
    }

    /**
     * 使用七伤拳
     */
    public void QiShang() {
        jingMai.jingmai();      //开启经脉
        neiGong.JiuYang();      //使用内功九阳神功
        zhaoShi.QiShangQuan();  //使用招式七伤拳
    }
}
