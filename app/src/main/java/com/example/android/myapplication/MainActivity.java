package com.example.android.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import com.example.android.myapplication.pojo.DataBody;
import com.example.android.myapplication.pojo.MyWebService;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String CLASS_TAG = "MainActivity";

    Retrofit retrofit;
    MyWebService service;
    private EditText editTextId;
    private EditText editTextName;
    private EditText editTextPrice;
    private EditText editTextEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextId = (EditText) findViewById(R.id.edit_text_id);
        editTextName = (EditText) findViewById(R.id.edit_text_name);
        editTextPrice = (EditText) findViewById(R.id.edit_text_price);
        editTextEngine = (EditText) findViewById(R.id.edit_text_engine);

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClientBuilder.addInterceptor(logging);
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.4:8080")
                .client(okHttpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // creating service
        service = retrofit.create(MyWebService.class);
        findViewById(R.id.button_get).setOnClickListener(v -> {
            try {
                service.getData().enqueue(new Callback<List<DataBody>>() {
                    @Override
                    public void onResponse(Call<List<DataBody>> call, Response<List<DataBody>> response) {
                        List<DataBody> list = response.body();
                        DataBody dataBody = list.get(0);
                        int id = dataBody.getId();
                        editTextId.setText(id + "");
                        String name = dataBody.getName();
                        editTextName.setText(name);
                        String price = dataBody.getPrice().toString();
                        editTextPrice.setText(price);
                        String engine = dataBody.getEngine();
                        editTextEngine.setText(engine);
                        Log.d(CLASS_TAG, dataBody.getName());
                    }

                    @Override
                    public void onFailure(Call<List<DataBody>> call, Throwable t) {
                        Log.d(CLASS_TAG, t.getLocalizedMessage());
                    }
                });

            } catch (Exception e) {
                Log.d(CLASS_TAG, e.toString());
            }
        });

        findViewById(R.id.button_post).setOnClickListener(v -> {
            try {
                DataBody body = new DataBody();
                body.setId(1234);
                body.setName("my name!");

                service.postData(body).enqueue(new Callback<List<DataBody>>() {
                    @Override
                    public void onResponse(Call<List<DataBody>> call, Response<List<DataBody>> response) {
                        Log.d(CLASS_TAG, response.message());
                    }

                    @Override
                    public void onFailure(Call<List<DataBody>> call, Throwable t) {
                        Log.d(CLASS_TAG, t.getLocalizedMessage());
                    }
                });
            } catch (Exception e) {
                Log.d(CLASS_TAG, e.toString());
            }
        });
    }
}