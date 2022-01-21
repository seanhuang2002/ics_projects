package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoginView implements Initializable{

    @FXML
    private ImageView imageView;
    
    @FXML
    private TextField usernameField;
    
    @FXML
    private PasswordField passwordField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image image = new Image("file:resources/Logo copy 3.png");
		imageView.setImage(image);
		
	}
    
	public void login()
	{
		
	}
    

}
