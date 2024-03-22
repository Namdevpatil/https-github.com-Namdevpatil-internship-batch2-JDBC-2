package com.javaDatabaseConectivity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateEmployee 
{

	public static void main(String[] args) throws SQLException
	{



		Connection connection = null;

		try
		{

			//connection object created
			connection = DatabaseConnection.getDBConnection();

			Employee employee = new Employee(117, "Ajay Kumar", "Business Analyst");
		
			//query 

			String query = "update employee set employee_name = '"+employee.getEmployeeName()+"',  employee_role = '"+employee.getEmployeeRole()+"' where employee_id = "+employee.getEmployeeId();

			//query statement object
			Statement statement = connection.createStatement();

			statement.executeUpdate(query);

			System.out.println("employee data updated.");

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
