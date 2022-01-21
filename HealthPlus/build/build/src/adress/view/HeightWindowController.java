package adress.view;

import adress.Main;
import javafx.stage.Stage;

public class HeightWindowController {
	private Main main;
	private Stage secondaryStage;
	public void setMain(Main main, Stage secondaryStage)
	{
		this.main=main;
		this.secondaryStage=secondaryStage;
	}
	public void goBack() {
		secondaryStage.close();
	}
	public void goBMI()
	{
		secondaryStage.close();
		main.BMIWindow();
	}

}
