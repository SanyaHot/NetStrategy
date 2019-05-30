package com.trance.netstrategy.Dagger2;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    ActivityComponent activityComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        activityComponent = DaggerActivityComponent.builder()
                .swordsManComponent(DaggerSwordsManComponent.builder()
                        .build()).build();
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }
}
