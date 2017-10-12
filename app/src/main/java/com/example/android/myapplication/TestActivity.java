package com.example.android.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.example.android.myapplication.pojo.Car;
import com.example.android.myapplication.pojo.MyWebService;

import java.util.ArrayList;
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

    private static RecyclerView.Adapter adapter;
    private static final String CLASS_TAG = "TestActivity";
    public static View.OnClickListener myOnClickListener;
    private MyWebService service;
    static List<Car> items;
    private static RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private static ArrayList<Car> data;

    @BindView(R.id.spinner_brand)
    Spinner spinnerBrand;
    @BindView(R.id.spinner_type)
    Spinner spinnerType;
    @BindView(R.id.spinner_year)
    Spinner spinnerYeah;
    @BindView(R.id.button_checker)
    Button buttonChecker;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cars_layout);

        ButterKnife.bind(this);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
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

                        adapter = new CustomAdapter(items);
                        recyclerView.setAdapter(adapter);
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