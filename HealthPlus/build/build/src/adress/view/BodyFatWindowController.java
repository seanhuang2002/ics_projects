package adress.view;

import adress.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class BodyFatWindowController {
	private Main main;
	private Stage secondaryStage;
	public void setMain(Main main, Stage secondaryStage)
	{
		this.main=main;
		this.secondaryStage=secondaryStage;
	}
	@FXML
	private TextField field;
	@FXML
	private RadioButton maleButton;
	@FXML
	private RadioButton femaleButton;

	public void goBack()
	{
		secondaryStage.close();
	}
	String st;
	int per;
	public void enter()
	{
		if(field.getText().equals(""))
		{
			Alert alert=new Alert(AlertType.ERROR);
			alert.setHeaderText("Error");
			alert.setTitle("Error");
			alert.setContentText("Please entre your body fat ratio in the textfield.");
			alert.show();
		}
		else
		{
			per = Integer.parseInt(field.getText());
			if(maleButton.isSelected())
			{
				male(per);
			}
			else if(femaleButton.isSelected())
			{
				female(per);
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
	}
	public void male(int a)
	{
		if (a<5)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("You have an extremely low ratio of fat, you must gain some weight.");
			alert.show();
		}
		else if(a<13)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("You have a low ratio of fat. If you are not an athlete, you must gain some weight.");
			alert.show();
		}
		else if (a<20)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("You have a healthy ratio of fat.");
			alert.show();
		}
		else if (a<27)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("You have a higher ratio of fat, you should lose some weight.");
			alert.show();
		}
		else
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("You have an extremely high ratio of fat, you must lose a lot of weight.");
			alert.show();
		}
	}
	public void female(int a)
	{
		if (a<13)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("You have an extremely low ratio of fat, you must gain some weight.");
			alert.show();
		}
		else if(a<20)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("You have a low ratio of fat. If you are not an athlete, you must gain some weight.");
			alert.show();
		}
		else if (a<31)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("You have a healthy ratio of fat.");
			alert.show();
		}
		else if (a<40)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("You have a higher ratio of fat, you should lose some weight.");
			alert.show();
		}
		else
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("You have an extremely high ratio of fat, you must lose a lot of weight.");
			alert.show();
		}
	}

}