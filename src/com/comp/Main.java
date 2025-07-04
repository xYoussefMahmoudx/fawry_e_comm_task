package com.comp;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> stock = new HashMap<>();

        // Initialize stock quantities
        stock.put("Online Gift Card", 100);
        stock.put("Mobile Scratch Card", 200);
        stock.put("Textbook", 50);
        stock.put("Backpack", 30);
        stock.put("Promo Coupons", 40);
        stock.put("Milk", 30);
        stock.put("Protein Bar", 20);
        stock.put("Frozen Pizza", 15);


        System.out.println("*********** Example 1: Empty Cart ***********");
        User user1 = new User(100);
        user1.checkoutCart();

        System.out.println("\n*********** Example 2: Successful Purchase with Shipping ***********");
        User user2 = new User(2000);
        user2.cart.addItem(new ShippableProduct("Textbook", 150, 1, 1200), stock);
        user2.cart.addItem(new ShippableProduct("Backpack", 250, 1, 3000), stock);
        user2.cart.addItem(new Product("Online Gift Card", 10, 3), stock);
        user2.checkoutCart();

        System.out.println("\n*********** Example 3: Expired Product ***********");
        User user3 = new User(50);
        user3.cart.addItem(
                new ShippableExpirableProduct("Milk", 25, 1, LocalDate.of(2020, 11, 15),250),
                stock
        );

        System.out.println("\n*********** Example 4: Insufficient Balance ***********");
        User user4 = new User(10);
        user4.cart.addItem(new ShippableProduct("Textbook", 150, 1, 1200), stock);
        user4.checkoutCart();

        System.out.println("\n*********** Example 5: Heavy Shipment ***********");
        User user5 = new User(5000);
        user5.cart.addItem(new ShippableProduct("Textbook", 150, 5, 1200), stock);
        user5.cart.addItem(new ShippableProduct("Backpack", 250, 3, 3000), stock);
        user5.cart.addItem(new ShippableExpirableProduct("Frozen Pizza", 180, 2,
                LocalDate.of(2025, 12, 1), 800), stock);
        user5.checkoutCart();

        System.out.println("\n*********** Example 6: Mixed Cart ***********");
        User user6 = new User(100);
        user6.cart.addItem(new ExpirableProduct("Promo Coupons", 30, 2,
                LocalDate.of(2024, 12, 31)), stock);
        user6.cart.addItem(new ShippableExpirableProduct("Protein Bar", 15, 1,
                LocalDate.of(2025, 9, 15), 26), stock);
        user6.cart.addItem(new Product("Mobile Scratch Card", 10, 5), stock);
        user6.checkoutCart();

        System.out.println("\n*********** Example 7: Insufficient Stock ***********");
        User user7 = new User(1000);
        user7.cart.addItem(new Product("Online Gift Card", 10, 200), stock);
        System.out.println("Online Gift Card stock: " + stock.get("Online Gift Card"));
    }
}