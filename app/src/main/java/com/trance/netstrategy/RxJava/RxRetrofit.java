package com.trance.netstrategy.RxJava;

import android.util.Log;

import com.trance.netstrategy.NetWork.IpService;
import com.trance.netstrategy.bean.IpModel;

import java.util.Observable;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RxRetrofit {
    private static final String TAG = "RxRetrofit";

    public void postIpInformation(String ip) {

        String baseUrl = "http://10.0.2.2:8080/";
        Subscription subscription;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        IpService ipService = retrofit.create(IpService.class);

        subscription = ipService.getIpMsg(ip)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<IpModel>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(IpModel ipModel) {
                        Log.d(TAG, "onNext: " + ipModel.getCity());
                    }
                });
    }
}
