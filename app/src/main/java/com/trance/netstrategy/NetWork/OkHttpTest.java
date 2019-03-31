package com.trance.netstrategy.NetWork;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpTest {
    private static final MediaType VIDEO_TYPE = MediaType.parse("video/mpeg4");
    private static final MediaType STREAM_TYPE = MediaType.parse("application/octet-stream");
    private static final String TAG = "OkHttpTest";
    private static final String baseUrl = "http://192.168.1.64:8080/FuckWeb";

    public static void jsonNet() {
        Request request = new Request.Builder()
                .url(baseUrl + "/JsonServlet?id=10086&city=beijing")
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse: " + response.body().string());
            }
        });
    }

    public static void downNet() {
        Request request = new Request.Builder()
                .url(baseUrl + "/DownloadServlet")
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream in = response.body().byteStream();
                long length = response.body().contentLength();
                Log.d(TAG, "FileLength: " + length);
                FileOutputStream out = new FileOutputStream(new File(Environment
                        .getExternalStorageDirectory().getAbsolutePath(), "downNet.exe"));
                int len;
                long currentLen = 0;
                byte[] buff = new byte[1024];
                while ((len = in.read(buff)) != -1) {
                    out.write(buff, 0, len);
                    currentLen += len;
                    Log.d(TAG, "正在下载***");
//                    Log.d(TAG, "正在下载***"+((double)currentLen)/(double)length+"%");
                }

                Log.d(TAG, "100%下载完成~");
            }
        });
    }

    public static void postNet() {
        String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/QQfile_recv";
        File file = new File(filePath, "D6DA015FEDDAF45457020FA7D089C82E.mp4");
        RequestBody body = RequestBody.create(VIDEO_TYPE, file);
        Request request = new Request.Builder()
                .url(baseUrl + "/FileServlet")
                .post(body)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse: " + response.body().string());
            }
        });
    }

    public static void postMultipart(String fileName, String fileType) {
        String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/QQfile_recv";
        File file = new File(filePath, "D6DA015FEDDAF45457020FA7D089C82E.mp4");
        RequestBody body = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file_name", fileName)
                .addFormDataPart("file_type", fileType)
                .addFormDataPart("image", file.getName(), RequestBody.create(VIDEO_TYPE, file))
                .build();
        final Request request = new Request.Builder()
                .url(baseUrl + "/FileServlet")
                .post(body)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse: " + response.body().string());
            }
        });
    }

    public static void download() {
        Request request = new Request.Builder()
                .url(baseUrl + "/girl.mp4")
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                Log.d(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                File file = new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), "download_girl.mp4");
                if (file.exists()) {
                    file.delete();
                }
                InputStream in = response.body().byteStream();
                FileOutputStream out = new FileOutputStream(file);
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) != -1) {
                    out.write(buf, 0, len);
                }
                Log.d(TAG, "Download success");
            }
        });
    }
}
