package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.sql.SQLException;

import application.Entry;

public class Controller {

	@FXML
	private TableColumn<Entry, String> columnBodyFat;

	@FXML
	private TextField fieldDia;

	@FXML
	private Button buttNew;

	@FXML
	private TableColumn<Entry, String> columnSys;

	@FXML
	private TextField fieldBMI;

	@FXML
	private TextField fieldMonth;

	@FXML
	private TextArea fieldMSG;

	@FXML
	private TextField fieldHeight;

	@FXML
	private TableColumn<Entry, String> columnBloodSugar;

	@FXML
	private Button buttSubmit;

	@FXML
	private TableColumn<Entry, String> columnWeight;

	@FXML
	private TextField fieldWaist;

	@FXML
	private TableColumn<Entry, String> columnWaist;

	@FXML
	private TableColumn<Entry, String> columnDia;

	@FXML
	private TextField fieldSys;

	@FXML
	private Button buttDelete;

	@FXML
	private TableColumn<Entry, String> columnHeight;

	@FXML
	private TextField fieldBodyFat;

	@FXML
	private Button buttEdit;

	@FXML
	private TableColumn<Entry, String> columnBMI;

	@FXML
	private TableColumn<Entry, String> columnHeartRate;

	@FXML
	private TextField fieldDay;

	@FXML
	private TableColumn<Entry, Integer> columnID;

	@FXML
	private TableView<Entry> tableView;

	@FXML
	private TextField fieldHeartRate;

	@FXML
	private TextField fieldWeight;

	@FXML
	private TableColumn<Entry, String> columnYear;

	@FXML
	private TableColumn<Entry, String> columnDay;

	@FXML
	private TableColumn<Entry, String> columnMonth;

	@FXML
	private TextField fieldBloodSugar;

	@FXML
	private Label selectedID;

	@FXML
	private TextField fieldYear;

	private int IDselected = 0;

	private boolean creatingNew = true;

	private boolean entrySelected=false;

	private ObservableList<Entry> data =
			FXCollections.observableArrayList(
					new Entry("1","1","1"));
	@FXML
	private void initialize() throws Exception
	{
		fieldMSG.setWrapText(true);
		columnMonth.setCellValueFactory(cellData -> cellData.getValue().monthProperty());
		columnDay.setCellValueFactory(cellData -> cellData.getValue().dayProperty());
		columnYear.setCellValueFactory(cellData -> cellData.getValue().yearProperty());
		columnHeight.setCellValueFactory(cellData -> cellData.getValue().heightProperty());
		columnWeight.setCellValueFactory(cellData -> cellData.getValue().weightProperty());
		columnWaist.setCellValueFactory(cellData -> cellData.getValue().waistProperty());
		columnBodyFat.setCellValueFactory(cellData -> cellData.getValue().bodyFatProperty());
		columnSys.setCellValueFactory(cellData -> cellData.getValue().sysProperty());
		columnDia.setCellValueFactory(cellData -> cellData.getValue().diaProperty());
		columnBloodSugar.setCellValueFactory(cellData -> cellData.getValue().bloodSugarProperty());
		columnHeartRate.setCellValueFactory(cellData -> cellData.getValue().heartRateProperty());
		columnBMI.setCellValueFactory(cellData -> cellData.getValue().bmiProperty());
		columnID.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
		handleFields("disable");
		refreshEntries();
	}

	public void handleFields(String type)
	{
		if(type.equals("disable"))
		{
			tableView.requestFocus();
			fieldMonth.setDisable(true);
			fieldDay.setDisable(true);
			fieldYear.setDisable(true);
			fieldHeight.setDisable(true);
			fieldWeight.setDisable(true);
			fieldWaist.setDisable(true);
			fieldBodyFat.setDisable(true);
			fieldSys.setDisable(true);
			fieldDia.setDisable(true);
			fieldBloodSugar.setDisable(true);
			fieldHeartRate.setDisable(true);
			fieldBMI.setDisable(true);
		}
		else if(type.equals("enable"))
		{
			fieldMonth.setDisable(false);
			fieldDay.setDisable(false);
			fieldYear.setDisable(false);
			fieldHeight.setDisable(false);
			fieldWeight.setDisable(false);
			fieldWaist.setDisable(false);
			fieldBodyFat.setDisable(false);
			fieldSys.setDisable(false);
			fieldDia.setDisable(false);
			fieldBloodSugar.setDisable(false);
			fieldHeartRate.setDisable(false);
			fieldBMI.setDisable(false);
		}
		else if(type.equals("clear"))
		{
			fieldMonth.setText("");
			fieldDay.setText("");
			fieldYear.setText("");
			fieldHeight.setText("");
			fieldWeight.setText("");
			fieldWaist.setText("");
			fieldBodyFat.setText("");
			fieldSys.setText("");
			fieldDia.setText("");
			fieldBloodSugar.setText("");
			fieldHeartRate.setText("");
			fieldBMI.setText("");
		}
	}

