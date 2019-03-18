package com.invillia.acme.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.model.Order;
import com.invillia.acme.model.Payment;
import com.invillia.acme.service.OrderData;

@RestController
public class OrderController {

	@RequestMapping("/")
	public String index() {
		return "Accessing order requests.";
	}

	@GetMapping("/order/{id}")
    public Order getStoreById(@PathVariable String id){
        int orderId = Integer.parseInt(id);
        return OrderData.getInstance().getOrderById(orderId);
    }

    @PostMapping("/order")
    public Order createOrder(@RequestBody Order body){
        return OrderData.getInstance().createNewOrder(body);
    }

    @PutMapping("/order/{id}")
    public Order createOrderPayment(@PathVariable String id, @RequestBody Payment body){
        return OrderData.getInstance().createPaymentForAnOrder(body, Integer.parseInt(id));
    }

    @PutMapping("/order/{id}/refund")
    public Order refundOrder(@PathVariable String id){
        return OrderData.getInstance().refundOrder(Integer.parseInt(id));
    }
	
}
