package com.javaDatabaseConectivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetEmployees2 
{

	public static void main(String[] args) throws SQLException
	{



		Connection connection = null;

		try
		{

			//connection object created
			connection = DatabaseConnection.getDBConnection();

			//query 
			//String query = "select * from employee";
			String query = "select employee_id, employee_name, employee_role from employee";
			
			//query statement object
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(query);		
			
			List<Employee> listOfEmployees = new ArrayList<Employee>();
			
			while(resultSet.next())
			{	
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String role = resultSet.getString(3);
				
				Employee employee = new Employee(id, name, role);
								
				listOfEmployees.add(employee);				
			}
			
			//print all employees whom role is Software Developer			
			for(Employee employee: listOfEmployees)
			{
				if(employee.getEmployeeRole().equals("Software Developer") || employee.getEmployeeRole().equals("software developer"))
				{
					System.out.println(employee.toString());
				}
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
