package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
	private StringProperty firstNameProperty;
	private StringProperty lastNameProperty;
	private IntegerProperty studentIdProperty;
	private IntegerProperty studentGradeProperty;
	private StringProperty parent1EmailProperty;
	private StringProperty parent2EmailProperty;
	private StringProperty parent1NameProperty;
	private StringProperty parent2NameProperty;
	public Student(String firstName, String lastName)
	{
		this.firstNameProperty=new SimpleStringProperty(firstName);
		this.lastNameProperty=new SimpleStringProperty(lastName);
		this.studentIdProperty=new SimpleIntegerProperty();
		this.studentGradeProperty=new SimpleIntegerProperty();
		this.parent1EmailProperty=new SimpleStringProperty();
		this.parent2EmailProperty=new SimpleStringProperty();
		this.parent1NameProperty=new SimpleStringProperty();
		this.parent2NameProperty=new SimpleStringProperty();
	}
	
	public String getFirstName() {
		return firstNameProperty.get();
	}
	public void setFirstName(String a) {
		this.firstNameProperty.set(a);
	}
	public StringProperty getFirstNameProperty() {
		return firstNameProperty;
	}
	public void setFirstNameProperty(StringProperty firstNameProperty) {
		this.firstNameProperty = firstNameProperty;
	}
	public StringProperty firstNameProperty() {
		return firstNameProperty;
	}
	
	
	public String getLastName() {
		return lastNameProperty.get();
	}
	public void setLasttName(String a) {
		this.lastNameProperty.set(a);
	}
	public StringProperty getLastNameProperty() {
		return lastNameProperty;
	}
	public void setLastNameProperty(StringProperty lastNameProperty) {
		this.lastNameProperty = lastNameProperty;
	}
	public StringProperty lastNameProperty() {
		return lastNameProperty;
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
	
	
	public int getStudentGrade() {
		return studentGradeProperty.get();
	}
	public void setStudentGrade(int a) {
		this.studentGradeProperty.set(a);
	}
	public IntegerProperty getStudentGradeProperty() {
		return studentGradeProperty;
	}
	public void setStudentGradeProperty(IntegerProperty studentGradeProperty) {
		this.studentGradeProperty = studentGradeProperty;
	}
	public IntegerProperty parent1Email() {
		return studentGradeProperty;
	}
	
	
	public String getParent1Email() {
		return parent1EmailProperty.get();
	}
	public void setParent1Email(String a) {
		this.parent1EmailProperty.set(a);
	}
	public StringProperty getParent1EmailProperty() {
		return parent1EmailProperty;
	}
	public void setParent1EmailProperty(StringProperty parent1EmailProperty) {
		this.parent1EmailProperty = parent1EmailProperty;
	}
	public StringProperty parent1EmailProperty() {
		return parent1EmailProperty;
	}
	
	
	public String getParent2Email() {
		return parent2EmailProperty.get();
	}
	public void setParent2Email(String a) {
		this.parent2EmailProperty.set(a);
	}
	public StringProperty getParent2EmailProperty() {
		return parent2EmailProperty;
	}
	public void setParent2EmailProperty(StringProperty parent1EmailProperty) {
		this.parent2EmailProperty = parent1EmailProperty;
	}
	public StringProperty parent2EmailProperty() {
		return parent2EmailProperty;
	}

	
	public String getParent1Name() {
		return parent1NameProperty.get();
	}
	public void setParent1Name(String a) {
		this.parent1NameProperty.set(a);
	}
	public StringProperty getParent1NameProperty() {
		return parent1NameProperty;
	}
	public void setParent1NameProperty(StringProperty parent1NameProperty) {
		this.parent1NameProperty = parent1NameProperty;
	}
	public StringProperty parent1NameProperty() {
		return parent1NameProperty;
	}
	
	
	public String getParent2Name() {
		return parent2NameProperty.get();
	}
	public void setParent2Name(String a) {
		this.parent2NameProperty.set(a);
	}
	public StringProperty getParent2NameProperty() {
		return parent2NameProperty;
	}
	public void setParent2NameProperty(StringProperty parent1NameProperty) {
		this.parent2NameProperty = parent1NameProperty;
	}
	public StringProperty parent2NameProperty() {
		return parent2NameProperty;
	}
	
	

}
