package adress.view;

import adress.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class BMIWindowController {
	@FXML
	private TextField fieldWeight;
	@FXML
	private TextField fieldHeight;
	@FXML
	private RadioButton rb1;//male
	@FXML
	private RadioButton rb2;//female
	private Main main;
	private Stage secondaryStage;
	
	public void setMain(Main main, Stage secondaryStage)
	{
		this.main=main;
		this.secondaryStage=secondaryStage;
	}
	public void goBack()
	{
		secondaryStage.close();
	}
	public void radios()
	{
		if(rb1.isSelected())
		{
			calculesM(Double.parseDouble(fieldWeight.getText()),Double.parseDouble(fieldHeight.getText()));
		}
		else if(rb2.isSelected())
		{
			calculesF(Double.parseDouble(fieldWeight.getText()),Double.parseDouble(fieldHeight.getText()));
		}
		else
		{
			Alert alert=new Alert(AlertType.ERROR);
			alert.setHeaderText("Error");
			alert.setTitle("Error");
			alert.setContentText("Please choose a sex.");
			alert.show();
		}
	}
	public void calculesM(double w, double h) 
	{
		double bmi = w/Math.pow(h, 2);
		if(bmi<20)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("Your BMI is low. Your weight is under the ideal weight. Gain some weight.");
			alert.show();
		}
		else if(bmi<25)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("Your BMI is normal");
			alert.show();
		}
		else if(bmi<30)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("Your BMI is moderate. You are overweight and should strive to lose weight.");
			alert.show();
		}
		else
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("Your BMI is high. You are obese and need to lose weight immediately.");
			alert.show();
		}
	
	}
	public void calculesF(double w, double h) 
	{
		double bmi = w/Math.pow(h, 2);
		if(bmi<19)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("Your BMI is low. Your weight is under the ideal weight. Gain some weight.");
			alert.show();
		}
		else if(bmi<24)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("Your BMI is normal");
			alert.show();
		}
		else if(bmi<29)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("Your BMI is moderate. You are overweight and should strive to lose weight.");
			alert.show();
		}
		else
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("Your BMI is high. You are obese and need to lose weight immediately.");
			alert.show();
		}
		
	}
	
}


