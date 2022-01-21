package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class OrderController {

    @FXML
    private Label StudentIdLabel;
    //Must be "STUDENT ID: "+student name

    @FXML
    private TextField barcodeField;

    @FXML
    private Button proceedToCheckoutBut;

    @FXML
    private Label studentNameLabel;

    @FXML
    private Label totalPriceLabel;
    //Must be "TOTAL PRICE: $"+price

    @FXML
    private Button closeBut;
    
    public void closeWindow()
    {
    	//this closes window
    }
    
    public void proceedToCheckout()
    {
    	//this will submit all
    }

}
