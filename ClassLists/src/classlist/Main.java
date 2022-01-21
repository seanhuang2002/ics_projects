package classlist;

import java.io.IOException;


import classlist.view.EntryOverviewController;
import classlist.view.PatientOverviewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("ClassApp");
        

        EntryOverview();
        initRootLayout();
        //showPatientOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void EntryOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/EntryOverview.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();
            rootLayout.setCenter(pane);
            EntryOverviewController controller = loader.getController();
			controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showPatientOverview() {
    	try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("PatientOverview.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			Stage secondaryStage = new Stage();
			PatientOverviewController secondWindowController = loader.getController();
			secondWindowController.setMain(this, secondaryStage);
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.WINDOW_MODAL);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}