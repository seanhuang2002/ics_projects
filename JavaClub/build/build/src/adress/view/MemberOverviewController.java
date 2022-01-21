package adress.view;

import adress.Main;
import adress.model.Member;
import adress.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;

public class MemberOverviewController 
{
	private Main main;
	   @FXML
	    private TableView<Member> memberTable;
	    @FXML
	    private TableColumn<Member,String> prenomColumn;
	    @FXML
	    private TableColumn<Member,String> nomColumn;
	    @FXML
	    private Label prenomLabel;
	    @FXML
	    private Label nomLabel;
	    @FXML
	    private Label rueLabel;
	    @FXML
	    private Label codepostalLabel;
	    @FXML
	    private Label villeLabel;
	    @FXML
	    private Label telephoneLabel;
	    @FXML
	    private Label emailLabel;
	    @FXML
	    private Label anniversaireLabel;
	    
	    /**
	     * ==============================================================
	     * Le Constructeur sera appelé avant le Initialize()
	     * Nous mettons un constructeur vide
	     * =============================================================
	     */   
	    public MemberOverviewController() 
	    {
	    }
	    
	    @FXML
	    private void initialize()
	    {
	        // Initialisation de la tableview des membres avec les deux premières colonnes.
	        prenomColumn.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
	        nomColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
	        
	        // vider le contenu des informations personnelles.
	        showMemberDetails(null);

	        // Suivre les changements en foncton des selections faites et afficher les détails des informations personnelles
	        memberTable.getSelectionModel().selectedItemProperty().addListener(
	                (observable, oldValue, newValue) -> showMemberDetails(newValue));
	    }  
	    
	    /**
	     * ==================================================================================
	     * Cette methode est invoquée à partir du Main
	     * 
	     * ==================================================================================
	     * @param main
	     */
	    public void setMain(Main main) {
	        this.main = main;

	        // Ajouter un observable list de données à la table en se referant au getMemberData
	        memberTable.setItems(main.getMemberData());
	    } 
	    /**
	     * ===================================================================================
	     * Affichage des Informations détaillées des membres
	     * Si l'information du membre est nulle, rien ne va s'afficher.
	     * ===================================================================================
	     * @param member ou null
	     */
	    private void showMemberDetails(Member member) {
	        if (member != null) 
	        {
	            prenomLabel.setText(member.getPrenom());
	            nomLabel.setText(member.getNom());
	            rueLabel.setText(member.getRue());
	            villeLabel.setText(member.getVille());
	            codepostalLabel.setText(member.getCodePostal());
	            telephoneLabel.setText(member.getTelephone());
	            emailLabel.setText(member.getEmail());
	            anniversaireLabel.setText(DateUtil.format(member.getAnniversaire()));
	        } else {
	            // si les données du membre ne sont pas disponible, effacer le contenu des champs
	            prenomLabel.setText("");
	            nomLabel.setText("");
	            rueLabel.setText("");
	            villeLabel.setText("");
	            codepostalLabel.setText("");
	            telephoneLabel.setText("");
	            emailLabel.setText("");
	            anniversaireLabel.setText("");
	        }        
	    }    
	  /**
	   * Effacer un membre
	   */
	    @FXML
        private void handleDeleteMember() 
	    {
            int selectedIndex = memberTable.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) // donc un membre a été selectionné
            {
                memberTable.getItems().remove(selectedIndex);
            }
            else  // rien n'a été selectionné - message d'alerte
            {
                Alert alert = new Alert(AlertType.WARNING);
                alert.initOwner(main.getPrimaryStage());
                alert.setTitle("Information manquante");
                alert.setHeaderText("Pas de membre choisi");
                alert.setContentText("Il faudrait choisir un membre dans le tableau.");
                
                alert.showAndWait();
            }
        }
	    
/**
*==================================================================
* On choisit de créer un nouveau membre.Une fenêtre pour ajouter
*  un membre s'ouvre
*==================================================================
*/
	    @FXML
	    private void handleNewMember() {
	        Member tempMember = new Member();
	        boolean okClicked = main.showMemberEdit(tempMember);
	        if (okClicked) {
	            main.getMemberData().add(tempMember);
	        }
	    }
	    /**
	     *==================================================================
	     * On choisit de modifier les informations d'un membre.
	     * Une boite de dialogue s'ouvre pour faire les modifications.
	     *==================================================================
	     */
	    @FXML
	    private void handleEditMember() {
	        Member selectedMember = memberTable.getSelectionModel().getSelectedItem();
	        if (selectedMember != null) {
	            boolean okClicked = main.showMemberEdit(selectedMember);
	            if (okClicked) {
	                showMemberDetails(selectedMember);
	            }

	        } else // Aucune selection n'a été faite
	        {
	            
	            Alert alert = new Alert(AlertType.WARNING);
	            alert.initOwner(main.getPrimaryStage());
	            alert.setTitle("Information manquante");
	            alert.setHeaderText("Pas de membre choisi");
	            alert.setContentText("Il faudrait choisir un membre dans le tableau.");
	            
	            alert.showAndWait();
	        }
	    }
    
	    
	    
	    
	    
	    

}














