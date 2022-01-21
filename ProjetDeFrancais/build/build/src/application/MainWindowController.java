package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainWindowController implements Initializable{

    @FXML
    private TitledPane paneBaroque;

    @FXML
    private Label labelRomantisme;

    @FXML
    private Label labelNaturalisme;

    @FXML
    private Button buttMusLumieres;

    @FXML
    private Accordion accordionXX;

    @FXML
    private Tab tabXVIII;

    @FXML
    private Button buttLitClassicisme;

    @FXML
    private Button buttLitHumanisme;

    @FXML
    private Button buttLitPleiade;

    @FXML
    private Button buttMusNaturalisme;

    @FXML
    private Label labelLumieres;

    @FXML
    private TitledPane paneAbsurde;

    @FXML
    private Button buttArtNewRoman;

    @FXML
    private TitledPane paneSymbolisme;

    @FXML
    private Button buttMusSymbolisme;

    @FXML
    private Button buttLitNewRoman;

    @FXML
    private Label labelAbsurde;

    @FXML
    private Button buttArtPleiade;

    @FXML
    private Button buttArtSymbolisme;

    @FXML
    private Tab tabXVI;

    @FXML
    private Label labelClassicisme;

    @FXML
    private Tab tabXIX;

    @FXML
    private ImageView imageNaturalisme;

    @FXML
    private Button buttLitAbsurde;

    @FXML
    private Button buttArtAbsurde;

    @FXML
    private TitledPane paneHumanisme;

    @FXML
    private TitledPane paneRomantisme;

    @FXML
    private Button buttArtClassicisme;

    @FXML
    private Label labelHumanisme;

    @FXML
    private Accordion accordionXIX;

    @FXML
    private Button buttMusRomantisme;

    @FXML
    private Button buttArtNaturalisme;

    @FXML
    private Tab tabXX;

    @FXML
    private Accordion accordionXVI;

    @FXML
    private Button buttMusPleiade;

    @FXML
    private Accordion accordionXVII;

    @FXML
    private Accordion accordionXVIII;

    @FXML
    private Button buttLitSymbolisme;

    @FXML
    private ImageView imagePleiade;

    @FXML
    private Button buttMusRealisme;

    @FXML
    private ImageView imageRomantisme;

    @FXML
    private Button buttLitBaroque;

    @FXML
    private ImageView imageHumanisme;

    @FXML
    private Button buttMusAbsurde;

    @FXML
    private Button buttArtHumanisme;

    @FXML
    private Tab tabXVII;

    @FXML
    private TitledPane paneClassicisme;

    @FXML
    private Button buttLitRealisme;

    @FXML
    private Label labelPleiade;

    @FXML
    private ImageView imageAbsurde;

    @FXML
    private Label labelBaroque;

    @FXML
    private TitledPane paneNewRoman;

    @FXML
    private Label labelSymbolisme;

    @FXML
    private TitledPane panePleiade;

    @FXML
    private Button buttMusBaroque;

    @FXML
    private ImageView imageLumieres;

    @FXML
    private Button buttLitRomantisme;

    @FXML
    private TitledPane paneRealisme;

    @FXML
    private Label labelNewRoman;

    @FXML
    private ImageView imageBaroque;

    @FXML
    private ImageView imageSymbolisme;
    
    @FXML
    private Label labelParnasse;
    
    @FXML
    private ImageView imageParnasse;
    
    @FXML
    private ImageView imageClassicisme;

    @FXML
    private TitledPane paneNaturalisme;

    @FXML
    private Button buttLitLumieres;

    @FXML
    private Label labelRealisme;

    @FXML
    private ImageView imageRealisme;

    @FXML
    private TitledPane paneLumieres;

    @FXML
    private Button buttArtRealisme;

    @FXML
    private Button buttMusClassicisme;

    @FXML
    private Button buttMusHumanisme;

    @FXML
    private Button buttLitNaturalisme;

    @FXML
    private ImageView imageNewRoman;

    @FXML
    private Button buttArtBaroque;

    @FXML
    private Button buttArtLumieres;

    @FXML
    private TabPane tabPane;

    @FXML
    private Button butMusNewRoman;

    @FXML
    private Button buttArtRomantisme;
    
    @FXML
    private Button buttArtParnasse;
    
    @FXML
    private Button buttLitParnasse;
    
    @FXML
    private Rectangle boxXVI;
    
    @FXML
    private Rectangle boxXVII;
    
    @FXML
    private Rectangle boxXVIII;
    
    @FXML
    private Rectangle boxXIX;
    
    @FXML
    private Rectangle boxXX;
    
    @FXML
    private ImageView image;
    
    @FXML
    private TitledPane paneParnasse;

	private Main main;
	public void setMain(Main main) {
		this.main = main;
	}
	
	SingleSelectionModel<Tab> selectionModel;
	public void initialize(URL location, ResourceBundle resources)
	{
		selectionModel = tabPane.getSelectionModel();
		Platform.runLater(this::onStartup);
	}
	
	public void onStartup()
	{
		Image a = new Image("file:resources/images/a.jpg");
		image.setImage(a);
		Image b = new Image("file:resources/images/(humanisme) François Rabelais.jpg");
		imageHumanisme.setImage(b);
		Image c = new Image("file:resources/images/(pléiade) Joachim du Bellay.jpg");
		imagePleiade.setImage(c);
		Image d = new Image("file:resources/images/Johann_Sebastian_Bach.jpg");
		imageBaroque.setImage(d);
		Image e = new Image("file:resources/images/(classicisme) Molière_.jpg");
		imageClassicisme.setImage(e);
		Image f = new Image("file:resources/images/(lumière)Denis Diderot.png");
		imageLumieres.setImage(f);
		Image g = new Image("file:resources/images/(romantisme)Victor Hugo_.jpg");
		imageRomantisme.setImage(g);
		Image h = new Image("file:resources/images/(réalisme)Honoré de Balzac_.jpg");
		imageRealisme.setImage(h);
		Image i = new Image("file:resources/images/(naturalisme)Guy de Maupassant.jpg");
		imageNaturalisme.setImage(i);
		Image j = new Image("file:resources/images/(symbolisme) Paul Verlaine.jpg");
		imageSymbolisme.setImage(j);
		Image k = new Image("file:resources/images/(absurde)Eugène Ionesco_.jpg");
		imageAbsurde.setImage(k);
		Image l = new Image("file:resources/images/(nouveau roman)Nathalie Sarraute.jpg");
		imageNewRoman.setImage(l);
		Image m = new Image("file:resources/images/lisle.jpg");
		imageParnasse.setImage(m);
		
	}
	
	
	public void clearLabel()
	{
		labelHumanisme.setStyle(null);
		labelPleiade.setStyle(null);
		labelBaroque.setStyle(null);
		labelClassicisme.setStyle(null);
		labelLumieres.setStyle(null);
		labelRomantisme.setStyle(null);
		labelRealisme.setStyle(null);
		labelNaturalisme.setStyle(null);
		labelSymbolisme.setStyle(null);
		labelAbsurde.setStyle(null);
		labelNewRoman.setStyle(null);
		labelParnasse.setStyle(null);
		
	}
	public void clearBox()
	{
		boxXVI.setFill(null);
		boxXVII.setFill(null);
		boxXVIII.setFill(null);
		boxXIX.setFill(null);
		boxXX.setFill(null);
	}
	public void showXVI()
	{
		
	}
	public void showXVII()
	{
	}
	public void showXVIII()
	{
	}
	public void showXIX()
	{
	}
	public void showXX()
	{
	}
	public void openParnasse()
	{
		
		selectionModel.select(tabXIX);
		accordionXIX.setExpandedPane(paneParnasse);
		labelParnasse.setStyle("-fx-background-color: #9ec3ff");
	}
	public void openHumanisme()
	{
		selectionModel.select(tabXVI);
		accordionXVI.setExpandedPane(paneHumanisme);
		labelHumanisme.setStyle("-fx-background-color: #9ec3ff");
	}
	public void openPleiade()
	{
		selectionModel.select(tabXVI);
		accordionXVI.setExpandedPane(panePleiade);
		labelPleiade.setStyle("-fx-background-color: #9ec3ff");
	}
	public void openBaroque()
	{
		selectionModel.select(tabXVII);
		accordionXVII.setExpandedPane(paneBaroque);
		labelBaroque.setStyle("-fx-background-color: #9ec3ff");
	}
	public void openClassicisme()
	{
		selectionModel.select(tabXVII);
		accordionXVII.setExpandedPane(paneClassicisme);
		labelClassicisme.setStyle("-fx-background-color: #9ec3ff");
	}
	public void openLumieres()
	{
		selectionModel.select(tabXVIII);
		accordionXVIII.setExpandedPane(paneLumieres);
		labelLumieres.setStyle("-fx-background-color: #9ec3ff");
	}
	public void openRomanticism()
	{
		selectionModel.select(tabXIX);
		accordionXVI.setExpandedPane(paneRomantisme);
		labelRomantisme.setStyle("-fx-background-color: #9ec3ff");
	}
	public void openRealisme()
	{
		selectionModel.select(tabXIX);
		accordionXVI.setExpandedPane(paneRealisme);
		labelRealisme.setStyle("-fx-background-color: #9ec3ff");
	}
	public void openNaturalisme()
	{
		selectionModel.select(tabXIX);
		accordionXVI.setExpandedPane(paneNaturalisme);
		labelNaturalisme.setStyle("-fx-background-color: #9ec3ff");
	}
	public void openSymbolicisme()
	{
		selectionModel.select(tabXIX);
		accordionXVI.setExpandedPane(paneSymbolisme);
		labelSymbolisme.setStyle("-fx-background-color: #9ec3ff");
	}
	public void openAbsurde()
	{
		selectionModel.select(tabXX);
		accordionXVI.setExpandedPane(paneAbsurde);
		labelAbsurde.setStyle("-fx-background-color: #9ec3ff");
	}
	public void openNewRoman()
	{
		selectionModel.select(tabXX);
		accordionXVI.setExpandedPane(paneNewRoman);
		labelNewRoman.setStyle("-fx-background-color: #9ec3ff");
	}
	
	public void handleClose()
	{
		System.exit(0);
	}
	
	public void handleInstructions()
	{
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Info-flash");
		alert.setTitle("Instructions");
		alert.setContentText("Il faut cliquer sur le mouvement littéraire pour le voir."
				+ "Il faut pauser la musique avant de quitter.");
		alert.show();
	}
	
	public void handleAbout()
	{
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Info-flash");
		alert.setTitle("À Propos");
		alert.setContentText("Cette programme a été crée par Sean Huang, avec les informations de Laila Hayashi,"
				+ "Nathalie Jeans et Tanya Chen pour la classe de Mme Ben-Mansour sur les mouvements littéraires "
				+ "historiques.");
		alert.show();
	}
	
	public void selectNewCentury()
	{
		clearLabel();
		clearBox();
		if(tabPane.getSelectionModel().getSelectedItem()==tabXVI)
		{
			boxXVI.setFill(Color.web("#ff8484"));
		}
		else if(tabPane.getSelectionModel().getSelectedItem()==tabXVII)
		{
			boxXVII.setFill(Color.web("#ff8484"));
		}
		else if(tabPane.getSelectionModel().getSelectedItem()==tabXVIII)
		{
			boxXVIII.setFill(Color.web("#ff8484"));
		}
		else if(tabPane.getSelectionModel().getSelectedItem()==tabXIX)
		{
			boxXIX.setFill(Color.web("#ff8484"));
		}
		else if(tabPane.getSelectionModel().getSelectedItem()==tabXX)
		{
			boxXX.setFill(Color.web("#ff8484"));
		}
	}
	
	public void handleOpenPopup(ActionEvent e)
	{
		Button xt = (Button)e.getSource();
		if(xt==buttArtAbsurde)
		{
			main.openPopupWindow("Art", "Absurde");
		}
		else if(xt==buttArtBaroque)
		{
			main.openPopupWindow("Art", "Baroque");
		}
		else if(xt==buttArtClassicisme)
		{
			main.openPopupWindow("Art", "Classicisme");
		}
		else if(xt==buttArtHumanisme)
		{
			main.openPopupWindow("Art", "Humanisme");
		}
		else if(xt==buttArtLumieres)
		{
			main.openPopupWindow("Art", "Lumieres");
		}
		else if(xt==buttArtNaturalisme)
		{
			main.openPopupWindow("Art", "Naturalisme");
		}
		else if(xt==buttArtNewRoman)
		{
			main.openPopupWindow("Art", "New Roman");
		}
		else if(xt==buttArtPleiade)
		{
			main.openPopupWindow("Art", "Pleiade");
		}
		else if(xt==buttArtRealisme)
		{
			main.openPopupWindow("Art", "Realisme");
		}
		else if(xt==buttArtRomantisme)
		{
			main.openPopupWindow("Art", "Romantisme");
		}
		else if(xt==buttArtSymbolisme)
		{
			main.openPopupWindow("Art", "Symbolisme");
		}
		else if(xt==buttArtParnasse)
		{
			main.openPopupWindow("Art", "Parnasse");
		}
//________________________
		else if(xt==buttLitParnasse)
		{
			main.openPopupWindow("Lit", "Parnasse");
		}
		else if(xt==buttLitAbsurde)
		{
			main.openPopupWindow("Lit", "Absurde");
		}
		else if(xt==buttLitBaroque)
		{
			main.openPopupWindow("Lit", "Baroque");
		}
		else if(xt==buttLitClassicisme)
		{
			main.openPopupWindow("Lit", "Classicisme");
		}
		else if(xt==buttLitHumanisme)
		{
			main.openPopupWindow("Lit", "Humanisme");
		}
		else if(xt==buttLitLumieres)
		{
			main.openPopupWindow("Lit", "Lumieres");
		}
		else if(xt==buttLitNaturalisme)
		{
			main.openPopupWindow("Lit", "Naturalisme");
		}
		else if(xt==buttLitNewRoman)
		{
			main.openPopupWindow("Lit", "New Roman");
		}
		else if(xt==buttLitPleiade)
		{
			main.openPopupWindow("Lit", "Pleiade");
		}
		else if(xt==buttLitRealisme)
		{
			main.openPopupWindow("Lit", "Realisme");
		}
		else if(xt==buttLitRomantisme)
		{
			main.openPopupWindow("Lit", "Romantisme");
		}
		else if(xt==buttLitSymbolisme)
		{
			main.openPopupWindow("Lit", "Symbolisme");
		}
		
	}
	public void startAbsurdeMusic()
	{
		main.startAbsurdeMusic();
	}
	public void startClassicismeMusic()
	{
		main.startClassicismMusic();
	}
	public void startLumieresMusic()
	{
		main.startLumieresMusic();
	}
	public void startHumanismeMusic()
	{
		main.startHumanismeMusic();
	}
	public void startBaroqueMusic()
	{
		main.startBaroqueMusic();
	}
	public void startRomantismeMusic()
	{
		main.startRomantismeMusic();
	}
	public void startRealismeMusic()
	{
		main.startRealismeMusic();
	}
	public void startNaturalismeMusic()
	{
		main.startNaturalismeMusic();
	}
	public void startSymbolismeMusic()
	{
		main.startSymbolismeMusic();
	}
	
}















