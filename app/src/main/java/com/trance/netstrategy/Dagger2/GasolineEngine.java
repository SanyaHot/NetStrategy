package com.trance.netstrategy.Dagger2;

import javax.inject.Inject;

public class GasolineEngine extends Engine {
    @Override
    public String work() {
        return "汽油发动机启动";
    }
}
