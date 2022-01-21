package application;

public class MainWindowController {
	
	private Main main;
	public void setMain(Main main)
	{
		this.main=main;
	}
	
	public void openHighLow()
	{
		main.openBlackjackWindow();
	}

}
