package com.trance.netstrategy.DesignMode.Observer;

public class Client {
    public static void main(String[] args) {
        //创建被观察者
        SubscriptionSubject subscriptionSubject = new SubscriptionSubject();

        //添加观察者
        WeChatUser user1 = new WeChatUser("Trance");
        WeChatUser user2 = new WeChatUser("Kotlin");
        WeChatUser user3 = new WeChatUser("Python");

        //订阅
        subscriptionSubject.attach(user1);
        subscriptionSubject.attach(user2);
        subscriptionSubject.attach(user3);

        //发布
        subscriptionSubject.notify("WSF update");
    }
}
