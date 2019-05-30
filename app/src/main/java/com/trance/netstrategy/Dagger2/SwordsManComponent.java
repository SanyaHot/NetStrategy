package com.trance.netstrategy.Dagger2;

import dagger.Component;

@Component(modules = SwordsManModule.class)
public interface SwordsManComponent {
    SwordsMan getSwordsMan();
}
