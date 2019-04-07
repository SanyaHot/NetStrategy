package com.trance.netstrategy.NetWork;

import com.trance.netstrategy.bean.IpModel;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface IpService {
    @GET("/FuckWeb/JsonServlet?ip=15.6.108.72&code=200&city=Shanghai")
    Call<IpModel> getMsg();

    @GET("{path}/JsonServlet?ip=15.6.108.72&code=200&city=Shanghai")
    Call<IpModel> getPath(@Path("path") String path);

    @GET("/FuckWeb/JsonServlet")
    Call<IpModel> getQuery(
            @Query("ip") String ip,
            @Query("code") int code,
            @Query("city") String city
    );

    @FormUrlEncoded         //表示这是一个表单请求
    @POST("/FuckWeb/JsonServlet")
    Call<IpModel> post(
            @Field("ip") String ipAddress,
            @Field("code") int code,
            @Field("city") String city
    );

    @POST("/FuckWeb/JsonServlet")
    Call<IpModel> postBody(
            @Body IpModel model     //@Body可以将Java Bean转化为Json字符串并上传
    );

    @Multipart          //表示可以上传多个part
    @POST("/FuckWeb/FileServlet")
    Call<IpModel> postFile(
            @Part MultipartBody.Part photo,
            @Part("description") RequestBody description
    );

    @GET("/FuckWeb/JsonTest")
    Observable<IpModel> getIpMsg(
            @Query("ip") String ip
    );

}
