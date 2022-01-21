package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class ClassicismeWindowController implements Initializable {
	@FXML
	private MediaView mv;
	private Main main;
	private Stage secondaryStage;
	private MediaPlayer mp;
	private Media me;
	public void setMain(Main main, Stage secondaryStage)
	{
		this.main=main;
		this.secondaryStage=secondaryStage;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String path = new File("resources/audio/Hallelujah.mp4").getAbsolutePath();
		me = new Media(new File(path).toURI().toString());
		mp = new MediaPlayer(me);
		mv.setMediaPlayer(mp);
	}
	public void handlePause()
	{
		mp.pause();
	}
	public void handlePlay()
	{
		mp.play();
	}
	public void handleQuit()
	{
		secondaryStage.close();
	}

}
