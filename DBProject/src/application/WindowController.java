package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

public class WindowController implements Initializable {

	@FXML
	private Button butNewCategory;

	@FXML
	private TextField fieldSupplier;

	@FXML
	private TextField fieldMessage;

	@FXML
	private TextField fieldName;

	@FXML
	private TextField fieldCode;

	@FXML
	private TextField fieldCost;

	@FXML
	private TextField fieldQUNum;

	@FXML
	private TextField fieldQUFormat;

	@FXML
	private TextField fieldListPrice;

	@FXML
	private TextField fieldUnitsPerOrder;

	@FXML
	private ImageView imageLogo;

	@FXML
	private TableColumn<Product, String> colName;

	@FXML
	private Button butEdit;

	@FXML
	private Button butSubmit;

	@FXML
	private TextField fieldUser;

	@FXML
	private PasswordField fieldPass;

	@FXML
	private Tab tabList;

	@FXML
	private Label labelID;

	@FXML
	private Tab tabLogin;

	@FXML
	private Button butDelete;

	@FXML
	private TableView<Product> tableList;

	@FXML
	private Button butSubmitNewProduct;

	@FXML
	private TableColumn<Product, Integer> colID;

	@FXML
	private Button butDetails;

	@FXML
	private ComboBox<String> boxCategory;

	@FXML
	private Tab tabNew;

	@FXML
	private TabPane pane;

	private ObservableList<Product> data=
			FXCollections.observableArrayList();

	private ObservableList<String> categories=
			FXCollections.observableArrayList();

	private int selectedProduct=0;
	private Boolean loggedIn=false;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		imageLogo.setImage(new Image("file:resources/Logo copy 2.png"));
		colName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		colID.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
		try {
			refreshTable();
			refreshCategories(true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		tableList.getSelectionModel().selectedItemProperty().addListener((abs, oldSelection, newSelection) -> {
			if(newSelection != null)
			{
				selectedProduct = newSelection.getId();
				labelID.setText(Integer.toString(selectedProduct));
			}
		});
		tabList.setDisable(true);
		tabNew.setDisable(true);
		fieldMessage.setDisable(true);

	}

	public void refreshTable() throws ClassNotFoundException, SQLException
	{
		System.out.println("a");
		tableList.getItems().clear();
		data=ProductFunctions.getAllProducts();
		tableList.setItems(data);
	}

	public void goNewProducts()
	{
		if(loggedIn)
		{
			SingleSelectionModel<Tab> selectionModel = pane.getSelectionModel();
			selectionModel.select(tabNew);
		}
		else
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Look, an Error Dialog");
			alert.setContentText("Please log in first.");
			alert.showAndWait();
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

	public void submitUsernamePassword() throws ClassNotFoundException, SQLException
	{
		if(UserFunctions.checkPassword(fieldUser.getText(),fieldPass.getText())==true)
		{
			tabList.setDisable(false);
			tabNew.setDisable(false);
			fieldMessage.setText("Sucess!");
			fieldUser.setDisable(true);
			fieldPass.setDisable(true);
			SingleSelectionModel<Tab> selectionModel = pane.getSelectionModel();
			selectionModel.select(tabList);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText("Look, an Information Dialog");
			alert.setContentText("Successfully logged in!");
			alert.showAndWait();
			loggedIn=true;
		}
		else
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Look, an Error Dialog");
			alert.setContentText("Wrong Username or Password.");
			alert.showAndWait();
			fieldMessage.setText("Wrong Username or Password");
		}
	}

	public void deleteProduct() throws ClassNotFoundException, SQLException
	{
		if(loggedIn)
		{
			if(selectedProduct!=0)
			{
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Dialog");
				alert.setHeaderText("Look, a Confirmation Dialog");
				alert.setContentText("Are you sure you want to delete product #"+selectedProduct+"?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK){
					ProductFunctions.deleteProduct(selectedProduct);
					refreshTable();
					Alert alert2 = new Alert(AlertType.INFORMATION);
					alert2.setTitle("Information Dialog");
					alert2.setHeaderText("Look, an Information Dialog");
					alert2.setContentText("Product successfully deleted!");
					alert2.showAndWait();
				}
				else
				{
					Alert alert1 = new Alert(AlertType.ERROR);
					alert1.setTitle("Error Dialog");
					alert1.setHeaderText("Look, an Error Dialog");
					alert1.setContentText("Please select a product to delete.");
					alert1.showAndWait();
				}
			}
		}
		else
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Look, an Error Dialog");
			alert.setContentText("Please log in first.");
			alert.showAndWait();
		}

	}

