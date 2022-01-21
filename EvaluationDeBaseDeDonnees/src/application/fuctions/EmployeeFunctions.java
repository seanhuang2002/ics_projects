package application.fuctions;

import java.sql.ResultSet;
import java.sql.SQLException;

import application.DatabaseUtilities;
import application.model.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeFunctions {
	public static ObservableList<Employee> getAllEmployees() throws ClassNotFoundException, SQLException
	{
		try {
			String sql="select * from employees";
			ResultSet rsSet=DatabaseUtilities.dbExecute(sql);
			ObservableList<Employee> employeeList=getEmployeeObjects(rsSet);
			return employeeList;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public static ObservableList<Employee> getEmployeeObjects(ResultSet rsSet) throws ClassNotFoundException, SQLException
	{
		ObservableList<Employee> employeeList=FXCollections.observableArrayList();
		while(rsSet.next())
		{
			Employee emp = new Employee(rsSet.getString("first_name"), rsSet.getString("last_name"));
			emp.setId(rsSet.getInt("id"));
			employeeList.add(emp);
		}
		return employeeList;
	}
	
	
	public static int getEmployeeIdFromName(String firstName, String lastName) throws ClassNotFoundException, SQLException
	{
		Employee empQ = new Employee("","");
		try {
			ObservableList<Employee> employeeList=FXCollections.observableArrayList();
			employeeList=getAllEmployees();
			for(int i=0;i<employeeList.size();i++)
			{
				Employee emp = employeeList.get(i);
				if(emp.getFirstName().equals(firstName) && emp.getLastName().equals(lastName))
				{
					empQ.setId(emp.getId());
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return empQ.getId();
	}
	
}
