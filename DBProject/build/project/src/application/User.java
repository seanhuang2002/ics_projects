package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
	private StringProperty usernameProperty;
	private StringProperty passwordProperty;
	
	public User (String username, String password)
	{
		this.usernameProperty=new SimpleStringProperty(username);
		this.passwordProperty=new SimpleStringProperty(password);
	}

	public String getUsername() {
		return usernameProperty.get();
	}
	public void setUsername(String name) {
		this.usernameProperty.set(name);
	}
	public StringProperty getUsernameProperty() {
		return usernameProperty;
	}
	public void setUsernameProperty(StringProperty usernameProperty) {
		this.usernameProperty = usernameProperty;
	}

	public String getPassword() {
		return passwordProperty.get();
	}
	public void setPassword(String name) {
		this.passwordProperty.set(name);
	}
	public StringProperty getPasswordProperty() {
		return passwordProperty;
	}
	public void setPasswordProperty(StringProperty passwordProperty) {
		this.passwordProperty = passwordProperty;
	}
	
	

}
