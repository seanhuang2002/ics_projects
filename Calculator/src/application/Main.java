package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	@Override
	public void start(Stage primaryStage) 
	{
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("JavaClub");
		initRootLayout();
		FirstWindow();
	}
	public void initRootLayout()
	{
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("root.fxml"));
			rootLayout = (BorderPane) loader.load();
			Scene scene = new Scene(rootLayout);
			rootlayoutController controller = loader.getController();
			controller.setMain(this);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void FirstWindow()
	{
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("FirstWindowView.fxml"));
			AnchorPane memberOverview = (AnchorPane) loader.load();
			rootLayout.setCenter(memberOverview);
			FirstWindowController controller = loader.getController();
	        controller.setMain(this);
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
