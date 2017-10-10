package com.example.android.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.myapplication.pojo.Car;

import java.util.List;

/**
 * Created by l4z on 09.10.2017.
 */

public class Adapter extends ArrayAdapter<Car> {

    public Adapter(Activity context, List<Car> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.cars_list, parent, false);
        }

        Car currentItem = getItem(position);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view_car);
        imageView.setImageResource(R.drawable.jeep);

        TextView tViCarId = (TextView) listItemView.findViewById(R.id.text_view_car_id);
        tViCarId.setText("Vehical number: " + currentItem.getId());

        TextView tVCarName = (TextView) listItemView.findViewById(R.id.text_view_car_name);
        tVCarName.setText("Name: " + currentItem.getName());

        TextView tVCarPrice = (TextView) listItemView.findViewById(R.id.text_view_car_price);
        tVCarPrice.setText("Price: " + currentItem.getPrice() + "$");

        TextView tVCarEngine = (TextView) listItemView.findViewById(R.id.text_view_car_engine);
        tVCarEngine.setText("Engine: " + currentItem.getEngine());

        TextView tVCarPassenger = (TextView) listItemView.findViewById(R.id.text_view_car_passenger);
        tVCarPassenger.setText("Passenger seat " + currentItem.getPassenger());

        return listItemView;
    }
}