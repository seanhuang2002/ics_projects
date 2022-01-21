package application;

import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class MainWindowController {
	@SuppressWarnings("unused")
	private Main main;

	public void setMain(Main main, AnchorPane pane) {
		this.main = main;
		setGlobalEventHandler(pane);	
	}
	
	public void setGlobalEventHandler(Node root) {
	    root.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
	        if (ev.getCode() == KeyCode.ENTER) {
	           //handleSoumettre();
	           ev.consume(); 
	        }
	    });
	}
}
