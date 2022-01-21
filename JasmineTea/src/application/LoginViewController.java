package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoginViewController implements Initializable{

    @FXML
    private ImageView imageView;
    
    @FXML
    private TextField usernameField;
    
    @FXML
    private PasswordField passwordField;
    
    private Main main;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image image = new Image("file:resource/images/Logo copy 3.png");
		imageView.setImage(image);
	}
	
	public void setMain(Main main)
	{
		this.main=main;
	}
	
	public void open()
	{
		main.openHomeWindow();
	}
    @FXML
	public void login()
	{
		String username = usernameField.getText();
		String password = passwordField.getText();
		boolean check1 = false, check2 = false;
		
		if (username.equals("admin"))
		{
			check1=true;
		}
		
		if(password.equals("uniform"))
		{
			check2=true;
		}
		
		if (check1 ==true && check2 == true)
		{
			open();
			System.out.println("Hi check is done");
		}
	}
    

}
