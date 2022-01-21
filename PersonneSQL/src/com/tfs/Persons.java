package com.tfs;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persons
{
	private IntegerProperty idProperty;
    private StringProperty firstNameProperty;
    private StringProperty lastNameProperty;
    private StringProperty addressProperty;
    private StringProperty phoneNumberProperty;
    
    
    public Persons()
    {
    	this.idProperty = new SimpleIntegerProperty();
        this.firstNameProperty = new SimpleStringProperty();
        this.lastNameProperty = new SimpleStringProperty();
        this.addressProperty = new SimpleStringProperty();
        this.phoneNumberProperty= new SimpleStringProperty();
    	
    }

   public int getId()
   {
	   return idProperty.get();
   }
   public void setId(int id)
   {
	   this.idProperty.set(id);
   }
    public IntegerProperty getPersonId() {
		return idProperty;
	}
	public void setIdProperty(IntegerProperty idProperty) {
		this.idProperty = idProperty;
	}

	
	public String getFirstName()
	{
		return firstNameProperty.get();
	}
	public void setFirstName(String firstName)
	{
		this.firstNameProperty.set(firstName);
	}
	public StringProperty getFirstNameProperty() {
		return firstNameProperty;
	}


	public void setFirstNameProperty(StringProperty firstNameProperty) {
		this.firstNameProperty = firstNameProperty;
	}


	public StringProperty getLastNameProperty() {
		return lastNameProperty;
	}


	public void setLastNameProperty(StringProperty lastNameProperty) {
		this.lastNameProperty = lastNameProperty;
	}

	public String getLastName()
	{
		return lastNameProperty.get();
	}
	public void setLastName(String lastName)
	{
		this.lastNameProperty.set(lastName);
	}
	
	

	public StringProperty getAddressProperty() {
		return addressProperty;
	}


	public void setAddressProperty(StringProperty addressProperty) {
		this.addressProperty = addressProperty;
	}

	public String getAddress()
	{
		return addressProperty.get();
	}
	public void setAddress(String address)
	{
		this.addressProperty.set(address);
	}
	

	public StringProperty getPhoneNumberProperty() {
		return phoneNumberProperty;
	}


	public void setPhoneNumberProperty(StringProperty phoneNumberProperty) {
		this.phoneNumberProperty = phoneNumberProperty;
	}
	public String getPhoneNumber()
	{
		return phoneNumberProperty.get();
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumberProperty.set(phoneNumber);
	}
	@Override
    public String toString() {
	 String nom=this.getFirstName() + " " +this.getLastName();
        return nom;  
    }

	

}
