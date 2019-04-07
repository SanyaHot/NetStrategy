package com.trance.netstrategy.RxJava;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.observables.GroupedObservable;
import rx.schedulers.Schedulers;

public class RxOperator {
    private static final String TAG = "RxJava";

    //定时操作
    public static void interval() {
        Observable.interval(3, TimeUnit.SECONDS)
                .subscribe(aLong -> Log.d(TAG, "call: " + aLong));
    }

    //范围操作
    public static void range() {
        Observable.range(0, 5)
                .subscribe(integer -> Log.d(TAG, "range: " + integer));
    }

    //重复操作
    public static void repeat() {
        Observable.range(0, 3)
                .repeat(2)
                .subscribe(integer -> Log.d(TAG, "repeat: " + integer));
    }

    //map操作符通过指定一个Func对象，将Observable转化为一个新的Observable对象并发射
    //观察者将收到新的Observable处理
    public static void map() {
        final String Host = "http://blog.csdn.net/";
        Observable.just("itachi85").map(s -> Host + s)
                .subscribe(s -> Log.d(TAG, "map: " + s));
    }

    //1.flatMap操作符将Observable发射的数据集合变换为Observable集合，
    // 然后将这些Observable集合发射的数据平坦化的放进一个单独的Observable
    //2.cast操作符的作用是强制将Observable发射的所有数据转换为指定类型
    //3.flatMap的合并允许交叉，也就是说可能会交错的发送事件，
    //  最终结果的顺序可能并不是原始Observable发送时的顺序
    //4.concatMap操作符与flatMap操作符一致，解决了flatMap的交叉问题
    public static void flatMap() {
        final String Host = "http://blog.csdn.net/";
        List<String> list = new ArrayList<>();

        list.add("itachi85");
        list.add("itachi86");
        list.add("itachi87");
        list.add("itachi88");
        list.add("itachi89");

        Observable.from(list).flatMap(s -> Observable.just(Host + s))
                .cast(String.class)
                .subscribe(s -> Log.d(TAG, "flatMap: " + s));

    }

    //flatMapIterable操作符可以将数据包装成Iterable，在Iterable我们就可以
    //对数据进行处理了
    public static void flatMapIterable() {
        Observable.just(1, 2, 3)
                .flatMapIterable(integer -> {
                    List<Integer> list = new ArrayList<>();
                    list.add(integer + 1);
                    return list;
                })
                .subscribe(integer -> Log.d(TAG, "flatMapIterable: " + integer));
    }

