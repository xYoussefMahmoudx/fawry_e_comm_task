package com.comp;

import java.util.ArrayList;

public class Cart {
    ArrayList<Product> products;
    ArrayList<Product> shippableProducts;
    Cart(){
        products= new ArrayList<>();
        shippableProducts=new ArrayList<>();
    }
    public boolean isEmpty(){
        return products.isEmpty();
    }
    public boolean addItem(Product product,ArrayList<Product> stock){
        for (Product item :stock){
            if(item.name.equals(product.name)){
                if(item instanceof Expirable){
                    if( ((Expirable) item).isExpired()){
                        return false;
                    }
                }
                if(item.quantity>= product.quantity){
                    if(item instanceof Shippable)
                        this.shippableProducts.add(item);
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
        double ans=0;
        for(Product item:products){
            ans+=(item.price* item.quantity);
        }
        return ans;
    }

    public double calculateTotalWeight(){
        double totalWeight=0;
        for(Product item:shippableProducts){
                totalWeight+= ((Shippable)item).getWeight();
        }
        return totalWeight;
    }

    public double calculateShipping(){
        double totalWeight=calculateTotalWeight();
        if(totalWeight==0)
            return 0.0;
        else if (totalWeight/1000<10) {
            return 30;
        }
        else
            return 50;
    }
}
