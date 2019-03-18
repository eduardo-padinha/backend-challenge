package com.invillia.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invillia.acme.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
}
