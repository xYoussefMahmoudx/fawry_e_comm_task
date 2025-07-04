package com.comp;

import java.time.LocalDate;
import java.util.Date;

public class ShippableExpirableProduct extends ExpirableProduct implements Shippable{
    double weight ;
    ShippableExpirableProduct(String name, double price, int quantity, LocalDate expDate, double weight) {
        super(name, price, quantity, expDate);
        this.weight=weight;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }
}
