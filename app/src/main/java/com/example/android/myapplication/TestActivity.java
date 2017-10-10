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

    /*    @BindView(R.id.cars_list)
        View cars_layout;*/
    @BindView(R.id.spinner_brand)
    Spinner spinnerBrand;
    @BindView(R.id.spinner_type)
    Spinner spinnerType;
    @BindView(R.id.spinner_year)
    Spinner spinnerYeah;
/*    @BindView(R.id.button_checker)
    Button buttonChecker;
    @BindView(R.id.text_view_car_id)
    TextView textViewCarId;
    @BindView(R.id.text_view_car_name)
    TextView textViewCarName;
    @BindView(R.id.text_view_car_price)
    TextView textViewCarPrice;
    @BindView(R.id.text_view_car_engine)
    TextView textViewCarEngine;
    @BindView(R.id.text_view_car_passenger)
    TextView textViewCarPassenger;*/

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cars_layout);

        ButterKnife.bind(this);
        //   ButterKnife.bind(this, cars_layout);

        View inflatedView = getLayoutInflater().inflate(R.layout.cars_list, null);

        TextView textViewCarId = (TextView) inflatedView.findViewById(R.id.text_view_car_id);
        TextView textViewCarName = (TextView) inflatedView.findViewById(R.id.text_view_car_name);
        TextView textViewCarPrice = (TextView) inflatedView.findViewById(R.id.text_view_car_price);
        TextView textViewCarEngine = (TextView) inflatedView.findViewById(R.id.text_view_car_engine);
        TextView textViewCarPassenger = (TextView) inflatedView.findViewById(R.id.text_view_car_passenger);
        ImageView imageView = (ImageView) inflatedView.findViewById(R.id.image_view_car);
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

                        for (int i = 0; i < items.size(); i++) {
                            Car car = items.get(i);
                            int id = car.getId();

                            imageView.setImageResource(R.drawable.jeep);

                            textViewCarId.setText(id + "");

                            String name = car.getName();
                            textViewCarName.setText(name);

                            String priceString = car.getPrice().toString();
                            textViewCarPrice.setText(priceString);

                            String engine = car.getEngine();
                            textViewCarEngine.setText(engine);

                            String passenger = car.getEngine();
                            textViewCarPassenger.setText(passenger);
                            Log.d(CLASS_TAG, car.getName());

                            Adapter adapter = new Adapter(TestActivity.this, items);
                            ListView listView = (ListView) findViewById(R.id.list_view);
                            listView.setAdapter(adapter);
                        }
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
