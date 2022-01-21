package application.classes;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Product {
	private IntegerProperty idProperty;
	private StringProperty barcodeIdProperty;
	private StringProperty productNameProperty;
	private DoubleProperty priceProperty;
	private DoubleProperty discountProperty; 
	
	public Product(){
		
	}
	
	public Product(int id, String barcodeId,String productName, double price) {
		this.idProperty=new SimpleIntegerProperty(id);
		this.barcodeIdProperty=new SimpleStringProperty(barcodeId);
		this.productNameProperty=new SimpleStringProperty(productName);
		this.priceProperty=new SimpleDoubleProperty(price);
		this.discountProperty=new SimpleDoubleProperty(0);
	}
	
	public Product(int id, String barcodeId,String productName, double price, double discount) {
		this.idProperty=new SimpleIntegerProperty(id);
		this.barcodeIdProperty=new SimpleStringProperty(barcodeId);
		this.productNameProperty=new SimpleStringProperty(productName);
		this.priceProperty=new SimpleDoubleProperty(price);
		this.discountProperty=new SimpleDoubleProperty(discount);
	}
	
	public int getId() {
		return idProperty.get();
	}
	public void setId(int a) {
		this.idProperty.set(a);
	}
	public IntegerProperty getIdProperty() {
		return idProperty;
	}
	public void setIdProperty(IntegerProperty idProperty) {
		this.idProperty = idProperty;
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
	
	
	public String getBarcodeId() {
		return barcodeIdProperty.get();
	}
	public void setBarcodeId(String a) {
		this.barcodeIdProperty.set(a);
	}
	public StringProperty getBarcodeIdProperty() {
		return barcodeIdProperty;
	}
	public void setBarcodeIdProperty(StringProperty barcodeIdProperty) {
		this.barcodeIdProperty = barcodeIdProperty;
	}
	
	
	public double getPrice() {
		return priceProperty.get();
	}
	public void setPrice(double a) {
		this.priceProperty.set(a);
	}
	public DoubleProperty getPriceProperty() {
		return priceProperty;
	}
	public void setPriceProperty(DoubleProperty priceProperty) {
		this.priceProperty = priceProperty;
	}
	
	
	public double getDiscount() {
		return discountProperty.get();
	}
	public void setDiscount(double a) {
		this.discountProperty.set(a);
	}
	public DoubleProperty getDiscountProperty() {
		return discountProperty;
	}
	public void setDiscountProperty(DoubleProperty studentIdProperty) {
		this.discountProperty = studentIdProperty;
	}
	
	public double calcPercentageDiscount (double _percentage, double _priceProduct) {
		return 100-((this.getPrice()-this.getDiscount())/this.getPrice());
	}
	
	public double calcFinalPrice () {
		return this.getPrice()-this.getDiscount();
	}
	
	@Override
	public String toString()
	{
		return priceProperty.toString();
	}
	
}