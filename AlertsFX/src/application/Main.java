package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private Stage primaryStage;
	@Override
	
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		mainWindow();
		primaryStage.setOnCloseRequest(e -> Platform.exit());
	}
	
	private void mainWindow() {
		try {
			FXMLLoader loader=new FXMLLoader(Main.class.getResource("MainWindowView.fxml"));
			AnchorPane pane = loader.load();
			MainWindowController mainWindowController = loader.getController();
			mainWindowController.setMain(this);
			
			Scene scene = new Scene (pane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void handle(WindowEvent event) 
	{
		Platform.exit();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
