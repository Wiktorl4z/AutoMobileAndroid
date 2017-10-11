package com.example.android.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android.myapplication.pojo.Car;
import com.example.android.myapplication.pojo.MyWebService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by l4z on 09.10.2017.
 */

public class TestActivity extends AppCompatActivity {

    private static final String CLASS_TAG = "MainActivity";
    private MyWebService service;
    static List<Car> items;

    @BindView(R.id.spinner_brand)
    Spinner spinnerBrand;
    @BindView(R.id.spinner_type)
    Spinner spinnerType;
    @BindView(R.id.spinner_year)
    Spinner spinnerYeah;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cars_layout);

        ButterKnife.bind(this);

        Button buttonChecker = (Button) findViewById(R.id.button_checker);

        service = HttpConnector.getService(MyWebService.class);

        spinnerBrand.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        spinnerType.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        spinnerYeah.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        buttonChecker.setOnClickListener(v -> {
            try {
                service.getData().enqueue(new Callback<List<Car>>() {
                    @Override
                    public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
                        items = response.body();

                        Adapter adapter = new Adapter(TestActivity.this, items);
                        ListView listView = (ListView) findViewById(R.id.list_view);
                        listView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<List<Car>> call, Throwable t) {
                        Log.d(CLASS_TAG, t.getLocalizedMessage());
                    }
                });
            } catch (Exception e) {
                Log.d(CLASS_TAG, e.toString());
            }
        });
    }
}
