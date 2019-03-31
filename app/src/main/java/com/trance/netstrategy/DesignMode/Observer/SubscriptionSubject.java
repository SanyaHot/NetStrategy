package com.trance.netstrategy.DesignMode.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体被观察者
 */
public class SubscriptionSubject implements Subject {

    private List<Observer> weChatUserList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        weChatUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weChatUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : weChatUserList) {
            observer.update(message);
        }
    }
}
