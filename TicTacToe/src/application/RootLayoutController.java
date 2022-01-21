package application;

import application.Main;

public class RootLayoutController {
	private Main main;

    public void setMain(Main main) {
        this.main = main;
    }
    public void handleClose()
    {
    	System.exit(0);
    }

}
