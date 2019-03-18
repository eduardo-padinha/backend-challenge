package com.invillia.acme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.invillia.acme.model.MvpOrder;
import com.invillia.acme.model.OrderItem;
import com.invillia.acme.model.Payment;

public class OrderDaoImpl {

	public static void createNewOrder(MvpOrder order) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO mvpOrder"
				+ "(address, confirmationDate, orderStatus) VALUES"
				+ "(?,?,?)";

		try {
			dbConnection = JdbcConnection.getConnnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, order.getAddress());
			preparedStatement.setLong(2, order.getConfirmationDate());
			preparedStatement.setString(3, order.getStatus());

			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is inserted into table!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}
	
	public static void createNewOrderItem(OrderItem orderItem, int orderId) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO orderItem"
				+ "(description, unitPrice, quantity, orderId) VALUES"
				+ "(?,?,?,?)";

		try {
			dbConnection = JdbcConnection.getConnnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, orderItem.getDescription());
			preparedStatement.setDouble(2, orderItem.getUnitPrice());
			preparedStatement.setInt(3, orderItem.getQuantity());
			preparedStatement.setInt(4, orderId);

			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is inserted into table!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}
	
	public static void createNewPayment(Payment payment, int orderId) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO payment"
				+ "(status, creditCardNumber, paymentDate, orderId) VALUES"
				+ "(?,?,?,?)";

		try {
			dbConnection = JdbcConnection.getConnnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, payment.getStatus());
			preparedStatement.setLong(2, payment.getCreditCardNumber());
			preparedStatement.setLong(3, payment.getPaymentDate());
			preparedStatement.setInt(4, orderId);

			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is inserted into table!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}
	
	public static MvpOrder getOrderById(int orderId) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		MvpOrder order = null;

		String selectSQL = "SELECT * FROM mvpOrder WHERE mvpOrder.orderId = ?";

		try {
			dbConnection = JdbcConnection.getConnnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, orderId);

			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				order = new MvpOrder();
				order.setId(rs.getInt("orderId"));
				order.setAddress(rs.getString("address"));
				order.setConfirmationDate(rs.getLong("confirmationDate"));
				order.setStatus(rs.getString("orderStatus"));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		
		return order;
	}
	
	public static List<OrderItem> getOrderItemByOrderId(int orderId) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		List<OrderItem> result = new ArrayList<OrderItem>();

		String selectSQL = "SELECT * FROM orderItem WHERE orderId = ?";

		try {
			dbConnection = JdbcConnection.getConnnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, orderId);

			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				OrderItem orderItem = new OrderItem();
				orderItem.setId(rs.getInt("orderItemId"));
				orderItem.setDescription(rs.getString("description"));
				orderItem.setQuantity(rs.getInt("quantity"));
				orderItem.setUnitPrice(rs.getInt("unitPrice"));
				result.add(orderItem);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		
		return result;
	}
	
	public static void refundOrder(int orderId) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String updateTableSQL = "UPDATE payment SET status = REFUNDED "
				                  + " WHERE orderId = ?";

		try {
			dbConnection = JdbcConnection.getConnnection();
			preparedStatement = dbConnection.prepareStatement(updateTableSQL);

			preparedStatement.setInt(1, orderId);

			// execute update SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is updated to table!");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}
}
