package com.invillia.acme.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@RequestMapping("/order")
	public String index() {
		return "Accessing order requests.";
	}
	
}
