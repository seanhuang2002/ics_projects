package adress.view;

import adress.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
//TODO error dialog for empty field
public class BloodSugarWindowController {
	@FXML
	private RadioButton rb1;
	@FXML
	private RadioButton rb2;
	@FXML
	private TextField field;
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
	public void radioSelect()
	{
		String gend="";
		if(rb1.isSelected())
		{
			if(field.getText().equals(""))
			{
				Alert alert=new Alert(AlertType.ERROR);
				alert.setHeaderText("Error");
				alert.setTitle("Error");
				alert.setContentText("Please entre your blood sugar levels in the textfield.");
				alert.show();
			}
			else
			{
				gend="mmol";
				calculesMMOL(Integer.parseInt(field.getText()));
			}
		}
		else if(rb2.isSelected())
		{
			if(field.getText().equals(""))
			{
				Alert alert=new Alert(AlertType.ERROR);
				alert.setHeaderText("Error");
				alert.setTitle("Error");
				alert.setContentText("Please entre your blood sugar levels in the textfield.");
				alert.show();
			}
			else
			{
				gend="mgdl";
				calculesMGDL(Integer.parseInt(field.getText()));
			}
		}
	}
	public void calculesMMOL(int a)
	{
		if(a>=4&&a<=6)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("Your blood glucose levels are normal");
			alert.show();
		}
		else if(a<=6.9)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("Your blood glucose levels are slightly elevated. You have prediabetes and should seek to reduce sugar intake.");
			alert.show();
		}
		else
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("Your blood glucose levels are high. You have type 2 diabetes and should seek to immediatly reduce sugar intake and seek medical attention.");
			alert.show();
		}
	}
	public void calculesMGDL(int a)
	{
		if(a>=70&&a<=99)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("Your blood glucose levels are normal");
			alert.show();
		}
		else if(a<=125)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("Your blood glucose levels are slightly elevated. You have prediabetes and should seek to reduce sugar intake.");
			alert.show();
		}
		else
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("Your blood glucose levels are high. You have type 2 diabetes and should seek to immediatly reduce sugar intake and seek medical attention.");
			alert.show();
		}
	}

}
