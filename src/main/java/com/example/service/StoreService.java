package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class StoreService {

	public String getAmount(final String price, final String userType) {

		float totalCost, costToPaid = 0, discountAmount;
		int discountPercentage = 0;

		totalCost = Float.valueOf(price);

		if (userType.equalsIgnoreCase("employee")) {
			discountPercentage = 30;
			discountAmount = (float) (totalCost * (discountPercentage/100.0));
			costToPaid = totalCost - discountAmount;
		} else if (userType.equalsIgnoreCase("affiliate")) {
			discountPercentage = 10;
			discountAmount = (float) (totalCost * (discountPercentage/100.0));
			costToPaid = totalCost - discountAmount;
		} else if (userType.equalsIgnoreCase("customer")) {
			discountPercentage = ((int) totalCost / 100) * 5;
			discountAmount = (float) (totalCost * (discountPercentage/100.0));
			costToPaid = totalCost - discountAmount;
		} else {
			costToPaid = totalCost;
		}
		return "Net payable amount is: " + costToPaid;
	}
}
