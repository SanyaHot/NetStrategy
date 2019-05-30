package com.trance.netstrategy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

//import com.trance.annotations.BindView;
import com.google.gson.Gson;
import com.trance.netstrategy.Dagger2.App;
import com.trance.netstrategy.Dagger2.Car;
import com.trance.netstrategy.Dagger2.DaggerActivityComponent;
import com.trance.netstrategy.Dagger2.Engine;
import com.trance.netstrategy.Dagger2.Man;
import com.trance.netstrategy.Dagger2.SwordsMan;
import com.trance.netstrategy.Dagger2.Watch;
import com.trance.netstrategy.EventBus.MessageEvent;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.Lazy;

public class SecondActivity extends AppCompatActivity {

//    @BindView(value = R.id.send_msg)
//    int send;

    @BindView(R.id.send_msg)
    Button send;

    @Inject
    Watch watch;

    @Inject
    Gson gson;

    @Inject
    Gson gson1;

    @Inject
    Car car;

    @Inject
    SwordsMan swordsMan;

    /**
     * 懒加载
     * 在@Inject的时候不初始化，而是使用的时候，调用get方法来获取实例
     */
    @Inject
    Lazy<SwordsMan> swordsManLazy;

    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

        send.setOnClickListener(v -> {
//            EventBus.getDefault().post(new MessageEvent("Where is my iPhone?"));
            EventBus.getDefault().postSticky(new MessageEvent("处理一个黏性事件"));
            finish();
        });

//        Watch watch = new Watch();
//        watch.work();

//        DaggerSecondActivityComponent.create().inject(this);

        App.get(this).getActivityComponent().inject(this);

//        DaggerWatchComponent.create().inject(this);

        watch.work();

        String json = "{'name':'wsf','age':20}";
        Man man = gson.fromJson(json, Man.class);
        Log.i(TAG, "onCreate: " + man.getName());

        Log.i(TAG, "onCreate: " + car.run());

        //Object如果是单例,那么hashcode相同;则之
        Log.d(TAG, "gson_hashcode = " + gson.hashCode() + "\tgson1_hashcode = " + gson1.hashCode());

        Log.d(TAG, "SwordsMan fighting : " + swordsMan.fighting());

        //懒加载初始化
        SwordsMan lazyMan = swordsManLazy.get();
        Log.d(TAG, "LazyMan fighting : " + lazyMan.fighting());
    }
}
