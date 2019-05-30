package com.trance.netstrategy.Dagger2;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class EngineModule {

    /**
     * 1.@Qualifier 是限定符，
     * 2.@Named 则是@Qualifier 的一种实现。
     * 当有两个相同的依赖时，它们都继承同一个父类或者均实现同一个接口。
     * 当它们被提供给高层时，Component 就不知道我们到底要提供哪一个依赖对象了，因为它找到了多个
     * @return
     */
    @Provides
//    @Named("Gasoline")
    @Gasoline
    public Engine provideGasoline() {
        return new GasolineEngine();
    }

    @Provides
//    @Named("Diesel")
    @Diesel
    public Engine provideDiesel() {
        return new DieselEngine();
    }
}
