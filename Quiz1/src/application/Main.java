package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application 
{
	private Stage primaryStage;
	@Override
	public void start(Stage primaryStage) 
	{
		this.primaryStage = primaryStage;
		firstWindow();	
		primaryStage.setOnCloseRequest(e -> Platform.exit());
	}
	private void firstWindow() 
	{
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("FirstWindowView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			FirstWindowController firstWindowController = loader.getController();
			firstWindowController.setMain(this);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void handle(WindowEvent event) 
	{
		Platform.exit();
	}
	public static void main(String[] args) 
	{
		launch(args);
	}
}
