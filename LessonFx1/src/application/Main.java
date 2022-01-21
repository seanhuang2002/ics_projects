package application;
	
import java.io.IOException;
/*Java is made by classes and each is unique, if you want to use a method 
from a class, you need to import the class. Eclipse will import a class
if needed. Pay attention that the classes are 'javafx'*/
import javafx.application.Application;
import javafx.fxml.FXMLLoader;//Lets us use .xml files
import javafx.stage.Stage;//Creates a base for the program
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;//A way to organize elements on the scene
//AnchorPane lets you place elements and move them around in the scene


public class Main extends Application {
	/* The main inherates all properties of the 'extends'*/
	private Stage primaryStage;
	@Override
	public void start(Stage primaryStage) //there is always a start in JavaFX
	{
		try {
			this.primaryStage=primaryStage; //The stage of the application
			//this is used to specify an object that belongs to the primary stage 
			mainWindow();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	// Afficher les éléments de la fenêtre
	public void mainWindow()
	{
		try {
			FXMLLoader loader=new FXMLLoader(Main.class.getResource("MainWindowView.fxml"));
			//An FXML object is created and the Main.class will use this FXML
			//This is the connection between the main to class
			AnchorPane pane = loader.load();
			//Declaring and initialising the layout
			MainWindowController mainWindowController = loader.getController();
			//connection to the controller
			mainWindowController.setMain(this);
			//This references a method within the controller 
			Scene scene = new Scene (pane);
			//Creating the scene
			primaryStage.setScene(scene);
			//putting the scene in the Stage
			primaryStage.show();
			//shows the stage
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
		//it starts everything and the table args. 
		//Args will execute the program, starting from the 'start'
	}
}
