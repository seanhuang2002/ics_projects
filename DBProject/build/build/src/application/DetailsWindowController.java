package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DetailsWindowController {

	@FXML
	private Label labelSupplier;

	@FXML
	private Label labelQuantity;

	@FXML
	private Label labelUnits;

	@FXML
	private Label labelCategory;

	@FXML
	private Label labelName;

	@FXML
	private Label labelCode;

	@FXML
	private Label labelCost;

	@FXML
	private Label labelPrice;

	private Main main;
	private Stage dialogStage;
	int selectedProduct;
	Product product = new Product();

	public void setMain(Main main, Stage dialogStage, int selectedProduct) throws ClassNotFoundException, SQLException
	{
		this.main=main;
		this.dialogStage=dialogStage;
		this.selectedProduct=selectedProduct;
		product=ProductFunctions.getProduct(selectedProduct);
		labelName.setText(product.getName().substring(18));
		labelQuantity.setText(product.getQuantityPerUnit());
		labelUnits.setText(Integer.toString(product.getUnitsPerOrder()));
		labelCategory.setText(product.getCategory());
		labelSupplier.setText(product.getSupplier());
		labelCode.setText(product.getCode());
		labelCost.setText(Double.toString(product.getStandardCost()));
		labelPrice.setText(Double.toString(product.getListPrice()));
	}

	public void editProduct()
	{
		main.openEditDialog(selectedProduct);
		dialogStage.close();
	}

	public void closeWindow()
	{
		dialogStage.close();
	}

}
