package application;

public class FirstWindowController 
{
	private Main main;
	public void setMain(Main main)
	{
		this.main=main;
	}
	public void openNewWindow()
	{
		main.secondWindow();
	}
	public void changeWindow()
	{
		main.changeWindow();
	}
}
