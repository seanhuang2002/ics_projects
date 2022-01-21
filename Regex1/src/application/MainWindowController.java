package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class MainWindowController {

	@FXML
	private TextField f1;

	@FXML
	private TextField f2;

	@FXML
	private TextField f3;

	@FXML
	private TextField fieldEmail;

	@FXML
	private TextField fieldPass;

	@FXML
	private Label msgEmail;

	@FXML
	private Label msgPass;

	@FXML
	private Label msgLabel;

	@FXML
	private TabPane tabPane;

	@FXML
	private Tab tabNAS;

	@FXML
	private Tab tabEmail;

	@FXML
	private Tab tabPass;

	@FXML
	private Button buttok;
	
	@FXML
	private Button buttEmail;
	
	@FXML
	private Button buttPass;
	
	Tab selectedTab;

	@SuppressWarnings("unused")
	private Main main;

	public void setMain(Main main, AnchorPane pane) {
		this.main = main;
		setGlobalEventHandler(pane);
	}

	@FXML
	private void handleNumeriques1()
	{
		f1.textProperty().addListener((observable, oldValue, newValue) -> 
		{
			if (!newValue.matches("\\d")) {
				f1.setText(newValue.replaceAll("[^\\d\\s*]", ""));
			}
		});
		if(f1.getText().length()==3)
		{
			f2.requestFocus();
		}
	}

	@FXML
	private void handleNumeriques2()
	{
		f2.textProperty().addListener((observable, oldValue, newValue) -> 
		{
			if (!newValue.matches("\\d")) {
				f2.setText(newValue.replaceAll("[^\\d\\s*]", ""));
			}
			else
			{

			}
		});
		if(f2.getText().length()==3)
		{
			f3.requestFocus();
		}
	}

	@FXML
	private void handleNumeriques3()
	{
		f3.textProperty().addListener((observable, oldValue, newValue) -> 
		{
			if(f3.getText().length()!=3)
			{
				if (!newValue.matches("\\d")) {
					f3.setText(newValue.replaceAll("[^\\d\\s*]", ""));
				}
			}
			else
			{
				buttok.requestFocus();
			}
		});
	}
	
	@FXML
	private void handleSoumettre(ActionEvent e)
	{
		Button xt = new Button();
		if(e!=null)
		{
			xt=(Button)e.getSource();
		}
		if(xt==buttok||selectedTab==tabNAS)
		{
			if(buttok.getText().equals("Remettre à zéro"))
			{
				f1.clear();
				f1.setDisable(false);
				f2.clear();
				f2.setDisable(false);
				f3.clear();
				f3.setDisable(false);
				buttok.setText("Soumettre");
				f1.requestFocus();
				msgLabel.setTextFill(Color.web("#000000"));
				msgLabel.setText("Entrez votre numéro d'assurance sociale");
				selectedTab=null;
			}
			else if(buttok.getText().equals("Soumettre")
					&&f1.getText().matches("\\d+\\d+\\d")
					&&f2.getText().matches("\\d+\\d+\\d")
					&&f3.getText().matches("\\d+\\d+\\d")){
				msgLabel.setText("Merci! NAS Reçu!");
				f1.setDisable(true);
				f2.setDisable(true);
				f3.setDisable(true);
				buttok.setText("Remettre à zéro");
			}
			else if(buttok.getText().equals("Soumettre")
					&&!f1.getText().matches("\\d+\\d+\\d")
					&&!f2.getText().matches("\\d+\\d+\\d")
					&&!f3.getText().matches("\\d+\\d+\\d"))
			{
				msgLabel.setTextFill(Color.web("#f45342"));
				msgLabel.setText("Entrez une numéro d'assurance sociale valide");
				f1.setDisable(true);
				f2.setDisable(true);
				f3.setDisable(true);
				buttok.setText("Remettre à zéro");
			}
		}
		if(xt==buttEmail||selectedTab==tabEmail)
		{
			String emailRegex = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
			if(buttEmail.getText().equals("Remettre à zéro"))
			{
				fieldEmail.setDisable(false);
				fieldEmail.setText("");
				msgEmail.setTextFill(Color.web("#000000"));
				msgEmail.setText("Entrez votre adresse e-mail");
				
			}
			else if(fieldEmail.getText().matches(emailRegex))
			{
				msgEmail.setText("Adresse d'email valide");
				fieldEmail.setDisable(true);
				buttEmail.setText("Remettre à zéro");
			}
			else
			{
				msgEmail.setTextFill(Color.web("#f45342"));
				msgEmail.setText("Adress d'email non valide");
				fieldEmail.setDisable(true);
				buttEmail.setText("Remettre à zéro");
			}
		}
		else if(xt==buttPass||selectedTab==tabPass)
		{
			String passRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*(?=.*[_\\W])).+$";
			if(buttPass.getText().equals("Remettre à zéro"))
			{
				fieldPass.setDisable(false);
				fieldPass.setText("");
				msgPass.setTextFill(Color.web("#000000"));
				msgPass.setText("Entrez votre mot de passe");
			}
			else if(fieldPass.getText().matches(passRegex))
			{
				msgPass.setText("Mot de passe valide");
				fieldPass.setDisable(true);
				buttPass.setText("Remettre à zéro");
			}
			else
			{
				msgPass.setTextFill(Color.web("#f45342"));
				msgPass.setText("Mot de passe non valide");
				fieldPass.setDisable(true);
				buttPass.setText("Remettre à zéro");
			}
		}
	}

	public void setGlobalEventHandler(Node root) {
		root.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
			if (ev.getCode() == KeyCode.ENTER) {
				Tab tabselected = tabPane.getSelectionModel().getSelectedItem();
				if(tabselected == tabNAS)
				{
					selectedTab=tabselected;
					handleSoumettre(null);
				}
				else if(tabselected == tabEmail)
				{
					selectedTab=tabselected;
					handleSoumettre(null);
				}
				else if(tabselected == tabPass)
				{
					selectedTab=tabselected;
					handleSoumettre(null);
				}
				ev.consume(); 
			}
		});
	}
}