package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class EditWindowController implements Initializable{
	@FXML
    private Button butNewCategory;

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldListPrice;

    @FXML
    private TextField fieldCode;

    @FXML
    private TextField fieldCost;

    @FXML
    private TextField fieldQUNum;

    @FXML
    private TextField fieldUnitsPerOrder;

    @FXML
    private Button butSubmitNewProduct;

    @FXML
    private ComboBox<String> boxCategory;

    @FXML
    private TextField fieldQUFormat;

    @FXML
    private TextField fieldSupplier;
	private Main main;
	private Stage dialogStage;
	int selectedProduct = 0;
	Product product = new Product();
	
	private ObservableList<String> categories=
			FXCollections.observableArrayList();
	
	
	public void setMain(Main main, Stage dialogStage, int selectedProduct)
	{
		this.main=main;
		this.dialogStage=dialogStage;
		this.selectedProduct=selectedProduct;
		try {
			product=ProductFunctions.getProduct(selectedProduct);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		fieldName.setText(product.getName().substring(18));
		fieldUnitsPerOrder.setText(Integer.toString(product.getUnitsPerOrder()));
		fieldSupplier.setText(product.getSupplier());
		fieldCode.setText(product.getCode());
		fieldCost.setText(Double.toString(product.getStandardCost()));
		fieldListPrice.setText(Double.toString(product.getListPrice()));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			refreshCategories(true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateProduct() throws ClassNotFoundException, SQLException, IOException
	{
		if(fieldSupplier.getText()!="" && fieldName.getText()!="" && fieldCode.getText()!="" && fieldCost.getText()!="" && fieldQUNum.getText()!="" 
				&& fieldQUFormat.getText()!="" && fieldListPrice.getText()!="" && fieldUnitsPerOrder.getText()!="" && boxCategory.getValue()!="")
		{
			ProductFunctions.modifyProduct(selectedProduct, fieldSupplier.getText(), "Northwind Traders "+ fieldName.getText(), fieldCode.getText(), 
					Double.parseDouble(fieldCost.getText()), Double.parseDouble(fieldListPrice.getText()), fieldQUNum.getText() + " X " + 
							fieldQUFormat.getText(), boxCategory.getValue().toString(), Integer.parseInt(fieldUnitsPerOrder.getText()));
			Alert alert2 = new Alert(AlertType.INFORMATION);
			alert2.setTitle("Information Dialog");
			alert2.setHeaderText("Look, an Information Dialog");
			alert2.setContentText("Product successfully modified!");
			alert2.showAndWait();
			dialogStage.close();
		}
		else
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Look, an Error Dialog");
			alert.setContentText("Please make sure all fields are filled in correctly.");
			alert.showAndWait();
		}
	}
	
	public void newCategory() throws ClassNotFoundException, SQLException
	{
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("Look, a Text Input Dialog");
		dialog.setContentText("Please enter your new category:");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			categories.add(result.get());
			refreshCategories(false);
			Alert alert2 = new Alert(AlertType.INFORMATION);
			alert2.setTitle("Information Dialog");
			alert2.setHeaderText("Look, an Information Dialog");
			alert2.setContentText("Category successfully added to list! Please select it from the drop down menu.");
			alert2.showAndWait();
		}
	}
	
	public void refreshCategories(boolean a) throws ClassNotFoundException, SQLException
	{
		if(a)
		{
			categories=ProductFunctions.getProductCategories();
			boxCategory.setItems(categories);
		}
		else
		{
			boxCategory.setItems(categories);
		}
	}

}

