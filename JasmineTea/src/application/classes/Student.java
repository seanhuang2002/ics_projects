package application.classes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
	private StringProperty firstNameProperty;
	private StringProperty lastNameProperty;
	private IntegerProperty idProperty;
	private IntegerProperty studentIdProperty;
	private IntegerProperty studentGradeProperty;
	private StringProperty parent1EmailProperty;
	private StringProperty parent2EmailProperty;
	private StringProperty parent1NameProperty;
	private StringProperty parent2NameProperty;
	private StringProperty levelGradeProperty;
	public Student(int id, int studentId, String firstName, String lastName, int grade, String levelGrade, String Name1, String Email1, String Name2, String Email2)
	{
		this.firstNameProperty=new SimpleStringProperty(firstName);
		this.lastNameProperty=new SimpleStringProperty(lastName);
		this.idProperty=new SimpleIntegerProperty(id);
		this.studentIdProperty=new SimpleIntegerProperty(studentId);
		this.studentGradeProperty=new SimpleIntegerProperty(grade);
		this.parent1EmailProperty=new SimpleStringProperty(Email1);
		this.parent2EmailProperty=new SimpleStringProperty(Email2);
		this.parent1NameProperty=new SimpleStringProperty(Name1);
		this.parent2NameProperty=new SimpleStringProperty(Name2);
		this.levelGradeProperty=new SimpleStringProperty(levelGrade);
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

	
	public String getLevelGrade() {
		return levelGradeProperty.get();
	}
	public void setLevelGrade(String a) {
		this.levelGradeProperty.set(a);
	}
	public StringProperty getLevelGradeProperty() {
		return levelGradeProperty;
	}
	public void setLevelGradeProperty(StringProperty levelGradeProperty) {
		this.levelGradeProperty = levelGradeProperty;
	}
	
	

}
