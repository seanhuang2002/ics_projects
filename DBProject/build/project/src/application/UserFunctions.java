package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserFunctions {
	
	public static ObservableList<User> getAllUsers() throws ClassNotFoundException, SQLException
	{
		String sqlQuery = "select * from login";
		try
		{
			ResultSet rsSet=DBUtilities.dbExecute(sqlQuery);
			ObservableList<User> list = getUserObjects(rsSet);
			return list;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public static ObservableList<User> getUserObjects(ResultSet rsSet) throws ClassNotFoundException, SQLException
	{
		try
		{
			ObservableList<User> list = FXCollections.observableArrayList();
			while(rsSet.next()) 
			{
				User user = new User(rsSet.getString("username"),rsSet.getString("password"));
				list.add(user);
			}
			return list;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public static boolean checkPassword(String username, String password) throws ClassNotFoundException, SQLException
	{
		ObservableList<User> list = getAllUsers();
		for(int i=0; i<list.size();i++)
		{
			if(username.equals(list.get(i).getUsername())&&password.equals(list.get(i).getPassword()))
			{
				return true;
			}
		}
		return false;
	}

}
