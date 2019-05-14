package com.trance.netstrategy.Dagger2;

import android.util.Log;

import javax.inject.Inject;

public class Watch {
    private static final String TAG = "Watch";

    @Inject
    public Watch() {
    }

    public void work() {
        Log.i(TAG, "手表工作");
    }
}
