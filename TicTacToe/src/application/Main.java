package application;
	
import java.io.IOException;

import javafx.application.Application;
import application.RootLayoutController;
import application.TTTController;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	public Stage primaryStage;
	public BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage){
		this.primaryStage=primaryStage;
		initRootLayout();
	FirstWindow();
		
	}
	public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            RootLayoutController controller = loader.getController();
            try {
				controller.setMain(this);
			} catch (Exception e) {
				e.printStackTrace();
			}
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	/**
	 * This makes the welcome screen
	 */
	public void FirstWindow() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("TicTacToeView.fxml"));
			AnchorPane entryWindow = (AnchorPane) loader.load();
			rootLayout.setCenter(entryWindow);
			TTTController controller = loader.getController();
			controller.setMain(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}

	
}
