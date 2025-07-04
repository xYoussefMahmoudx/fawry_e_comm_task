package com.comp;

import java.time.LocalDate;


public class ExpirableProduct extends Product implements Expirable{
    LocalDate expDate;
    ExpirableProduct(String name, double price, int quantity,LocalDate expDate) {
        super(name, price, quantity);
        this.expDate=expDate;
    }

    @Override
    public boolean isExpired() {
        LocalDate currentDate = LocalDate.now();
        return this.expDate.isBefore(currentDate);
    }
}
