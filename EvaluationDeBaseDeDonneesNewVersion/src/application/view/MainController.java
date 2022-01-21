package application.view;

import java.sql.SQLException;
import java.util.Optional;

import application.Main;
import application.fuctions.CustomerFunctions;
import application.fuctions.OrderFunctions;
import application.fuctions.ProductFunctions;
import application.fuctions.UserFunctions;
import application.model.Customer;
import application.model.Order;
import application.model.Product;
import application.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Alert.AlertType;

public class MainController{
	//CUSTOMER TAB
	@FXML
	private Tab customerTab;
	@FXML
	private Accordion customerAcc;
	@FXML
	private TitledPane cusOrdersPane;
	@FXML
	private TitledPane newOrdersPane;
	//Customer Orders
	@FXML
	private TableView<Order> cusOrders;
	@FXML
	private TableColumn<Order, Integer> cusOrdersIDCol;
	@FXML
	private TableColumn<Order, String> cusOrdersSalesRepCol;
	@FXML
	private TableColumn<Order, String> cusOrdersShipperCol;
	@FXML
	private TableColumn<Order, String> cusOrdersDateCol;
	@FXML
	private TableColumn<Order, String> cusOrdersStatusCol;
	@FXML
	private Button cusOrdersModBut;
	@FXML
	private Button cusOrdersDelBut;
	@FXML
	private Button cusOrdersViewBut;
	@FXML
	private TextArea cusOrdersMSG;
	//Customer New Order
	@FXML
	private TabPane creationPane;
	@FXML
	private Tab customerDetailsTab;
	@FXML
	private Tab orderDetailsTab;
	@FXML
	private Tab submitTab;
	//=====Customer details=====
	@FXML
	private TextField cusNameField;
	@FXML
	private TextField cusLastNameField;
	@FXML
	private TextField cusCompanyField;
	@FXML
	private TextField cusTitleField;
	@FXML
	private TextField cusEmailField;
	@FXML
	private TextField cusPhoneNumberField;
	@FXML
	private TextField cusAddressField;
	@FXML
	private TextField cusCityField;
	@FXML
	private TextField cusProvinceField;
	@FXML
	private TextField cusPostalCodeField;
	@FXML
	private TextField cusCountryField;
	@FXML
	private TextField cusSalesRepIdField;
	@FXML
	private Button cusDetailsBut;
	//=====Order Details=====
	@FXML
	private ComboBox<String> product1Box;
	@FXML
	private ComboBox<String> product2Box;
	@FXML
	private ComboBox<String> product3Box;
	@FXML
	private ComboBox<String> product4Box;
	@FXML
	private ComboBox<String> product5Box;
	@FXML
	private ComboBox<String> product6Box;
	@FXML
	private TextField product1QuantityField;
	@FXML
	private TextField product2QuantityField;
	@FXML
	private TextField product3QuantityField;
	@FXML
	private TextField product4QuantityField;
	@FXML
	private TextField product5QuantityField;
	@FXML
	private TextField product6QuantityField;
	@FXML
	private Button orderDetailsBut;
	//=====Payment And Shipping=====
	@FXML
	private TextField shipNameField;
	@FXML
	private TextField shipAddressField;
	@FXML
	private TextField shipCityField;
	@FXML
	private TextField shipProvinceField;
	@FXML
	private TextField shipPostalCodeField;
	@FXML
	private TextField shipCountryField;
	@FXML
	private RadioButton shipperARadio;
	@FXML
	private RadioButton shipperBRadio;
	@FXML
	private RadioButton shipperCRadio;
	@FXML
	private ComboBox<String> paymentTypeBox;
	@FXML
	private Label subtotalLabel;
	@FXML
	private Label taxesLabel;
	@FXML
	private Button submitOrder;
	//======================================
	//EMPLOYEE TAB
	@FXML
	private Tab employeeTab;
	@FXML
	private Accordion employeeAcc;
	@FXML
	private TitledPane allOrdersPane;
	@FXML
	private TitledPane yourOrdersPane;
	//Employee All Orders
	@FXML
	private TableView<Order> allOrders;
	@FXML
	private TableColumn<Order, Integer> allOrdersIDCol;
	@FXML
	private TableColumn<Order, String> allOrdersEmployeeCol;
	@FXML
	private TableColumn<Order, String> allOrdersPaymentCol;
	@FXML
	private TableColumn<Order, String> allOrdersCustomerCol;
	@FXML
	private TableColumn<Order, String> allOrdersDateCol;
	@FXML
	private TableColumn<Order, String> allOrdersStatusCol;
	@FXML
	private Button allOrdersModBut;
	@FXML
	private Button allOrdersDelBut;
	@FXML
	private Button allOrdersViewBut;
	@FXML
	private TextArea allOrdersMSG;
	//Employee Your Orders
	@FXML
	private TableView<Order> yourOrders;
	@FXML
	private TableColumn<Order, Integer> yourOrdersIDCol;
	@FXML
	private TableColumn<Order, String> yourOrdersEmployeeCol;
	@FXML
	private TableColumn<Order, String> yourOrdersPaymentCol;
	@FXML
	private TableColumn<Order, String> yourOrdersCustomerCol;
	@FXML
	private TableColumn<Order, String> yourOrdersDateCol;
	@FXML
	private TableColumn<Order, String> yourOrdersStatusCol;
	@FXML
	private Button yourOrdersModBut;
	@FXML
	private Button yourOrdersDelBut;
	@FXML
	private Button yourOrdersViewBut;
	@FXML
	private TextArea yourOrdersMSG;
	@FXML
	private Label yourOrdersLabel;
	//======================================
	//LOGIN
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private RadioButton employeeRadio;
	@FXML
	private RadioButton customerRadio;
	@FXML
	private Button newEmployeeBut;
	@FXML
	private Button newCustomerBut;
	@FXML
	private TextField loginMSG;
	@FXML
	private Button loginSubmitBut;
	@FXML
	private TabPane tabPane;
	@FXML
	private ProgressBar progressBar;
	@FXML
	private MenuItem newEmployeeMenuItem;
	@FXML
	private MenuItem newCustomerMenuItem;

