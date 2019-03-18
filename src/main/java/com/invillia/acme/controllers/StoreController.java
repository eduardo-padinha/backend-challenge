package com.invillia.acme.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.model.Store;
import com.invillia.acme.service.StoreData;

@RestController
public class StoreController {

	@RequestMapping("/store")
	public String index() {
		return "Accessing store requests";
	}
	
	@GetMapping("/store/{id}")
    public Store getStoreById(@PathVariable String id){
        int storeId = Integer.parseInt(id);
        return StoreData.getInstance().getStoreById(storeId);
    }

    @PostMapping("/store")
    public Store createStore(@RequestBody Store body){
        return StoreData.getInstance().createNewStore(body);
    }

    @PutMapping("/store/{id}/")
    public Store updateStore(@PathVariable String id, @RequestBody Store body){
    	body.setId(Integer.parseInt(id));
        return StoreData.getInstance().updateStore(body);
    }
    
}
