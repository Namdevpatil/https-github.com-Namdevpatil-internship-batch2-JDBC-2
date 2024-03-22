package com.javaDatabaseConectivity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteEmployee 
{

	public static void main(String[] args) throws SQLException
	{
		
		Connection connection = null;

		try
		{

			//connection object created
			connection = DatabaseConnection.getDBConnection();

			Employee employee = new Employee();
			employee.setEmployeeId(110);
		
			//query 

			String query = "delete from employee where employee_id = "+employee.getEmployeeId();

			//query statement object
			Statement statement = connection.createStatement();

			statement.executeUpdate(query);

			System.out.println("employee data deleted.");

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
