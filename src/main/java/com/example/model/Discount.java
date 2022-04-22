package com.example.model;

public interface Discount {
    DiscountType getDiscountType();
    double applyDiscount(double amount);
}
