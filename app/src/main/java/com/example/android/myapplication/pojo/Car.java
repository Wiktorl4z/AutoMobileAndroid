package com.example.android.myapplication.pojo;

import java.math.BigDecimal;

/**
 * Created by l4z on 09.10.2017.
 */


public class Car {
    private int id;
    private String name;
    private BigDecimal price;
    private String engine;
    private int image;
    private int passenger;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getEngine() {
        return engine;
    }

    public int getImage() {
        return image;
    }

    public int getPassenger() {
        return passenger;
    }
}
