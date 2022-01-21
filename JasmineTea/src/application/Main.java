package application;

import java.sql.SQLException;

import application.classes.Student;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Main extends Application {
	private Stage primaryStage;
	public static ObservableList<application.classes.Student> students = FXCollections.observableArrayList();
	
	@Override
	public void start(Stage primaryStage) 
	{
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("TFS Parents Association");
		this.primaryStage.getIcons().add(new Image("file:resource/images/Logo copy 3.png"));
		openMainWindow(primaryStage);
		//Get all students from data base
		try {
			students=DBActions.getAllStudents();
		} catch (ClassNotFoundException | SQLException e) {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setHeaderText("An error has occured");
			alert.setTitle("Error");
			alert.setContentText("An error occured while student information was retreived from the database.");
			alert.show();
			//e.printStackTrace();
		}
	}
	public void openMainWindow(Stage primaryStage)
	{
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("loginView.fxml"));
			AnchorPane pane =loader.load();
			LoginViewController Logincontroller= loader.getController();
			Logincontroller.setMain(this);
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	public void openHomeWindow()
	{
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("home.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			HomeController homecontroller = loader.getController();
			homecontroller.setMain(this);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void openSearchWindow()
	{
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("Search.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			SearchController searchcontroller = loader.getController();
			searchcontroller.setMain(this);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void openOrderWindow(Student s)
	{
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("orders.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			OrderController ordercontroller = loader.getController();
			ordercontroller.setMain(this);
			primaryStage.setScene(scene);
			ordercontroller.setStudent(s);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void openEditWindow(Student s)
	{
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("EditStudentView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			EditStudentController editStudentController = loader.getController();
			editStudentController.setMain(this);
			primaryStage.setScene(scene);
			editStudentController.setStudent(s);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void openModifyWindow()
	{
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("ModifyItemView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			ModifyItemController editStudentController = loader.getController();
			editStudentController.setMain(this);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openCreateProductWindow() {
		try {
			Stage dialog = new Stage();
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("CreateItemView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			CreateItemController searchcontroller = loader.getController();
			searchcontroller.setMain(this, dialog);
			dialog.setScene(scene);
			dialog.initOwner(primaryStage);
			dialog.initModality(Modality.APPLICATION_MODAL); 
			dialog.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
