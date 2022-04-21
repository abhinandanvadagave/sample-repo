package com.example.service;

import com.example.model.Products;
import com.example.model.User;

public interface Cart {
    void addProducts(Products products, int quantity);
    int checkUserTypeAndGetDiscounts(User user);
    double totalAmount();
}
