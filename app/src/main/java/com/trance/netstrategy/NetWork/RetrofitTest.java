package com.trance.netstrategy.NetWork;

import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

import com.trance.netstrategy.bean.IpModel;

import java.io.File;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitTest {
    private static final String TAG = "RetrofitTest";
    private static String baseUrl = "http://192.168.1.64:8080/";

    public static void retrofitGet(final TextView tv) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IpService service = retrofit.create(IpService.class);
//        Call<IpModel> call = service.getMsg();
//        Call<IpModel> call = service.getPath("FuckWeb");       //@Path
//        Call<IpModel> call = service.getQuery("12.15.60.79", 200, "Shanghai");
//        Call<IpModel> call = service.post("12.15.60.79", 200, "深圳");
        Call<IpModel> call = service.postBody(new IpModel(200, "12.15.60.79", "NewYork"));
        call.enqueue(new Callback<IpModel>() {
            @Override
            public void onResponse(Call<IpModel> call, Response<IpModel> response) {
                Log.d(TAG, "onResponse: " + response.body().getCity());
                tv.setText(response.body().getCity());
            }

            @Override
            public void onFailure(Call<IpModel> call, Throwable t) {

            }
        });
    }

    public static void postFile() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Tencent/QQfile_recv";
        File file = new File(path, "D6DA015FEDDAF45457020FA7D089C82E.mp4");
        RequestBody mp4RequestBody = RequestBody.create(MediaType.parse("image/png"), file);
        MultipartBody.Part mp4 = MultipartBody.Part.createFormData("image",
                "HelloMyFriend" + file.getName(), mp4RequestBody);
        IpService service = retrofit.create(IpService.class);
        Call<IpModel> call = service.postFile(mp4, RequestBody.create(null, "Halo Apple"));
        call.enqueue(new Callback<IpModel>() {
            @Override
            public void onResponse(Call<IpModel> call, Response<IpModel> response) {
                Log.d(TAG, "onResponse: ");
            }

            @Override
            public void onFailure(Call<IpModel> call, Throwable t) {

            }
        });

    }
}
