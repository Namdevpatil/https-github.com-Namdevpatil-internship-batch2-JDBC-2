package com.javaDatabaseConectivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetEmployee 
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
			//String query = "insert into employee(employee_id, employee_name, employee_role) values('"+employee.getEmployeeId()+"', '"+employee.getEmployeeName()+"', '"+employee.getEmployeeRole()+"')";
			String query = "select * from employee where employee_id = '"+employee.getEmployeeId()+"'";

			//query statement object
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt(1)+" | "+resultSet.getString(2)+" | "+resultSet.getString(3));
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
