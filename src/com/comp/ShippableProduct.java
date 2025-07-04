package com.comp;

public class ShippableProduct extends Product implements Shippable{
    double weight ;
    ShippableProduct(String name, double price, int quantity,double weight) {
        super(name, price, quantity);
        this.weight=weight;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getWeight() {
        return this.quantity*this.weight;
    }
}
