package com.comp;

public class ShippableProduct extends Product implements Shippable{
    float weight ;
    ShippableProduct(String name, double price, int quantity,float weight) {
        super(name, price, quantity);
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
