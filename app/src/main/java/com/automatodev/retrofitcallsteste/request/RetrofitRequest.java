package com.automatodev.retrofitcallsteste.request;

import com.automatodev.retrofitcallsteste.CoinDaddy;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitRequest {

    @GET("all/{value}")
    Call<CoinDaddy> getSingle(@Path("value")String value);

    @GET("all")
    Call<String> getAll();
}