	public void onClickedTable()
	{
		Entry entry = tableView.getSelectionModel().getSelectedItem();
		if(entry!=null)
		{
			entrySelected=true;
		}
		IDselected=entry.getId();
		selectedID.setText(Integer.toString(entry.getId()));
		fieldDay.setText(entry.getDay());
		fieldMonth.setText(entry.getMonth());
		fieldYear.setText(entry.getYear());
		fieldHeight.setText(entry.getHeight());
		fieldWeight.setText(entry.getWeight());
		fieldWaist.setText(entry.getWaist());
		fieldBodyFat.setText(entry.getBodyFat());
		fieldSys.setText(entry.getSys());
		fieldDia.setText(entry.getDia());
		fieldBloodSugar.setText(entry.getBloodSugar());
		fieldHeartRate.setText(entry.getHeartRate());
		fieldBMI.setText(entry.getBmi());
	}

	public void handleEdit()
	{
		fieldMSG.setText("Editing entry number "+selectedID.getText());
		if(entrySelected)
		{
			creatingNew = false;
			handleFields("enable");
		}
		else
		{
			fieldMSG.setText("Please select an entry to edit");
		}
	}

	public void handleDelete()
	{
		fieldMSG.setText("");
		if(entrySelected)
		{
			try {
				EntryFunctions.deleteEntryById(IDselected);
				refreshEntries();
				resetFields();
				fieldMSG.setText("Entry sucessfully deleted!");
			} catch (ClassNotFoundException | SQLException e) {
				fieldMSG.setText("Error encountered when deleting: "+e.toString());
				e.printStackTrace();
			} 
		}
		else
		{
			fieldMSG.setText("Please select an entry to delete");
		}
	}
	//insert into HealthPlus(month, day, year) values ('01','02','1998')
	public void handleNew()
	{
		fieldMSG.setText("Creating new entry");
		creatingNew=true;
		handleFields("enable");
		handleFields("clear");
	}

	public void handleSubmit()
	{
		if(creatingNew)
		{
			try {
				EntryFunctions.insertEntry(fieldDay.getText(),fieldMonth.getText(),fieldYear.getText(),fieldHeight.getText(),fieldWeight.getText(),fieldWaist.getText(),fieldBodyFat.getText(),
						fieldSys.getText(),fieldDia.getText(),fieldBloodSugar.getText(),fieldHeartRate.getText(),fieldBMI.getText());
				fieldMSG.setText("Entry successfully created!");
				refreshEntries();
				resetFields();
			} catch (ClassNotFoundException | SQLException e) {
				fieldMSG.setText("Error encountered when submitting new entry: "+e.toString());
				e.printStackTrace();
			}
		}
		else if(creatingNew==false)
		{
			try {
				EntryFunctions.updateEntry(IDselected,fieldDay.getText(),fieldMonth.getText(),fieldYear.getText(),fieldHeight.getText(),fieldWeight.getText(),fieldWaist.getText(),fieldBodyFat.getText(),
						fieldSys.getText(),fieldDia.getText(),fieldBloodSugar.getText(),fieldHeartRate.getText(),fieldBMI.getText());
				fieldMSG.setText("Entry sucessfully edited!");
				refreshEntries();
				resetFields();
			} catch (ClassNotFoundException | SQLException e) {
				fieldMSG.setText("Error encountered when submitting edited entry: "+e.toString());
				e.printStackTrace();
			}
		}
	}

	public void resetFields()
	{
		handleFields("disable");
		handleFields("clear");
		IDselected=0;
		selectedID.setText("None");
		entrySelected=false;
	}
	
	public void refreshEntries() throws ClassNotFoundException, SQLException
	{
		data = EntryFunctions.getAllEntries();
		tableView.getItems().clear();
		tableView.setItems(data);
	}
}
