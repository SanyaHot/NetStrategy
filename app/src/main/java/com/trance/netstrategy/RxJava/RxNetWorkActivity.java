package com.trance.netstrategy.RxJava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.trance.netstrategy.R;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class RxNetWorkActivity extends AppCompatActivity {

    //针对多个网络请求,可以在请求网络的地方compositeSubscription.add(subscription)
    private CompositeSubscription compositeSubscription;

    //针对单个网络请求
    private Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_net_work);
        String ip = "15.67.201.101";

        RxOkHttp rxOkHttp = new RxOkHttp();
        rxOkHttp.postAsyncHttp(ip);

        RxRetrofit rxRetrofit = new RxRetrofit();
        rxRetrofit.postIpInformation(ip);
    }

    @Override
    protected void onStop() {
        super.onStop();

        //单个网络请求取消
        if (subscription != null && subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }

        //多个网络请求取消
        compositeSubscription.unsubscribe();
    }
}
