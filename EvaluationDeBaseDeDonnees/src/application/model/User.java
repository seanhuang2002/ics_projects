package application.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
	IntegerProperty idProperty;
	IntegerProperty customerIdProperty;
	IntegerProperty employeeIdProperty;
	StringProperty usernameProperty;
	StringProperty passwordProperty;
	IntegerProperty employeeBooleanProperty;
	
	public User (String username, String password)
	{
		this.idProperty=new SimpleIntegerProperty();
		this.customerIdProperty=new SimpleIntegerProperty();
		this.employeeIdProperty=new SimpleIntegerProperty();
		this.employeeBooleanProperty=new SimpleIntegerProperty();
		this.passwordProperty=new SimpleStringProperty(password);
		this.usernameProperty=new SimpleStringProperty(username);
	}
	
	public int getId(){
		return idProperty.get();
	}
	public void setId(int value){
		idProperty.set(value);
	}
	public IntegerProperty idProperty(){
		return idProperty;
	}
	//
	public int getCustomerId(){
		return customerIdProperty.get();
	}
	public void setCustomerId(int value){
		customerIdProperty.set(value);
	}
	public IntegerProperty customerIdProperty(){
		return customerIdProperty;
	}
	//
	public int getEmployeeId(){
		return employeeIdProperty.get();
	}
	public void setEmployeeId(int value){
		employeeIdProperty.set(value);
	}
	public IntegerProperty employeeIdProperty(){
		return employeeIdProperty;
	}
	//
	public String getUsername(){
		return usernameProperty.get();
	}
	public void setUsername(String value){
		usernameProperty.set(value);
	}
	public StringProperty usernameProperty(){
		return usernameProperty;
	}
	//
	public String getPassword(){
		return passwordProperty.get();
	}
	public void setPassword(String value){
		passwordProperty.set(value);
	}
	public StringProperty passwordProperty(){
		return passwordProperty;
	}
	//
	public int getEmployeeBoolean(){
		return employeeBooleanProperty.get();
	}
	public void setEmployeeBoolean(int value){
		employeeBooleanProperty.set(value);
	}
	public IntegerProperty employeeBooleanProperty(){
		return employeeBooleanProperty;
	}
}