	String password = "";

	String username = "";

	boolean employee = false;

	int customerId=0, employeeId=0, numberOfProducts=0;

	Order selectedOrder=new Order(0,0);

	Order order = new Order();

	private ObservableList<String> paymentData =
			FXCollections.observableArrayList(
					"Cash","Cheque","Credit Card");

	private ObservableList<Order> allData=
			FXCollections.observableArrayList(
					new Order(0, 0));

	private ObservableList<Order> employeeData=
			FXCollections.observableArrayList(
					new Order(0, 0));

	private ObservableList<Order> customerData =
			FXCollections.observableArrayList(
					new Order(0, 0));

	private ObservableList<Product> productList=
			FXCollections.observableArrayList(
					new Product("",0));

	private ObservableList<String> productData= FXCollections.observableArrayList();

	@FXML
	private void initialize() throws Exception{
		//TODO initialize all the columns
		cusOrdersIDCol.setCellValueFactory(cellData -> cellData.getValue().orderIdProperty().asObject());
		cusOrdersDateCol.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
		cusOrdersStatusCol.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
		cusOrdersSalesRepCol.setCellValueFactory(cellData -> cellData.getValue().salesRepNameProperty());
		cusOrdersShipperCol.setCellValueFactory(cellData -> cellData.getValue().shipperProperty());
		yourOrdersIDCol.setCellValueFactory(cellData -> cellData.getValue().orderIdProperty().asObject());
		yourOrdersEmployeeCol.setCellValueFactory(cellData -> cellData.getValue().salesRepNameProperty());
		yourOrdersPaymentCol.setCellValueFactory(cellData -> cellData.getValue().paymentTypeProperty());
		yourOrdersCustomerCol.setCellValueFactory(cellData -> cellData.getValue().shippingNameProperty());
		yourOrdersDateCol.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
		yourOrdersStatusCol.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
		allOrdersIDCol.setCellValueFactory(cellData -> cellData.getValue().orderIdProperty().asObject());
		allOrdersEmployeeCol.setCellValueFactory(cellData -> cellData.getValue().salesRepNameProperty());
		allOrdersPaymentCol.setCellValueFactory(cellData -> cellData.getValue().paymentTypeProperty());
		allOrdersCustomerCol.setCellValueFactory(cellData -> cellData.getValue().shippingNameProperty());
		allOrdersDateCol.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
		allOrdersStatusCol.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
		paymentTypeBox.setItems(paymentData);
		customerAcc.setDisable(true);
		employeeAcc.setDisable(true);
		populateComboBoxes();
		newOrdersPane.expandedProperty().addListener((obs, wasExpanded, isNowExpanded) -> {
			if(isNowExpanded) {
				populateFields();
			}
		});
	}
	//TODO create method to get product id from name
	public void populateComboBoxes() throws ClassNotFoundException, SQLException
	{
		productList=ProductFunctions.getAllProducts();
		for(int i=0;i<productList.size();i++)
		{
			String name=productList.get(i).getName();
			productData.add(name);
		}
		product1Box.setItems(productData);
		product2Box.setItems(productData);
		product3Box.setItems(productData);
		product4Box.setItems(productData);
		product5Box.setItems(productData);
		product6Box.setItems(productData);
	}
	//TODO make each method to do another that opens the
	public void onClickedCustomerTable()
	{
		selectedOrder = cusOrders.getSelectionModel().getSelectedItem();
	}

