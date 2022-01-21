package adress.view;


import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import adress.model.Entry;
import javafx.beans.property.SimpleDoubleProperty;

import javafx.beans.property.SimpleObjectProperty;
//@XmlRootElement(name = "entries")

public class EntryTableData {
	SimpleDoubleProperty weight= new SimpleDoubleProperty();
	SimpleDoubleProperty height= new SimpleDoubleProperty();
	SimpleDoubleProperty bloodpressure= new SimpleDoubleProperty();
	SimpleDoubleProperty bloodsugar= new SimpleDoubleProperty();
	SimpleDoubleProperty waist= new SimpleDoubleProperty();
	SimpleDoubleProperty heartrate= new SimpleDoubleProperty();
	SimpleDoubleProperty bodyfat= new SimpleDoubleProperty();
	SimpleDoubleProperty bmi= new SimpleDoubleProperty();
    SimpleObjectProperty <Date > dateOfBirth= new SimpleObjectProperty<Date>();
    public EntryTableData(){}
    // added to create the model from the Person object, which might be data retrieved from a database 
    public EntryTableData(Entry p) {
        this.weight = new SimpleDoubleProperty(p.getWeight());
        this.height = new SimpleDoubleProperty(p.getHeight());
        this.dateOfBirth = new SimpleObjectProperty < Date > (
            p.getDateOfBirth());
        this.bloodpressure = new SimpleDoubleProperty(p.getBloodpressure());
        this.bloodsugar = new SimpleDoubleProperty(p.getBloodsugar());
        this.waist= new SimpleDoubleProperty(p.getWaist());
        this.heartrate=new SimpleDoubleProperty(p.getHeartrate());
        this.bodyfat=new SimpleDoubleProperty(p.getBodyfat());
        this.bmi=new SimpleDoubleProperty(p.getBmi());
    }
    public EntryTableData(double Weight, double Height, double BloodPressure,
    		double BloodSugar, double Waist, double HeartRate, double bodyFat, double Bmi,
        final Date date) {
        this.weight = new SimpleDoubleProperty(Weight);
        this.height = new SimpleDoubleProperty(Height);
        this.dateOfBirth = new SimpleObjectProperty < Date > (date);
        this.bloodpressure = new SimpleDoubleProperty(BloodPressure);
        this.bloodsugar = new SimpleDoubleProperty(BloodSugar);
        this.waist=new SimpleDoubleProperty(Waist);
        this.heartrate=new SimpleDoubleProperty(HeartRate);
        this.bodyfat=new SimpleDoubleProperty(bodyFat);
        this.bmi=new SimpleDoubleProperty(Bmi);
    }
    public double getWeight() {
        return weight.get();
    }
    public void setWeight(final double Weight) {
        this.weight.set(Weight);
    }
    public double getHeight() {
        return height.get();
    }
    public void setHeight(final double value) {
        this.height.set(value);
    }
    public Date getDateOfBirth() {
        return dateOfBirth.get();
    }
    public void setDateOfBirth(final Date value) {
        this.dateOfBirth.set(value);
    }
    public double getBloodPressure() {
        return bloodpressure.get();
    }
    public void setBloodPressure(final double bloodPressure) {
        this.bloodpressure.set(bloodPressure);
    }
    public double getBloodSugar() {
        return bloodsugar.get();
    }
    public void setBloodSugar(final double bloodsugarw) {
        this.bloodsugar.set(bloodsugarw);
    }
    public double getWaist() {
        return waist.get();
    }
    public void setWaist(final double Waist) {
        this.waist.set(Waist);
    }
    public double getHeartRate() {
        return heartrate.get();
    }
    public void setHeartRate(final double rate) {
        this.heartrate.set(rate);
    }
    public double getBodyFat() {
        return bodyfat.get();
    }
    public void setBodyFat(final double fat) {
        this.bodyfat.set(fat);
    }
    public double getBmi(){
    	return bmi.get();
    }
    public void setBmi(final double bmi){
    	this.bmi.set(bmi);
    }
}
