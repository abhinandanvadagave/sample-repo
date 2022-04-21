package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class StoreService {

	public String totalAmount(Cart cart) {
		double amountToPay = cart.totalAmount();
		return "Total Amount To Be Paid: " + amountToPay;
	}
}
