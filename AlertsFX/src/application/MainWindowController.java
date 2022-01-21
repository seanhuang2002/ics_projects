package application;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;

public class MainWindowController 
{
	@SuppressWarnings("unused")
	private Main main;
	public void setMain(Main main) 
	{
		this.main=main;
	}
	public void showAlert1()
	{
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Info-flash");
		alert.setTitle("INFO");
		alert.setContentText("Message important");
		alert.show();
	}
	public void showAlert2()
	{
		Alert alert=new Alert(AlertType.WARNING);
		alert.setHeaderText("Avertissement");
		alert.setTitle("Attntion");
		alert.setContentText("Message d'avertissement");
		alert.show();
	}
	public void showAlert3()
	{
		Alert alert=new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("Confirmation");
		alert.setTitle("Confirmation");
		alert.setContentText("Confirmer le message reçu !");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get()==ButtonType.OK)
		{
			System.out.println("Confirmation enregistrée");
		}
		else
		{
			System.out.println("Non confirmé");
		}
		alert.show();
	}
	public void showAlert4()
	{
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Entrée texte");
		dialog.setContentText("Inscris ton nom :");
		Optional<String> result=dialog.showAndWait();
		if(result.isPresent())
		{
			System.out.println(result.get());
		}
		//dialog.show();
	}

}
