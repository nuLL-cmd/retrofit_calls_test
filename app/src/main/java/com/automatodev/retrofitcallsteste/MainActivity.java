package com.automatodev.retrofitcallsteste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonElement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://economia.awesomeapi.com.br/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        RetrofitRequest request = retrofit.create(RetrofitRequest.class);

        Call<String> call = request.getAll();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        String jsonresponse = response.body();
                        writeTv(jsonresponse);
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });

    }

    private void writeTv(String response) {
        List<CoinChild> list = new ArrayList<>();
        CoinChild coin = new CoinChild();
        try {
            JSONObject obj = new JSONObject(response.trim());
            Iterator<String> keys = obj.keys();
            int i=0;
            while (keys.hasNext()) {
                String key = keys.next();
                list.add(new CoinChild(((JSONObject) obj.get(key)).get("ask").toString()
                        ,((JSONObject) obj.get(key)).get("bid").toString()
                        ,((JSONObject) obj.get(key)).get("code").toString()
                        ,((JSONObject) obj.get(key)).get("codein").toString()
                        ,((JSONObject) obj.get(key)).get("create_date").toString()
                        ,((JSONObject) obj.get(key)).get("high").toString()
                        ,((JSONObject) obj.get(key)).get("low").toString()
                        ,((JSONObject) obj.get(key)).get("name").toString()
                        ,((JSONObject) obj.get(key)).get("pctChange").toString()
                        ,((JSONObject) obj.get(key)).get("timestamp").toString()
                        ,((JSONObject) obj.get(key)).get("varBid").toString()));

                Log.i("logx","Nome: "+list.get(i).getName());
                Log.i("logx","Venda: "+list.get(i).getBid()+"\n----------");
                i++;
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
