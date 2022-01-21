package application.view;

import application.model.Order;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class OrderDetailsController {

	private Stage dialogStage;

	public void setDialogStage(Stage dialogStage, boolean modify, Order order) {
		this.dialogStage = dialogStage;
		initializeTextfields(modify);
	}

	public static void initializeTextfields(boolean modify)
	{
		if(modify)
		{
			//all textfields are .setDisable(false)
		}
		else if(modify==false)
		{
			//all textfields are .setDisable(true)
		}
	}

	public void closeWindow(boolean afterCreation)
	{
		if(afterCreation)
		{
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Information");
			alert.setTitle("INFO");
			alert.setContentText("Order sucessfully modified!");
			alert.show();
			dialogStage.close();
		}
		//if close button is pressed
		else if(afterCreation==false)
		{
			dialogStage.close();
		}
	}
}
