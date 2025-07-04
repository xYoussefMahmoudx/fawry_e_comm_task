package com.comp;

import java.util.Date;

public class ShippableExpirableProduct extends ExpirableProduct implements Shippable{
    float weight ;
    ShippableExpirableProduct(String name, double price, int quantity, Date expDate,float weight) {
        super(name, price, quantity, expDate);
        this.weight=weight;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public float getWeight() {
        return 0;
    }
}
