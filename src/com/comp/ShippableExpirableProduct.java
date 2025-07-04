package com.comp;

import java.time.LocalDate;
import java.util.Date;

public class ShippableExpirableProduct extends ExpirableProduct implements Shippable{
    float weight ;
    ShippableExpirableProduct(String name, double price, int quantity, LocalDate expDate, float weight) {
        super(name, price, quantity, expDate);
        this.weight=weight;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getWeight() {
        return this.weight;
    }
}
