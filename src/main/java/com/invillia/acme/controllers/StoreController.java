package com.invillia.acme.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {

	@RequestMapping("/store")
	public String index() {
		return "Accessing store requests";
	}
	
}
