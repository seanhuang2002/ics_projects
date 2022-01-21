package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.classes.Product;
import application.classes.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class OrderController implements Initializable {

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
    
    @FXML
    private ImageView a;
    
    private Main main;
    private Student s;
    
    private String barcode;
    
    @FXML
    private TableView<Product> table1;
    
    @FXML
    private TableColumn<Product, String> productname;
    
    @FXML
    private TableColumn<Product, Integer> productprice;
    @FXML
    private Label total;
    
    public ObservableList<Product> productList;
    
    public double totalPrice;
    
    
    public void setMain(Main main)
    {
		this.main=main;
	}
    
    public void setStudent(Student s) {
    	this.s=s;
    	studentNameLabel.setText(s.getLastName()+", "+s.getFirstName());
    	StudentIdLabel.setText("ID#: "+Integer.toString(s.getStudentId()));
    }
    
    public void closeWindow()
    {
    	//this closes window
    	main.openSearchWindow();
    }   
    
    
    public void proceedToCheckout()
    {
    	//this will submit all
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
		Image i = new Image("file:resource/images/user_icon.png");
		a.setImage(i);
		productList = FXCollections.observableArrayList();	
		productname.setCellValueFactory(new PropertyValueFactory<Product, String>("getProductName"));
		productprice.setCellValueFactory(new PropertyValueFactory<Product, Integer>("getPrice"));
		table1.setItems(productList);
	}
    
    public void check() throws ClassNotFoundException, SQLException
    {
    	try {
    		barcode=barcodeField.getText();
    		if(barcode.length()==8)
    		{
    			Product p =DBActions.getProductByBarcodeId(barcode);
    			productList.add(p);
    			
    		
    			table1.setItems(productList);
    			
    			int lenght =productList.size();
        		totalPrice +=  productList.get(lenght-1).getPrice();
        		//System.out.println(totalPrice);
        		total.setText(String.valueOf(totalPrice));
        		barcodeField.clear();
    			
    		}
    		

    
    		
    	}
    catch (SQLException e) {
		System.out.println("there is an error in finding the product from a barcode ID");
		throw e;
		
		
	}
    }
    	
    	public void proceed() {
    		
    		String allproducts;
    		
    		for(int i =0;i<productList.size();i++)
    		{
    			
    		}
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Check receipt");
        	alert.setHeaderText("the receipt");
        	alert.setContentText("The products are :");

        	alert.showAndWait();
    		
    	}
    	  	
    
   
    
    
    
}
