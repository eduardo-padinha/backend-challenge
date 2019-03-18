package com.invillia.acme.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.invillia.acme.dao.OrderDaoImpl;
import com.invillia.acme.model.MvpOrder;
import com.invillia.acme.model.OrderItem;
import com.invillia.acme.model.Payment;
import com.invillia.acme.util.Constants;

public class OrderData {

	private static OrderData mockedDataInstance = null;
	private List<MvpOrder> ordersList;

	public static OrderData getInstance() {
		if (mockedDataInstance == null) {
			mockedDataInstance = new OrderData();
		}

		return mockedDataInstance;
	}

	public OrderData() {
		ordersList = new ArrayList<MvpOrder>();
		ordersList.add(new MvpOrder(1, "Endereço 1", (new Date()).getTime(), "Processando"));
		ordersList.add(new MvpOrder(2, "Endereço 2", (new Date()).getTime(), "Cancelado"));
		ordersList.add(new MvpOrder(3, "Endereço 3", (new Date()).getTime(), "Concluido"));
		ordersList.add(new MvpOrder(4, "Endereço 4", (new Date()).getTime(), "Concluido"));
		ordersList.add(new MvpOrder(5, "Endereço 5", (new Date()).getTime(), "Processando"));
	}

	/**
	 * Returns a specific order filtering by id
	 * 
	 * @param id The order id
	 * @return A single order that has the same passed id
	 */
	public MvpOrder getOrderById(int id) {
		MvpOrder result = null;
		try {
			result = OrderDaoImpl.getOrderById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 
	 * Used to create a new order and register on BD
	 * 
	 * @param newOrder New order to be created on BD
	 * @return Returns The created order
	 */
	public MvpOrder createNewOrder(MvpOrder newOrder) {
		try {
			OrderDaoImpl.createNewOrder(newOrder);

			if (newOrder.getPayment() != null) {
				OrderDaoImpl.createNewPayment(newOrder.getPayment(), newOrder.getId());
			}

			if (newOrder.getOrderItems() != null && !newOrder.getOrderItems().isEmpty()) {
				for (OrderItem orderItem : newOrder.getOrderItems()) {
					OrderDaoImpl.createNewOrderItem(orderItem, newOrder.getId());
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newOrder;
	}

	/**
	 * 
	 * Used to create a payment for a specific order
	 * 
	 * @param payment Payment to be added into the order
	 * @param orderId Id of the order
	 * @return The modified order
	 */
	public Payment createPaymentForAnOrder(Payment payment, int orderId) {
		try {
			OrderDaoImpl.createNewPayment(payment, orderId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return payment;
	}

	/**
	 * 
	 * Used to refund a pre-existing order
	 * 
	 * @param orderId Id of the order to be refund
	 * @return Returns the modified order
	 */
	public MvpOrder refundOrder(int orderId) {
		
		MvpOrder order = null;
		try {
			order = OrderDaoImpl.getOrderById(orderId);
			
			if (order.getId() == orderId && order.getPayment() != null) {
				long currentDate = (new Date()).getTime();
				long diff = currentDate - order.getPayment().getPaymentDate();
				long diffDays = diff / (24 * 60 * 60 * 1000);

				if (diffDays <= 10 && order.getPayment().getStatus().equals(Constants.CONFIRMED_STATUS)) {
					OrderDaoImpl.refundOrder(orderId);
				}

				return order;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return order;
	}

	/**
	 * 
	 * Used to refund a pre-existing order item
	 * 
	 * @param orderId     Id of the order that contains the order item to be refund
	 * @param orderItemId Id of the order item to be refund
	 * @return Returns the modified order
	 */
	public MvpOrder refundOrderItem(int orderId, int orderItemId) {
		for (MvpOrder order : ordersList) {
			if (order.getId() == orderId) {
				for (OrderItem orderItem : order.getOrderItems()) {
					if (orderItem.getId() == orderItemId && orderItem.getPayment() != null) {
						long currentDate = (new Date()).getTime();
						long diff = currentDate - orderItem.getPayment().getPaymentDate();
						long diffDays = diff / (24 * 60 * 60 * 1000);

						if (diffDays <= 10 && orderItem.getPayment().getStatus().equals(Constants.CONFIRMED_STATUS)) {
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
