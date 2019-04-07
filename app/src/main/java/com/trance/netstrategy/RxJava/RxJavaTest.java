package com.trance.netstrategy.RxJava;

import android.util.Log;

import com.trance.netstrategy.DesignMode.o;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

public class RxJavaTest {
    private static final String TAG = "RxJavaTest";

    public static void main(String[] args) {
        RxJavaTest rx = new RxJavaTest();
//        rx.rx();
        rx.rx1();

    }

    //传统方式创建观察者
    public void rx() {
        //创建观察者
        Subscriber subscriber = new Subscriber<String>() {
            @Override
            public void onStart() {
                o.p(TAG, "onStart: ");
            }

            @Override
            public void onCompleted() {
                o.p(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                o.p(TAG, "onError: ");
            }

            @Override
            public void onNext(String s) {
                o.p(TAG, "onNext: " + s);
            }
        };

        //创建被观察者,三种方式都可以
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("杨影枫");
                subscriber.onNext("月眉儿");
                subscriber.onCompleted();
            }
        });

        Observable observable1 = Observable.just("杨影枫", "月眉儿");

        String[] words = {"杨影枫", "月眉儿"};
        Observable observable2 = Observable.from(words);

        observable.subscribe(subscriber);
    }

    //Action方式创建观察者(应用RxJava的不完整回调)
    public void rx1() {
        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                o.p(TAG, "onNext: " + s);
            }
        };

        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                o.p(TAG, "onError: ");
            }
        };

        Action0 onCompleteAction = new Action0() {
            @Override
            public void call() {
                o.p(TAG, "onComplete: ");
            }
        };

        Observable observable = Observable.just("杨影枫", "月眉儿");

        observable.subscribe(onNextAction, onErrorAction, onCompleteAction);

        //可以只传一个或两个Action，我们称之为不完整回调
//        observable.subscribe(onNextAction);
//        observable.subscribe(onNextAction, onErrorAction);
    }
}
