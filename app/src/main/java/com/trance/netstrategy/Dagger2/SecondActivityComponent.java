package com.trance.netstrategy.Dagger2;

import com.trance.netstrategy.SecondActivity;

import dagger.Component;

//@Component
@Component(modules = GsonModule.class)
public interface SecondActivityComponent {
    void inject(SecondActivity activity);
}
