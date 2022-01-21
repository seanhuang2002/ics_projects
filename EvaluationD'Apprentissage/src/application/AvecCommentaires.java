package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class AvecCommentaires implements Initializable {

	@FXML
	private TextField fieldNom;

	@FXML
	private TextField fieldVille;

	@FXML
	private TextField fieldCode;

	@FXML
	private Label labelNumero;

	@FXML
	private TextField fieldRue;

	@FXML
	private Label labelTele;

	@FXML
	private TextField fieldProvince;

	@FXML
	private TextField fieldNumero;

	@FXML
	private TextField fieldTele;

	@FXML
	private Label labelProvince;

	@FXML
	private Label labelCode;

	private Main main;
	public void setMain(Main main, AnchorPane pane) {
		this.main = main;
	}
	//Met tous les labels des X en rouge et en X
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		labelTele.setText("X");
		labelTele.setTextFill(Color.web("#FF0000"));
		labelProvince.setText("X");
		labelProvince.setTextFill(Color.web("#FF0000"));
		labelCode.setText("X");
		labelCode.setTextFill(Color.web("#FF0000"));
		labelNumero.setText("X");
		labelNumero.setTextFill(Color.web("#FF0000"));
	}
	//Vérifie si l'entré est un numéro
	@FXML
	public void handleNumeroType()
	{
		fieldNumero.textProperty().addListener((observable, oldValue, newValue) -> 
		{
			if (!newValue.matches("\\d")) {
				fieldNumero.setText(newValue.replaceAll("[^\\d\\s*]", ""));
			}
		});
	}
	//Vérifie si le format est correcte
	@FXML
	public void handleNumeroLength()
	{
		if(fieldNumero.getText().length()==4)
		{
			fieldRue.requestFocus();
			labelNumero.setText("");
		}
	}

	@FXML
	public void handleProvince()
	{
		if(fieldProvince.getText().length()==2)
		{
		switch(fieldProvince.getText())
		{
		case "AB":
			fieldCode.requestFocus();
			labelProvince.setText("");
			break;
		case "ON":
			fieldCode.requestFocus();
			labelProvince.setText("");
			break;
		case "QC":
			fieldCode.requestFocus();
			labelProvince.setText("");
			break;
		case "NB":
			fieldCode.requestFocus();
			labelProvince.setText("");
			break;
		case "MB":
			fieldCode.requestFocus();
			labelProvince.setText("");
			break;
		case "BC":
			fieldCode.requestFocus();
			labelProvince.setText("");
			break;
		case "NL":
			fieldCode.requestFocus();
			labelProvince.setText("");
			break;
		case "NT":
			fieldCode.requestFocus();
			labelProvince.setText("");
			break;
		case "NS":
			fieldCode.requestFocus();
			labelProvince.setText("");
			break;
		case "PE":
			fieldCode.requestFocus();
			labelProvince.setText("");
			break;
		case "SK":
			fieldCode.requestFocus();
			labelProvince.setText("");
			break;
		case "YT":
			fieldCode.requestFocus();
			labelProvince.setText("");
			break;
		case "NU":
			fieldCode.requestFocus();
			labelProvince.setText("");
			break;
		}
		}
	}

	public void handleCode()
	{
		if(fieldCode.getText().length()==7)
		{
			if(fieldCode.getText().matches("^[A-Z][0-9][A-Z] ?[0-9][A-Z][0-9]$"))
			{
				fieldTele.requestFocus();
				labelCode.setText("");
			}
		}
	}

	@FXML
	public void handleTele()
	{
		if(fieldTele.getText().length()==12)
		{
			if(fieldTele.getText().matches("^[1-9][0-9][0-9][-][0-9][0-9][0-9][-][0-9][0-9][0-9][0-9]$"))
			{
				labelTele.setText("");
			}
		}
	}
}


