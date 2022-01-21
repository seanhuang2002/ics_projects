package application.fuctions;

import java.sql.ResultSet;
import java.sql.SQLException;

import application.DatabaseUtilities;
import application.model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CustomerFunctions {
	public static void insertNewCustomer(String company, String lastName, String firstName, String email, String jobTitle, 
			String busPhone, String homePhone, String mobilePhone, String faxNumber, String address, String city, String province, String postalCode, String country)
	{
		String sql ="insert into customers(company, last_name, first_name, email_address, job_title, business_phone, home_phone,"
				+ " mobile_phone, fax_number, address, city, state_province, zip_postal_code, country_region) "
				+ "values('"+company+"','"+lastName+"','"+firstName+"','"+email+"','"+jobTitle+"','"+busPhone+"',"
				+ "'"+homePhone+"','"+mobilePhone+"','"+faxNumber+"','"+address+"','"+city+"','"+province+"','"+postalCode+"','"+country+"')";
		try {
			DatabaseUtilities.dbExecuteQuery(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertNewEmployee(String code, String lastName, String firstName, String email, String jobTitle, 
			String busPhone, String homePhone, String mobilePhone, String faxNumber, String address, String city, String province, String postalCode, String country)
	{
		String sql ="insert into employees(company,last_name,first_name,email_address,job_title,business_phone,home_phone,"
				+ "mobile_phone,fax_number,address,city,state_province,zip_postal_code,country_region) values('Northwind Traders',"
				+ "'"+lastName+"','"+firstName+"','"+email+"','"+jobTitle+"','"+busPhone+"','"+homePhone+"','"+mobilePhone+"','"+faxNumber+"',"
				+ "'"+address+"','"+city+"','"+province+"','"+postalCode+"','"+country+"')";
		if(checkCode(code))
		{
			try {
				System.out.println("DONE");
				DatabaseUtilities.dbExecuteQuery(sql);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Invalid Access Code");
		}
	}
	
	public static boolean checkCode(String code)
	{
		//TODO create a database of codes 
		if(code.equals("code123"))
		{
			return true;
		}
		return false;
	}
	
	public static ObservableList<Customer> getAllCustomer() throws ClassNotFoundException, SQLException
	{
		try {
			String sql="select * from customers";
			ResultSet rsSet=DatabaseUtilities.dbExecute(sql);
			ObservableList<Customer> customerList=getCustomerObjects(rsSet);
			return customerList;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public static ObservableList<Customer> getCustomerObjects(ResultSet rsSet) throws ClassNotFoundException, SQLException
	{
		try {
			ObservableList<Customer> customerList=FXCollections.observableArrayList();
			while(rsSet.next())
			{
				Customer cus = new Customer(rsSet.getString("last_name"), rsSet.getString("first_name"));
				cus.setCompany(rsSet.getString("company"));
				cus.setEmail(rsSet.getString("email_address"));
				cus.setJobTitle(rsSet.getString("job_title"));
				cus.setBusinessPhone(rsSet.getString("business_phone"));
				cus.setHomePhone(rsSet.getString("home_phone"));
				cus.setMobilePhone(rsSet.getString("mobile_phone"));
				cus.setFaxNumber(rsSet.getString("fax_number"));
				cus.setAddress(rsSet.getString("address"));
				cus.setCity(rsSet.getString("city"));
				cus.setProvince(rsSet.getString("state_province"));
				cus.setPostalCode(rsSet.getString("zip_postal_code"));
				cus.setCountry(rsSet.getString("country_region"));
				cus.setId(rsSet.getInt("id"));
				customerList.add(cus);
			}
			return customerList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public static Customer getUniqueCustomer(int customerId) throws ClassNotFoundException, SQLException
	{
		Customer selectedCustomer = new Customer("","");
		try {
			ObservableList<Customer> customerList = CustomerFunctions.getAllCustomer();
			for(int i=0;i<customerList.size();i++)
			{
				Customer cus=customerList.get(i);
				if(cus.getId()==customerId)
				{
					selectedCustomer=cus;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return selectedCustomer;
	}
	//TODO create same for employee
	public static int getCutomerIdFromName(String firstName, String lastName) throws ClassNotFoundException, SQLException
	{
		int returnValue=0;
		try {
			ObservableList<Customer> CustomerList=FXCollections.observableArrayList();
			CustomerList=getAllCustomer();
			for(int i=0;i<CustomerList.size();i++)
			{
				Customer cus = CustomerList.get(i);
				if(cus.getFirstName().equals(firstName)&&cus.getLastName().equals(lastName))
				{
					returnValue=cus.getId();
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return returnValue;
	}
}



