	public void onClickedYourTable()
	{
		selectedOrder = yourOrders.getSelectionModel().getSelectedItem();
	}

	public void onClickedAllTable()
	{
		selectedOrder = allOrders.getSelectionModel().getSelectedItem();
	}

	public void deleteOrder(ActionEvent e) throws ClassNotFoundException, SQLException
	{
		Button selected = (Button) e.getSource();
		OrderFunctions.deleteOrder(selectedOrder.getOrderId());
		if(selected == cusOrdersDelBut)
			{
			retrieveData(false, false);
			}
		else if(selected == yourOrdersDelBut || selected == allOrdersDelBut)
		{
			retrieveData(false, true);
		}
	}

	public void viewOrder()
	{
		Main main=new Main();
		main.openOrderDetailsWindow(false, selectedOrder);
	}

	public void modifyOrder()
	{
		Main main=new Main();
		main.openOrderDetailsWindow(true, selectedOrder);
	}

	public void createOrder(ActionEvent e) throws ClassNotFoundException, SQLException
	{
		/*
		 * cus id
		 * emp id
		 * all products and quantities
		 * shipper 
		 * shipping name and address
		 * payment type
		 */
		SingleSelectionModel<Tab> model= creationPane.getSelectionModel();
		Button clickedButton = (Button) e.getSource();
		order.setCusId(customerId);
		order.setEmpId(Integer.parseInt(cusSalesRepIdField.getText()));
		if(clickedButton==cusDetailsBut)
		{
			System.out.println(customerId);

			model.select(orderDetailsTab);
		}
		else if(clickedButton==orderDetailsBut)
		{
			if(product1Box.getValue()!=null)
			{
				order.setProduct1Name(product1Box.getValue());
				order.setProduct1Quantity(Integer.parseInt(product1QuantityField.getText()));
				numberOfProducts=1;
				System.out.println();
			}
			if(product2Box.getValue()!=null)
			{
				order.setProduct2Name(product2Box.getValue());
				order.setProduct2Quantity(Integer.parseInt(product2QuantityField.getText()));
				numberOfProducts=2;
			}
			if(product3Box.getValue()!=null)
			{
				order.setProduct3Name(product3Box.getValue());
				order.setProduct3Quantity(Integer.parseInt(product3QuantityField.getText()));
				numberOfProducts=3;
			}
			if(product4Box.getValue()!=null)
			{
				order.setProduct4Name(product4Box.getValue());
				order.setProduct4Quantity(Integer.parseInt(product4QuantityField.getText()));
				numberOfProducts=4;
			}
			if(product5Box.getValue()!=null)
			{
				order.setProduct5Name(product5Box.getValue());
				order.setProduct5Quantity(Integer.parseInt(product5QuantityField.getText()));
				numberOfProducts=5;
			}
			if(product6Box.getValue()!=null)
			{
				order.setProduct5Name(product6Box.getValue());
				order.setProduct5Quantity(Integer.parseInt(product6QuantityField.getText()));
				numberOfProducts=6;
			}
			//set subtotal and taxes in submit tab
			model.select(submitTab);
		}
		else if(clickedButton==submitOrder)
		{
			order.setShippingName(shipNameField.getText());
			order.setShippingAddress(shipAddressField.getText());
			order.setShippingCity(shipCityField.getText());
			order.setShippingProvince(shipProvinceField.getText());
			order.setShippingPostalCode(shipPostalCodeField.getText());
			order.setShippingCountry(shipCountryField.getText());
			if(shipperARadio.isSelected())
			{
				order.setShipper("1");
			}
			else if(shipperBRadio.isSelected())
			{
				order.setShipper("2");
			}
			else if(shipperCRadio.isSelected())
			{
				order.setShipper("3");
			}
			order.setPayment(paymentTypeBox.getValue());
			OrderFunctions.insertOrder(order, numberOfProducts);
			retrieveData(false, false);
		}
	}

