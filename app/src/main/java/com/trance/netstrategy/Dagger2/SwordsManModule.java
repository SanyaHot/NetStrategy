package com.trance.netstrategy.Dagger2;

import dagger.Module;
import dagger.Provides;

@Module
public class SwordsManModule {
    @Provides
    public SwordsMan provideSwordsMan() {
        return new SwordsMan();
    }
}
