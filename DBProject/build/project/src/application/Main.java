package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Main extends Application {
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) 
	{
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("Northwind Traders - Products");
		this.primaryStage.getIcons().add(new Image("file:resources/Logo copy 2.png"));
		openMainWindow(primaryStage);
	}
	public void openMainWindow(Stage primaryStage)
	{
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Window.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void openDetailsDialog(int selectedProduct) throws ClassNotFoundException, SQLException
	{
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("DetailsWindow.fxml"));
			Stage dialogStage = new Stage();
			Parent root = loader.load();
			Scene scene = new Scene(root);
			DetailsWindowController controller = loader.getController();
			controller.setMain(this, dialogStage, selectedProduct);
			dialogStage.setScene(scene);
			dialogStage.initOwner(primaryStage);
			dialogStage.initModality(Modality.APPLICATION_MODAL);
			dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void openEditDialog(int selectedProduct)
	{
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("EditWindow.fxml"));
			Stage dialogStage = new Stage();
			Parent root = loader.load();
			Scene scene = new Scene(root);
			EditWindowController controller = loader.getController();
			controller.setMain(this, dialogStage, selectedProduct);
			dialogStage.setScene(scene);
			dialogStage.initOwner(primaryStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void openNewAccountDialog()
	{
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("NewAccountWindow.fxml"));
			Stage dialogStage = new Stage();
			Parent root = loader.load();
			Scene scene = new Scene(root);
			NewAccountWindowController controller = loader.getController();
			controller.setMain(this, dialogStage);
			dialogStage.setScene(scene);
			dialogStage.initOwner(primaryStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
