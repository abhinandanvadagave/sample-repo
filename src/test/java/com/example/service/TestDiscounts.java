package com.example.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

import com.example.model.Discount;
import com.example.model.Product;
import com.example.model.ProductType;
import com.example.model.Products;
import com.example.model.StoreDiscount;
import com.example.model.User;
import com.example.model.UserType;

public class TestDiscounts {

    private Products groceryItem;
    private Products otherItem;
    private User employee;
    private User affiliate;
    private User simpleUser;
    private User simpleUserWith2Years;
    private Discount discounts;

    @Before
    public void setUp() {
        employee = new User("Tim", LocalDateTime.now(), UserType.EMPLOYEE);
        affiliate = new User("James", LocalDateTime.now(), UserType.AFFILIATE);
        simpleUser = new User("Helen", LocalDateTime.now(), UserType.GENERAL);
        simpleUserWith2Years = new User("Abhi", LocalDateTime.of(2020, Month.APRIL, 20, 10, 00), UserType.GENERAL);

        groceryItem = new Product("Soap", 20, ProductType.GROCERY);
        otherItem = new Product("TV", 110, ProductType.ELECTRONICS);
        discounts = new StoreDiscount();
    }

    @Test
    public void test_employeeWithGrocery() {
        Cart cart = new ShoppingCart(discounts, employee);
        cart.addProducts(groceryItem, 4);
        assertEquals(80, cart.totalAmount(), 0.01);
    }
    
    @Test
    public void test_employeeWithOtherItem() {
        Cart cart = new ShoppingCart(discounts, employee);
        cart.addProducts(otherItem, 4);
        assertEquals(293.0, cart.totalAmount(), 0.01);
    }
    
    @Test
    public void test_affiliateWithGrocery() {
        Cart cart = new ShoppingCart(discounts, affiliate);
        cart.addProducts(groceryItem, 4);
        assertEquals(80, cart.totalAmount(), 0.01);
    }
    
    @Test
    public void test_affiliateWithOtherItem() {
        Cart cart = new ShoppingCart(discounts, affiliate);
        cart.addProducts(otherItem, 4);
        assertEquals(381.0, cart.totalAmount(), 0.01);
    }
    
    @Test
    public void test_simpleUserWithGrocery() {
        Cart cart = new ShoppingCart(discounts, simpleUser);
        cart.addProducts(groceryItem, 4);
        assertEquals(80, cart.totalAmount(), 0.01);
    }
    
    @Test
    public void test_simpleUserWithOtherItem() {
        Cart cart = new ShoppingCart(discounts, simpleUser);
        cart.addProducts(otherItem, 4);
        assertEquals(420.0, cart.totalAmount(), 0.01);        
    }

    @Test
    public void test_simpleUserWith2YearsWithOtherItem() {
        Cart cart = new ShoppingCart(discounts, simpleUserWith2Years);
        cart.addProducts(otherItem, 4);
        assertEquals(337.0, cart.totalAmount(), 0.01);
    }

}
