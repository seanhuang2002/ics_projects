package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class PopupWindowController implements Initializable{

	@FXML
	private ImageView humanismeView;
	
	@FXML
	private ImageView pleiadeView;
	
	@FXML
	private ImageView baroqueView;
	
	@FXML
	private ImageView classicismeView;
	
	@FXML
	private ImageView lumieresView;
	
	@FXML
	private ImageView romantismeView;
	
	@FXML
	private ImageView naturalismeView;
	
	@FXML
	private ImageView realismeView;
	
	@FXML
	private ImageView symbolismeView;
	
	@FXML
	private ImageView absurdeView;
	
	@FXML
	private ImageView newRomanView;
	
	@FXML
	private ImageView parnasseView;
	
	
	String fxmlFile="";
	
	private Main main;
	private Stage secondaryStage;
	public void setMain(Main main, Stage secondaryStage, String fxml) {
		this.main=main;
		this.secondaryStage=secondaryStage;
		fxmlFile=fxml;
	}
	
	public void handleClose()
	{
		secondaryStage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		Platform.runLater(this::onStartup);
	}
	@FXML
	private MediaView mvAbsurde;
	public void onStartup()
	{
		switch(fxmlFile)
		{
		case "Art/HumanismeView.fxml":
			Image a = new Image("file:resources/images/david.jpg");
			humanismeView.setImage(a);
			break;
		case "Art/ParnasseView.fxml" :
			Image aa = new Image("file:resources/images/monet.jpg");
			parnasseView.setImage(aa);
			break;
		case "Art/PleiadeView.fxml":
			Image b = new Image("file:resources/images/last.jpg");
			pleiadeView.setImage(b);
			break;
		case "Art/BaroqueView.fxml":
			Image c = new Image("file:resources/images/decent.jpg");
			baroqueView.setImage(c);
			break;
		case "Art/ClassicismeView.fxml":
			Image d = new Image("file:resources/images/somelatin.jpg");
			classicismeView.setImage(d);
			break;
		case "Art/LumieresView.fxml":
			Image e = new Image("file:resources/images/marat.jpg");
			lumieresView.setImage(e);
			break;
		case "Art/RomantismeView.fxml":
			Image f = new Image("file:resources/images/romantic.jpg");
			romantismeView.setImage(f);
			break;
		case "Art/RealismeView.fxml":
			Image g = new Image("file:resources/images/burial.jpg");
			realismeView.setImage(g);
			break;
		case "Art/NaturalismeView.fxml":
			Image h = new Image("file:resources/images/boy.jpg");
			naturalismeView.setImage(h);
			break;
		case "Art/SymbolismeView.fxml":
			Image i = new Image("file:resources/images/yellowchrist.jpg");
			symbolismeView.setImage(i);
			break;
		case "Art/AbsurdeView.fxml":
			Image j = new Image("file:resources/images/guernica.jpg");
			absurdeView.setImage(j);
			break;
		case "Art/NewRomanView.fxml":
			Image k = new Image("file:resources/images/convergence.jpg");
			newRomanView.setImage(k);
			break;
		}
		
	}

}
