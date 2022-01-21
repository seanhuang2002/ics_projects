package application;

import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class FirstWindowController {
	@SuppressWarnings("unused")
	private Main main;
	@FXML Button btnSoumettre;
	@FXML
	public TextField field;
	@FXML Label label;

	public void setMain(Main main)
	{
		this.main=main;
	}
	public void openInstructions()
	{
		Alert alert=new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("Instructions");
		alert.setTitle("Instructions");
		alert.setContentText("Cette calculatrice contient six opérations:"
				+ " l'addition (+), la soustractions (-), la multiplication (*),"
				+ " la division (/), une pouvoir (^), racine carré (√)."
				+ " Cette calculatrice est formatée comme ça:"
				+ " 'terme, espace, opérateur, espace, terme'.");
		alert.show();
	}
	public void handleSoumettre()
	{
		String input=field.getText();
		label.setText("Le résultat est " + calcules(input));
	}
	public void handleClose()
	{
		Main.handle(null);
	}
	public static double calcules(String input)
	{
		String firstnumber,secondnumber;
		int operation,lastchar,num, firstspace = 0,secondspace = 0,i,t;
		double result = 0;
		t = input.length();
		num = t -1;
		for(i=0; num > i; i++ )
		{
			char j =input.charAt(i);
			if(j==' ')
			{
				firstspace = i;
				secondspace = i + 2;
				break;
			}
		}
		lastchar = input.length();
		operation = firstspace + 1;
		firstnumber = input.substring(0, firstspace);
		int numberone = Integer.valueOf(firstnumber).intValue();

		secondnumber = input.substring(secondspace+1, lastchar);
		int numbertwo = Integer.valueOf(secondnumber).intValue();


		switch (input.charAt(operation)){
		case '+':
			result = numberone + numbertwo;
			break;
		case '-':
			result = numberone - numbertwo; 
			break;
		case '*':
			result = numberone * numbertwo;
			break;
		case '/':
			result = numberone / numbertwo;
			break;
		case '^':
			result = Math.pow(numberone, numbertwo);
			break;
		case '√':
			result = Math.sqrt(numbertwo);
			break;
		}	
		return result;	
	}
	

}
