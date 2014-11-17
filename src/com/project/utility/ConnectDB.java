package com.project.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	private static ConnectDB instance = null;
	private static String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static String DB_CONNECTION = "jdbc:mysql://localhost:3306/proj2014_013?characterEncoding=utf-8";
<<<<<<< HEAD
	private static String DB_USER = "proj2014_013";
	private static String DB_PASSWORD = "proj2014_013";
=======
	private static String DB_USER = "root";
	private static String DB_PASSWORD = "1234";
>>>>>>> d3e4f8d5608e9d1716edb7fb102ac923243c6734

	public Connection DBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
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
