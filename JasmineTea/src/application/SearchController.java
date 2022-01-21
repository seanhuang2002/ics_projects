package application;

import application.classes.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class SearchController {

    @FXML
    private TextField searchField;
    @FXML
    private Button closeButton;
    @FXML
    private Button SelectStudentButton;
    @FXML
    private TableView<application.classes.Student> studentTable;
    @FXML
    private TableColumn<application.classes.Student, String> firstNameColumn;
    @FXML
    private TableColumn<application.classes.Student, String> lastNameColumn;
    @FXML
    private TableColumn<application.classes.Student, String> levelGradeColumn;
    @FXML
    private TableColumn<application.classes.Student, Integer> idColumn;
    @FXML
    private TableColumn<application.classes.Student, String> parentEmailColumn;
    private Main main;
    
    @FXML
    private void initialize() {
    	//Set table view columns
    	firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().getFirstNameProperty());
    	lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().getLastNameProperty());
    	levelGradeColumn.setCellValueFactory(cellData -> cellData.getValue().getLevelGradeProperty());
    	idColumn.setCellValueFactory(cellData -> cellData.getValue().getStudentIdProperty().asObject());
    	parentEmailColumn.setCellValueFactory(cellData -> cellData.getValue().getParent1EmailProperty());
    	
    	//Action listener for the search text field
    	searchField.textProperty().addListener((observable, oldValue, newValue) -> searchAndShow(newValue));
    }
    
    public void setMain(Main main)
    {
    		this.main=main;
    		studentTable.setItems(Main.students);
    }
    
	public void searchAndShow(String a) {
		ObservableList<Student> filteredStudents = FXCollections.observableArrayList();
		for(Student s : Main.students) {
    		if(s.getLastName().toLowerCase().startsWith(a.toLowerCase()))
    			filteredStudents.add(s);
    	}
		studentTable.setItems(filteredStudents);
    }
    
    public void selectStudent() {
    	Student s = studentTable.getSelectionModel().getSelectedItem();
    	if(s!=null)
    	main.openOrderWindow(s);
    	else {
    		Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Oops!");
			alert.setTitle("Information");
			alert.setContentText("You must select a student by clicking on the table to continue.");
			alert.show();
    	}
    		
    }
    
    public void open()
    {
    		Student s = studentTable.getSelectionModel().getSelectedItem();
    		main.openEditWindow(s);
    }

    public void close() {
    	//closes the window
    	main.openHomeWindow();
    }
    

}
