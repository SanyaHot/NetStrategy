package com.trance.netstrategy;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.trance.netstrategy.EventBus.MessageEvent;
import com.trance.netstrategy.NetWork.OkHttpTest;
import com.trance.netstrategy.NetWork.RetrofitTest;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    TextView tv_message;
    Button bt_message;
    Button bt_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_message = findViewById(R.id.result);
        bt_message = findViewById(R.id.bt_message);
        bt_register = findViewById(R.id.bt_subscription);

        bt_message.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SecondActivity.class));
        });

        bt_register.setOnClickListener(v -> {
            //如果发送的是黏性事件，可以等事件发送后再注册
            EventBus.getDefault().register(MainActivity.this);
        });


//        startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));

//        OkHttpTest.jsonNet();
//        OkHttpTest.downNet();
//        RetrofitTest.retrofitGet(result);
//        RetrofitTest.postFile();

//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED) {
//            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 2);
//        } else {
////            OkHttpTest.postNet();
//            OkHttpTest.postMultipart("girl", "mp4");
//        }

    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onHandleEvent(MessageEvent event) {
//        tv_message.setText(event.getMessage());
//    }

    /**
     * 处理黏性事件
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onHandleStickyEvent(MessageEvent event) {
        tv_message.setText(event.getMessage());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == 2) {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
////                OkHttpTest.postNet();
//                OkHttpTest.postMultipart("girl", "mp4");
//            }
//        }


        if (requestCode == 5) {
            if (grantResults.length > 0) {
                for (int result : grantResults) {
                    if (result != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                    }
                }
                OkHttpTest.download();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
