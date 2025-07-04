package com.comp;

import java.util.*;
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
    public boolean addItem(Product product,Map<String, Integer> stock){
        for (Map.Entry<String, Integer> entry : stock.entrySet()){
            String item = entry.getKey();
            Integer stockAmount = entry.getValue();
            if(item.equals(product.name)){
                if(product instanceof Expirable){
                    if( ((Expirable) product).isExpired()){
                        System.out.println("Cannot add the item as it is Expired ");
                        return false;
                    }
                }
                if(stockAmount>= product.quantity){
                    if(product instanceof Shippable)
                        this.shippableProducts.add(product);
                    this.products.add(product);
                    entry.setValue(stockAmount-product.quantity);
                    return true;
                }else{
                    System.out.println("there is not enough Stock in the Market ");
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
