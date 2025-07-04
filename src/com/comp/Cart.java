package com.comp;

import java.util.ArrayList;

public class Cart {
    ArrayList<Product> products;
    Cart(){
        products= new ArrayList<>();
    }
    public boolean isEmpty(){
        return false;
    }
    public boolean addItem(Product product){
        return false;
    }
    public double calculateSubTotal(){
        return 0.0;
    }
    public double calculateShipping(){
        return 0.0;
    }
}
