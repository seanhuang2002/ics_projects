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

    public void openOrders() {
    	System.out.println("A");
    }

    public void openPrices() {
    	System.out.println("B");
    }
    
    public void openSales() {
    	System.out.println("C");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image i = new Image("file:resources/Uniform App - Home.png");
	}

}

