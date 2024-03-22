package com.javaDatabaseConectivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetEmployees 
{

	public static void main(String[] args) throws SQLException
	{



		Connection connection = null;

		try
		{

			//connection object created
			connection = DatabaseConnection.getDBConnection();

			Employee employee = new Employee();
			employee.setEmployeeId(117);

			//query 
			//String query = "select * from employee";
			String query = "select employee_name, employee_role from employee";
			
			//query statement object
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next())
			{
				System.out.println(resultSet.getString(1)+" | "+resultSet.getString(2));
			}


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
