package adress.view;

import java.io.File;

import adress.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

/*
 * Cette classe fournit le foctionnalité de base
 * pour le RootLayout afin de sauver et accéder aux préferences
 * de l'usager
 */

public class RootLayoutController {
	
	
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    /*
     * Creer un carnet d'adresses vide.
     */
    @FXML
    private void handleNew() {
        main.getMemberData().clear();
        main.setMemberFilePath(null);
    }

    /*
     * Le FileChooser permet à l'usager de choisir le fichier à ouvrir.
     */
    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();

        // Permettre un filtre sur l'extension du fichier à chercher
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // montrer le dialogue
        File file = fileChooser.showOpenDialog(main.getPrimaryStage());

        if (file != null) {
            main.loadMemberDataFromFile(file);
        }
    }

    /*
     * Sauvegarde le fichier correspondant au membre actif.
     * S'il n y a pas de fichier, le menu sauvegarder Sous va s'afficher
     */
    @FXML
    private void handleSave() {
        File memberFile = main.getMemberFilePath();
        if (memberFile != null) {
            main.saveMemberDataToFile(memberFile);
        } else {
            handleSaveAs();
        }
    }

    /*
     * Ouvrir le FileChooser pour chercher le fichier à ouvrir.
     */
    @FXML
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Sauvegarde
        File file = fileChooser.showSaveDialog(main.getPrimaryStage());

        if (file != null) {
            // Vérification de l'extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            main.saveMemberDataToFile(file);
        }
    }

    /*
     * À propos.
     */
    @FXML
    private void handleAbout() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("JavaClub");
    	alert.setHeaderText("À Propos");
    	alert.setContentText("Auteur: S.Huang");

    	alert.showAndWait();
    }

    /*
     * Quitter.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
    /**
     * Opens the birthday statistics.
     */
    @FXML
    private void handleShowBirthdayStatistics() {
      main.showBirthdayStats();
    }

}

