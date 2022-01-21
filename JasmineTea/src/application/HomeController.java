package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class HomeController implements Initializable{

    @FXML
    private Circle pricesCircle;

    @FXML
    private Circle saleCircle;

    @FXML
    private Circle orderCircle;
    
    @FXML
    private ImageView a;

    
    private Main main;
    public void setMain(Main main)
    {
    		this.main=main;
    }
    
    @FXML
    public void openOrders() {
    		main.openSearchWindow();
    		
    }
    
    @FXML
    public void openPrices() {
    	main.openModifyWindow();
    	
    	
    }
   
    @FXML
    public void openSales() {
    	
    }

	@Override
    public void initialize(URL location, ResourceBundle resources) {
		Image i = new Image("file:resource/images/UniformApp-Home.png");
		a.setImage(i);
	}

}

