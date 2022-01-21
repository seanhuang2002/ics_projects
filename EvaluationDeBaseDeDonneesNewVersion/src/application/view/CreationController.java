package application.view;

import java.sql.SQLException;

import application.fuctions.CustomerFunctions;
import application.fuctions.EmployeeFunctions;
import application.fuctions.UserFunctions;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CreationController {
	@FXML
	private TextField cusJobTitleField;
	@FXML
	private TextField cusEmailField;
	@FXML
	private TextField cusFaxField;
	@FXML
	private TextField cusHomePhoneField;
	@FXML
	private TextField cusFirstNameField;
	@FXML
	private TextField cusMobilePhoneField;
	@FXML
	private TextField cusCompanyField;
	@FXML
	private TextField cusProvinceField;
	@FXML
	private TextField cusCountryField;
	@FXML
	private TextField cusBusPhoneField;
	@FXML
	private TextField cusLastNameField;
	@FXML
	private TextField cusCityField;
	@FXML
	private TextField cusAddressField;
	@FXML
	private TextField cusPostalCodeField;
	@FXML
	private Button cusSubmitBut;
	//======
	@FXML
	private TextField empJobTitleField;
	@FXML
	private TextField empEmailField;
	@FXML
	private TextField empFaxField;
	@FXML
	private TextField empHomePhoneField;
	@FXML
	private TextField empFirstNameField;
	@FXML
	private TextField empMobilePhoneField;
	@FXML
	private TextField empCodeField;
	@FXML
	private TextField empProvinceField;
	@FXML
	private TextField empCountryField;
	@FXML
	private TextField empBusPhoneField;
	@FXML
	private TextField empLastNameField;
	@FXML
	private TextField empCityField;
	@FXML
	private TextField empAddressField;
	@FXML
	private TextField empPostalCodeField;
	@FXML
	private Button empSubmitBut;
	//======
	@FXML
	private Tab empTab;
	@FXML
	private Tab cusTab;
	@FXML
	private TabPane pane;
	@FXML
	private PasswordField passwordField;
	@FXML
	private PasswordField confirmPasswordField;
	@FXML
	private TextField usernameField;

	private Stage dialogStage;
	
	private String password="";
	
	public void setDialogStage(Stage dialogStage, boolean employee) {
		this.dialogStage = dialogStage;
		SingleSelectionModel<Tab> selectionModel = pane.getSelectionModel();
		if(employee)
		{
			selectionModel.select(empTab);
			cusTab.setDisable(true);
		}
		else if(employee==false)
		{
			selectionModel.select(cusTab);
			empTab.setDisable(true);
		}
	}
	
	public void getPassword()
	{
		if(passwordField.getText().equals(confirmPasswordField.getText()))
		{
			password=confirmPasswordField.getText();
		}
	}
	
	public void closeWindow()
	{
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Information");
		alert.setTitle("INFO");
		alert.setContentText("User sucessfully created!");
		alert.show();
		dialogStage.close();
	}
	
	public void submitCustomer() throws ClassNotFoundException, SQLException
	{
		getPassword();
		CustomerFunctions.insertNewCustomer(cusCompanyField.getText(), cusLastNameField.getText(), cusFirstNameField.getText(), 
				cusEmailField.getText(), cusJobTitleField.getText(), cusBusPhoneField.getText(), cusHomePhoneField.getText(), 
				cusMobilePhoneField.getText(), cusFaxField.getText(), cusAddressField.getText(), cusCityField.getText(), cusProvinceField.getText(), 
				cusPostalCodeField.getText(), cusCountryField.getText());
		int cusId = CustomerFunctions.getCutomerIdFromName(cusFirstNameField.getText(), cusLastNameField.getText());
		UserFunctions.createUser(cusId,false,usernameField.getText(),password);
		closeWindow();
	}
	
	public void submitEmployee() throws ClassNotFoundException, SQLException
	{
		getPassword();
		CustomerFunctions.insertNewEmployee(empCodeField.getText(), empLastNameField.getText(), empFirstNameField.getText(), 
				empEmailField.getText(), empJobTitleField.getText(), empBusPhoneField.getText(), empHomePhoneField.getText(), 
				empMobilePhoneField.getText(), empFaxField.getText(), empAddressField.getText(), empCityField.getText(), empProvinceField.getText(), 
				empPostalCodeField.getText(), empCountryField.getText());
		int empId = EmployeeFunctions.getEmployeeIdFromName(empFirstNameField.getText(), empLastNameField.getText());
		System.out.println(empId);
		UserFunctions.createUser(empId,true,usernameField.getText(),password);
		closeWindow();
	}

}















