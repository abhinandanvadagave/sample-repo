package com.example.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Discount;
import com.example.model.Product;
import com.example.model.ProductType;
import com.example.model.Products;
import com.example.model.StoreDiscount;
import com.example.model.User;
import com.example.model.UserType;
import com.example.service.Cart;
import com.example.service.ShoppingCart;
import com.example.service.StoreService;

@Component
@RestController
public class StoreController {

	@Autowired
	StoreService storeService;

	@GetMapping("/calculate")
	@ResponseBody
	public String getAmount() {
		User employee = new User("Tim", LocalDateTime.now(), UserType.EMPLOYEE);
		Products grocery = new Product("Sugar", 90, ProductType.GROCERY);
		Products jersey = new Product("Jersey", 900, ProductType.SPORTS);
		Products tv = new Product("TV", 400, ProductType.ELECTRONICS);

		Discount discount = new StoreDiscount();
		Cart cart = new ShoppingCart(discount, employee);
		cart.addProducts(grocery, 1);
		cart.addProducts(jersey, 3);
		cart.addProducts(tv, 1);

//		User affiliate = new User("John", LocalDateTime.of(2020, Month.APRIL, 20, 10, 00), UserType.GENERAL);
//		Products shoes = new Product("Shoes", 900, ProductType.SPORTS);
//		Products heater = new Product("Heater", 400, ProductType.ELECTRONICS);

//		Discounts discount2 = new StoreDiscounts();
//		Cart cart1 = new ShoppingCart(discount2, affiliate);
//		cart1.addProducts(shoes, 2);
//		cart1.addProducts(heater, 2);

		return storeService.totalAmount(cart);
	}
}
