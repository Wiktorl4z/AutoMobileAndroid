package com.example.android.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Spinner;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by l4z on 09.10.2017.
 */

public class TestActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cars_layout);

        setListener(R.id.spinner_brand);
        setListener(R.id.spinner_type);
        setListener(R.id.spinner_year);

        ArrayList<Car> items = new ArrayList<>();
        items.add(new Car(1, "Audi", new BigDecimal(200000), "Super Turbo", R.drawable.car, 5));
        items.add(new Car(2, "Mercedes", new BigDecimal(150000), "Turbo", R.drawable.track, 5));
        items.add(new Car(3, "Toyota", new BigDecimal(130000), "Turbo", R.drawable.jeep, 5));
        items.add(new Car(4, "Audi", new BigDecimal(200000), "Super Turbo", R.drawable.car, 5));
        items.add(new Car(5, "Mercedes", new BigDecimal(150000), "Turbo", R.drawable.track, 5));
        items.add(new Car(6, "Toyota", new BigDecimal(130000), "Turbo", R.drawable.jeep, 5));

        Adapter adapter = new Adapter(this, items);

        ListView listView = (ListView) findViewById(R.id.list_view1);
        listView.setAdapter(adapter);
    }

    private void setListener(int spinner_brand) {
        Spinner spinnerBrand = (Spinner) findViewById(spinner_brand);
        spinnerBrand.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }
}
