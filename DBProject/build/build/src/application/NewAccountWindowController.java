package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewAccountWindowController{

	@FXML
	private PasswordField fieldCode;

	@FXML
	private PasswordField fieldConfirm;

	@FXML
	private PasswordField fieldPass;

	@FXML
	private TextField fieldUser;

	private Stage stage;
	private Main main;

	public void setMain(Main main, Stage stage)
	{
		this.main=main;
		this.stage=stage;
		
	}

	//Code == NWTEmployeeAccess
	
	@FXML
	public void createAccount() throws ClassNotFoundException, SQLException 
	{
		if(fieldPass.getText().equals(fieldConfirm.getText())&&fieldCode.getText().equals("NWTEmployeeAccess"))
		{
			String sqlStmt="insert into login(username, password) values ('"+fieldUser.getText()+"','"+fieldPass.getText()+"')";
			DBUtilities.dbExecuteQuery(sqlStmt);
			Alert alert2 = new Alert(AlertType.INFORMATION);
			alert2.setTitle("Information Dialog");
			alert2.setHeaderText("Look, an Information Dialog");
			alert2.setContentText("New User Created!");
			alert2.showAndWait();
			stage.close();
		}
		else if(!fieldPass.getText().equals(fieldConfirm.getText())&&fieldCode.getText().equals("NWTEmployeeAccess"))
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Look, an Error Dialog");
			alert.setContentText("Please make sure the passwords match.");
			alert.showAndWait();
		}
		else if(fieldPass.getText().equals(fieldConfirm.getText())&&!fieldCode.getText().equals("NWTEmployeeAccess"))
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Look, an Error Dialog");
			alert.setContentText("Please enter correct employee access code.");
			alert.showAndWait();
		}
		else if(!fieldPass.getText().equals(fieldConfirm.getText())&&!fieldCode.getText().equals("NWTEmployeeAccess"))
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Look, an Error Dialog");
			alert.setContentText("Please enter correct employee access code and make sure the passwords match.");
			alert.showAndWait();
		}
	}

	

}
