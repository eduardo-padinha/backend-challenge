package com.invillia.acme.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.invillia.acme.model.Order;
import com.invillia.acme.model.OrderItem;
import com.invillia.acme.model.Payment;
import com.invillia.acme.util.Constants;

public class OrderData {

	private static OrderData mockedDataInstance = null;
	private List<Order> ordersList;
	
	public static OrderData getInstance() {
		if(mockedDataInstance == null) {
			mockedDataInstance = new OrderData();
		}
		
		return mockedDataInstance;
	}
	
	public OrderData() {
		ordersList = new ArrayList<Order>();
		ordersList.add(new Order(1, "Endereço 1", (new Date()).getTime(), "Processando", new ArrayList<OrderItem>(), new Payment()));
		ordersList.add(new Order(2, "Endereço 2", (new Date()).getTime(), "Cancelado", new ArrayList<OrderItem>(), new Payment()));
		ordersList.add(new Order(3, "Endereço 3", (new Date()).getTime(), "Concluido", new ArrayList<OrderItem>(), new Payment()));
		ordersList.add(new Order(4, "Endereço 4", (new Date()).getTime(), "Concluido", new ArrayList<OrderItem>(), new Payment()));
		ordersList.add(new Order(5, "Endereço 5", (new Date()).getTime(), "Processando", new ArrayList<OrderItem>(), new Payment()));
	}
	
	/**
	 * Returns a specific order filtering by id
	 * 
	 * @param id The order id
	 * @return A single order that has the same passed id
	 */
    public Order getOrderById(int id) {
        for(Order order: ordersList) {
            if(order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    /**
     * 
     * Used to create a new order and register on BD
     * 
     * @param newOrder New order to be created on BD
     * @return Returns TRUE if success or FALSE if it fails
     */
    public boolean createNewOrder(Order newOrder) {
        ordersList.add(newOrder);
        return true;
    }
    
    /**
     * 
     * Used to create a payment for a specific order
     * 
     * @param payment Payment to be added into the order
     * @param orderId Id of the order
     * @return The modified order
     */
    public Order createPaymentForAnOrder(Payment payment, int orderId) {
    	for(Order order: ordersList) {
            if(order.getId() == orderId) {
                int orderIndex = ordersList.indexOf(order);
                order.setPayment(payment);
                ordersList.set(orderIndex, order);
                return order;
            }

        }
    	
    	return null;
    }

    /**
     * 
     * Used to refund a pre-existing order
     * 
     * @param orderId Id of the order to be refund
     * @return Returns the modified order
     */
    public Order refundOrder(int orderId) {
        for(Order order: ordersList) {
            if(order.getId() == orderId && order.getPayment() != null) {
            	long currentDate = (new Date()).getTime();
            	long diff = currentDate - order.getPayment().getPaymentDate();
            	long diffDays = diff / (24 * 60 * 60 * 1000);
            	
            	if(diffDays <= 10 && order.getPayment().getStatus().equals(Constants.CONFIRMED_STATUS)) { 
            		order.setStatus(Constants.REFUND_STATUS);
            	}
            	
                int orderIndex = ordersList.indexOf(order);
                ordersList.set(orderIndex, order);
                return order;
            }

        }

        return null;
    }
    
    /**
     * 
     * Used to refund a pre-existing order item
     * 
     * @param orderId Id of the order that contains the order item to be refund
     * @param orderItemId Id of the order item to be refund
     * @return Returns the modified order
     */
    public Order refundOrderItem(int orderId, int orderItemId) {
        for(Order order: ordersList) {
            if(order.getId() == orderId) {
            	for(OrderItem orderItem: order.getOrderItems()) {
            		if(orderItem.getId() == orderItemId && orderItem.getPayment() != null) {
            			long currentDate = (new Date()).getTime();
                    	long diff = currentDate - orderItem.getPayment().getPaymentDate();
                    	long diffDays = diff / (24 * 60 * 60 * 1000);
                    	
                    	if(diffDays <= 10 && orderItem.getPayment().getStatus().equals(Constants.CONFIRMED_STATUS)) { 
                    		orderItem.getPayment().setStatus(Constants.REFUND_STATUS);
                    	}
                    	
                        int orderIndex = ordersList.indexOf(order);
                        ordersList.set(orderIndex, order);
                        return order;
            		}
            	}
            	
            }

        }

        return null;
    }

}
