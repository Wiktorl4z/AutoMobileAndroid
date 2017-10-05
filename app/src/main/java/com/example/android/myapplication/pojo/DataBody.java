package com.example.android.myapplication.pojo;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class DataBody {
    private int id;
    private String name;
    private BigDecimal price;
    private String engine;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
}
