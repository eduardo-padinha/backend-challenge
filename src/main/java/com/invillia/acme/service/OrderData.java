package com.invillia.acme.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.invillia.acme.model.Order;

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
		ordersList.add(new Order(1, "Endereço 1", (new Date()).getTime(), "Processando"));
		ordersList.add(new Order(2, "Endereço 2", (new Date()).getTime(), "Cancelado"));
		ordersList.add(new Order(3, "Endereço 3", (new Date()).getTime(), "Concluido"));
		ordersList.add(new Order(4, "Endereço 4", (new Date()).getTime(), "Concluido"));
		ordersList.add(new Order(5, "Endereço 5", (new Date()).getTime(), "Processando"));
	}
	
	/**
	 * Returns all orders registered on BD
	 * 
	 * @return A list of all orders
	 */
	public List<Order> fetchAllOrders(){
		return ordersList;
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
     * Used to update a pre-existing order
     * 
     * @param modifiedOrder Modified order used to update the BD
     * @return Returns the modified order
     */
    public Order updateOrder(Order modifiedOrder) {
        for(Order order: ordersList) {
            if(order.getId() == modifiedOrder.getId()) {
                int orderIndex = ordersList.indexOf(order);
                order.setAddress(modifiedOrder.getAddress());
                order.setConfirmationDate(modifiedOrder.getConfirmationDate());
                order.setStatus(modifiedOrder.getStatus());
                ordersList.set(orderIndex, order);
                return order;
            }

        }

        return null;
    }

    /**
     * 
     * Used to delete an specific order from the list
     * 
     * @param id Id of the order to be deleted
     * @return Returns TRUE if success or FALSE if it fails
     */
    public boolean deleteOrder(int id){
        int orderIndex = -1;
        for(Order order: ordersList) {
            if(order.getId() == id) {
            	orderIndex = ordersList.indexOf(order);
                break;
            }
        }
        
        if(orderIndex > -1){
        	ordersList.remove(orderIndex);
        	return true;
        }
        
        return false;
    }
}
