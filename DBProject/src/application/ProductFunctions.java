package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductFunctions {

	public static void insertProduct(String supplier, String name, String code, double cost, double price, String quantity, String category, int units) throws ClassNotFoundException, SQLException
	{
		String sql = "insert into products (supplier_ids,product_name,product_code,standard_cost,list_price,quantity_per_unit,category,minimum_reorder_quantity) "
				+ "values('"+supplier+"','"+name+"','"+code+"','"+cost+"','"+price+"','"+quantity+"','"+category+"','"+units+"')";
		try
		{
			DBUtilities.dbExecuteQuery(sql);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void deleteProduct(int id) throws ClassNotFoundException, SQLException
	{
		String sqlStmt1="delete from purchase_order_details where id="+id;
		String sqlStmt2="delete from order_details where id="+id;
		String sqlStmt3="delete from products where id="+id;
		try
		{
			DBUtilities.dbExecuteQuery(sqlStmt1);
			DBUtilities.dbExecuteQuery(sqlStmt2);
			DBUtilities.dbExecuteQuery(sqlStmt3);
		} 
		catch(SQLException e) 
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void modifyProduct(int id, String supplier, String name, String code, double cost, double price, String quantity, String category, int units) throws ClassNotFoundException, SQLException
	{
		String sqlStmt = "update products set supplier_ids='"+supplier+"', product_name='"+name+"', product_code='"+code+"', standard_cost='"+cost+"',"
				+ " list_price='"+price+"',quantity_per_unit='"+quantity+"', category='"+category+"', minimum_reorder_quantity='"+units+"' where id=" +id;
		try
		{
			DBUtilities.dbExecuteQuery(sqlStmt);
		} 
		catch(SQLException e) 
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public static ObservableList<Product> getAllProducts() throws ClassNotFoundException, SQLException
	{
		String sql = "select * from products";
		try
		{
			ResultSet rsSet=DBUtilities.dbExecute(sql);
			ObservableList<Product> list = getProductObjects(rsSet);
			return list;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public static ObservableList<Product> getProductObjects(ResultSet rsSet) throws ClassNotFoundException, SQLException
	{
		try
		{
			ObservableList<Product> list = FXCollections.observableArrayList();
			while(rsSet.next()) 
			{
				Product product = new Product();
				product.setId(rsSet.getInt("id"));
				product.setSupplier(rsSet.getString("supplier_ids"));
				product.setName(rsSet.getString("product_name"));
				product.setCode(rsSet.getString("product_code"));
				product.setStandardCost(rsSet.getDouble("standard_cost"));
				product.setListPrice(rsSet.getDouble("list_price"));
				product.setQuantityPerUnit(rsSet.getString("quantity_per_unit"));
				product.setCategory(rsSet.getString("category"));
				product.setUnitsPerOrder(rsSet.getInt("minimum_reorder_quantity"));
				list.add(product);
			}
			return list;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public static Product getProduct(int id) throws ClassNotFoundException, SQLException
	{
		String sqlQuery = "select * from products where id="+id;
		Product product = new Product();
		try
		{
			ResultSet rsSet=DBUtilities.dbExecute(sqlQuery);
			while(rsSet.next())
			{
				product.setId(rsSet.getInt("id"));
				product.setSupplier(rsSet.getString("supplier_ids"));
				product.setName(rsSet.getString("product_name"));
				product.setCode(rsSet.getString("product_code"));
				product.setStandardCost(rsSet.getDouble("standard_cost"));
				product.setListPrice(rsSet.getDouble("list_price"));
				product.setQuantityPerUnit(rsSet.getString("quantity_per_unit"));
				product.setCategory(rsSet.getString("category"));
				product.setUnitsPerOrder(rsSet.getInt("minimum_reorder_quantity"));
			}
			return product;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public static ObservableList<String> getProductCategories() throws ClassNotFoundException, SQLException
	{
		try {
			String sqlQuery = "select category from products";
			ResultSet rsSet = DBUtilities.dbExecute(sqlQuery);
			ObservableList<String> list = sortCategories(rsSet);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public static ObservableList<String> sortCategories(ResultSet rsSet) throws ClassNotFoundException, SQLException
	{
		try {
			ObservableList<String> list = FXCollections.observableArrayList();
			while(rsSet.next())
			{
				String string = rsSet.getString("category");
				if(!list.contains(string))
				{
					list.add(string);
				}
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}






