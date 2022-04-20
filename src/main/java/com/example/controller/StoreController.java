package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.StoreService;

@Component
@RestController
public class StoreController {

	@Autowired
	StoreService storeService;

	@GetMapping("/calculate")
	@ResponseBody
	public String getAmount(@RequestParam String price, @RequestParam String userType) {
		
		return storeService.getAmount(price, userType);
	}
}
