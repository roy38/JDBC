package com.jdbc_crud;

import java.sql.DriverManager;
import java.sql.Connection;

public class Connectdb {
	
	static Connection conn;
	public Connection connect_db()
	{
		try {
			//Declare the connect string here
			String db_url = "jdbc:mysql://localhost:3306/jdbc_crud";
			String username = "root";
			String password = "";
			conn = DriverManager.getConnection(db_url, username, password);
			
			if (conn != null) {
				System.out.println("Connect to db success.");
			} else {
				System.out.println("Error connect to db.");
			}
		}
		catch (Exception ex) {
			ex.getStackTrace();
		}
		
		return conn;
	}
}
