package application;

import application.Main;

public class TTTController {
	
	private Main main;
	
	public void setMain(Main main) {
		this.main=main;
	}
	public void handleQuit()
	{
		System.exit(0);
	}

}
