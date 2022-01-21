package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Product {
	private IntegerProperty barcodeIdProperty;
	private StringProperty productNameProperty;
	private DoubleProperty priceProperty;
	public Product(int barcodeId,String productName, double price) {
		this.barcodeIdProperty=new SimpleIntegerProperty(barcodeId);
		this.productNameProperty=new SimpleStringProperty(productName);
		this.priceProperty=new SimpleDoubleProperty(price);
	}
	
	public String getProductName() {
		return productNameProperty.get();
	}
	public void setProductName(String a) {
		this.productNameProperty.set(a);
	}
	public StringProperty getProductNameProperty() {
		return productNameProperty;
	}
	public void setProductNameProperty(StringProperty firstNameProperty) {
		this.productNameProperty = firstNameProperty;
	}
	public StringProperty productNameProperty() {
		return productNameProperty;
	}
	
	
	public int getBarcodeId() {
		return barcodeIdProperty.get();
	}
	public void setBarcodeId(int a) {
		this.barcodeIdProperty.set(a);
	}
	public IntegerProperty getBarcodeIdProperty() {
		return barcodeIdProperty;
	}
	public void setBarcodeIdProperty(IntegerProperty studentIdProperty) {
		this.barcodeIdProperty = studentIdProperty;
	}
	public IntegerProperty barcodeIdProperty() {
		return barcodeIdProperty;
	}
	
	
	public double getPrice() {
		return priceProperty.get();
	}
	public void setPrice(int a) {
		this.priceProperty.set(a);
	}
	public DoubleProperty getPriceProperty() {
		return priceProperty;
	}
	public void setPriceProperty(DoubleProperty studentIdProperty) {
		this.priceProperty = studentIdProperty;
	}
	public DoubleProperty PriceProperty() {
		return priceProperty;
	}
}
