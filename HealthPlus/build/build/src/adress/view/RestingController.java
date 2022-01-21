package adress.view;

import java.net.URL;
import java.util.ResourceBundle;

import adress.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class RestingController {
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
	@FXML
	public ComboBox<String> comboBox;

	public ObservableList<String> combolist =
			FXCollections.observableArrayList(
					"18-25",
					"26-35",
					"36-45",
					"45-55",
					"55-65",
					"65+"
					);

	public void initialize(URL location, ResourceBundle resources)
	{
		comboBox.setItems(combolist);
		comboBox.getItems().addAll(
				"18-25",
				"26-35",
				"36-45",
				"45-55",
				"55-65",
				"65+"
				);
	}

	int input;
	public void comboChanged(ActionEvent event)
	{
		if(field.getText().equals(""))
		{
			Alert alert=new Alert(AlertType.ERROR);
			alert.setHeaderText("Error");
			alert.setTitle("Error");
			alert.setContentText("Please entre your resting heart rate in the textfield.");
			alert.show();
		}
		else
		{
			input = Integer.parseInt(field.getText());
			if(maleButton.isSelected())
			{
				male(input);
			}
			else if(femaleButton.isSelected())
			{
				female(input);
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
		String option = comboBox.getValue();
		if(option.equals("18-25"))
		{
			if(a<61)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an excellent resting heart rate.");
				alert.show();
			}
			else if(a<69)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a good resting heart rate.");
				alert.show();
			}
			else if(a<73)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an average resting heart rate.");
				alert.show();
			}
			else if(a<81)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a below average resting heart rate. You should strive to increase your cardio capacities.");
				alert.show();
			}
			else if(a>82)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a poor resting heart rate. You need to increase your cardio capacities.");
				alert.show();
			}
		}
		else if(option.equals("26-35"))
		{
			if(a<61)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an excellent resting heart rate.");
				alert.show();
			}
			else if(a<70)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a good resting heart rate.");
				alert.show();
			}
			else if(a<74)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an average resting heart rate.");
				alert.show();
			}
			else if(a<81)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a below average resting heart rate. You should strive to increase your cardio capacities.");
				alert.show();
			}
			else if(a>82)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a poor resting heart rate. You need to increase your cardio capacities.");
				alert.show();
			}
		}
		else if(option.equals("36-45"))
		{
			if(a<62)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an excellent resting heart rate.");
				alert.show();
			}
			else if(a<70)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a good resting heart rate.");
				alert.show();
			}
			else if(a<75)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an average resting heart rate.");
				alert.show();
			}
			else if(a<82)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a below average resting heart rate. You should strive to increase your cardio capacities.");
				alert.show();
			}
			else if(a>83)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a poor resting heart rate. You need to increase your cardio capacities.");
				alert.show();
			}
		}
		else if(option.equals("46-55"))
		{
			if(a<63)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an excellent resting heart rate.");
				alert.show();
			}
			else if(a<71)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a good resting heart rate.");
				alert.show();
			}
			else if(a<76)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an average resting heart rate.");
				alert.show();
			}
			else if(a<83)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a below average resting heart rate. You should strive to increase your cardio capacities.");
				alert.show();
			}
			else if(a>84)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a poor resting heart rate. You need to increase your cardio capacities.");
				alert.show();
			}
		}
		else if(option.equals("56-65"))
		{
			if(a<61)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an excellent resting heart rate.");
				alert.show();
			}
			else if(a<71)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a good resting heart rate.");
				alert.show();
			}
			else if(a<75)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an average resting heart rate.");
				alert.show();
			}
			else if(a<81)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a below average resting heart rate. You should strive to increase your cardio capacities.");
				alert.show();
			}
			else if(a>82)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a poor resting heart rate. You need to increase your cardio capacities.");
				alert.show();
			}
		}
		else if(option.equals("65+"))
		{
			if(a<61)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an excellent resting heart rate.");
				alert.show();
			}
			else if(a<69)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a good resting heart rate.");
				alert.show();
			}
			else if(a<73)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an average resting heart rate.");
				alert.show();
			}
			else if(a<79)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a below average resting heart rate. You should strive to increase your cardio capacities.");
				alert.show();
			}
			else if(a>80)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a poor resting heart rate. You need to increase your cardio capacities.");
				alert.show();
			}
		}
		else
		{
			Alert alert=new Alert(AlertType.ERROR);
			alert.setHeaderText("Error");
			alert.setTitle("Error");
			alert.setContentText("Please choose an age group.");
			alert.show();
		}
	}
	public void female(int a)
	{
		String option = comboBox.getValue();
		if(option.equals("18-25"))
		{
			if(a<65)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an excellent resting heart rate.");
				alert.show();
			}
			else if(a<73)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a good resting heart rate.");
				alert.show();
			}
			else if(a<78)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an average resting heart rate.");
				alert.show();
			}
			else if(a<84)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a below average resting heart rate. You should strive to increase your cardio capacities.");
				alert.show();
			}
			else if(a>85)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a poor resting heart rate. You need to increase your cardio capacities.");
				alert.show();
			}
		}
		else if(option.equals("26-35"))
		{
			if(a<64)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an excellent resting heart rate.");
				alert.show();
			}
			else if(a<72)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a good resting heart rate.");
				alert.show();
			}
			else if(a<76)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an average resting heart rate.");
				alert.show();
			}
			else if(a<82)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a below average resting heart rate. You should strive to increase your cardio capacities.");
				alert.show();
			}
			else if(a>83)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a poor resting heart rate. You need to increase your cardio capacities.");
				alert.show();
			}
		}
		else if(option.equals("36-45"))
		{
			if(a<64)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an excellent resting heart rate.");
				alert.show();
			}
			else if(a<73)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a good resting heart rate.");
				alert.show();
			}
			else if(a<78)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an average resting heart rate.");
				alert.show();
			}
			else if(a<84)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a below average resting heart rate. You should strive to increase your cardio capacities.");
				alert.show();
			}
			else if(a>85)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a poor resting heart rate. You need to increase your cardio capacities.");
				alert.show();
			}
		}
		else if(option.equals("46-55"))
		{
			if(a<65)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an excellent resting heart rate.");
				alert.show();
			}
			else if(a<73)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a good resting heart rate.");
				alert.show();
			}
			else if(a<77)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an average resting heart rate.");
				alert.show();
			}
			else if(a<83)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a below average resting heart rate. You should strive to increase your cardio capacities.");
				alert.show();
			}
			else if(a>84)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a poor resting heart rate. You need to increase your cardio capacities.");
				alert.show();
			}
		}
		else if(option.equals("56-65"))
		{
			if(a<64)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an excellent resting heart rate.");
				alert.show();
			}
			else if(a<73)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a good resting heart rate.");
				alert.show();
			}
			else if(a<77)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an average resting heart rate.");
				alert.show();
			}
			else if(a<83)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a below average resting heart rate. You should strive to increase your cardio capacities.");
				alert.show();
			}
			else if(a>84)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a poor resting heart rate. You need to increase your cardio capacities.");
				alert.show();
			}
		}
		else if(option.equals("65+"))
		{
			if(a<64)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an excellent resting heart rate.");
				alert.show();
			}
			else if(a<72)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a good resting heart rate.");
				alert.show();
			}
			else if(a<76)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have an average resting heart rate.");
				alert.show();
			}
			else if(a<84)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a below average resting heart rate. You should strive to increase your cardio capacities.");
				alert.show();
			}
			else if(a>85)
			{
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Results");
				alert.setTitle("Results");
				alert.setContentText("You have a poor resting heart rate. You need to increase your cardio capacities.");
				alert.show();
			}
		}
		else
		{
			Alert alert=new Alert(AlertType.ERROR);
			alert.setHeaderText("Error");
			alert.setTitle("Error");
			alert.setContentText("Please choose an age group.");
			alert.show();
		}
	}
	public void goBack()
	{
		secondaryStage.close();
	}

}
