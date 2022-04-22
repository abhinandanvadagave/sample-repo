package com.example.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;
import java.util.Map;

import com.example.model.Discount;
import com.example.model.ProductType;
import com.example.model.Products;
import com.example.model.User;
import com.example.model.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ShoppingCart implements Cart {

	@Getter
	@Setter
	private Map<Products, Integer> productQuantityMap;
	private Discount discount;
	private User user;

	public ShoppingCart(Discount discount, User user) {
		productQuantityMap = new LinkedHashMap<>();
		this.discount = discount;
		this.user = user;
	}

	@Override
	public void addProducts(Products products, int quantity) {
		int storedQuantity = productQuantityMap.getOrDefault(products, 0);
		productQuantityMap.put(products, storedQuantity + quantity);
	}

	@Override
	public int checkUserTypeAndGetDiscounts(User user) {
		if (user.getUserType() == UserType.EMPLOYEE)
			return 30;
		else if (user.getUserType() == UserType.AFFILIATE)
			return 10;
		else if (user.getUserType() == UserType.GENERAL
				&& ChronoUnit.YEARS.between(user.getRegisteredDateAndTime(), LocalDateTime.now()) >= 2)
			return 5;
		else
			return 0;
	}

	@Override
	public double totalAmount() {
		double total = 0;
		for (Products product : productQuantityMap.keySet()) {
			double productPrice = product.getTotalPrice(productQuantityMap.get(product));
			if (product.getProductType() != ProductType.GROCERY) {
				total = total + (productPrice - (productPrice * checkUserTypeAndGetDiscounts(user) / 100));
			} else {
				total = total + productPrice;
			}
		}

		if (discount != null)
			total = discount.applyDiscount(total);
		return total;
	}
}
