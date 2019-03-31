package com.trance.netstrategy.DesignMode.Strategy;

public class Client {
    public static void main(String[] args) {
        Context context;

        //张无忌遇到对手宋青书，使用对较弱对手的策略
        context = new Context(new WeakRivalStrategy());
        context.fighting();

        //张无忌遇到对手灭绝师太，使用对普通对手的策略
        context = new Context(new CommonRivalStrategy());
        context.fighting();

        //张无忌遇到对手成昆，使用对强大对手的策略
        context = new Context(new StrongRivalStrategy());
        context.fighting();
    }
}
