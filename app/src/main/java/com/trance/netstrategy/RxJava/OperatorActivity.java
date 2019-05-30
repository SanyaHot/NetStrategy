package com.trance.netstrategy.RxJava;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.trance.netstrategy.R;

import static com.trance.netstrategy.RxJava.RxOperator.*;

public class OperatorActivity extends AppCompatActivity {

    private static final String TAG = "OperatorActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);

//        创建操作符
//        interval();
//        range();
//        repeat();

//        变换操作符
//        map();
//        flatMap();
//        flatMapIterable();
//        buffer();
//        groupBy();

//        过滤操作符
//        filter();
//        elementAt();
//        distinct();
//        skip();
//        take();
//        ignoreElements();
//        throttleFirst();
//        throttleWithTimeOut();

//        组合操作符
//        startWith();
//        merge();
//        concat();
//        zip();
//        combineLatest();

//        辅助操作符
//        delay();
//        Do();
//        subscribeOn();
//        timeOut();

//        错误处理操作符
//        Catch();
//        retry();

//        布尔操作符
//        all();
//        contains();
//        isEmpty();

//        条件操作符
//        amb();
//        defaultIfEmpty();

//        转换操作符
        toList();
        toSortedList();
        toMap();
    }
}
