package com.trance.netstrategy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

//import com.trance.annotations.BindView;
import com.google.gson.Gson;
import com.trance.netstrategy.Dagger2.DaggerSecondActivityComponent;
import com.trance.netstrategy.Dagger2.Man;
import com.trance.netstrategy.Dagger2.Watch;
import com.trance.netstrategy.EventBus.MessageEvent;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {

//    @BindView(value = R.id.send_msg)
//    int send;

    @BindView(R.id.send_msg)
    Button send;

    @Inject
    Watch watch;

    @Inject
    Gson gson;

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
        DaggerSecondActivityComponent.create().inject(this);
        watch.work();

        String json = "{'name':'wsf','age':20}";
        Man man = gson.fromJson(json, Man.class);
        Log.i(TAG, "onCreate: "+man.getName());
    }
}
