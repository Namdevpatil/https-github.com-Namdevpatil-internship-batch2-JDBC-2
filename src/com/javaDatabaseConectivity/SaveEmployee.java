package com.javaDatabaseConectivity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveEmployee 
{

	public static void main(String[] args) throws SQLException
	{
		
		//Employee employee = new Employee(110, "Harish Reddy", "Software Developer");
		//Employee employee = new Employee(122, "Karthik Patil", "Software Developer");
		//Employee employee = new Employee(332, "Kumar singh", "Java Developer");
		Employee employee = new Employee(117, "John Rock", "Software Engineer");
		
		Connection connection = null;
		
		try
		{
			
			//connection object created
			connection = DatabaseConnection.getDBConnection();
			
			//query 
			String query = "insert into employee(employee_id, employee_name, employee_role) values('"+employee.getEmployeeId()+"', '"+employee.getEmployeeName()+"', '"+employee.getEmployeeRole()+"')";
			
			//query statement object
			Statement statement = connection.createStatement();
			
			//execute query statement
			int status = statement.executeUpdate(query);
			
			System.out.println(status+ " employee object stored in the database table.");
			
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			connection.close();
		}

	}

}
