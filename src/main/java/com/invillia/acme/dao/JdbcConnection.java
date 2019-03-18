package com.invillia.acme.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/acmeMVP?useTimezone=true&serverTimezone=UTC&useSSL=false";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	public static Connection getConnnection() {
		Connection dbConnection = null;

		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return dbConnection;
	}

}
