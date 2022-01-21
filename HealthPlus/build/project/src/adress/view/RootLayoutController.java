package adress.view;

import adress.Main;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RootLayoutController 
{
	 @SuppressWarnings("unused")
	private Main main;

	    public void setMain(Main main) {
	        this.main = main;
	    }
	    public void handleClose()
	    {
	    	System.exit(0);
	    }
	    public void handleAbout()
	    {
	    	Alert alert=new Alert(AlertType.INFORMATION);
			alert.setHeaderText("About");
			alert.setTitle("About");
			alert.setContentText("Created by Sean Huang in 2018 for ICS3U5Oa at Toronto French School");
			alert.show();
	    }

}
