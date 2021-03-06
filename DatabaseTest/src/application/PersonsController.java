package application;

import java.sql.SQLException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PersonsController {
    
    @FXML
    private TextField txtPhone;
    
    @FXML
    private ComboBox<Persons> cboID;
    
    @FXML
    private Button btnDelete;
    
    @FXML
    private Button btnAdd;
    
    @FXML
    private TextField txtAddress;
    
    @FXML
    private Button btnUpdate;
    
    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextField txtLastName;
    
    @FXML
    private TextField txtFirstName;
    @FXML
    private Label LabelID;
    
    //initialiser les données dans le combobox
	@FXML
    private void initialize() throws Exception
    {
    	ObservableList<Persons> PersonsList=PersonsDAO.getAllRecords();
    	
    	cboID.setItems(PersonsList);
    	cboID.valueProperty().addListener((obs, oldVal, newVal) ->
        showDetails(newVal));
  
    	
    }

	  /*
     * Afficher les détails
     *
     */
    
    public void showDetails(Persons person)
    {
        if(person!=null)
        {
            btnAdd.setDisable(true);
            LabelID.setText(String.valueOf(person.getId()));
            txtFirstName.setText(person.getFirstName());
            txtLastName.setText(person.getLastName());
            txtAddress.setText(person.getAddress());
            txtPhone.setText(person.getPhoneNumber());
            
        }
        else
        {
            btnAdd.setDisable(false);
            LabelID.setText("");
            txtFirstName.setText("");
            txtLastName.setText("");
            txtAddress.setText("");
            txtPhone.setText("");
        }
    }

    
    /*

     * Insertion de nouvelles personnes dansla base de données
     */
    @FXML
    private void insertPerson (ActionEvent event) throws ClassNotFoundException, SQLException
    {
        PersonsDAO.insertPersons(txtLastName.getText(), txtFirstName.getText(), txtAddress.getText(),txtPhone.getText());
        txtResult.setText("Personne ajoutée dans la BD");
    }
    
    /*
     * Modification de données d'une personne dans la base de données
     */
    @FXML
    private void modifPersonne(ActionEvent event) throws ClassNotFoundException, SQLException
    {
        try
        {
            PersonsDAO.updatePersons(Integer.parseInt(LabelID.getText()), txtLastName.getText(), txtFirstName.getText(), txtAddress.getText(), txtPhone.getText());
            txtResult.setText("Les données de " +txtLastName.getText()+ " ont été mises à jour" );
            // réinitialiser
            ObservableList<Persons> PersonsList=PersonsDAO.getAllRecords();
            cboID.setItems(PersonsList);
            
        }
        catch(SQLException e)
        {
            System.out.println("Erreur pour la mise à jour de données " + e);
            e.printStackTrace();
            throw e;
        }
    }

    /*
     * Effacer les données
     *
     */
    @FXML
    private void deletePersons(ActionEvent event) throws ClassNotFoundException, SQLException
    {
        try
        {
            PersonsDAO.deletePersonById(Integer.parseInt(LabelID.getText()));
            txtResult.setText("Données effacées de la BD ");
            ObservableList<Persons> PersonsList=PersonsDAO.getAllRecords();
            cboID.setItems(PersonsList);
           
           
            
        }
        catch(SQLException e)
        {
            System.out.println("Erreur pour la suppression de données " + e);
            e.printStackTrace();
            throw e;
        }
    }
 
}
