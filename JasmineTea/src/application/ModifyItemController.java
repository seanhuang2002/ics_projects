package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.classes.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ModifyItemController implements Initializable{


    @FXML
    private Button newProductBut;

    @FXML
    private Button closeBut;

    @FXML
    private Button proceedToCheckoutBut;
    
    @FXML
    private ComboBox<String> discountCombo;

    @FXML
    private TableColumn<Product, String> barcodeCol;

    @FXML
    private TableColumn<Product, String> nameCol;

    @FXML
    private TableColumn<Product, String> discountCol;

    @FXML
    private TableColumn<Product, Double> priceCol;
    
    @FXML
    private TableView<Product> tableView;

    @FXML
    private TextField barcodeField;
    
    @FXML
    private TextField priceField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField scanBarcodeField;

    private Main main;
    
    private Product item;
    
    public void setMain(Main main)
    {
    	this.main=main;
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		barcodeCol.setCellValueFactory(cellData -> cellData.getValue().getBarcodeIdProperty());
		nameCol.setCellValueFactory(cellData -> cellData.getValue().getProductNameProperty());
		priceCol.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty().asObject());
		try {
			tableView.setItems(DBActions.getAllProducts());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		    	barcodeField.setText(newSelection.getBarcodeId());
		    	nameField.setText(newSelection.getProductName());
		    	priceField.setText(Double.toString(newSelection.getPrice()));
		    	item=newSelection;
		    }
		});
	}   

    @FXML
    public void saveChanges() {
    	int itemId=item.getId();
    	//TODO jdhf
    	try {
			DBActions.updateProduct(item.getId(),barcodeField.getText(),nameField.getText(), Double.parseDouble(priceField.getText()), Double.parseDouble(discountCombo.getValue()));
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Information Dialog");
    	alert.setHeaderText("Look, an Information Dialog");
    	alert.setContentText("Sucess! Item updated!");
    	barcodeField.setText("");
    	nameField.setText("");
    	priceField.setText("");
    	discountCombo.setSelectionModel(null);
    	item=null;
    	alert.showAndWait();
    }

    @FXML
    public void closeWindow() {
    	main.openHomeWindow();
    }

    @FXML
    public void newProduct() {
    	main.openCreateProductWindow();
    }

}
