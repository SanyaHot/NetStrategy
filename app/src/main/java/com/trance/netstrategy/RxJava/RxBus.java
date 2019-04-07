package com.trance.netstrategy.RxJava;

import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

public class RxBus {
    private static volatile RxBus rxBus;
    private final Subject<Object, Object> subject = new SerializedSubject<>(
            PublishSubject.create());
    private RxBus(){}

    public static RxBus getInstance() {
        if (rxBus == null) {
            synchronized (RxBus.class) {
                if (rxBus == null) {
                    rxBus = new RxBus();
                }
            }
        }
        return rxBus;
    }

    public void post(Object object) {
        subject.onNext(object);
    }

    public <T> Observable<T> tObservable(Class<T> eventType) {
        return subject.ofType(eventType);
    }
}
