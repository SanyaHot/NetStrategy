package com.trance.netstrategy.Dagger2;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class GsonModule {
//    @Singleton
    @ApplicationScope
    @Provides
    public Gson provideGson() {
        return new Gson();
    }
}
