package application;

public class ChangeWindowController {

	private Main main;
	public void setMain(Main main)
	{
		this.main=main;
	}
	
	public void goBack()
	{
		main.firstWindow();
	}
	

}
