package adress.view;

import java.io.File;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import adress.Main;
import adress.model.Entry;
import adress.model.EntryListWrapper;
import adress.util.MyDateStringConverter;
import adress.util.MyDoubleStringConverter;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TableAppController implements Initializable {

	private Main main;
	private Stage secondaryStage;
	public void setMain(Main main, Stage secondaryStage)
	{
		this.main=main;
		this.secondaryStage=secondaryStage;
	}
	@FXML
	private TableView<EntryTableData> table;

	@FXML 
	private TextField bmiTextField;

	@FXML
	private TableColumn<EntryTableData, Double> bmiColumn;

	@FXML
	private TextField weightTextField;

	@FXML
	private TableColumn<EntryTableData, Double> weightColumn;

	@FXML
	private TextField heightTextField;

	@FXML
	private TableColumn<EntryTableData, Double> heightColumn;

	@FXML
	private TextField dateOfBirthTextField;

	@FXML
	private TableColumn<EntryTableData, Date> dateOfBirthColumn;

	@FXML
	private TextField bloodPressureTextField;

	@FXML
	private TableColumn<EntryTableData, Double> bloodPressureColumn;

	@FXML
	private TextField bloodSugarTextField;

	@FXML
	private TableColumn<EntryTableData,Double> bloodSugarColumn;

	@FXML
	private TextField waistTextField;

	@FXML
	private TableColumn<EntryTableData,Double> waistColumn;

	@FXML
	private TextField heartRateTextField;

	@FXML
	private TableColumn<EntryTableData,Double> heartRateColumn;

	@FXML
	private TextField bodyFatTextField;

	@FXML
	private TableColumn<EntryTableData,Double> bodyFatColumn;

	@FXML
	private Button submitButton;
	
	@FXML
	private ScatterChart<Double,Double> weightChart;
	
	@FXML
	private ScatterChart<Double,Double> bodyFatChart;
	
	@FXML
	private ScatterChart<Double,Double> bmiChart;
	
	@FXML
	private ScatterChart<Double,Double> waistChart;
	
	@FXML
	private ScatterChart<Double,Double> bloodSugarChart;

	public ObservableList<EntryTableData> data = FXCollections
			.observableArrayList();

	private static final String DATE_PATTERN = "dd/MM/yyyy";

	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(
			DATE_PATTERN);

	@Override
	public void initialize(final URL url, final ResourceBundle rb) {
		DATE_FORMATTER.setLenient(false);
		table.setItems(data);
		populate(retrieveData());
		setupDateOfBirthColumn();
		setupSalaryColumn();
		setupHeartRateColumn();
		setupWeightColumn();
		setupWaistColumn();
		setupBodyMassIndexColumn();
		setupBloodPressureColumn();
		setupBodyFatColumn();
		setupBloodSugarColumn();
		Platform.runLater(this::onStartup);

	}
	public void onStartup()
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Record Book");
		alert.setHeaderText("Record Book");
		alert.setContentText("Choose your option.");
		
		ButtonType buttonTypeOne = new ButtonType("New Profile");
		ButtonType buttonTypeTwo = new ButtonType("Load Profile");
		ButtonType buttonTypeCancel = new ButtonType("Close", ButtonData.CANCEL_CLOSE);

		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne){
		   handleNew();
		} 
		else if (result.get() == buttonTypeTwo) {
		    // ... user chose "Two"
			handleOpen();
		} 
		else {
		    secondaryStage.close();
		}
	}
	private List<Entry> retrieveData() {
		try {
			Entry intArray = null;
			intArray=new Entry(1, 2, 3, 4, 5, 6, 7, 8, DATE_FORMATTER.parse("24/01/1995"));
			return Arrays.asList(intArray);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new ArrayList<Entry>();
	}
	private void populate(final List<Entry> people) {
		people.forEach(p -> data.add(new EntryTableData(p)));

	}
	private void setupDateOfBirthColumn() {
		dateOfBirthColumn
		.setCellFactory(EditCell.<EntryTableData, Date>forTableColumn(
				new MyDateStringConverter(DATE_PATTERN)));
	}
	private void setupHeartRateColumn() {
		heartRateColumn.setCellFactory(
				EditCell.<EntryTableData, Double>forTableColumn(
						new MyDoubleStringConverter()));
	}
	private void setupWeightColumn() {
		weightColumn.setCellFactory(
				EditCell.<EntryTableData, Double>forTableColumn(
						new MyDoubleStringConverter()));
	}
	private void setupSalaryColumn() {
		heightColumn.setCellFactory(
				EditCell.<EntryTableData, Double>forTableColumn(
						new MyDoubleStringConverter()));
	}
	private void setupWaistColumn() {
		waistColumn.setCellFactory(
				EditCell.<EntryTableData, Double>forTableColumn(
						new MyDoubleStringConverter()));
	}
	private void setupBodyMassIndexColumn() {
		bmiColumn.setCellFactory(
				EditCell.<EntryTableData, Double>forTableColumn(
						new MyDoubleStringConverter()));
	}
	private void setupBloodPressureColumn() {
		bloodPressureColumn.setCellFactory(
				EditCell.<EntryTableData, Double>forTableColumn(
						new MyDoubleStringConverter()));
	}
	private void setupBloodSugarColumn() {
		bloodSugarColumn.setCellFactory(
				EditCell.<EntryTableData, Double>forTableColumn(
						new MyDoubleStringConverter()));
	}
	private void setupBodyFatColumn() {
		bodyFatColumn.setCellFactory(
				EditCell.<EntryTableData, Double>forTableColumn(
						new MyDoubleStringConverter()));
	}
	@SuppressWarnings("unused")
	private TableColumn<EntryTableData, ?> getTableColumn(
			final TableColumn<EntryTableData, ?> column, int offset) {
		int columnIndex = table.getVisibleLeafIndex(column);
		int newColumnIndex = columnIndex + offset;
		return table.getVisibleLeafColumn(newColumnIndex);
	}
	@FXML
	private void submit(final ActionEvent event) {
		if(allFieldsValid()!= true)
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error");
			alert.setContentText("Please make sure all fields have been submitted. Note that "
					+ "the two blood pressures must be divided by a dot and that the date is "
					+ "formatted as 'dd/mm/yyyy'.");
			alert.showAndWait();
		}
		else if (allFieldsValid()== true) {
			double weight = Double.parseDouble(weightTextField.getText());
			double bloodpressure = Double.parseDouble(bloodPressureTextField.getText());
			double bloodsugar = Double.parseDouble(bloodSugarTextField.getText());
			double waist = Double.parseDouble(waistTextField.getText());
			double heartrate = Double.parseDouble(heartRateTextField.getText());
			double bodyfat = Double.parseDouble(bodyFatTextField.getText());
			double bmi = Double.parseDouble(bmiTextField.getText());
			double height = Double.parseDouble(heightTextField.getText());
			Date dateOfBirth = seeDateFormat();
			if(dateOfBirth != null){
				data.add(new EntryTableData(weight,height,bloodpressure,bloodsugar,waist,heartrate,bodyfat, bmi, dateOfBirth));
			}
			
		}
	}
	public Date seeDateFormat()
	{
		if(isValidDate(dateOfBirthTextField.getText())){
			try {
				Date dateOfBirth = DATE_FORMATTER
						.parse(dateOfBirthTextField.getText());
				return dateOfBirth;
			} catch (final ParseException e) {
				e.printStackTrace();
			}
		}
		else
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error");
			alert.setContentText("Please format date as 'dd/mm/yyyy'");
			alert.showAndWait();
			return null;
		}
		return null;
	}

	public static boolean isValidDate(String inDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inDate.trim());
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}

	private boolean allFieldsValid() {
		return !weightTextField.getText().isEmpty()
				&& !bloodPressureTextField.getText().isEmpty()
				&& dateOfBirthFieldValid()
				&& !waistTextField.getText().isEmpty()
				&& !heartRateTextField.getText().isEmpty()
				&& !bodyFatTextField.getText().isEmpty()
				&& !bloodSugarTextField.getText().isEmpty()
				&& !heightTextField.getText().isEmpty();
	}

	private boolean dateOfBirthFieldValid() {
		if (!dateOfBirthTextField.getText().isEmpty()) {
			try {
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}
	@FXML
	private void handleNew() {
		data.clear();
		setEntryFilePath(null);
	}
	@FXML
	public void handleOpen() {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
				"XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showOpenDialog(main.getPrimaryStage());
		if (file != null) {
			loadPersonDataFromFile(file);
			graphs();
		}
		
	}
	@FXML
	private void handleSave() {
		File personFile = getEntryFilePath();
		if (personFile != null) {
			savePersonDataToFile(personFile);
		} else {
			handleSaveAs();
		}
	}
	@FXML
	private void handleSaveAs() {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
				"XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showSaveDialog(main.getPrimaryStage());
		if (file != null) {
			if (!file.getPath().endsWith(".xml")) {
				file = new File(file.getPath() + ".xml");
			}
			savePersonDataToFile(file);
		}
	}
	@FXML
	private void handleExit() {
		secondaryStage.close();
	}
	public File getEntryFilePath() {
		Preferences prefs = Preferences.userNodeForPackage(Main.class);
		String filePath = prefs.get("filePath", null);
		if (filePath != null) {
			return new File(filePath);
		} else {
			return null;
		}
	}

	public void setEntryFilePath(File file) {
		Preferences prefs = Preferences.userNodeForPackage(Main.class);
		if (file != null) {
			prefs.put("filePath", file.getPath());
		} else {
			prefs.remove("filePath");
		}

	}
	public void loadPersonDataFromFile(File file) {
		try {
			JAXBContext context = JAXBContext
					.newInstance(EntryListWrapper.class);
			Unmarshaller u = context.createUnmarshaller();
			EntryListWrapper wrapper;
			wrapper = (EntryListWrapper) u.unmarshal(file);
			data.clear();
			data.addAll(wrapper.getEntries());
			setEntryFilePath(file);
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not load data");
			alert.setContentText("Could not load data from file:\n" + file.getPath());
			alert.showAndWait();
		}
	}

	public void savePersonDataToFile(File file) {
		try {
			JAXBContext context = JAXBContext
					.newInstance(EntryListWrapper.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			EntryListWrapper wrapper = new EntryListWrapper();
			wrapper.setEntries(data);
			m.marshal(wrapper, file);
			setEntryFilePath(file);
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not save data");
			alert.setContentText("Could not save data to file:\n" + file.getPath());
			alert.showAndWait();
		}
	}
	public void handleInstructions()
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Instructions");
		alert.setHeaderText("Instructions");
		alert.setContentText("Please make sure to format the blood pressure with a dot seperating the systolic and disatolic pressures. Please make sure the date is formatted as"
				+ " 'dd/mm/yyyy'. Please make sure to save every use and to reload at the start of every use. ");

		alert.showAndWait();
	}
	public void handleAbout() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("About");
		alert.setHeaderText("About");
		alert.setContentText("This record book was based on Dan Newton's 'Editable Tables in JavaFX' tutorial"
				+ " (link:https://dzone.com/articles/editable-tables-in-javafx).");
		alert.showAndWait();
	}
	public int length()
	{
		List<Double>MyColumn = new ArrayList<>();
		for (EntryTableData item : table.getItems()) {
			MyColumn.add(weightColumn.getCellObservableValue(item).getValue());
		}
		int length = MyColumn.size();
		return length;
	}
	public void graphs()
	{
		int length = length();
		weightColumnData(length);
		bmiColumnData(length);
		bloodSugarColumnData(length);
		waistColumnData(length);
		bodyFatColumnData(length);
	}
	
		
	public void weightColumnData(int length){
		weightChart.getData().clear();
		List<Double> weightColumnData = new ArrayList<>();
		weightColumnData.clear();
		for (EntryTableData item : table.getItems()) {
			weightColumnData.add(weightColumn.getCellObservableValue(item).getValue());
		}
		XYChart.Series<Double, Double> series = new XYChart.Series<Double,Double>();
		for(int i = 0; i<length; i++)
		{
			Double number = weightColumnData.get(i);
			series.getData().add(new XYChart.Data<Double, Double>((double) i,number));
		}
		weightChart.getData().add(series);
	}

	
	
	public void bmiColumnData(int length){
		bmiChart.getData().clear();
		List<Double> bmiColumnData = new ArrayList<>();
		bmiColumnData.clear();
		for (EntryTableData item : table.getItems()) {
			bmiColumnData.add(bmiColumn.getCellObservableValue(item).getValue());
		}	
		XYChart.Series<Double, Double> series = new XYChart.Series<Double,Double>();
		for(int i = 0; i<length; i++)
		{
			Double number = bmiColumnData.get(i);
			series.getData().add(new XYChart.Data<Double, Double>((double) i,number));
		}
		bmiChart.getData().add(series);
	}


	
	public void bloodSugarColumnData(int length){
		bloodSugarChart.getData().clear();
		List<Double> bloodSugarColumnData = new ArrayList<>();
		bloodSugarColumnData.clear();
		for (EntryTableData item : table.getItems()) {
			bloodSugarColumnData.add(bloodSugarColumn.getCellObservableValue(item).getValue());
		}	
		XYChart.Series<Double, Double> series = new XYChart.Series<Double,Double>();
		for(int i = 0; i<length; i++)
		{
			Double number = bloodSugarColumnData.get(i);
			series.getData().add(new XYChart.Data<Double, Double>((double) i,number));
		}
		bloodSugarChart.getData().add(series);
	}


	
	public void waistColumnData(int length){
		waistChart.getData().clear();
		List<Double> waistColumnData = new ArrayList<>();
		waistColumnData.clear();
		for (EntryTableData item : table.getItems()) {
			waistColumnData.add(waistColumn.getCellObservableValue(item).getValue());
		}	
		XYChart.Series<Double, Double> series = new XYChart.Series<Double,Double>();
		for(int i = 0; i<length; i++)
		{
			Double number = waistColumnData.get(i);
			series.getData().add(new XYChart.Data<Double, Double>((double) i,number));
		}
		waistChart.getData().add(series);
	}

	
	public void bodyFatColumnData(int length){
		bodyFatChart.getData().clear();
		List<Double> bodyFatColumnData = new ArrayList<>();
		bodyFatColumnData.clear();
		for (EntryTableData item : table.getItems()) {
			bodyFatColumnData.add(bodyFatColumn.getCellObservableValue(item).getValue());
		}
		XYChart.Series<Double, Double> series = new XYChart.Series<Double,Double>();
		for(int i = 0; i<length; i++)
		{
			Double number = bodyFatColumnData.get(i);
			series.getData().add(new XYChart.Data<Double, Double>((double) i,number));
		}
		bodyFatChart.getData().add(series);
	}
}

