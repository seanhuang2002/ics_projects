package adress.view;

import java.net.URL;
import java.util.ResourceBundle;

import adress.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EntryWindowController implements Initializable
{
	private Main main;
	@FXML
	private ComboBox<String> calcucombobox;
	@FXML
	private ListView<String> list;
	@FXML
	private Accordion accord;
	@FXML
	private TitledPane Welcome;
	@FXML
	private ImageView cardioImageView;
	@FXML
	private ImageView strengthImageView;
	@FXML
	private ImageView dietImageView;
	@FXML
	private ImageView relaxImageView;
	@FXML
	private ImageView sleepImageView;
	public ObservableList<String> calcombo =
			FXCollections.observableArrayList(
					"Body Mass Index",
					"Body Weight",
					"Height",
					"Blood Pressure",
					"Blood Sugar Level",
					"Waist Circumference",
					"Body Fat Ratio",
					"Resting Heart Rate"
					);
	public void setMain(Main main)
	{
		this.main = main;
	}

	ObservableList<String> items=
			FXCollections.observableArrayList(
					"Eating Well",
					"Canada's Food Guide",
					"Reducing Blood Sugar",
					"Reducing Blood Pressure",
					"Six Heart-Healthy Foods",
					"Ways to improve Cardiac Health"
					,"Stategies to lose weight"
					,"Simple, No-equipment workouts"
					,"Easy, Fat Burning Recipes"
					,"Aerobic Exercise for Cardio"
					,"Sleeping Better"
					,"Improving Mental Health"
					,"How to Feel More Relaxed"
					,"Ten Best Diets"
					);
	
	public void initialize(URL location, ResourceBundle resources)
	{
		Image strengthImage = new Image("file:resources/Images/shutterstock_105840977.jpg");
		Image cardioImage = new Image("file:resources/Images/swim-courses.jpg");
		Image dietImage = new Image("file:resources/Images/flexitarian-diet-produce-groceries-720.jpg");
		Image relaxImage = new Image("file:resources/Images/relaxation.jpg");
		Image sleepImage = new Image("file:resources/Images/maxresdefault.jpg");
		cardioImageView.setImage(cardioImage);
		strengthImageView.setImage(strengthImage);
		dietImageView.setImage(dietImage);
		relaxImageView.setImage(relaxImage);
		sleepImageView.setImage(sleepImage);
		accord.setExpandedPane(Welcome);
		calcucombobox.setItems(calcombo);
		list.setItems(items);
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable,
		            String oldValue, String newValue) {
		    	if(newValue.equals("Eating Well"))
		    	{
		    		main.WebWindow("http://www.healthycanadians.gc.ca/eating-nutrition/healthy-eating-saine-alimentation/food-guide-aliment/my-guide-mon-guide/mfg_p1-eng.php");
		    	}
		    	else if(newValue.equals("Canada's Food Guide"))
		    	{
		    		main.WebWindow("https://www.canada.ca/en/health-canada/services/canada-food-guides.html");
		    	}
		    	else if(newValue.equals("Reducing Blood Sugar"))
		    	{
		    		main.WebWindow("https://www.healthline.com/nutrition/15-ways-to-lower-blood-sugar");
		    	}
		    	else if(newValue.equals("Reducing Blood Pressure"))
		    	{
		    		main.WebWindow("https://www.theactivetimes.com/fitness/your-first-time/7-ways-naturally-lower-your-blood-pressure");
		    	}
		    	else if(newValue.equals("Six Heart-Healthy Foods"))
		    	{
		    		main.WebWindow("https://www.theactivetimes.com/6-heart-healthy-foods-you-should-eat-all-year-long");
		    	}
		    	else if(newValue.equals("Ways to improve Cardiac Health"))
		    	{
		    		main.WebWindow("https://www.theactivetimes.com/8-easy-ways-improve-your-heart-health");
		    	}
		    	else if(newValue.equals("Stategies to lose weight"))
		    	{
		    		main.WebWindow("http://www.goodhousekeeping.com/health/diet-nutrition/advice/a17162/lose-weight-faster-karas-0302/");
		    	}
		    	else if(newValue.equals("Simple, No-equipment workouts"))
		    	{
		    		main.WebWindow("http://www.oprah.com/health/the-no-equipment-workout-you-can-do-at-home/all");
		    	}
		    	else if(newValue.equals("Easy, Fat Burning Recipes"))
		    	{
		    		main.WebWindow("https://greatist.com/health/52-healthy-meals-12-minutes-or-less");
		    	}
		    	else if(newValue.equals("Aerobic Exercise for Cardio"))
		    	{
		    		main.WebWindow("http://www.heart.org/HEARTORG/HealthyLiving/PhysicalActivity/FitnessBasics/Endurance-Exercise-Aerobic_UCM_464004_Article.jsp");
		    	}
		    	else if(newValue.equals("Sleeping Better"))
		    	{
		    		main.WebWindow("https://www.helpguide.org/articles/sleep/getting-better-sleep.htm");
		    	}
		    	else if(newValue.equals("Improving Mental Health"))
		    	{
		    		main.WebWindow("https://www.uhs.umich.edu/tenthings");
		    	}
		    	else if(newValue.equals("How to Feel More Relaxed"))
		    	{
		    		main.WebWindow("https://greatist.com/happiness/40-ways-relax-5-minutes-or-less");
		    	}
		    	else if(newValue.equals("Ten Best Diets"))
		    	{
		    		main.WebWindow("https://www.shape.com/healthy-eating/diet-tips/10-best-diet-programs");
		    	}
		    }
		});
	}
	
	public void starttable()
	{
		try {
			main.startTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void comboBoxChanged(ActionEvent event)
	{
		String option=calcucombobox.getValue();
		if(option.equals("Body Mass Index"))
		{
			main.BMIWindow();
		}
		else if(option.equals("Body Weight"))
		{
			main.WeightWindow();
		}
		else if(option.equals("Height"))
		{
			main.HeightWindow();
		}
		else if(option.equals("Blood Pressure"))
		{
			main.BloodPressureWindow();
		}
		else if(option.equals("Blood Sugar Level"))
		{
			main.BloodSugarWindow();
		}
		else if(option.equals("Waist Circumference"))
		{
			main.WaistWindow();
		}
		else if(option.equals("Resting Heart Rate"))
		{
			main.RestingWindow();
		}
		else if(option.equals("Body Fat Ratio"))
		{
			main.BodyFatWindow();
		}
	}
	
	
	
	
	
}
