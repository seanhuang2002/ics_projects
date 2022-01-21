package application;
	
import application.model.Order;
import application.view.CreationController;
import application.view.OrderDetailsController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage primaryStage;
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		openMainWindow(primaryStage);
	}
	
	public void openMainWindow(Stage primaryStage)
	{
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("view/MainWindow.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openCreationWindow(boolean employee)
	{
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/CreationWindow.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			CreationController controller = loader.getController();
			controller.setDialogStage(dialogStage, employee);
			dialogStage.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openOrderDetailsWindow(boolean modify, Order order)
	{
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/OrderDetailsWindow.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			OrderDetailsController controller = loader.getController();
			controller.setDialogStage(dialogStage, modify, order);
			dialogStage.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
