package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Transaction {
	private IntegerProperty idProperty;
	private StringProperty dateProperty;
	private IntegerProperty studentIdProperty;
	private IntegerProperty barcodeIdProperty;
	private DoubleProperty priceProperty;
	
	public Transaction (int id, int barcodeId, int studentId, String date, Double price)
	{
		this.idProperty=new SimpleIntegerProperty(id);
		this.barcodeIdProperty=new SimpleIntegerProperty(barcodeId);
		this.studentIdProperty=new SimpleIntegerProperty(studentId);
		this.dateProperty=new SimpleStringProperty(date);
		this.priceProperty=new SimpleDoubleProperty(price);
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
	public void setidProperty(IntegerProperty studentIdProperty) {
		this.idProperty = studentIdProperty;
	}
	public IntegerProperty idProperty() {
		return idProperty;
	}
	
	public int getStudentId() {
		return studentIdProperty.get();
	}
	public void setStudentId(int a) {
		this.studentIdProperty.set(a);
	}
	public IntegerProperty getStudentIdProperty() {
		return studentIdProperty;
	}
	public void setStudentIdProperty(IntegerProperty studentIdProperty) {
		this.studentIdProperty = studentIdProperty;
	}
	public IntegerProperty studentIdProperty() {
		return studentIdProperty;
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
