package adress;

import java.io.IOException;

import adress.view.BMIWindowController;
import adress.view.BloodPressureWindowController;
import adress.view.BloodSugarWindowController;
import adress.view.BodyFatWindowController;
import adress.view.EntryWindowController;
import adress.view.HeightWindowController;
import adress.view.RestingController;
import adress.view.RootLayoutController;
import adress.view.TableAppController;
import adress.view.WaistWindowController;
import adress.view.WebController;
import adress.view.WeightWindowController;
import adress.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application{
	public Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("HealthPlus");
		initRootLayout();
		EntryWindowOverview();
	}
	public void startTable() throws Exception {
			try {
				FXMLLoader root = new FXMLLoader(Main.class.getResource("view/TableApp.fxml"));
				AnchorPane pane = root.load();
				Scene scene = new Scene(pane);
				Stage secondaryStage= new Stage();
				secondaryStage.setTitle("Record Book");

				secondaryStage.setMinHeight(250);
				secondaryStage.setMinWidth(500);

				secondaryStage.setMaxHeight(800000);
				secondaryStage.setMaxWidth(1000000);

				TableAppController secondWindowController = root.getController();
				secondWindowController.setMain(this, secondaryStage);
				secondaryStage.initOwner(primaryStage);
				secondaryStage.initModality(Modality.NONE);
				secondaryStage.setScene(scene);
				secondaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	//main page creation
	public Stage getPrimaryStage() {
		return primaryStage;
	} 
	public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            RootLayoutController controller = loader.getController();
            controller.setMain(this);
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
	public void EntryWindowOverview() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/EntryWindow.fxml"));
			AnchorPane entryWindow = (AnchorPane) loader.load();
			rootLayout.setCenter(entryWindow);
			EntryWindowController controller = loader.getController();
			controller.setMain(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * These make information windows
	 */
	public void BMIWindow()
	{
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/BMIWindow.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			Stage secondaryStage = new Stage();
			BMIWindowController secondWindowController = loader.getController();
			secondWindowController.setMain(this, secondaryStage);
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.WINDOW_MODAL);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void WebWindow(String a)
	{
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/WebBrowserWindow.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			Stage secondaryStage = new Stage();
			WebController secondWindowController = loader.getController();
			secondWindowController.setMain(this, secondaryStage);
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.NONE);
			secondWindowController.goToSite(a);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void WeightWindow()
	{
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/WeightWindow.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			Stage secondaryStage = new Stage();
			WeightWindowController secondWindowController = new WeightWindowController();
			secondWindowController = loader.getController();
			secondWindowController.setMain(this, secondaryStage);
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.WINDOW_MODAL);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void HeightWindow()
	{
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/HeightWindow.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			Stage secondaryStage = new Stage();
			HeightWindowController secondWindowController = loader.getController();
			secondWindowController.setMain(this, secondaryStage);
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.WINDOW_MODAL);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void BloodPressureWindow()
	{
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/BloodPressure.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			Stage secondaryStage = new Stage();
			BloodPressureWindowController secondWindowController = loader.getController();
			secondWindowController.setMain(this, secondaryStage);
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.WINDOW_MODAL);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void BloodSugarWindow()
	{
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/BloodSugar.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			Stage secondaryStage = new Stage();
			BloodSugarWindowController secondWindowController = loader.getController();
			secondWindowController.setMain(this, secondaryStage);
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.WINDOW_MODAL);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void WaistWindow()
	{
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/WaistWindow.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			Stage secondaryStage = new Stage();
			WaistWindowController controller = new WaistWindowController();
			controller= loader.getController();
			controller.setMain(this, secondaryStage);
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.WINDOW_MODAL);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void BodyFatWindow()
	{
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/BodyFatWindow.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			Stage secondaryStage = new Stage();
			BodyFatWindowController secondWindowController = new BodyFatWindowController() ;
			secondWindowController= loader.getController();
			secondWindowController.setMain(this, secondaryStage);
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.WINDOW_MODAL);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void RestingWindow()
	{
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/RestingWindow.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			Stage secondaryStage = new Stage();
			RestingController secondWindowController = new RestingController() ;
			secondWindowController= loader.getController();
			secondWindowController.setMain(this, secondaryStage);
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
