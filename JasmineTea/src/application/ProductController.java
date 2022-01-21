package application;

import java.awt.TextField;

import application.classes.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ProductController {

	//name price discount barcode

	@FXML
	private TextField barcodeEdit;

	@FXML
	private TextField priceEdit;

	@FXML
	private TextField nameEdit;

	@FXML
	private TextField scan_barcode;

	@FXML
	private ComboBox discount;

	@FXML
	private Button saveChanges;

	@FXML
	private Button newProduct;

	@FXML 
	private TableView<Product> productTable;

	@FXML
	private TableColumn<Product, String> productNameColumn;

	@FXML
	private TableColumn<Product, Double> priceColumn;

	ObservableList<Product> productList = FXCollections.observableArrayList();
	ObservableList<String> discountList = FXCollections.observableArrayList(
			"30% off", "50% off");


	@FXML
	private void initialize() {
		//Set table view columns

		try {
			productNameColumn.setCellValueFactory(cellData -> cellData.getValue().getProductNameProperty());
			priceColumn.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty().asObject());

			productTable.setItems(productList);

			productTable.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
				nameEdit.setText(newValue.getProductName());
				priceEdit.setText(Double.toString(newValue.getPrice()));
				barcodeEdit.setText(newValue.getBarcodeId());
				
			
			discountList = FXCollections.observableArrayList(discountList);
			discount.setItems(discountList);
			}));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
	}
	
	

}
