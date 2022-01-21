package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FirstWindowController 
{
	@SuppressWarnings("unused")
	private Main main;
	@FXML TextField field;
	@FXML Button quitter;
	public void setMain(Main main) 
	{
		this.main=main;
	}
	public void handleSoumettre()
	{
		String nom=field.getText();
		if(nom.trim().length()>0){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText("Bienvenue!");
			alert.setContentText("Bienvenue à "+ nom);
			alert.showAndWait();
			field.clear();
		}
	}
	public void quitter()
	{
		Main.handle(null);
	}
}
