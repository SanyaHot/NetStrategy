package com.trance.netstrategy.Dagger2;

import com.trance.netstrategy.MainActivity;
import com.trance.netstrategy.SecondActivity;

import dagger.Component;

/**
 * 公用一个Component可以实现全局单例
 */

@ApplicationScope
@Component(modules = {GsonModule.class, EngineModule.class},dependencies = SwordsManComponent.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);

    void inject(SecondActivity secondActivity);
}
