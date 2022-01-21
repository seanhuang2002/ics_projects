package classlist.view;

import classlist.Main;
import javafx.stage.Stage;

public class PatientOverviewController {
	 private Main main;
	private Stage controller;

	    public void setMain(Main main, Stage secondaryStage) {
	        this.main = main;
	        this.controller = secondaryStage;
	    }
	    public void goBack()
		{
			controller.close();
		}
}
