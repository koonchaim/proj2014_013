package com.project.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	private static ConnectDB instance = null;
	private static String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static String DB_CONNECTION = "jdbc:mysql://http://172.16.0.20:8080/proj2014_013?characterEncoding=utf-8";
	private static String DB_USER = "proj2014_013";
	private static String DB_PASSWORD = "proj2014_013";

	public Connection DBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

	public ConnectDB() {
	}

	public static ConnectDB getInstance() {
		if (instance == null) {
			instance = new ConnectDB();
		}
		return instance;
	}
}
