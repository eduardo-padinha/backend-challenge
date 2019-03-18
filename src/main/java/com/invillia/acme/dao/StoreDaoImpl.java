package com.invillia.acme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.invillia.acme.model.Store;

public class StoreDaoImpl {

	public static void createNewStore(Store store) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO store"
				+ "(storeName, address) VALUES"
				+ "(?,?)";

		try {
			dbConnection = JdbcConnection.getConnnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, store.getName());
			preparedStatement.setString(2, store.getAddress());

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
	
	public static Store getStoreById(int storeId) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		Store store = null;

		String selectSQL = "SELECT * FROM store WHERE storeId = ?";

		try {
			dbConnection = JdbcConnection.getConnnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, storeId);

			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				store = new Store();
				store.setId(rs.getInt("storeId"));
				store.setAddress(rs.getString("storeName"));
				store.setName(rs.getString("address"));

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
		
		return store;
	}
	
	public static void updateStore(Store store) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String updateTableSQL = "UPDATE store SET storeName = ?, address = ? "
				                  + " WHERE storeId = ?";

		try {
			dbConnection = JdbcConnection.getConnnection();
			preparedStatement = dbConnection.prepareStatement(updateTableSQL);

			preparedStatement.setInt(1, store.getId());
			preparedStatement.setString(2, store.getName());
			preparedStatement.setString(3, store.getAddress());

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
