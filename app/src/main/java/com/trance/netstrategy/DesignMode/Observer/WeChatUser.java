package com.trance.netstrategy.DesignMode.Observer;

import com.trance.netstrategy.DesignMode.o;

/**
 * 具体观察者
 */
public class WeChatUser implements Observer {

    private String name;

    public WeChatUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        o.p(name + "-" + message);
    }
}
