package com.automatodev.retrofitcallsteste;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.automatodev.retrofitcallsteste.entity.CoinEntity;
import com.automatodev.retrofitcallsteste.request.AlphaRequest;
import com.automatodev.retrofitcallsteste.request.RetrofitRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "logx";

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Chamada retrofit usando o ScalarsConverterFactory ao inves do GsonConverterFactory, permitindo assim trazer um jsonobject para uma string, sem a necessidade de criar
        * diversas classes pojo ou entidades para representar este jsonobject*/
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.alphavantage.co/")
                .addConverterFactory(ScalarsConverterFactory.create()).build();
        AlphaRequest alpha = retrofit.create(AlphaRequest.class);
        //chamada do metodo da interface que contera os endpoints, aqui passamos apenas as variaveis que representaram o resultado das @Query que ja estao anotadas na chamada
        Call<String> call = alpha.getSingleRange("FX_INTRADAY","USD","BRL","60min","H7CA8PZAVE3IJ82V");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                /*Verifica se o response foi obtido com sucesso, caso isso tenha acontecido verifica se se corpo é diferente de null
                * se for, coloca o response.body() dentro de uma variavel string(que é o intuito do ScalarsConverterFactory)*/
                if (response.isSuccessful()){
                    if (response.body() != null){
                        String awnser = response.body();
                        //Chama o metodo que fara a manipulação dessa string
                        writeTv(awnser);
                    }

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("logx","Error: "+t.getMessage(), t);
            }
        });
        
    }

        private void writeTv(String response) {
            try {
                /*cria um novo objeto json passando como o parametro o response.trim() tirando assim todos os espaços e quebras de linhas do arquivo json*/
                JSONObject obj = new JSONObject(response.trim());
                /*Passa para uma segunda string o mesmo objeto json porem agora filtrando pelo nome do NÓ do objeto a ser usado*/
                String var =  obj.getString("Time Series FX (60min)");
                //instanci novamento o objeto json agora definitivo, que recebe a variavel ja com o filtro aplicado
                obj = new JSONObject(var);
                //A cereja do bolo esta em criar um Interater<String> e atribuir todas as keys ou seja todos os tilos dos nós dos objetos json, podendo assim navegar agora dentro de um objeto JSON
                Iterator<String> keys = obj.keys();
                /*Equanto for possivel ir para a proxima key*/
                while (keys.hasNext()) {
                    //atribui um keys.next() a uma string que sera usada como ponteiro para a chamada ((JSONObject) obj.get(key)).get("nome do campo dentro do no").toString()
                    String key = keys.next();
                    Log.i(TAG,"Key: "+key);

                    //Agora voce pode atribuir os campos dentro de uma entidade generica nao havendo necessidade de criar uma classe para cada key conforme convencção.
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
}
