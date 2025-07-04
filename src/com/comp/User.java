package com.comp;

public class User {
    double balance;
    Cart cart;
    User(double balance){
        this.balance=balance;
        cart= new Cart();
    }

    public boolean checkoutCart(){
        return false;
    }
}
