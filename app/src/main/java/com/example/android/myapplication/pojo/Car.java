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

    public Car(int id, String name, BigDecimal price, String engine, int image, int passenger) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.engine = engine;
        this.image = image;
        this.passenger = passenger;
    }

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
