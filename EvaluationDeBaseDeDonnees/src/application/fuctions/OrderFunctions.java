package application.fuctions;

import java.sql.ResultSet;
import java.sql.SQLException;

import application.DatabaseUtilities;
import application.model.Order;
import application.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OrderFunctions {
	public static void deleteOrder(int orderId) throws ClassNotFoundException, SQLException 
	{
		String sql1 = "delete from order_details where order_id="+orderId;
		String sql2 = "delete from orders where id="+orderId;
		DatabaseUtilities.dbExecuteQuery(sql1);
		DatabaseUtilities.dbExecuteQuery(sql2);
	}
	
	public static ObservableList<Order> getAllOrders() throws ClassNotFoundException, SQLException
	{
		String sql ="select * from orders";
		try {
			ResultSet rsSet=DatabaseUtilities.dbExecute(sql);
			System.out.println("1");
			ObservableList<Order> OrderList=getOrderObjects(rsSet);
			System.out.println("2");
			return OrderList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static ObservableList<Order> getOrderObjects(ResultSet rsSetOrders) throws ClassNotFoundException, SQLException
	{
		try {
			ObservableList<Order> orderList =FXCollections.observableArrayList();
			while(rsSetOrders.next())
			{
				Order order = new Order(rsSetOrders.getInt("customer_id"),rsSetOrders.getInt("employee_id"));
				order.setOrderId(rsSetOrders.getInt("id"));
				order.setSalesRepName(getEmployeeName(rsSetOrders.getInt("employee_id")));
				order.setPayment(rsSetOrders.getString("payment_type"));
				//work out the proper format for dates in sql
				order.setStatus(getStatusDescriptions(rsSetOrders.getInt("status_id")));
				order.setShipper(getShipperDescriptions(rsSetOrders.getInt("shipper_id")));
				order.setShippingName(getCustomerName(rsSetOrders.getInt("customer_id")));
				order.setShippingAddress(rsSetOrders.getString("ship_address"));
				order.setShippingCity(rsSetOrders.getString("ship_city"));
				order.setShippingCountry(rsSetOrders.getString("ship_country_region"));
				order.setShippingPostalCode(rsSetOrders.getString("ship_zip_postal_code"));
				order.setShippingProvince(rsSetOrders.getString("ship_state_province"));
				ObservableList<Product> list = FXCollections.observableArrayList();
				list=getAllProductsFromOrder(order.getOrderId());
				for(int i=0;i<list.size()&&i<6;i++)
				{
					Product prod = list.get(i);
					switch(i) {
					case 0:
						order.setProduct1Name(prod.getName());
						order.setProduct1Quantity(prod.getQuantity());
						break;
					case 1:
						order.setProduct2Name(prod.getName());
						order.setProduct2Quantity(prod.getQuantity());
						break;
					case 2:
						order.setProduct3Name(prod.getName());
						order.setProduct3Quantity(prod.getQuantity());
						break;
					case 3:
						order.setProduct4Name(prod.getName());
						order.setProduct4Quantity(prod.getQuantity());
						break;
					case 4:
						order.setProduct5Name(prod.getName());
						order.setProduct5Quantity(prod.getQuantity());
						break;
					case 5:
						order.setProduct6Name(prod.getName());
						order.setProduct6Quantity(prod.getQuantity());
						break;
					}
				}
				orderList.add(order);
			}
			//
			return orderList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}	
	}

	public static void insertOrder(Order order, int numberOfProducts) throws ClassNotFoundException, SQLException	
	{
		String sql="";
		int orderId=0;
		String sqlQuery ="insert into orders(employee_id, customer_id,shipper_id,ship_name,"
				+ "ship_address,ship_city,ship_state_province, ship_zip_postal_code, ship_country_region, "
				+ "payment_type) values('"+order.getEmpId()+"', '"+order.getCusId()+"', '"+order.getShipper()+"',"
				+ "'"+order.getShippingName()+"', '"+order.getShippingAddress()+"', '"+order.getShippingCity()+"',"
				+ "'"+order.getShippingProvince()+"', '"+order.getShippingPostalCode()+"', '"+order.getShippingCountry()+"',"
				+ "'"+order.getPaymentType()+"');";
		ResultSet rsSet= DatabaseUtilities.dbExecuteQueryWithIdReturn(sqlQuery);
		while(rsSet.next())
		{
			orderId=(int) rsSet.getLong(1);
		}
		System.out.println(numberOfProducts);
		if(numberOfProducts==1)
		{
			sql = "insert into order_details(order_id,product_id,quantity,status_id) values"
					+ "('"+orderId+"','"+ProductFunctions.getProductId(order.getProduct1Name())+"','"+order.getProduct1Quantity()+"','1')";
		}
		else if(numberOfProducts==2)
		{
			sql = "insert into order_details(order_id,product_id,quantity,status_id) values"
					+ "('"+orderId+"','"+ProductFunctions.getProductId(order.getProduct1Name())+"','"+order.getProduct1Quantity()+"','1'),"
					+ "('"+orderId+"','"+ProductFunctions.getProductId(order.getProduct2Name())+"','"+order.getProduct2Quantity()+"','1')";
		}
		else if(numberOfProducts==3)
		{
			sql = "insert into order_details(order_id,product_id,quantity,status_id) values"
					+ "('"+orderId+"','"+ProductFunctions.getProductId(order.getProduct1Name())+"','"+order.getProduct1Quantity()+"','1'),"
					+ "('"+orderId+"','"+ProductFunctions.getProductId(order.getProduct2Name())+"','"+order.getProduct2Quantity()+"','1'),"
					+ "('"+orderId+"','"+ProductFunctions.getProductId(order.getProduct3Name())+"','"+order.getProduct3Quantity()+"','1')";
		}
		else if(numberOfProducts==4)
		{
			sql = "insert into order_details(order_id,product_id,quantity,status_id) values"
					+ "('"+orderId+"','"+ProductFunctions.getProductId(order.getProduct1Name())+"','"+order.getProduct1Quantity()+"','1'),"
					+ "('"+orderId+"','"+ProductFunctions.getProductId(order.getProduct2Name())+"','"+order.getProduct2Quantity()+"','1'),"
					+ "('"+orderId+"','"+ProductFunctions.getProductId(order.getProduct3Name())+"','"+order.getProduct3Quantity()+"','1'),"
					+ "('"+orderId+"','"+ProductFunctions.getProductId(order.getProduct4Name())+"','"+order.getProduct4Quantity()+"','1')";
		}
		else if(numberOfProducts==5)
		{
			sql = "insert into order_details(order_id,product_id,quantity,status_id) values"
					+ "('"+orderId+"','"+ProductFunctions.getProductId(order.getProduct1Name())+"','"+order.getProduct1Quantity()+"','1'),"
					+ "('"+orderId+"','"+ProductFunctions.getProductId(order.getProduct2Name())+"','"+order.getProduct2Quantity()+"','1'),"
					+ "('"+orderId+"','"+ProductFunctions.getProductId(order.getProduct3Name())+"','"+order.getProduct3Quantity()+"','1'),"
					+ "('"+orderId+"','"+ProductFunctions.getProductId(order.getProduct4Name())+"','"+order.getProduct4Quantity()+"','1'),"
					+ "('"+orderId+"','"+ProductFunctions.getProductId(order.getProduct5Name())+"','"+order.getProduct5Quantity()+"','1')";
		}
		else if(numberOfProducts==6)
		{
			sql = "insert into order_details(order_id,product_id,quantity,status_id) values"
				+ "('"+orderId+"','"+ProductFunctions.getProductId(order.getProduct1Name())+"','"+order.getProduct1Quantity()+"','1'),"
				+ "('"+orderId+"','"+ProductFunctions.getProductId(order.getProduct2Name())+"','"+order.getProduct2Quantity()+"','1'),"
				+ "('"+orderId+"','"+ProductFunctions.getProductId(order.getProduct3Name())+"','"+order.getProduct3Quantity()+"','1'),"
				+ "('"+orderId+"','"+ProductFunctions.getProductId(order.getProduct4Name())+"','"+order.getProduct4Quantity()+"','1'),"
				+ "('"+orderId+"','"+ProductFunctions.getProductId(order.getProduct5Name())+"','"+order.getProduct5Quantity()+"','1'),"
				+ "('"+orderId+"','"+ProductFunctions.getProductId(order.getProduct6Name())+"','"+order.getProduct6Quantity()+"','1')";
		}
		DatabaseUtilities.dbExecuteQuery(sql);

	}

	public static ObservableList<Order> getOrdersByCustomer(int customerId) throws ClassNotFoundException, SQLException

	{
		String sql ="select * from orders where customer_id="+customerId;
		ResultSet rsSet = DatabaseUtilities.dbExecute(sql);
		ObservableList<Order> list = getOrderObjects(rsSet);
		return list;
	}

	public static ObservableList<Order> getOrdersByEmployee(int employeeId) throws ClassNotFoundException, SQLException
	{
		String sql ="select * from orders where employee_id="+employeeId;
		ResultSet rsSet = DatabaseUtilities.dbExecute(sql);
		ObservableList<Order> list = getOrderObjects(rsSet);
		return list;
	}

	public static ObservableList<Product> getAllProductsFromOrder(int orderId)throws ClassNotFoundException, SQLException
	{
		try {
			String sql = "select * from order_details where order_id="+orderId;
			ResultSet rsSet = DatabaseUtilities.dbExecute(sql);
			ObservableList<Product> list = FXCollections.observableArrayList();
			while(rsSet.next())
			{
				Product prod = new Product(getProductName(rsSet.getInt("product_id")),rsSet.getBigDecimal("quantity").intValue());
				list.add(prod);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	public static String getProductName(int id)
	{
		String returnValue="";
		return returnValue;
	}

	public static String getEmployeeName(int id) throws ClassNotFoundException, SQLException
	{
		try {
			String returnValue="";
			ResultSet rsSet=DatabaseUtilities.dbExecute("select * from employees");
			while(rsSet.next())
			{
				if(rsSet.getInt("id")==id)
				{
					returnValue=rsSet.getString("first_name")+" "+rsSet.getString("last_name");
				}
			}
			return returnValue;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	public static String getCustomerName(int id) throws ClassNotFoundException, SQLException
	{
		try {
			String returnValue="";
			ResultSet rsSet=DatabaseUtilities.dbExecute("select * from customers");
			while(rsSet.next())
			{
				if(rsSet.getInt("id")==id)
				{
					returnValue=rsSet.getString("first_name")+" "+rsSet.getString("last_name");
				}
			}
			return returnValue;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	public static String getShipperDescriptions(int id) throws ClassNotFoundException, SQLException
	{
		try {
			String returnValue="";
			ResultSet rsSet=DatabaseUtilities.dbExecute("select * from shippers");
			while(rsSet.next())
			{
				if(rsSet.getInt("id")==id)
				{
					returnValue=rsSet.getString("company");
				}
			}
			return returnValue;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static String getStatusDescriptions(int id) throws ClassNotFoundException, SQLException
	{
		try {
			String returnValue="";
			ResultSet rsSet=DatabaseUtilities.dbExecute("select * from orders_status");
			while(rsSet.next())
			{
				if(rsSet.getInt("id")==id)
				{
					returnValue=rsSet.getString("status_name");
				}
			}
			return returnValue;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

}	














