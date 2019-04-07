package com.trance.netstrategy.RxJava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.trance.netstrategy.EventBus.MessageEvent;
import com.trance.netstrategy.R;

public class RxBusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_bus);
        Button send = findViewById(R.id.bt_post);
        send.setOnClickListener(view -> {
            RxBus.getInstance().post(new MessageEvent("用RxJava实现RxBus"));
        });
    }
}
