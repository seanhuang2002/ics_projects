package adress.view;

import adress.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class BloodPressureWindowController{
	@FXML
	private TextField sysText;
	@FXML
	private TextField disText;
	@SuppressWarnings("unused")
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
	public void input()
	{
		if(sysText.getText().equals("") || disText.getText().equals(""))
		{
			Alert alert=new Alert(AlertType.ERROR);
			alert.setHeaderText("Error");
			alert.setTitle("Error");
			alert.setContentText("Error Message: Please correctly indicate both your systolic and disatolic blood pressure. ");
			alert.show();
		}
		else if (Integer.parseInt(sysText.getText())<=120 && Integer.parseInt(disText.getText())<=80)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("Your blood pressure is normal");
			alert.show();
		}
		else
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("Your blood pressure is not normal, you are in the stages of Prehypertension and/or have Hypertension");
			alert.show();
		}
	}
	
}