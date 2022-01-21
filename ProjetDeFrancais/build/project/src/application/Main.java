package application;

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
	public void startPopupWindow(Stage primaryStage, String fxml)
	{
		try {
			FXMLLoader loader=new FXMLLoader(Main.class.getResource(fxml));
			AnchorPane pane = loader.load();
			Scene scene = new Scene (pane);
			Stage secondaryStage = new Stage();
			PopupWindowController popupWindowController = loader.getController();
			popupWindowController.setMain(this, secondaryStage, fxml);
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.WINDOW_MODAL);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void startAbsurdeMusic()
	{
		try{
			FXMLLoader loader=new FXMLLoader(Main.class.getResource("Mus/AbsurdeView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene (pane);
			Stage secondaryStage = new Stage();
			AbsurdeWindowController popupWindowController = loader.getController();
			popupWindowController.setMain(this, secondaryStage);
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.WINDOW_MODAL);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void startLumieresMusic()
	{
		try{
			FXMLLoader loader=new FXMLLoader(Main.class.getResource("Mus/LumieresView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene (pane);
			Stage secondaryStage = new Stage();
			LumieresWindowController aWindowController = loader.getController();
			aWindowController.setMain(this, secondaryStage);
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.WINDOW_MODAL);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void startHumanismeMusic()
	{
		try{
			FXMLLoader loader=new FXMLLoader(Main.class.getResource("Mus/HumanismeView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene (pane);
			Stage secondaryStage = new Stage();
			HumanismeWindowController aWindowController = loader.getController();
			aWindowController.setMain(this, secondaryStage);
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.WINDOW_MODAL);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void startBaroqueMusic()
	{
		try{
			FXMLLoader loader=new FXMLLoader(Main.class.getResource("Mus/BaroqueView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene (pane);
			Stage secondaryStage = new Stage();
			BaroqueWindowController aWindowController = loader.getController();
			aWindowController.setMain(this, secondaryStage);
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.WINDOW_MODAL);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void startClassicismMusic()
	{
		try{
			FXMLLoader loader=new FXMLLoader(Main.class.getResource("Mus/ClassicismeView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene (pane);
			Stage secondaryStage = new Stage();
			ClassicismeWindowController aWindowController = loader.getController();
			aWindowController.setMain(this, secondaryStage);
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.WINDOW_MODAL);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void startRomantismeMusic()
	{
		try{
			FXMLLoader loader=new FXMLLoader(Main.class.getResource("Mus/RomantismeView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene (pane);
			Stage secondaryStage = new Stage();
			RomantismeWindowController aWindowController = loader.getController();
			aWindowController.setMain(this, secondaryStage);
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.WINDOW_MODAL);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void startRealismeMusic()
	{
		try{
			FXMLLoader loader=new FXMLLoader(Main.class.getResource("Mus/RealismeView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene (pane);
			Stage secondaryStage = new Stage();
			RealismeWindowController aWindowController = loader.getController();
			aWindowController.setMain(this, secondaryStage);
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.WINDOW_MODAL);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void startNaturalismeMusic()
	{
		try{
			FXMLLoader loader=new FXMLLoader(Main.class.getResource("Mus/NaturalismeView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene (pane);
			Stage secondaryStage = new Stage();
			NaturalismeWindowController aWindowController = loader.getController();
			aWindowController.setMain(this, secondaryStage);
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.WINDOW_MODAL);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void startSymbolismeMusic()
	{
		try{
			FXMLLoader loader=new FXMLLoader(Main.class.getResource("Mus/SymbolismeView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene (pane);
			Stage secondaryStage = new Stage();
			SymbolismeWindowController aWindowController = loader.getController();
			aWindowController.setMain(this, secondaryStage);
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.WINDOW_MODAL);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void openPopupWindow(String type, String era)
	{
		String fxmlFile="";
		if(type.equals("Lit"))
		{
			switch(era)
			{
			case "Humanisme":
				fxmlFile="Lit/HumanismeView.fxml";
				break;
			case "Pleiade":
				fxmlFile="Lit/PleiadeView.fxml";
				break;
			case "Baroque":
				fxmlFile="Lit/BaroqueView.fxml";
				break;
			case "Classicisme":
				fxmlFile="Lit/ClassicismeView.fxml";
				break;
			case "Lumieres":
				fxmlFile="Lit/LumieresView.fxml";
				break;
			case "Romantisme":
				fxmlFile="Lit/RomantismeView.fxml";
				break;
			case "Realisme":
				fxmlFile="Lit/RealismeView.fxml";
				break;
			case "Naturalisme":
				fxmlFile="Lit/NaturalismeView.fxml";
				break;
			case "Symbolisme":
				fxmlFile="Lit/SymbolismeView.fxml";
				break;
			case "Absurde":
				fxmlFile="Lit/AbsurdeView.fxml";
				break;
			case "New Roman":
				fxmlFile="Lit/NewRomanView.fxml";
				break;
			case "Parnasse":
				fxmlFile="Lit/ParnasseView.fxml";
				break;
			}
		}
		else if(type.equals("Art"))
		{
			switch(era)
			{
			case "Humanisme":
				fxmlFile="Art/HumanismeView.fxml";
				break;
			case "Pleiade":
				fxmlFile="Art/PleiadeView.fxml";
				break;
			case "Baroque":
				fxmlFile="Art/BaroqueView.fxml";
				break;
			case "Classicisme":
				fxmlFile="Art/ClassicismeView.fxml";
				break;
			case "Lumieres":
				fxmlFile="Art/LumieresView.fxml";
				break;
			case "Romantisme":
				fxmlFile="Art/RomantismeView.fxml";
				break;
			case "Realisme":
				fxmlFile="Art/RealismeView.fxml";
				break;
			case "Naturalisme":
				fxmlFile="Art/NaturalismeView.fxml";
				break;
			case "Symbolisme":
				fxmlFile="Art/SymbolismeView.fxml";
				break;
			case "Absurde":
				fxmlFile="Art/AbsurdeView.fxml";
				break;
			case "New Roman":
				fxmlFile="Art/NewRomanView.fxml";
				break;
			case "Parnasse":
				fxmlFile="Art/ParnasseView.fxml";
				break;
			}
		}
		startPopupWindow(primaryStage, fxmlFile);
	}
	public static void main(String[] args) {
		launch(args);
	}
}