	public void deleteProduct(int selectedProduct) throws ClassNotFoundException, SQLException
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText("Look, a Confirmation Dialog");
		alert.setContentText("Are you sure you want to delete product #"+selectedProduct+"?");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			ProductFunctions.deleteProduct(selectedProduct);
			refreshTable();
			Alert alert2 = new Alert(AlertType.INFORMATION);
			alert2.setTitle("Information Dialog");
			alert2.setHeaderText("Look, an Information Dialog");
			alert2.setContentText("Product successfully deleted!");
			alert2.showAndWait();
		} 
	}

	public void editProduct() throws ClassNotFoundException, SQLException
	{
		if(loggedIn) 
		{
			if(selectedProduct!=0)
			{
				Main main = new Main();
				main.openEditDialog(selectedProduct);
			}
			else
			{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Look, an Error Dialog");
				alert.setContentText("Please select a product to edit.");
				alert.showAndWait();
			}
		}
		else
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Look, an Error Dialog");
			alert.setContentText("Please log in first.");
			alert.showAndWait();
		}
	}

	public void viewProduct() throws ClassNotFoundException, SQLException
	{
		if(loggedIn)
		{
			if(selectedProduct!=0)
			{
				Main main = new Main();
				main.openDetailsDialog(selectedProduct);
			}
			else
			{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Look, an Error Dialog");
				alert.setContentText("Please select a product to view.");
				alert.showAndWait();
			}
		}
		else
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Look, an Error Dialog");
			alert.setContentText("Please log in first.");
			alert.showAndWait();
		}
	}

	/*
	 * fieldSupplier;
	 * fieldName;
	 * fieldCode;
	 * fieldCost;
	 * fieldQUNum;
	 * fieldQUFormat;
	 * fieldListPrice;
	 * fieldUnitsPerOrder;
	 */
	/*
	 * (String supplier, String name, String code, double cost, double price, String quantity, String category, int units)
	 */

	public void newProduct() throws NumberFormatException, ClassNotFoundException, SQLException
	{
		if(fieldSupplier.getText()!="" && fieldName.getText()!="" && fieldCode.getText()!="" && fieldCost.getText()!="" && fieldQUNum.getText()!="" 
				&& fieldQUFormat.getText()!="" && fieldListPrice.getText()!="" && fieldUnitsPerOrder.getText()!="" && boxCategory.getValue()!="")
		{
			ProductFunctions.insertProduct(fieldSupplier.getText(), "Northwind Traders "+ fieldName.getText(), fieldCode.getText(), 
					Double.parseDouble(fieldCost.getText()), Double.parseDouble(fieldListPrice.getText()), fieldQUNum.getText() + " X " + 
							fieldQUFormat.getText(), boxCategory.getValue(), Integer.parseInt(fieldUnitsPerOrder.getText()));
			refreshTable();
			clearFields();
			Alert alert2 = new Alert(AlertType.INFORMATION);
			alert2.setTitle("Information Dialog");
			alert2.setHeaderText("Look, an Information Dialog");
			alert2.setContentText("Product successfully added to database!");
			alert2.showAndWait();
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

	public void clearFields()
	{
		fieldSupplier.setText("");
		fieldName.setText("");
		fieldCode.setText("");
		fieldCost.setText("");
		fieldQUNum.setText("");
		fieldQUFormat.setText("");
		fieldListPrice.setText("");
		fieldUnitsPerOrder.setText("");
		boxCategory.getSelectionModel().clearSelection();
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

	public void handleClose()
	{
		System.exit(0);
	}

	public void handleAbout()
	{
		Alert alert2 = new Alert(AlertType.INFORMATION);
		alert2.setTitle("About");
		alert2.setHeaderText("Look, a Dialog About the Program");
		alert2.setContentText("This program was created in the Fall and Winter of 2018 by Sean Huang for the ICS4U class at the Toronto French School"
				+ " taught by Mr J.Zagabe as the first term project.");
		alert2.showAndWait();
	}

	public void handleLogOut()
	{
		fieldUser.setText("");
		fieldUser.setDisable(false);
		fieldPass.setDisable(false);
		fieldPass.setText("");
		fieldMessage.setText("Enter Username and Password");
		tabNew.setDisable(true);
		tabList.setDisable(true);
		SingleSelectionModel<Tab> selectionModel = pane.getSelectionModel();
		selectionModel.select(tabLogin);
		loggedIn=false;
		Alert alert2 = new Alert(AlertType.INFORMATION);
		alert2.setTitle("Information Dialog");
		alert2.setHeaderText("Look, an Information Dialog");
		alert2.setContentText("Successfully logged out!");
		alert2.showAndWait();
	}

	public void handleNewAccount()
	{
		Main main = new Main();
		main.openNewAccountDialog();
	}	

}