	public void populateFields()
	{
		try {
			Customer cus = new Customer("","");
			cus=CustomerFunctions.getUniqueCustomer(customerId);
			cusNameField.setText(cus.getFirstName());
			cusLastNameField.setText(cus.getLastName());
			cusCompanyField.setText(cus.getCompany());
			cusTitleField.setText(cus.getJobTitle());
			cusEmailField.setText(cus.getEmail());
			cusPhoneNumberField.setText(cus.getBusinessPhone());
			cusAddressField.setText(cus.getAddress());
			cusCityField.setText(cus.getCity());
			cusProvinceField.setText(cus.getProvince());
			cusPostalCodeField.setText(cus.getPostalCode());
			cusCountryField.setText(cus.getCountry());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public void checkPassword() throws ClassNotFoundException, SQLException
	//REMINDER: 0 is customer, 1 is employee
	{
		ObservableList<User> UserList=FXCollections.observableArrayList();
		try {
			UserList=UserFunctions.getAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ObservableList<User> EmployeeList=FXCollections.observableArrayList();
		ObservableList<User> CustomerList=FXCollections.observableArrayList();
		for(int i=0;i<UserList.size();i++)
		{
			User user = UserList.get(i);
			if(user.getEmployeeBoolean()==1)
			{
				EmployeeList.add(user);
			}
			else if(user.getEmployeeBoolean()==0)
			{
				CustomerList.add(user);
			}
		}
		if(!usernameField.getText().equals("") && !passwordField.getText().equals(""))
		{
			username=usernameField.getText();
			password=passwordField.getText();
			if(employeeRadio.isSelected())
			{
				for(int i=0;i<EmployeeList.size();i++)
				{
					User user=EmployeeList.get(i);
					if(user.getUsername().equals(username))
					{
						if(user.getPassword().equals(password))
						{
							employee=true;
							employeeId=user.getEmployeeId();
							loginMSG.setText("Logged In");
							retrieveData(true, true);
						}
						else
						{
							loginMSG.setText("Wrong Password");
						}
					}
				}
			}
			else if(customerRadio.isSelected())
			{
				for(int i=0;i<CustomerList.size();i++)
				{
					User user=CustomerList.get(i);
					if(user.getUsername().equals(username))
					{
						if(user.getPassword().equals(password))
						{
							employee=false;
							customerId=user.getCustomerId();
							loginMSG.setText("Logged In");
							retrieveData(false, false);
						}
						else
						{
							loginMSG.setText("Wrong Password");
						}
					}
				}
			}
			else
			{
				loginMSG.setText("Please select employee or customer");
			}
		}
		else if(usernameField.getText().equals("") && !passwordField.getText().equals(""))
		{
			loginMSG.setText("Please enter username");
		}
		else if(passwordField.getText().equals("") && !usernameField.getText().equals("") )
		{
			loginMSG.setText("Please enter password");
		}
		else if(usernameField.getText().equals("") && passwordField.getText().equals(""))
		{
			loginMSG.setText("Please enter username and password");
		}
	}

	public void enableTabs(boolean employee)
	{
		SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
		passwordField.setDisable(true);
		usernameField.setDisable(true);
		if(employee)
		{
			employeeAcc.setDisable(false);
			selectionModel.select(employeeTab);
		}
		else
		{
			customerAcc.setDisable(false);
			selectionModel.select(customerTab);
		}
	}

	/*
	 * public void retrieveData(boolean employee) throws ClassNotFoundException, SQLException
	{
		if(employee)
		{
			progressBar.progressProperty().bind(employeeOrderRetrievalTask.progressProperty());
			employeeData.clear();
			allData.clear();
			new Thread(employeeOrderRetrievalTask).start();
			loginMSG.setText("Loading...");
			loginSubmitBut.setDisable(true);
			employeeOrderRetrievalTask.setOnSucceeded(e -> {
				allOrders.getItems().clear();
				yourOrders.getItems().clear();
				allOrders.setItems(allData);
				yourOrders.setItems(employeeData);
				loginMSG.setText("Logged In!");
				loginSubmitBut.setDisable(true);
				enableTabs(true);
			});
		}
		else if(employee==false)
		{
			progressBar.progressProperty().bind(customerOrderRetrievalTask.progressProperty());
			customerData.clear();
			new Thread(customerOrderRetrievalTask).start();
			loginMSG.setText("Loading...");
			loginSubmitBut.setDisable(true);
			customerOrderRetrievalTask.setOnSucceeded(e -> {
				cusOrders.getItems().clear();
				cusOrders.setItems(customerData);
				loginMSG.setText("Logged In!");
				loginSubmitBut.setDisable(true);
				enableTabs(false);
			});
		}

	}

	Task<Void> customerOrderRetrievalTask = new Task<Void>() {
		@Override
		protected Void call() throws Exception {
			customerData = OrderFunctions.getOrdersByCustomer(customerId);
			updateProgress(1,1);
			return null;
		}
	};

	Task<Void> employeeOrderRetrievalTask = new Task<Void>() {
		@Override
		protected Void call() throws Exception {
			allData = OrderFunctions.getAllOrders();
			employeeData = OrderFunctions.getOrdersByEmployee(employeeId);
			updateProgress(1,1);
			return null;
		}
	};
	 */
	
	public void retrieveData(boolean employee, boolean origineEmp) throws ClassNotFoundException, SQLException
	{
		if(employee)
		{
			employeeData.clear();
			allData.clear();
			loginMSG.setText("Loading...");
			loginSubmitBut.setDisable(true);
			allData = OrderFunctions.getAllOrders();
			employeeData = OrderFunctions.getOrdersByEmployee(employeeId);
			allOrders.getItems().clear();
			yourOrders.getItems().clear();
			allOrders.setItems(allData);
			yourOrders.setItems(employeeData);
			loginMSG.setText("Logged In!");
			loginSubmitBut.setDisable(true);
		}
		else if(employee==false)
		{
			customerData.clear();
			customerData = OrderFunctions.getOrdersByCustomer(customerId);
			loginMSG.setText("Loading...");
			loginSubmitBut.setDisable(true);
			cusOrders.getItems().clear();
			cusOrders.setItems(customerData);
			loginMSG.setText("Logged In!");
			loginSubmitBut.setDisable(true);
		}
		if(origineEmp==true)
		{
			enableTabs(true);
		}
		else if(origineEmp==false)
		{
			enableTabs(false);
		}

	}

	Task<Void> customerOrderRetrievalTask = new Task<Void>() {
		@Override
		protected Void call() throws Exception {
			customerData = OrderFunctions.getOrdersByCustomer(customerId);
			updateProgress(1,1);
			return null;
		}
	};

	public void openCreationWindowFromMenu(ActionEvent e)
	{
		Main main = new Main();
		MenuItem menu = (MenuItem) e.getSource();
		if(menu==newEmployeeMenuItem)
		{
			main.openCreationWindow(true);
		}
		else if(menu==newCustomerMenuItem)
		{
			main.openCreationWindow(false);
		}
	}

	public void openCreationWindow(ActionEvent e)
	{
		Main main = new Main();
		Button selectedButton = (Button) e.getSource();
		if(selectedButton==newEmployeeBut)
		{
			main.openCreationWindow(true);
		}
		else if(selectedButton==newCustomerBut)
		{
			main.openCreationWindow(false);
		}
	}

	public void openModifyDetailsWindow(ActionEvent e)
	{
		Button button = (Button) e.getSource();

	}

	public void handleClose()
	{
		System.exit(0);
	}

	public void handleLogoff()
	{
		order=null;
		selectedOrder=null;
		numberOfProducts=0;
		customerId=0;
		employeeId=0;
		username="";
		password="";
		allData.clear();
		customerData.clear();
		employeeData.clear();
		cusOrders.getItems().clear();
		yourOrders.getItems().clear();
		allOrders.getItems().clear();
		cusNameField.setText("");
		cusLastNameField.setText("");
		cusCompanyField.setText("");
		cusTitleField.setText("");
		cusEmailField.setText("");
		cusPhoneNumberField.setText("");
		cusAddressField.setText("");
		cusCityField.setText("");
		cusProvinceField.setText("");
		cusPostalCodeField.setText("");
		cusCountryField.setText("");
		usernameField.setText("");
		usernameField.setDisable(false);
		passwordField.setDisable(false);
		loginSubmitBut.setDisable(false);
		passwordField.setText("");
		customerAcc.setDisable(true);
		employeeAcc.setDisable(true);
		employeeAcc.setExpandedPane(null);
		customerAcc.setExpandedPane(null);
		progressBar.progressProperty().unbind();
		progressBar.setProgress(0);

	}

	public void handleAbout()
	{

	}

















}
