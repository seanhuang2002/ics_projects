package application;

import javafx.stage.Stage;

public class SecondWindowController {
	private Main main;
	private Stage secondaryStage;
	public void setMain(Main main, Stage secondaryStage)
	{
		this.main=main;
		this.secondaryStage=secondaryStage;
	}
	public void goBack()
	{
		secondaryStage.close();
	}
	
}

	
	



