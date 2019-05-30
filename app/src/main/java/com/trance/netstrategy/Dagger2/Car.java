package com.trance.netstrategy.Dagger2;

import javax.inject.Inject;
import javax.inject.Named;

public class Car {
    private Engine engine;

    /**
     * 通过@Named来指定采用provideDiesel方法来生成实例
     * @param engine
     */

//    @Inject
//    public Car(@Named("Diesel") Engine engine) {
//        this.engine = engine;
//    }

    @Inject
    public Car(@Diesel Engine engine) {
        this.engine = engine;
    }

    public String run() {
        return engine.work();
    }
}
