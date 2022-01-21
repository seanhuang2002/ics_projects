package application.fuctions;

import java.sql.ResultSet;
import java.sql.SQLException;

import application.DatabaseUtilities;
import application.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserFunctions {
	public static ObservableList<User> getAllUsers() throws ClassNotFoundException, SQLException
	{
		String sql="select * from login_password";
		try {
			ResultSet rsSet=DatabaseUtilities.dbExecute(sql);
			ObservableList<User> UserList=getUserObjects(rsSet);
			return UserList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public static ObservableList<User> getUserObjects(ResultSet rsSet) throws ClassNotFoundException, SQLException
	{
		try {
			ObservableList<User> UserList =FXCollections.observableArrayList();
			while(rsSet.next())
			{
				User user=new User(rsSet.getString("UserName"),rsSet.getString("PassWord"));
				user.setCustomerId(rsSet.getInt("customer_id"));
				user.setEmployeeId(rsSet.getInt("employee_id"));
				user.setEmployeeBoolean(rsSet.getInt("employee"));
				user.setId(rsSet.getInt("ID"));
				UserList.add(user);
			}
			return UserList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	public static void createUser(int userId, boolean employee, String userName, String password) throws ClassNotFoundException, SQLException
	{
		if(employee)//employee
		{
			String sql = "insert into login_password(UserName,PassWord,customer_id,employee,employee_Id)"
					+ " values('"+userName+"','"+password+"','1','1','"+userId+"')";
			DatabaseUtilities.dbExecuteQuery(sql);
		}
		else if(employee==false)//customer
		{
			String sql = "insert into login_password(UserName,PassWord,customer_id,employee,employee_Id)"
					+ " values('"+userName+"','"+password+"','"+userId+"','0','1')";
			DatabaseUtilities.dbExecuteQuery(sql);
		}
	}

}
