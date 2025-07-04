package com.comp;

import java.util.Date;

public class ExpirableProduct extends Product implements Expirable{
    Date expDate;
    ExpirableProduct(String name, double price, int quantity,Date expDate) {
        super(name, price, quantity);
        this.expDate=expDate;
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}
