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

import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

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
        Call<String> call = alpha.getSingleRange("FX_INTRADAY","USD","BRL",60+"min","H7CA8PZAVE3IJ82V");
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

/*
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
        });*/
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

                    //Agora voce pode atribuir os campos dentro de uma entidade generica nao havendo necessidade de criar uma classe para cada key conforme convencção.
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    public void LineChart_HelloChart() {
        /*LineChartView lineChartView;
        String[] axisData = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept",
                "Oct", "Nov", "Dec"};
        int[] yAxisData = {50, 20, 15, 30, 20, 60, 15, 40, 45, 10, 90, 18};
        lineChartView = findViewById(R.id.cubiclinechart    );
        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();
        Line line = new Line(yAxisValues).setColor(Color.parseColor("#9C27B0"));
        for (int i = 0; i < axisData.length; i++) {
            axisValues.add(i, new AxisValue(i).setLabel(axisData[i]));
        }
        for (int i = 0; i < yAxisData.length; i++) {
            yAxisValues.add(new PointValue(i, yAxisData[i]));
        }
        List lines = new ArrayList();
        lines.add(line);
        LineChartData data = new LineChartData();
        data.setLines(lines);
        Axis axis = new Axis();
        axis.setValues(axisValues);
        axis.setTextSize(16);
        axis.setTextColor(Color.parseColor("#03A9F4"));
        data.setAxisXBottom(axis);
        Axis yAxis = new Axis();
        yAxis.setName("Sales in millions");
        yAxis.setTextColor(Color.parseColor("#03A9F4"));
        yAxis.setTextSize(16);
        data.setAxisYLeft(yAxis);
        lineChartView.setLineChartData(data);
        Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top = 110;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);
        lineChartView.setZ(10f);*/
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void Pie_AnyChart() {
        /*Cartesian pie = AnyChart.bar();
        List<DataEntry> entry = new ArrayList<>();
        entry.add(new ValueDataEntry("Janeiro", 40));
        entry.add(new ValueDataEntry("Feverieiro", 75));
        entry.add(new ValueDataEntry("Março", 62));
        entry.add(new ValueDataEntry("Abril", 67));
        entry.add(new ValueDataEntry("Maio", 85));
        entry.add(new ValueDataEntry("Junho", 40));
        entry.add(new ValueDataEntry("Julho", 75));
        entry.add(new ValueDataEntry("Agosto", 62));
        entry.add(new ValueDataEntry("Setembro", 67));
        entry.add(new ValueDataEntry("Outubro", 85));
        entry.add(new ValueDataEntry("Novembro", 83));
        entry.add(new ValueDataEntry("Dezembro", 57));
        pie.setData(entry);
        pie.getYAxis().setEnabled(false);
        pie.getLegend().setMargin(new Double[]{20.2, 10.2});
        AnyChartView anyChart = findViewById(R.id.cubiclinechart);
        anyChart.setChart(pie);
        pie.getXZoom().continuous(true);
        anyChart.setOutlineAmbientShadowColor(Color.RED);
        anyChart.setHorizontalScrollBarEnabled(true);*/
    }

    public void Line_anyChart() {
/*        ValueLineChart mCubicValueLineChart = (ValueLineChart) findViewById(R.id.cubiclinechart);

    ValueLineSeries series = new ValueLineSeries();
        series.setColor(0xFF86B7F1);

        series.addPoint(new ValueLinePoint("Jan", 2.4f));
        series.addPoint(new ValueLinePoint("Feb", 3.4f));
        series.addPoint(new ValueLinePoint("Mar", .4f));
        series.addPoint(new ValueLinePoint("Apr", 1.2f));
        series.addPoint(new ValueLinePoint("Mai", 2.6f));
        series.addPoint(new ValueLinePoint("Jun", 1.0f));
        series.addPoint(new ValueLinePoint("Jul", 3.5f));
        series.addPoint(new ValueLinePoint("Aug", 2.4f));
        series.addPoint(new ValueLinePoint("Sep", 2.4f));
        series.addPoint(new ValueLinePoint("Oct", 3.4f));
        series.addPoint(new ValueLinePoint("Nov", .4f));
        series.addPoint(new ValueLinePoint("Dec", 1.3f));

        mCubicValueLineChart.addSeries(series);
        mCubicValueLineChart.setPressed(false);
        mCubicValueLineChart.startAnimation();*/
}
}
