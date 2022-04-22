package com.example.model;

public class StoreDiscount implements Discount {
    @Override
    public DiscountType getDiscountType() {
        return DiscountType.PERCENTAGE_BASED;
    }

    @Override
    public double applyDiscount(double amount) {

        if(amount < 100) return amount;
        else {
            return amount - (((int)(amount / 100)) * 5);
        }
    }
}
