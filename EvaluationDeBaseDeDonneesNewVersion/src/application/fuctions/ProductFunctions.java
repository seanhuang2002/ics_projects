package application.fuctions;

import java.sql.ResultSet;
import java.sql.SQLException;

import application.DatabaseUtilities;
import application.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductFunctions {
	public static ObservableList<Product> getAllProducts() throws ClassNotFoundException, SQLException
	{
		String sql ="select * from products";
		ResultSet rsSet=DatabaseUtilities.dbExecute(sql);
		ObservableList<Product> list = getProductObjects(rsSet);
		return list;
	}
	
	public static ObservableList<Product> getProductObjects(ResultSet rsSet) throws ClassNotFoundException, SQLException
	{
		ObservableList<Product> list = FXCollections.observableArrayList();
		while(rsSet.next())
		{
			Product prod = new Product(rsSet.getString("product_name"), 0);
			list.add(prod);
		}
		return list;
	}

	public static int getProductId(String productName) throws ClassNotFoundException, SQLException
	{
		int returnValue=0;
		String sql = "select id from products where product_name ='"+productName+"'";
		ResultSet rsSet=DatabaseUtilities.dbExecute(sql);
		while(rsSet.next())
		{
			System.out.println(rsSet.getInt("id"));
			returnValue=rsSet.getInt("id");
		}
		System.out.println(returnValue);
		return returnValue;
	}
}
