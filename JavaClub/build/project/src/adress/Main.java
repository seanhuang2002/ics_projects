package adress;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import adress.model.Member;
import adress.model.MemberListWrapper;
import adress.view.BirthdayStatisticsController;
import adress.view.MemberEditController;
import adress.view.MemberOverviewController;
import adress.view.RootLayoutController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application 
{
	private Stage primaryStage;
	private BorderPane rootLayout;
	/**
	 * Les données sont conservées sous forme de ObservableList
	 */
	private ObservableList<Member> memberData = FXCollections.observableArrayList();

	public Main()
	{
		//Ajouter des données pour certains membres
		memberData.add(new Member("Hans", "Muster"));
		memberData.add(new Member("Ruth", "Mueller"));
		memberData.add(new Member("Heinz", "Kurz"));
		memberData.add(new Member("Cornelia", "Meier"));
		memberData.add(new Member("Werner", "Meyer"));
		memberData.add(new Member("Lydia", "Kunz"));
		memberData.add(new Member("Anna", "Best"));
		memberData.add(new Member("Stefan", "Meier"));
		memberData.add(new Member("Martin", "Mueller"));
	}
	/** 
	 * Pour retourner la liste des membres.
	 * @return
	 */
	public ObservableList <Member> getMemberData()
	{
		return memberData;
	}

	@Override
	public void start(Stage primaryStage) 
	{
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("JavaClub");
		this.primaryStage.getIcons().add(new Image("file:resources/images/address_book_32.png"));
		initRootLayout();
		showMemberOverview();
	}
	/**====================================
     * Initialisation dela racine Root.
     * ====================================
     */
    public void initRootLayout() {
        try {
            // Charger le Layout de la racine (root).
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            //Donner l’accès au controller
            RootLayoutController controller = loader.getController();
            controller.setMain(this);

            // Afficher la scène de la racine (root)
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
     // Tenter de charger le dernier fichier ouvert.
        File file = getMemberFilePath();
        if (file != null) {
            loadMemberDataFromFile(file);
        }

    }
	/**
	 * ==============================================
	 * Afficher la fenêtre des membres dans la racine
	 * ==============================================
	 */
	public void showMemberOverview()
	{
		try {
			//Changer la view des membres
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/MemberOverview.fxml"));
			AnchorPane memberOverview = (AnchorPane) loader.load();
			//Placer la fenêtre des membres au milieu de la racine Root
			rootLayout.setCenter(memberOverview);
			//Donner accès aux données
			MemberOverviewController controller = loader.getController();
			controller.setMain(this);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	/**
	 * Modification des informations sur le membre
	 * @param member
	 * @return
	 */
	public boolean showMemberEdit(Member member) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/MemberEdit.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Modifier un membre");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Definir le controller
			MemberEditController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setMember(member);

			// Afficher le dialogue et attendre que l'usager le referme
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	/*=======================================================
	 * Permettre de garder les préférences de l’usager comme
	 * le dernier fichier utilisé
	 * 
	 * =====================================================
	 * @return
	 */
	public File getMemberFilePath() {
		Preferences prefs = Preferences.userNodeForPackage(Main.class);
		String filePath = prefs.get("filePath", null);
		if (filePath != null) {
			return new File(filePath);
		} else {
			return null;
		}
	}

	/*
	 * Garder les informations sur le présent fichier dans la base de registres 
	 * du système d’exploitation
	 * @param fichier actuel
	 */
	public void setMemberFilePath(File file) {
		Preferences prefs = Preferences.userNodeForPackage(Main.class);
		if (file != null) {
			prefs.put("filePath", file.getPath());

			// Mettre à jour le titre.
			primaryStage.setTitle("JavaClub - " + file.getName());
		} else {
			prefs.remove("filePath");

			// Mettre à jour l’entête de l’application.
			primaryStage.setTitle("JavaClub");
		}
	}
	/*
	 * Prendre les informations d’un membre à partir d’un fichier. 
	 * Les informations courantes seront remplacées.
	 * @param file
	 */
	public void loadMemberDataFromFile(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(MemberListWrapper.class);
			Unmarshaller um = context.createUnmarshaller();

			// Lire les données du fichier XML
			MemberListWrapper wrapper = (MemberListWrapper) um.unmarshal(file);

			memberData.clear();
			memberData.addAll(wrapper.getMembers());

			// Sauvegarder le fichier au niveau du registre.
			setMemberFilePath(file);

		} catch (Exception e) { 
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erreur");
			alert.setHeaderText("Les données n’ont pas été trouvées");
			alert.setContentText("Les données ne pouvaient pas être trouvées dans le fichier:\n" + file.getPath());

			alert.showAndWait();
		}
	}
	/*
	 * Sauvegarde les données actuelles dans le fichier spécifié.
	 * 
	 * @param file
	 */
	public void saveMemberDataToFile(File file) {
		try {
			JAXBContext context = JAXBContext
					.newInstance(MemberListWrapper.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


			MemberListWrapper wrapper = new MemberListWrapper();
			wrapper.setMembers(memberData);

			m.marshal(wrapper, file);

			// Sauvegarde dans le registre.
			setMemberFilePath(file);
		} catch (Exception e) { 
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erreur");
			alert.setHeaderText("Données non sauvegardées");
			alert.setContentText("Les données ne pouvaient pas être sauvegardées dans le fichier:\n" + file.getPath());

			alert.showAndWait();
		}
	}
	/**
	 * Opens a dialog to show birthday statistics.
	 */
	public void showBirthdayStats() {
	    try {
	        // Load the fxml file and create a new stage for the popup.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("view/BirthdayStatictics.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Statistiques d'Anniversaire");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Set the persons into the controller.
	        BirthdayStatisticsController controller = loader.getController();
	        controller.setPersonData(memberData);

	        dialogStage.show();

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	// Retourner le main avec son Stage
	public Stage getPrimaryStage() {
		return primaryStage;
	} 
	public static void main(String[] args) 
	{
		launch(args);
	}
}
