package adress.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="entries")
public class Entry {
	
	private Date dateOfBirth;
	private double weight;
	private double height;
	private double bloodpressure;
	private double bloodsugar;
	private double waist;
	private double heartrate;
	private double bodyfat;
	private double bmi;

	public Entry(double weight, double height, double bloodPressure,
    		double bloodSugar, double waist, double heartRate, double bodyFat, double bmi,
            final Date date) {
		super();
		this.weight = weight;
		this.height = height;
		this.dateOfBirth = date;
		this.bloodpressure=bloodPressure;
		this.bloodsugar=bloodSugar;
		this.waist=waist;
		this.heartrate=heartRate;
		this.bmi=bmi;
		this.bodyfat=bodyFat;
	}

	public double getBmi()
	{
		return bmi;
	}
	
	public void setBmi(double w){
		this.bmi=w;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getBloodpressure() {
		return bloodpressure;
	}

	public void setBloodpressure(double bloodpressure) {
		this.bloodpressure = bloodpressure;
	}

	public double getBloodsugar() {
		return bloodsugar;
	}

	public void setBloodsugar(double bloodsugar) {
		this.bloodsugar = bloodsugar;
	}
	
	public double getWaist() {
		return waist;
	}

	public void setWaist(double waist) {
		this.waist = waist;
	}
	
	public double getHeartrate() {
		return heartrate;
	}

	public void setHeartrate(double hrate) {
		this.heartrate = hrate;
	}
	
	public double getBodyfat() {
		return bodyfat;
	}

	public void setBodyfat(double bodyfat) {
		this.bodyfat = bodyfat;
	}

}
