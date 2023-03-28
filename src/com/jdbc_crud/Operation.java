package com.jdbc_crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class Operation {

	
	Connection conn;
	Connectdb cdb = new Connectdb();
	
	public void get()
	{
		conn = cdb.connect_db();
		try
		{
			String select_sql = "SELECT * FROM person";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(select_sql);
			
			while (rs.next()) {
				System.out.print(rs.getString(1));
				System.out.print(rs.getString(2));
				System.out.print(rs.getString(3));
				System.out.print(rs.getString(4));	
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public void insert()
	{
		conn = cdb.connect_db();
		try
		{
			String insert_sql = "INSERT INTO person (firstname, lastname, age) VALUES ('doe', 'they', 25)";
			PreparedStatement st = conn.prepareStatement(insert_sql);
			// st.setString(1, firstname);
			
			int row_inserted = st.executeUpdate();
			
			if (row_inserted > 0) {
				System.out.println("Added new row.");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void update()
	{
		conn = cdb.connect_db();
		try
		{
			String update_sql = "UPDATE person SET firstname = 'testoo' WHERE id = 1";
			PreparedStatement st = conn.prepareStatement(update_sql);
			
			int row_updated = st.executeUpdate();
			
			if (row_updated > 0) {
				System.out.println("Updated row.");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void delete()
	{
		conn = cdb.connect_db();
		try
		{
			String delete_sql = "DELETE FROM person WHERE id = 1";
			PreparedStatement st = conn.prepareStatement(delete_sql);
			
			int row_deleted = st.executeUpdate();
			
			if (row_deleted > 0) {
				System.out.println("Deleted row.");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
