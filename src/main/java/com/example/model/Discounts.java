package com.example.model;

public interface Discounts {
    DiscountType getDiscountType();
    double applyDiscount(double amount);
}
