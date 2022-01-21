package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Entry {

	private IntegerProperty idProperty;
	private StringProperty monthProperty;
	private StringProperty dayProperty;
	private StringProperty yearProperty;
	private StringProperty heightProperty;
	private StringProperty weightProperty;
	private StringProperty waistProperty;
	private StringProperty bodyFatProperty;
	private StringProperty sysProperty;
	private StringProperty diaProperty;
	private StringProperty bloodSugarProperty;
	private StringProperty heartRateProperty;
	private StringProperty bmiProperty;
	
	public Entry()
	{
		
	}
	
	public Entry(String month, String day, String year)
	{
		this.monthProperty=new SimpleStringProperty(month);
		this.dayProperty=new SimpleStringProperty(day);
		this.yearProperty=new SimpleStringProperty(year);
		this.idProperty=new SimpleIntegerProperty();
		this.heightProperty=new SimpleStringProperty();
		this.weightProperty=new SimpleStringProperty();
		this.waistProperty=new SimpleStringProperty();
		this.bodyFatProperty=new SimpleStringProperty();
		this.bloodSugarProperty=new SimpleStringProperty();
		this.sysProperty=new SimpleStringProperty();
		this.diaProperty=new SimpleStringProperty();
		this.heartRateProperty=new SimpleStringProperty();
		this.bmiProperty=new SimpleStringProperty();
	}

	//ID
	public int getId(){
		return idProperty.get();
	}
	public void setId(int day){
		idProperty.set(day);
	}
	public IntegerProperty idProperty(){
		return idProperty;
	}

	//Month
	public String getMonth(){
		return monthProperty.get();
	}
	public void setMonth(String day){
		monthProperty.set(day);
	}
	public StringProperty monthProperty(){
		return monthProperty;
	}

	//Day
	public String getDay(){
		return dayProperty.get();
	}
	public void setDay(String day){
		dayProperty.set(day);
	}
	public StringProperty dayProperty(){
		return dayProperty;
	}

	//Year
	public String getYear(){
		return yearProperty.get();
	}
	public void setYear(String day){
		yearProperty.set(day);
	}
	public StringProperty yearProperty(){
		return yearProperty;
	}

	//Height
	public String getHeight(){
		return heightProperty.get();
	}
	public void setHeight(String day){
		heightProperty.set(day);
	}
	public StringProperty heightProperty(){
		return heightProperty;
	}

	//Weight
	public String getWeight(){
		return weightProperty.get();
	}
	public void setWeight(String day){
		weightProperty.set(day);
	}
	public StringProperty weightProperty(){
		return weightProperty;
	}

	//Waist Circumference
	public String getWaist(){
		return waistProperty.get();
	}
	public void setWaist(String day){
		waistProperty.set(day);
	}
	public StringProperty waistProperty(){
		return waistProperty;
	}

	//Body Fat Percentage
	public String getBodyFat(){
		return bodyFatProperty.get();
	}
	public void setBodyFat(String day){
		bodyFatProperty.set(day);
	}
	public StringProperty bodyFatProperty(){
		return bodyFatProperty;
	}

	//Systolic pressure
	public String getSys(){
		return sysProperty.get();
	}
	public void setSys(String day){
		sysProperty.set(day);
	}
	public StringProperty sysProperty(){
		return sysProperty;
	}

	//Diastolic pressure
	public String getDia(){
		return diaProperty.get();
	}
	public void setDia(String day){
		diaProperty.set(day);
	}
	public StringProperty diaProperty(){
		return diaProperty;
	}

	//Blood Sugar
	public String getBloodSugar(){
		return bloodSugarProperty.get();
	}
	public void setBloodSugar(String day){
		bloodSugarProperty.set(day);
	}
	public StringProperty bloodSugarProperty(){
		return bloodSugarProperty;
	}
	
	//Resting Heart Rate
	public String getHeartRate(){
		return heartRateProperty.get();
	}
	public void setHeartRate(String day){
		heartRateProperty.set(day);
	}
	public StringProperty heartRateProperty(){
		return heartRateProperty;
	}

	//BMI
	public String getBmi(){
		return bmiProperty.get();
	}
	public void setBmi(String day){
		bmiProperty.set(day);
	}
	public StringProperty bmiProperty(){
		return bmiProperty;
	}
}
