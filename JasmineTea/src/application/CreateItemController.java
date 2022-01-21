package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateItemController {

    @FXML
    private TextField productNameField;

    @FXML
    private TextField barcodeIdField;

    @FXML
    private Button closeButton;

    @FXML
    private Button SelectStudentButton;

    @FXML
    private TextField productPriceField;

    @FXML
    private ComboBox<String> discountCombo;

    @FXML
    public void saveChanges(ActionEvent event) {
    	//TODO ADD NEW ITEM
    	dialog.close();
    }

    @FXML
    public void close(ActionEvent event) {
    	dialog.close();
    }
    
    private Stage dialog;
	private Main main;
	public void setMain(Main main, Stage dialog) {
		this.main=main;
		this.dialog=dialog;
		
	}

}
