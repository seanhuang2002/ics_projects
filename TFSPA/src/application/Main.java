package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private Stage primaryStage;
	@Override
	public void start(Stage primaryStage) 
	{
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("TFS Parents Association");
		this.primaryStage.getIcons().add(new Image("file:resources/Logo copy 3.png"));
		openMainWindow(primaryStage);
	}
	public void openMainWindow(Stage primaryStage)
	{
		try {
			Parent root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
