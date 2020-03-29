package com.automatodev.retrofitcallsteste.request;

import com.automatodev.retrofitcallsteste.entity.CoinEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AlphaRequest {
    /*Rotas que possuem consultas a dados como por exemplo from_currency=USD, requerem uma anotação Query contendo apens o nome e uma variavel representando o valor */
    @GET("query?")
    Call<String> getSingleTest(@Query("function")String function,@Query("from_currency")String from, @Query("to_currency") String to
           ,@Query("apikey")String key);
    @GET("query?")
    Call<String> getSingleRange(@Query("function")String function,@Query("from_symbol")String from, @Query("to_symbol") String to
            ,@Query("interval")String interval,@Query("apikey")String apikey);
}