    //buffer操作符将源Observable变换为一个新的Observable，这个新的Observable每次发射一个
    // 组列表值，而不是一个一个的发射
    //window与之相似，只不过window发射的是Observable而不是数据列表
    public static void buffer() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .buffer(3)
                .subscribe(integers -> {
                    for (Integer i : integers) {
                        Log.d(TAG, "buffer: " + i);
                    }
                    Log.d(TAG, "------------------");
                });
    }

    //groupBy操作符用于分组元素，将源Observable变换成一个发射Observable的新Observable(分组后的)
    //它们中的每一个新Observable都发射一组指定的数据
    public static void groupBy() {
        SwordMan s1 = new SwordMan("韦一笑", "A");
        SwordMan s2 = new SwordMan("张三丰", "SS");
        SwordMan s3 = new SwordMan("周芷若", "S");
        SwordMan s4 = new SwordMan("宋远桥", "S");
        SwordMan s5 = new SwordMan("殷梨亭", "A");
        SwordMan s6 = new SwordMan("张无忌", "SS");
        SwordMan s7 = new SwordMan("鹤笔翁", "S");
        SwordMan s8 = new SwordMan("宋青书", "A");

        Observable<GroupedObservable<String, SwordMan>> groupedObservable
                = Observable.just(s1, s2, s3, s4, s5, s6, s7, s8)
                .groupBy(swordMan -> swordMan.getLevel());
        Observable.concat(groupedObservable)
                .subscribe(swordMan -> Log.d(TAG, "groupBy: " +
                        swordMan.getName() + "---" +
                        swordMan.getLevel()));
    }

    public static void filter() {
        Observable.just(1, 2, 3, 4)
                .filter(integer -> integer > 2)
                .subscribe(integer -> Log.d(TAG, "filter: " + integer));
    }

    public static void elementAt() {
        Observable.just(1, 2, 3, 4)
                .elementAt(2)
                .subscribe(integer -> Log.d(TAG, "elementAt: " + integer));
    }

    //去除重复的元素
    public static void distinct() {
        Observable.just(1, 2, 2, 3, 4)
                .distinct()
                .subscribe(integer -> Log.d(TAG, "distinct: " + integer));
    }

    //skip过滤前n项，skipLast过滤后n项
    public static void skip() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .skip(2)
                .subscribe(integer -> Log.d(TAG, "skip: " + integer));
    }

    //take取前n项，takeLast取后n项
    public static void take() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .take(3)
                .subscribe(integer -> Log.d(TAG, "take: " + integer));
    }

    //ignoreElements操作符会忽略源Observable产生的结果，
    // 只把Observable的onComplete和onError事件通知给订阅者
    public static void ignoreElements() {
        Observable.just(1, 2, 3, 4)
                .ignoreElements()
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "onNext: ");
                    }
                });
    }

    //1.throttleFirst操作符则会定期发射这个时间段里源Observable发射的第一个数据，
    // throttleFirst操作符默认在computation 调度器上执行
    //2.和 throttleFirst 操作符类似的有sample操作符，
    // 它会定时地发射源Observable最近发射的数据，
    // 其他的都会被过滤掉
    public static void throttleFirst() {
        Observable.create(subscriber -> {
            for (int i = 0; i < 10; i++) {
                subscriber.onNext(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            subscriber.onCompleted();
        })
                .throttleFirst(200, TimeUnit.MILLISECONDS)
                .subscribe(integer -> Log.d(TAG, "throttleFirst: " + integer));
    }

    //1.通过时间来限流。源Observable每次发射出来一个数据后就会进行计时。
    // 如果在设定好的时间结束前源Observable有新的数据发射出来，这个数据就会被丢弃，
    // 同时throttleWithTimeOut重新开始计时。如果每次都是在计时结束前发射数据，
    // 那么这个限流就会走向极端：只会发射最后一个数据。其默认在 computation 调度器上执行。
    //2.和 throttleWithTimeOut 操作符类似的有deounce 操作符，它不仅可以使用时间来进行过滤，
    // 还可以根据一个函数来进行限流。
    public static void throttleWithTimeOut() {
        Observable.create(subscriber -> {
            for (int i = 0; i < 10; i++) {
                subscriber.onNext(i);
                int sleep = 100;
                if (i % 3 == 0) {
                    sleep = 300;
                }
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            subscriber.onCompleted();
        })
                .throttleWithTimeout(200, TimeUnit.MILLISECONDS)
                .subscribe(integer -> Log.d(TAG, "throttleWithTimeOut: " + integer));
    }

    //startWith操作符会在源Observable发射的数据前面插上一些数据
    public static void startWith() {
        Observable.just(3, 4, 5)
                .startWith(1, 2)
                .subscribe(integer -> Log.d(TAG, "startWith: " + integer));
    }

    //merge操作符将多个Observable合并到一个Observable中进行发射，merge可能会让合并的Observable发射的数据交错
    public static void merge() {
        Observable<Integer> observable1 = Observable.just(1, 2, 3).subscribeOn(Schedulers.io());
        Observable<Integer> observable2 = Observable.just(4, 5, 6);
//        Observable.just(4, 5, 6)
//                .mergeWith(observable1)
//                .subscribe(integer -> Log.d(TAG, "merge: " + integer));
        Observable.merge(observable1, observable2)
                .subscribe(integer -> Log.d(TAG, "merge: " + integer));
    }

    //将多个 Observable 发射的数据进行合并发射。
    //concat 严格按照顺序发射数据，前一个Observable没发射完成是不会发射后一个Observable的数据的
    public static void concat() {
        Observable<Integer> observable1 = Observable.just(1, 2, 3).subscribeOn(Schedulers.io());
        Observable<Integer> observable2 = Observable.just(4, 5, 6);
        Observable.concat(observable1, observable2)
                .subscribe(integer -> Log.d(TAG, "concat: " + integer));
    }

    //zip操作符合并两个或者多个Observable发射出的数据项，根据指定的函数变换它们，并发射一个新值
    public static void zip() {
        Observable<Integer> observable1 = Observable.just(1, 2, 3);
        Observable<String> observable2 = Observable.just("a", "b", "c");
        Observable.zip(observable1, observable2, ((integer, s) -> integer + s))
                .subscribe(s -> Log.d(TAG, "zip: " + s));
    }

    //当两个Observable中的任何一个发射了数据时，使用一个函数结合每个Observable发射的最近数据项，并且基于这个函数的结果发射数据。
    // combineLatest 操作符和zip有些类似。只不过zip操作符作用于最近未打包的两个Observable，只有当原始的Observable中的每一个
    // 都发射了一条数据时 zip 才发射数据；而 combineLatest 操作符作用于最近发射的数据项，在原始Observable中的任意一个发射了数
    // 据时发射一条数据
    public static void combineLatest() {
        Observable<Integer> observable1 = Observable.just(1, 2, 3);
        Observable<String> observable2 = Observable.just("a", "b", "c");
        Observable.combineLatest(observable1, observable2, ((integer, s) -> integer + s))
                .subscribe(s -> Log.d(TAG, "combineLatest: " + s));
    }

    //delay操作符让原始Observable在发射每项数据之前都暂停一段指定的时间段
    public static void delay() {
        Observable.create(subscriber -> {
            Long currentTime = System.currentTimeMillis() / 1000;
            subscriber.onNext(currentTime);
        })
                .delay(2, TimeUnit.SECONDS)
                .subscribe(along -> Log.d(TAG, "delay: " +
                        (System.currentTimeMillis() / 1000 - Long.valueOf(along.toString()))));
    }

    //Do系列操作符就是为原始Observable的生命周期事件注册一个回调，当Observable的某个事件发生时就会调用这些回调
    public static void Do() {
        Observable.just(1, 2)
                .doOnNext(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Log.d(TAG, "call: " + integer);
                    }
                })
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "onNext: " + integer);
                    }
                });

    }

    //1.subscribeOn操作符用于指定Observable自身在哪个线程上运行。
    // 如果Observable需要执行耗时操作，一般可以让其在新开的一个子线程上运行.
    //2.observerOn用来指定Observer所运行的线程，也就是发射出的数据在哪个线程上使用。
    // 一般情况下会指定在主线程中运行，这样就可以修改UI
    public static void subscribeOn() {
        Observable.create(subscriber -> {
            Log.d(TAG, "subscribeOn: " + Thread.currentThread().getName());
            subscriber.onNext(1);
            subscriber.onCompleted();
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> Log.d(TAG, "ObserverOn: " + Thread.currentThread().getName()));
    }

    //如果原始 Observable 过了指定的一段时长没有发射任何数据，timeout 操作符会以一个onError通知终止这个Observable，
    // 或者继续执行一个备用的Observable。timeout有很多变体，这里介绍其中的一种：timeout（long，TimeUnit，Observable），
    // 它在超时时会切换到使用一个你指定的备用的Observable，而不是发送错误通知。它默认在computation调度器上执行
    public static void timeOut() {
        Observable.create(subscriber -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(i * 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                subscriber.onNext(i);
            }
            subscriber.onCompleted();
        }).timeout(200, TimeUnit.MILLISECONDS, Observable.just(10, 11))
                .subscribe(integer -> Log.d(TAG, "timeOut: " + integer));
    }

    //catch操作符拦截原始Observable的onError通知，将它替换为其他数据项或数据序列，让产生的Observable能够正常终止或者根本不终止。
    //1.onErrorReturn：Observable遇到错误时返回原有Observable行为的备用Observable，备用Observable会忽略原有Observable
    // 的onError调用，不会将错误传递给观察者。作为替代，它会发射一个特殊的项并调用观察者的onCompleted方法
    //2.onErrorResumeNext：Observable遇到错误时返回原有Observable行为的备用Observable，备用Observable会忽略原有Observable
    // 的onError调用，不会将错误传递给观察者。作为替代，它会发射备用Observable的数据
    //3.onExceptionResumeNext：它和onErrorResumeNext类似。不同的是，如果onError收到的Throwable不是一个Exception，它会将错误
    // 传递给观察者的onError方法，不会使用备用的Observable
    public static void Catch() {
        Observable.create(subscriber -> {
            for (int i = 0; i < 5; i++) {
                if (i > 2) {
                    subscriber.onError(new Throwable("Throwable"));
//                    subscriber.onError(new IndexOutOfBoundsException("Halo"));
                }
                subscriber.onNext(i);
            }
            subscriber.onCompleted();
        })
                .onErrorReturn(throwable -> 6)
//                .onErrorResumeNext(Observable.just(10,11))
//                .onExceptionResumeNext(Observable.just(10, 20))
                .subscribe(integer -> Log.d(TAG, "Catch: " + integer));
    }

    //retry操作符不会将原始Observable的onError通知传递给观察者，它会订阅这个Observable，再给它一次机会无错误地完成其数据序列。
    // retry总是传递onNext通知给观察者，由于重新订阅，这可能会造成数据项重复
    public static void retry() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i < 5; i++) {
                    if (i == 1) {
                        subscriber.onError(new Throwable("Throwable"));
                    } else {
                        subscriber.onNext(i);
                    }
                }
                subscriber.onCompleted();
            }
        }).retry(2)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "onNext: " + integer);
                    }
                });
    }

    //all操作符根据一个函数对源Observable发射的所有数据进行判断，最终返回的结果就是这个判断结果。
    // 这个函数使用发射的数据作为参数，内部判断所有的数据是否满足我们定义好的判断条件。
    // 如果全部都满足则返回true，否则就返回false
    public static void all() {
        Observable.just(1, 2, 3, 4)
                .all(integer -> {
                    Log.d(TAG, "boolean: " + integer);
                    return integer < 3;
                })
                .subscribe(bool -> Log.d(TAG, "all: " + bool));
    }

    //contains 操作符用来判断源 Observable 所发射的数据是否包含某一个数据。
    // 如果包含该数据，会返回true；如果源Observable已经结束了却还没有发射这个数据，则返回false
    public static void contains() {
        Observable.just(1, 2, 3)
                .contains(1)
                .subscribe(it -> Log.d(TAG, "contains: " + it));
    }

    //isEmpty操作符用来判断源 Observable 是否发射过数据。
    // 如果发射过该数据，就会返回 false；如果源Observable已经结束了却还没有发射这个数据，则返回true
    public static void isEmpty() {
        Observable.just(1, 2, 3)
                .isEmpty()
                .subscribe(it -> Log.d(TAG, "isEmpty: " + it));
    }

    //amb 操作符对于给定两个或多个 Observable，它只发射首先发射数据或通知的那个Observable的所有数据
    public static void amb() {
        Observable.amb(Observable.just(1, 2, 3).delay(2, TimeUnit.SECONDS), Observable.just(4, 5, 6))
                .subscribe(integer -> Log.d(TAG, "amb: " + integer));
    }

    //发射来自原始Observable的数据。如果原始Observable没有发射数据，就发射一个默认数据
    public static void defaultIfEmpty() {
        Observable.create(subscriber -> subscriber.onCompleted())
                .defaultIfEmpty(3)
                .subscribe(integer -> Log.d(TAG, "defaultIfEmpty: " + integer));
    }

    //toList操作符将发射多项数据且为每一项数据调用onNext方法的Observable发射的多项数据组合成一个List，然后调用一次onNext方法传递整个列表
    public static void toList() {
        Observable.just(1, 2, 3)
                .toList()
                .subscribe(integers -> Log.d(TAG, "toList: " + integers));
    }

    //toSortedList操作符类似于toList操作符；不同的是，它会对产生的列表排序，默认是自然升序。
    // 如果发射的数据项没有实现Comparable接口，会抛出一个异常。当然，若发射的数据项没有实现Comparable接口，
    // 可以使用toSortedList（Func2）变体，其传递的函数参数Func2会作用于比较两个数据项
    public static void toSortedList() {
        Observable.just(1, 4, 5, 3, 2, 6)
                .toSortedList()
                .subscribe(integers -> Log.d(TAG, "toSortedList: " + integers));
    }

    //toMap操作符收集原始Observable发射的所有数据项到一个Map（默认是HashMap），然后发射这个Map。
    // 你可以提供一个用于生成Map的key的函数，也可以提供一个函数转换数据项到Map存储的值（默认数据项本身就是值）
    public static void toMap() {
        SwordMan s1 = new SwordMan("韦一笑", "A");
        SwordMan s2 = new SwordMan("张三丰", "SS");
        SwordMan s3 = new SwordMan("周芷若", "S");
        Observable.just(s1, s2, s3)
                .toMap(swordMan -> swordMan.getLevel())
                .subscribe(stringSwordManMap -> Log.d(TAG, "toMap: " + stringSwordManMap.get("SS").getName()));
    }
}
