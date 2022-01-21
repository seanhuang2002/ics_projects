package application.Blackjack;

import application.Main;
import javafx.stage.Stage;

public class BlackJackController {
	private Main main;
	private Stage secondaryStage;
	public void setMain(Main main, Stage secondaryStage)
	{
		this.main=main;
		this.secondaryStage=secondaryStage;
	}
}
