package application;
	
import java.io.IOException;

import application.Blackjack.BlackJackController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
public Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		openMainWindow(primaryStage);
	}
	public void openMainWindow(Stage primaryStage)
	{
		try {
			FXMLLoader loader=new FXMLLoader(Main.class.getResource("WindowView.fxml"));
			AnchorPane pane = loader.load();
			MainWindowController mainWindowController = loader.getController();
			mainWindowController.setMain(this);
			Scene scene = new Scene (pane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void openBlackjackWindow()
	{
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("Blackjack/BlackjackController.fxml"));
			AnchorPane pane = loader.load();
			Stage secondaryStage = new Stage();
			BlackJackController highLowController = loader.getController();
			highLowController.setMain(this, secondaryStage);
			Scene scene = new Scene(pane);
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.WINDOW_MODAL);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
