package com.trance.netstrategy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.trance.netstrategy.EventBus.MessageEvent;

import org.greenrobot.eventbus.EventBus;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button send = findViewById(R.id.send_msg);
        send.setOnClickListener(v -> {
//            EventBus.getDefault().post(new MessageEvent("Where is my iPhone?"));
            EventBus.getDefault().postSticky(new MessageEvent("处理一个黏性事件"));
            finish();
        });
    }
}
