/*


	To calculate the priceProperty (total price of a transaction)
	Get the value from OrderController
*/
package application.classes;



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
	private DoubleProperty priceProperty;


	
	public Transaction (int id, int studentId, String date, Double price)
	{
		this.idProperty=new SimpleIntegerProperty(id);
		this.studentIdProperty=new SimpleIntegerProperty(studentId);
		this.setDateProperty(new SimpleStringProperty(date));
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


	public double getPrice() {
		return priceProperty.get();
	}
	public void setPrice(double a) {
		this.priceProperty.set(a);
	}
	public DoubleProperty getPriceProperty() {
		return priceProperty;
	}
	public void setPriceProperty(DoubleProperty studentIdProperty) {
		this.priceProperty = studentIdProperty;
	}

	
	public StringProperty getDateProperty() {
		return dateProperty;
	}
	public void setDateProperty(StringProperty dateProperty) {
		this.dateProperty = dateProperty;
	}
	public String getDate() {
		return dateProperty.get();
	}
	public void setDate(String a) {
		this.dateProperty.set(a);
	}





}
