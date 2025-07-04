package com.comp;

public class User {
    double balance;
    Cart cart;
    User(double balance){
        this.balance=balance;
        cart= new Cart();
    }

    public boolean checkoutCart()
    {
        if(this.cart.isEmpty()){
            System.out.println("Cart is Empty please fill it first ");
            return false;
        }


        double subTotal=this.cart.calculateSubTotal();;
        double shipping=this.cart.calculateShipping();
        double totalAmount=subTotal+shipping;
        double totalWeight=this.cart.calculateTotalWeight();
        if(shipping>0){
            System.out.println("** Shipment notice **");
            for(Product item:this.cart.shippableProducts){
                System.out.println(item.quantity+"X "+((Shippable)item).getName()+"\t"+((Shippable)item).getWeight()+"g");
            }
            System.out.println("Total package weight is "+(totalWeight/1000)+"K.g");
            System.out.println("\n");
        }

        System.out.println("** Checkout recept **");
        for(Product item :this.cart.products){
            System.out.println(item.quantity+"X "+item.name+"\t"+item.quantity*item.price);
        }
        System.out.println("_______________________________");
        System.out.println("Subtotal\t"+subTotal);
        System.out.println("Shipping\t"+shipping);
        System.out.println("Amount\t"+totalAmount);

        if(totalAmount>this.balance){

            System.out.println("Failed to process the transaction as there is not enough balance");
            return false;
        }
        else{
            this.balance-=totalAmount;
            System.out.println("Transaction processed successfully your balance is now : "+this.balance);
            if(shipping>0) {
                System.out.println("Sent to Shipping Company and your order will be delivered soon ");
            }
            return false;
        }

    }
}
