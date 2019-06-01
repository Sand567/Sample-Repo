package com.sandeep.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDataSource {
	
	private static MySQLDataSource INSTANCE = new MySQLDataSource();
	
	private static final String URL = "jdbc:mysql://localhost:3306/my_personal_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	
	private MySQLDataSource() {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println("ERROR: Unable to connect to database");
		}
		
		return connection;
	}
	
	public static Connection getConnection() {
		return INSTANCE.createConnection();
	}

}
