package com.comp;

import java.util.ArrayList;

public class Cart {
    ArrayList<Product> products;
    Cart(){
        products= new ArrayList<>();
    }
    public boolean isEmpty(){
        return products.isEmpty();
    }
    public boolean addItem(Product product,ArrayList<Product> stock){
        for (Product item :stock){
            if(item.name.equals(product.name)){
                if(item.quantity>= product.quantity){
                    this.products.add(product);
                    item.quantity-=product.quantity;
                    return true;
                }else{
                    return false;
                }
            }

        }
        return false;
    }
    public double calculateSubTotal(){
        return 0.0;
    }
    public double calculateShipping(){
        return 0.0;
    }
}
