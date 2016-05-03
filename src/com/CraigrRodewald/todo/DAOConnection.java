package com.CraigrRodewald.todo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAOConnection {
	public static Connection connect = null;
	
	public static Connection startConnection() {
		String dbURL = "jdbc:mysql://localhost:3306/todolist?";
		String userName = "root";
		String password = "sesame";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(dbURL, userName, password);
			return connect;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
