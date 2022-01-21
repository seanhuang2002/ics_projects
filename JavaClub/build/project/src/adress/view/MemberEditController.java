package adress.view;
import adress.model.Member;
import adress.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MemberEditController 
{
	@FXML
	private TextField prenomField;
    @FXML
    private TextField nomField;
    @FXML
    private TextField rueField;
    @FXML
    private TextField codepostalField;
    @FXML
    private TextField telephoneField;
    @FXML
    private TextField villeField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField anniversaireField;
    private Stage dialogStage;
    private Member member;
    private boolean okClicked = false;

	    /**
	     * Methode invoquée juste après
	     * le chargement du fichier fxml
	     */
	    @FXML
	    private void initialize() 
	    {
	    }

	    /**
	     * Initialisation des paramètres
	     * 
	     * @param dialogStage
	     */
	    public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	    }

	    /**
	     * Mettre les informations de la personne
	     * à modifier
	     * @param member
	     */
	    public void setMember(Member member) {
	        this.member = member;

	        prenomField.setText(member.getPrenom());
	        nomField.setText(member.getNom());
	        rueField.setText(member.getRue());
	        villeField.setText(member.getVille());
	        telephoneField.setText(member.getTelephone());
	        codepostalField.setText(member.getCodePostal());
	        emailField.setText(member.getEmail());
	        anniversaireField.setText(DateUtil.format(member.getAnniversaire()));
	        anniversaireField.setPromptText("dd.mm.yyyy");
	    }

	    /*
	     * Retourne True si clické  sinon retourne False
	     * 
	     * @return
	     */
	    public boolean isOkClicked() {
	        return okClicked;
	    }

	    /*
	     * Quand l'usager clicque sur valider.
	     */
	    @FXML
	    private void handleOk() {
	        if (isInputValid()) {
	            member.setPrenom(prenomField.getText());
	            member.setNom(nomField.getText());
	            member.setRue(rueField.getText());
	            member.setVille(villeField.getText());
	            member.setTelephone(telephoneField.getText());
	            member.setCodePostal(codepostalField.getText());
	            member.setEmail(emailField.getText());
	            member.setAnniversaire(DateUtil.parse(anniversaireField.getText()));
	            okClicked = true;
	            dialogStage.close();
	        }
	    }

	    /*
	     * Quand l'usager clique sur annuler.
	     */
	    @FXML
	    private void handleCancel() {
	        dialogStage.close();
	    }

	    /**
	     * Validation des champs
	     * 
	     * @return TRUE si valeurs valides
	     */
	    private boolean isInputValid() 
	    {
	        String errorMessage = "";

	        if (prenomField.getText() == null || prenomField.getText().length() == 0) 
	        {
	            errorMessage += "Prénom non valide!\n";
	        }
	        if (nomField.getText() == null || nomField.getText().length() == 0) 
	        {
	            errorMessage += "Nom non valide!\n";
	        }
	        if (rueField.getText() == null || rueField.getText().length() == 0) 
	        {
	            errorMessage += "Adresse non valide!\n";
	        }

	        if (codepostalField.getText() == null || codepostalField.getText().length() == 0) 
	        {
	            errorMessage += "Code postal non valide !\n";
	        }

	        if (villeField.getText() == null || villeField.getText().length() == 0) {
	            errorMessage += "Nom de ville non valide !\n";
	        }

	        if (anniversaireField.getText() == null || anniversaireField.getText().length() == 0) {
	            errorMessage += "Date de naissance non valide !\n";
	        } else {
	            if (!DateUtil.validDate(anniversaireField.getText())) 
	            {
	                errorMessage += "Pour les dates, utiliser le format dd.mm.yyyy!\n";
	            }
	        }

	        if (errorMessage.length() == 0) {
	            return true;
	        } else {
	            // Afficher le message
	            Alert alert = new Alert(AlertType.ERROR);
	            alert.initOwner(dialogStage);
	            alert.setTitle("Champs non valides");
	            alert.setHeaderText("Veuillez corriger les champs non valides");
	            alert.setContentText(errorMessage);
	            alert.showAndWait();
	            
	            return false;
	        }
	    }
	       
	}
