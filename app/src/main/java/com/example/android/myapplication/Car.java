package com.example.android.myapplication;

import java.math.BigDecimal;

import lombok.Data;

/**
 * Created by l4z on 09.10.2017.
 */

@Data
public class Car {

    private int id;
    private String name;
    private BigDecimal price;
    private String engine;
    private int image;
    private Integer passenger;

    public int getId() {
        return id;
    }

    public Car(int id, String name, BigDecimal price, String engine, int image, Integer passenger) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.engine = engine;
        this.image = image;
        this.passenger = passenger;
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

    public Integer getPassenger() {
        return passenger;
    }
}
