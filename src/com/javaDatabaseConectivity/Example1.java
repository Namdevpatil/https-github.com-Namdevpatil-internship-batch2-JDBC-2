package com.javaDatabaseConectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Example1
{
	
	//the database server credentials are required
	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/employee_db";
	private static final String DATABASE_USERNAME = "root";
	private static final String DATABASE_PASSWORD = "DeV@1990";

	public static void main(String[] args) throws SQLException
	{	
		
		Connection connection = null;
		
		try 
		{
			//step-1: load the driver
			Class.forName(DRIVER_NAME);
			
			//step2: create connection object
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			
			//step3: create queries
			String query = "insert into employee values(101, 'sachin patil', 'java developer')";
			Statement statement = connection.createStatement();
			
			//step4: execute queries
			int status = statement.executeUpdate(query);
			
			System.out.println(status+" object is stored in database table.");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			//step5: close database connection.
			connection.close();
		}

	}

}
