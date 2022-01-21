/*
 * Author : seanhuang
 * Date : Dec 7, 2017
 */

package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class rootlayoutController {
	private Main main;
	public void setMain(Main main) {
		this.main=main;
	}
	public void handleClose()
	{
		Main.handle(null);
	}
	public void infor()
	{
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setHeaderText("À Propos");
		alert.setTitle("À PROPOS");
		alert.setContentText("Cette calculatrice simple a été créée par Sean Huang, étudiant "
				+ "de la Toronto French School avec la programme Eclipse et Scene Builder "
				+ "dans la language de JavaFX en 2017 pour la classe d'informatique.");
		alert.show();
	}

}
