package adress.view;

import adress.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WaistWindowController {

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
	int per;
	public void goBack()
	{
		secondaryStage.close();
	}
	public void enter()
	{
		if(field.getText().equals(""))
		{
			Alert alert=new Alert(AlertType.ERROR);
			alert.setHeaderText("Error");
			alert.setTitle("Error");
			alert.setContentText("Please entre your waist circumference in the textfield.");
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
		if(a<78)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("You have a low waist. If you are not an athlete, you must gain some weight.");
			alert.show();
		}
		else if (a<94)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("You have a healthy waist girth.");
			alert.show();
		}
		else if (a<102)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("You have a higher waist girth, you should lose some weight.");
			alert.show();
		}
		else
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("You have an extremely high waist girth, you must lose a lot of weight.");
			alert.show();
		}
	}
	public void female(int a)
	{
		if(a<64)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("You have a low waist. If you are not an athlete, you must gain some weight.");
			alert.show();
		}
		else if (a<80)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("You have a healthy waist girth.");
			alert.show();
		}
		else if (a<88)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("You have a higher waist girth, you should lose some weight.");
			alert.show();
		}
		else
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Results");
			alert.setTitle("Results");
			alert.setContentText("You have an extremely high waist girth, you must lose a lot of weight.");
			alert.show();
		}
	}

}