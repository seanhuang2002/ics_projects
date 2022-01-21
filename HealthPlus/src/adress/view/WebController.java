package adress.view;

import java.net.URL;
import java.util.ResourceBundle;

import adress.Main;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebHistory.Entry;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebController implements Initializable {
	@SuppressWarnings("unused")
	private Main main;
	private Stage secondaryStage;
	public void setMain(Main main, Stage secondaryStage)
	{
		this.main=main;
		this.secondaryStage=secondaryStage;
	}

	@FXML
	TextField txtURL;
	@FXML
	WebView webView;
	private WebEngine webEngine;
	@FXML
	MenuItem miPaste;
	@FXML
	MenuItem miCopy;
	@FXML 
	ComboBox<String> comboBox;



	@FXML
	private void goAction(ActionEvent evt) {

		webEngine.load(txtURL.getText().startsWith("http://") ? txtURL.getText() : "http://" + txtURL.getText());
	}
	public void copy()
	{
		Clipboard systemClipboard = Clipboard.getSystemClipboard();
		String selection = (String) webView.getEngine()
				.executeScript("window.getSelection().toString()");
		ClipboardContent content = new ClipboardContent();
		content.putString(selection);
		systemClipboard.setContent(content);
	}
	public void handleClose()
	{
		secondaryStage.close();
	}

	public void goToSite(String a)
	{
		webEngine.load(a);
	}
	public void handleBack()
	{
		goBack();
	}
	public void handleForward()
	{
		goForward();
	}
	public String goBack()
	{    
		final WebHistory history=webEngine.getHistory();
		ObservableList<WebHistory.Entry> entryList=history.getEntries();
		int currentIndex=history.getCurrentIndex();
		Platform.runLater(new Runnable() { public void run() { history.go(-1); } });
		return entryList.get(currentIndex>0?currentIndex-1:currentIndex).getUrl();
	}

	public String goForward()
	{    
		final WebHistory history=webEngine.getHistory();
		ObservableList<WebHistory.Entry> entryList=history.getEntries();
		int currentIndex=history.getCurrentIndex();
		Platform.runLater(new Runnable() { public void run() { history.go(1); } });
		return entryList.get(currentIndex<entryList.size()-1?currentIndex+1:currentIndex).getUrl();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		webEngine = webView.getEngine();
		webEngine.locationProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				txtURL.setText(newValue);
			}
		});


		//process history
		final WebHistory history = webEngine.getHistory();
		history.getEntries().addListener(new 
				ListChangeListener<WebHistory.Entry>(){
			@Override
			public void onChanged(Change<? extends Entry> c) {
				c.next();
				for (Entry e : c.getRemoved()) {
					comboBox.getItems().remove(e.getUrl());
				}
				for (Entry e : c.getAddedSubList()) {
					comboBox.getItems().add(e.getUrl());
				}
			}
		});

		//set the behavior for the history combobox               
		comboBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ev) {
				int offset =
						comboBox.getSelectionModel().getSelectedIndex()
						- history.getCurrentIndex();
				history.go(offset);
				goToSite(comboBox.getValue());
			}
		});


	}
	public void handleAbout()
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("About");
		alert.setHeaderText("About");
		alert.setContentText("This Web Browser was created with the help of Oracle's JavaFX Documentations.");
		alert.showAndWait();
	}
}
