package com.trance.netstrategy;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.trance.netstrategy.NetWork.OkHttpTest;
import com.trance.netstrategy.NetWork.RetrofitTest;

public class MainActivity extends AppCompatActivity{

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
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

//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED) {
//            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
//                    Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CALL_PHONE,
//                    Manifest.permission.READ_CONTACTS}, 5);
//        } else {
//            OkHttpTest.download();
//        }


//        TextView press = findViewById(R.id.press);
//        press.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ItemListDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
//            }
//        });
//        LinearLayout ll_scl_price = findViewById(R.id.ll_scl_price);
//        ll_scl_price.setVisibility(View.VISIBLE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == 2) {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
////                OkHttpTest.postNet();
//                OkHttpTest.postMultipart("girl", "mp4");
//            }
//        }

//        if (requestCode == 3) {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                OkHttpTest.download();
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
}
