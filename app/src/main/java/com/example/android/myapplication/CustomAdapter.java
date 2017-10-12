package com.example.android.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.myapplication.pojo.Car;

import junit.framework.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by l4z on 11.10.2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private List<Car> dataSet;

    public CustomAdapter(List<Car> items) {
        this.dataSet = items;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewCarId;
        TextView textViewCarName;
        TextView textViewCarPrice;
        TextView textViewCarEngine;
        TextView textViewCarPassenger;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewCarId = (TextView) itemView.findViewById(R.id.text_view_car_id);
            this.textViewCarName = (TextView) itemView.findViewById(R.id.text_view_car_name);
            this.textViewCarPrice = (TextView) itemView.findViewById(R.id.text_view_car_price);
            this.textViewCarEngine = (TextView) itemView.findViewById(R.id.text_view_car_engine);
            this.textViewCarPassenger = (TextView) itemView.findViewById(R.id.text_view_car_passenger);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cars_list, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewCarId = holder.textViewCarId;
        TextView textViewCarName = holder.textViewCarName;
        TextView textViewCarPrice = holder.textViewCarPrice;
        TextView textViewCarEngine = holder.textViewCarEngine;
        TextView textViewCarPassenger = holder.textViewCarPassenger;

        textViewCarId.setText("Numer: " + dataSet.get(listPosition).getId());
        textViewCarName.setText("Nazwa: " + dataSet.get(listPosition).getName());
        textViewCarPrice.setText("Cena: " + dataSet.get(listPosition).getPrice() + "$");
        textViewCarEngine.setText("Silnik " + dataSet.get(listPosition).getEngine());
        textViewCarPassenger.setText("Miejsca: " + dataSet.get(listPosition).getPassenger());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}