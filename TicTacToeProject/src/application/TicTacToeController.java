package application;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.control.Alert.AlertType;
/**
 * 
 * Controller class for the TicTacToeWindow.fxml
 * @author seanhuang
 * @version 1.0, 04/01/18
 * 
 */
public class TicTacToeController implements Initializable{

	/**
	 * Links the fx:ids of buttons to a variable
	 */
	@FXML
	private Button butt2;

	@FXML
	private Button butt1;

	@FXML
	private Button butt6;

	@FXML
	private Button butt5;

	@FXML
	private Button butt4;

	@FXML
	private Button butt3;

	@FXML
	private Button butt9;

	@FXML
	private Button butt8;

	@FXML
	private Button butt7;

	@FXML
	private Button buttNew;

	@FXML
	private Button buttReset;
	
	@FXML
	private Button buttStart;

	@FXML
	private Label winLabel;

	@FXML
	private Label lossLabel;

	@FXML
	private Label messageLabel;

	@FXML
	private ComboBox<String> difficultyCombo;

	@FXML
	private RadioButton playerFirst;

	@FXML
	private RadioButton compFirst;

	public Button[] arrayButts;

	String comboBoxChoice;

	int numTurns=0;

	/**
	 * Observable List for the difficulty combo box
	 * 
	 * Observable List pour les choix dans le combobox
	 */
	public ObservableList<String> difficultyComboList = 
			FXCollections.observableArrayList(
					"Easy",
					"Normal",
					"Hard"
					);

	/*
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeButtonArray();
		difficultyCombo.setItems(difficultyComboList);
		messageLabel.setText("Set Difficulty");
		for(int i = 0;i<9;i++)
		{
			arrayButts[i].setDisable(true);
		}
		buttReset.setDisable(true);
		buttStart.setDisable(true);
	}

	/**
	 * Listens for a change in the combo box for difficulty
	 * 
	 * Écouteur pour voir le niveau difficulté choisi par l'usagé dans le combobox
	 */
	public void checkComboBox()
	{
		System.out.println("Choosing difficulty");
		comboBoxChoice = difficultyCombo.getValue();
		buttStart.setDisable(false);
		System.out.println(comboBoxChoice + " difficulty chosen");
		messageLabel.setText("Plz Start Game");
		System.out.println("________________");
	}

	/**
	 * Initializes an array of buttons containing each button
	 * 
	 * Initialise une liste de boutons avec chaque bouton du tictactoe
	 */
	public void initializeButtonArray()
	{
		arrayButts = new Button[9];  
		arrayButts[0] = butt1;
		arrayButts[1] = butt2;
		arrayButts[2] = butt3;
		arrayButts[3] = butt4;
		arrayButts[4] = butt5;
		arrayButts[5] = butt6;
		arrayButts[6] = butt7;
		arrayButts[7] = butt8;
		arrayButts[8] = butt9;
	}
	
	/**
	 * Clears the playing field
	 * Places first move depending on game mode
	 * 
	 * Remettre les boutons à rien
	 * Placer le premier tour de l'ordinateur si le radiobutton compFirst est choisi
	 */
	public void startGame()
	{
		reInitialize();
		for(int i = 0;i<9;i++)
		{
			arrayButts[i].setDisable(false);
		}
		buttReset.setDisable(false);
		if(compFirst.isSelected())
		{
			if(comboBoxChoice.equals("Easy"))
			{
				setRandomBoxSelected();
			}
			else if(comboBoxChoice.equals("Normal")||comboBoxChoice.equals("Hard"))
			{
				setCompFirstBoxSelected();
			}
		}
	}

	/**
	 * Gets the fx:id of the button that was clicked
	 * Sets the text of button as "X", Disables the button
	 * Sets another button as "O"
	 * Checks if there is a winner with checkWin()
	 * 
	 * Recevoir le fx:id du bouton poussé
	 * Mettre le texte de ce bouton à "X" et mettre le bouton comme intouchable
	 * Mettre le texte d'un autre bouton à "O" comme le tour de l'ordi
	 * Vérifier s'il y en a un gangnant à chaque tour
	 * @param e Clicked button
	 */
	public void btnClicked(ActionEvent e)
	{
		numTurns = numTurns+1;
		if(playerFirst.isSelected())
		{
			Button xt=(Button)e.getSource();
			xt.setDisable(true);
			xt.setText("X");
			xt.setStyle("-fx-base: #66ccff;");
			if(checkWin("X").equals("Player Wins"))
			{
				for(int i = 0;i<9;i++)
				{
					arrayButts[i].setDisable(true);
				}
				messageLabel.setText("Player Wins");
				int winNum = Integer.parseInt(winLabel.getText())+1;
				winLabel.setText(Integer.toString(winNum)); 
			}
			else if(checkWin("X").equals("") && checkWin("O").equals(""))
			{
				if(numTurns==5)
				{
					messageLabel.setText("Tie");
				}
				else if(comboBoxChoice.equals("Easy"))
				{
					setRandomBoxSelected(); 
					if(checkWin("O").equals("Computer Wins"))
					{
						for(int i = 0;i<9;i++)
						{
							arrayButts[i].setDisable(true);
						}
						messageLabel.setText("CPU Wins");
						int lossNum = Integer.parseInt(lossLabel.getText())+1;
						lossLabel.setText(Integer.toString(lossNum));
					}
				}
				else if(comboBoxChoice.equals("Normal"))
				{
					setStrategyBoxSelected(xt);
					if(checkWin("O").equals("Computer Wins"))
					{
						for(int i = 0;i<9;i++)
						{
							arrayButts[i].setDisable(true);
						}
						messageLabel.setText("CPU Wins");
						int lossNum = Integer.parseInt(lossLabel.getText())+1;
						lossLabel.setText(Integer.toString(lossNum));
					}
				}
				else if(comboBoxChoice.equals("Hard"))
				{
					setStrategyBoxSelected(xt);
					if(checkWin("O").equals("Computer Wins"))
					{
						for(int i = 0;i<9;i++)
						{
							arrayButts[i].setDisable(true);
						}
						messageLabel.setText("CPU Wins");
						int lossNum = Integer.parseInt(lossLabel.getText())+1;
						lossLabel.setText(Integer.toString(lossNum));
					}
				}
			}
		}
		else if(compFirst.isSelected())
		{
			if(e==null)
			{
				for(int i = 0;i<9;i++)
				{
					arrayButts[i].setDisable(true);
				}
				messageLabel.setText("Player Wins");
				int winNum = Integer.parseInt(winLabel.getText())+1;
				winLabel.setText(Integer.toString(winNum));
			}
			else if(checkWin("O").equals("Computer Wins"))
			{
				for(int i = 0;i<9;i++)
				{
					arrayButts[i].setDisable(true);
				}
				messageLabel.setText("CPU Wins");
				int lossNum = Integer.parseInt(lossLabel.getText())+1;
				lossLabel.setText(Integer.toString(lossNum));
			}
			else if(checkWin("X").equals("Player Wins"))
			{
				for(int i = 0;i<9;i++)
				{
					arrayButts[i].setDisable(true);
				}
				messageLabel.setText("Player Wins");
				int winNum = Integer.parseInt(winLabel.getText())+1;
				winLabel.setText(Integer.toString(winNum));
			}
			else if(checkWin("O").equals("")&&numTurns!=5)
			{
				Button xt=(Button)e.getSource();
				xt.setDisable(true);
				xt.setText("X");
				xt.setStyle("-fx-base: #66ccff;");
				if(comboBoxChoice.equals("Easy"))
				{
					for(int i=0;i<9;i++)
					{
						if(arrayButts[i].getText().equals(""))
						{
							arrayButts[i].setDisable(true);
							arrayButts[i].setText("O");
							arrayButts[i].setStyle("-fx-base: #ff7566;");
							break;
						}
					}
					if(checkWin("O").equals("Computer Wins"))
					{
						for(int i = 0;i<9;i++)
						{
							arrayButts[i].setDisable(true);
						}
						messageLabel.setText("CPU Wins");
						int lossNum = Integer.parseInt(lossLabel.getText())+1;
						lossLabel.setText(Integer.toString(lossNum));
					}
					else if(checkWin("O").equals("")&&checkWin("X").equals("")&&numTurns==4)
					{
						for(int i = 0;i<9;i++)
						{
							arrayButts[i].setDisable(true);
						}
						messageLabel.setText("Tie");
					}
					
				}
				else if(comboBoxChoice.equals("Normal")||comboBoxChoice.equals("Hard"))
				{
					setCompFirstBoxSelected();
					if(checkWin("O").equals("Computer Wins"))
					{
						for(int i = 0;i<9;i++)
						{
							arrayButts[i].setDisable(true);
						}
						messageLabel.setText("CPU Wins");
						int lossNum = Integer.parseInt(lossLabel.getText())+1;
						lossLabel.setText(Integer.toString(lossNum));
					}
					else if(checkWin("O").equals("")&&checkWin("X").equals("")&&numTurns==4)
					{
						for(int i = 0;i<9;i++)
						{
							arrayButts[i].setDisable(true);
						}
						messageLabel.setText("Tie");
					}
				}
			}
		}
	}
	
	/**
	 * Places Os in appropriate places depending on the players choices if the player goes second
	 * Places Os first depending on difficulty
	 * 
	 * Utilisé seulement si l'usagé passe deuxièmement 
	 * Place les "O" dans des places selon la stratégie et le niveau de difficulté
	 * Au deuxième tour, l'ordi vérifie s'il y en a des "pairs" de Xs et place un O pour bloquer
	 */
	Button Xone, Xtwo, Xthree, Xfour;
	public void setCompFirstBoxSelected()
	{
		if(numTurns==0)
		{
			if(comboBoxChoice.equals("Normal"))
			{
				int randomNumber = randomNumberGenerator(2);
				if(randomNumber==0)
				{
					arrayButts[4].setDisable(true);
					arrayButts[4].setText("O");
					arrayButts[4].setStyle("-fx-base: #ff7566;");
				}
				else
				{
					arrayButts[5].setDisable(true);
					arrayButts[5].setText("O");
					arrayButts[5].setStyle("-fx-base: #ff7566;");
				}
			}
			else if(comboBoxChoice.equals("Hard"))
			{
				int randomNumber = randomNumberGenerator(2);
				if(randomNumber==0)
				{
					arrayButts[0].setDisable(true);
					arrayButts[0].setText("O");
					arrayButts[0].setStyle("-fx-base: #ff7566;");
				}
				else
				{
					arrayButts[4].setDisable(true);
					arrayButts[4].setText("O");
					arrayButts[4].setStyle("-fx-base: #ff7566;");
				}
			}
		}
		else if(numTurns==1)
		{
			for(int i=0;i<9;i++)
			{
				if(arrayButts[i].getText().equals("X"))
				{
					Xone=arrayButts[i];
				}
			}
			if(Xone!=butt7||Xone!=butt9||Xone!=butt3)
			{
				if(Xone==butt7)
				{
					arrayButts[2].setDisable(true);
					arrayButts[2].setText("O");
					arrayButts[2].setStyle("-fx-base: #ff7566;");
				}
				else if(Xone==butt3)
				{
					arrayButts[6].setDisable(true);
					arrayButts[6].setText("O");
					arrayButts[6].setStyle("-fx-base: #ff7566;");
				}
				else
				{
					arrayButts[8].setDisable(true);
					arrayButts[8].setText("O");
					arrayButts[8].setStyle("-fx-base: #ff7566;");
				}
						
			}
			else
			{
				if(arrayButts[4].getText().equals(""))
				{
					arrayButts[4].setDisable(true);
					arrayButts[4].setText("O");
					arrayButts[4].setStyle("-fx-base: #ff7566;");
				}
				else
				{
					setRandomBoxSelected();
				}
			}
		}
		else if(numTurns==2||numTurns==3)
		{
			//checks the first row
			if(arrayButts[0].getText().equals("X")&&arrayButts[1].getText().equals("X")&&arrayButts[2].getText().equals("")||
					arrayButts[1].getText().equals("")&&arrayButts[1].getText().equals("X")&&arrayButts[2].getText().equals("X")||
					arrayButts[0].getText().equals("X")&&arrayButts[1].getText().equals("")&&arrayButts[2].getText().equals("X"))
			{
				for(int i=0;i<3;i++)
				{
					if(!arrayButts[i].getText().equals("X"))
					{
						arrayButts[i].setDisable(true);
						arrayButts[i].setText("O");
						arrayButts[i].setStyle("-fx-base: #ff7566;");
						System.out.println("Availble button : Button id " + i);
						break;
					}
				}
			}
			//checks the second row
			else if(arrayButts[3].getText().equals("X")&&arrayButts[4].getText().equals("X")&&arrayButts[5].getText().equals("")||
					arrayButts[3].getText().equals("")&&arrayButts[4].getText().equals("X")&&arrayButts[5].getText().equals("X")||
					arrayButts[3].getText().equals("X")&&arrayButts[4].getText().equals("")&&arrayButts[5].getText().equals("X"))
			{
				for(int i=3;i<6;i++)
				{
					if(!arrayButts[i].getText().equals("X"))
					{
						arrayButts[i].setDisable(true);
						arrayButts[i].setText("O");
						arrayButts[i].setStyle("-fx-base: #ff7566;");
						System.out.println("Availble button : Button id " + i);
						break;
					}
				}
			}
			//checks the third row
			else if(arrayButts[6].getText().equals("X")&&arrayButts[7].getText().equals("X")&&arrayButts[8].getText().equals("")||
					arrayButts[6].getText().equals("")&&arrayButts[7].getText().equals("X")&&arrayButts[8].getText().equals("X")||
					arrayButts[6].getText().equals("X")&&arrayButts[7].getText().equals("")&&arrayButts[8].getText().equals("X"))
			{
				for(int i=6;i<9;i++)
				{
					if(!arrayButts[i].getText().equals("X"))
					{
						arrayButts[i].setDisable(true);
						arrayButts[i].setText("O");
						arrayButts[i].setStyle("-fx-base: #ff7566;");
						System.out.println("Availble button : Button id " + i);
						break;
					}
				}
			}
			//checks the first column
			else if(arrayButts[0].getText().equals("X")&&arrayButts[3].getText().equals("X")&&arrayButts[6].getText().equals("")||
					arrayButts[0].getText().equals("")&&arrayButts[3].getText().equals("X")&&arrayButts[6].getText().equals("X")||
					arrayButts[0].getText().equals("X")&&arrayButts[3].getText().equals("")&&arrayButts[6].getText().equals("X"))
			{
				for(int i=0;i<9;i=i+3)
				{
					if(!arrayButts[i].getText().equals("X"))
					{
						arrayButts[i].setDisable(true);
						arrayButts[i].setText("O");
						arrayButts[i].setStyle("-fx-base: #ff7566;");
						System.out.println("Availble button : Button id " + i);
						break;
					}
				}
			}
			//checks the second column
			else if(arrayButts[1].getText().equals("X")&&arrayButts[4].getText().equals("X")&&arrayButts[7].getText().equals("")||
					arrayButts[1].getText().equals("")&&arrayButts[4].getText().equals("X")&&arrayButts[7].getText().equals("X")||
					arrayButts[1].getText().equals("X")&&arrayButts[4].getText().equals("")&&arrayButts[7].getText().equals("X"))
			{
				for(int i=1;i<9;i=i+3)
				{
					if(!arrayButts[i].getText().equals("X"))
					{
						arrayButts[i].setDisable(true);
						arrayButts[i].setText("O");
						arrayButts[i].setStyle("-fx-base: #ff7566;");
						System.out.println("Availble button : Button id " + i);
						break;
					}
				}
			}
			//checks the third column
			else if(arrayButts[2].getText().equals("X")&&arrayButts[5].getText().equals("X")&&arrayButts[8].getText().equals("")||
					arrayButts[2].getText().equals("")&&arrayButts[5].getText().equals("X")&&arrayButts[8].getText().equals("X")||
					arrayButts[2].getText().equals("X")&&arrayButts[5].getText().equals("")&&arrayButts[8].getText().equals("X"))
			{
				for(int i=2;i<9;i=i+3)
				{
					if(!arrayButts[i].getText().equals("X"))
					{
						arrayButts[i].setDisable(true);
						arrayButts[i].setText("O");
						arrayButts[i].setStyle("-fx-base: #ff7566;");
						System.out.println("Availble button : Button id " + i);
						break;
					}
				}
			}
			//checks the 0,4,8 diagonal
			else if(arrayButts[0].getText().equals("X")&&arrayButts[4].getText().equals("X")&&arrayButts[8].getText().equals("")||
					arrayButts[0].getText().equals("")&&arrayButts[4].getText().equals("X")&&arrayButts[8].getText().equals("X")||
					arrayButts[0].getText().equals("X")&&arrayButts[4].getText().equals("")&&arrayButts[8].getText().equals("X"))
			{
				for(int i=0;i<9;i=i+4)
				{
					if(!arrayButts[i].getText().equals("X"))
					{
						arrayButts[i].setDisable(true);
						arrayButts[i].setText("O");
						arrayButts[i].setStyle("-fx-base: #ff7566;");
						System.out.println("Availble button : Button id " + i);
						break;
					}
				}
			}
			//checks the 2,4,6 diagonal
			else if(arrayButts[2].getText().equals("X")&&arrayButts[4].getText().equals("X")&&arrayButts[6].getText().equals("")||
					arrayButts[2].getText().equals("")&&arrayButts[4].getText().equals("X")&&arrayButts[6].getText().equals("X")||
					arrayButts[2].getText().equals("X")&&arrayButts[4].getText().equals("")&&arrayButts[6].getText().equals("X"))
			{
				for(int i=2;i<9;i=i+2)
				{
					if(!arrayButts[i].getText().equals("X"))
					{
						arrayButts[i].setDisable(true);
						arrayButts[i].setText("O");
						arrayButts[i].setStyle("-fx-base: #ff7566;");
						System.out.println("Availble button : Button id " + i);
						break;
					}

				}
			}
			else
			{
				for(int i=0;i<9;i++)
				{
					if(arrayButts[i].getText().equals(""))
					{
						arrayButts[i].setDisable(true);
						arrayButts[i].setText("O");
						arrayButts[i].setStyle("-fx-base: #ff7566;");
						break;
					}
				}
			}
		}
		else
		{
			for(int i=0;i<9;i++)
			{
				if(arrayButts[i].getText().equals(""))
				{
					arrayButts[i].setDisable(true);
					arrayButts[i].setText("O");
					arrayButts[i].setStyle("-fx-base: #ff7566;");
					break;
				}
			}
		}
	}

	/**
	 * Checks if a randomly generated number's button is taken
	 * Sets text of button as "O" if it was null
	 * Cycles until result found
	 * 
	 * Génére une nombre quelconque
	 * Vérifient si les boutons ont des X ou des O
	 * Si le texte du bouton est nulle, le texte sera mis comme X
	 */
	public void setRandomBoxSelected()
	{
		boolean doableNumber = false;
		for(int i = 0; doableNumber==false && i<=8; i++)
		{
			int randomNumber = randomNumberGenerator(9);
			if(arrayButts[randomNumber].getText()=="X");
			else if(arrayButts[randomNumber].getText()=="O");
			else if(arrayButts[randomNumber].getText()=="")
			{
				doableNumber = true;
				arrayButts[randomNumber].setDisable(true);
				arrayButts[randomNumber].setText("O");
				arrayButts[randomNumber].setStyle("-fx-base: #ff7566;");
				break;
			}
		}
	}

	/**
	 * Checks for any two adjacent player boxes and places an O to prevent player win if the player goes first
	 * 
	 * Utilisé seulement si l'usagé passe en premier
	 * Vérifie des "pairs' d'X et place un O pour le bloquer
	 * @param a Clicked button
	 */
	public void setStrategyBoxSelected(Button a)
	{
		if(numTurns==1)
		{
			if(comboBoxChoice.equals("Hard"))
			{
				if(a!= butt5)
				{
					arrayButts[4].setDisable(true);
					arrayButts[4].setText("O");
					arrayButts[4].setStyle("-fx-base: #ff7566;");
				}
				else
				{
					System.out.println("Placing O randomly");
					setRandomBoxSelected();
				}
			}
			else
			{
				setRandomBoxSelected();
			}
		}
		else if(numTurns!=1)
		{
			//checks the first row
			if(arrayButts[0].getText().equals("X")&&arrayButts[1].getText().equals("X")&&arrayButts[2].getText().equals("")||
					arrayButts[1].getText().equals("")&&arrayButts[1].getText().equals("X")&&arrayButts[2].getText().equals("X")||
					arrayButts[0].getText().equals("X")&&arrayButts[1].getText().equals("")&&arrayButts[2].getText().equals("X"))
			{
				for(int i=0;i<3;i++)
				{
					if(!arrayButts[i].getText().equals("X"))
					{
						arrayButts[i].setDisable(true);
						arrayButts[i].setText("O");
						arrayButts[i].setStyle("-fx-base: #ff7566;");
						System.out.println("Availble button : Button id " + i);
						break;
					}
				}
			}
			//checks the second row
			else if(arrayButts[3].getText().equals("X")&&arrayButts[4].getText().equals("X")&&arrayButts[5].getText().equals("")||
					arrayButts[3].getText().equals("")&&arrayButts[4].getText().equals("X")&&arrayButts[5].getText().equals("X")||
					arrayButts[3].getText().equals("X")&&arrayButts[4].getText().equals("")&&arrayButts[5].getText().equals("X"))
			{
				for(int i=3;i<6;i++)
				{
					if(!arrayButts[i].getText().equals("X"))
					{
						arrayButts[i].setDisable(true);
						arrayButts[i].setText("O");
						arrayButts[i].setStyle("-fx-base: #ff7566;");
						System.out.println("Availble button : Button id " + i);
						break;
					}
				}
			}
			//checks the third row
			else if(arrayButts[6].getText().equals("X")&&arrayButts[7].getText().equals("X")&&arrayButts[8].getText().equals("")||
					arrayButts[6].getText().equals("")&&arrayButts[7].getText().equals("X")&&arrayButts[8].getText().equals("X")||
					arrayButts[6].getText().equals("X")&&arrayButts[7].getText().equals("")&&arrayButts[8].getText().equals("X"))
			{
				for(int i=6;i<9;i++)
				{
					if(!arrayButts[i].getText().equals("X"))
					{
						arrayButts[i].setDisable(true);
						arrayButts[i].setText("O");
						arrayButts[i].setStyle("-fx-base: #ff7566;");
						System.out.println("Availble button : Button id " + i);
						break;
					}
				}
			}
			//checks the first column
			else if(arrayButts[0].getText().equals("X")&&arrayButts[3].getText().equals("X")&&arrayButts[6].getText().equals("")||
					arrayButts[0].getText().equals("")&&arrayButts[3].getText().equals("X")&&arrayButts[6].getText().equals("X")||
					arrayButts[0].getText().equals("X")&&arrayButts[3].getText().equals("")&&arrayButts[6].getText().equals("X"))
			{
				for(int i=0;i<9;i=i+3)
				{
					if(!arrayButts[i].getText().equals("X"))
					{
						arrayButts[i].setDisable(true);
						arrayButts[i].setText("O");
						arrayButts[i].setStyle("-fx-base: #ff7566;");
						System.out.println("Availble button : Button id " + i);
						break;
					}
				}
			}
			//checks the second column
			else if(arrayButts[1].getText().equals("X")&&arrayButts[4].getText().equals("X")&&arrayButts[7].getText().equals("")||
					arrayButts[1].getText().equals("")&&arrayButts[4].getText().equals("X")&&arrayButts[7].getText().equals("X")||
					arrayButts[1].getText().equals("X")&&arrayButts[4].getText().equals("")&&arrayButts[7].getText().equals("X"))
			{
				for(int i=1;i<9;i=i+3)
				{
					if(!arrayButts[i].getText().equals("X"))
					{
						arrayButts[i].setDisable(true);
						arrayButts[i].setText("O");
						arrayButts[i].setStyle("-fx-base: #ff7566;");
						System.out.println("Availble button : Button id " + i);
						break;
					}
				}
			}
			//checks the third column
			else if(arrayButts[2].getText().equals("X")&&arrayButts[5].getText().equals("X")&&arrayButts[8].getText().equals("")||
					arrayButts[2].getText().equals("")&&arrayButts[5].getText().equals("X")&&arrayButts[8].getText().equals("X")||
					arrayButts[2].getText().equals("X")&&arrayButts[5].getText().equals("")&&arrayButts[8].getText().equals("X"))
			{
				for(int i=2;i<9;i=i+3)
				{
					if(!arrayButts[i].getText().equals("X"))
					{
						arrayButts[i].setDisable(true);
						arrayButts[i].setText("O");
						arrayButts[i].setStyle("-fx-base: #ff7566;");
						System.out.println("Availble button : Button id " + i);
						break;
					}
				}
			}
			//checks the 0,4,8 diagonal
			else if(arrayButts[0].getText().equals("X")&&arrayButts[4].getText().equals("X")&&arrayButts[8].getText().equals("")||
					arrayButts[0].getText().equals("")&&arrayButts[4].getText().equals("X")&&arrayButts[8].getText().equals("X")||
					arrayButts[0].getText().equals("X")&&arrayButts[4].getText().equals("")&&arrayButts[8].getText().equals("X"))
			{
				for(int i=0;i<9;i=i+4)
				{
					if(!arrayButts[i].getText().equals("X"))
					{
						arrayButts[i].setDisable(true);
						arrayButts[i].setText("O");
						arrayButts[i].setStyle("-fx-base: #ff7566;");
						System.out.println("Availble button : Button id " + i);
						break;
					}
				}
			}
			//checks the 2,4,6 diagonal
			else if(arrayButts[2].getText().equals("X")&&arrayButts[4].getText().equals("X")&&arrayButts[6].getText().equals("")||
					arrayButts[2].getText().equals("")&&arrayButts[4].getText().equals("X")&&arrayButts[6].getText().equals("X")||
					arrayButts[2].getText().equals("X")&&arrayButts[4].getText().equals("")&&arrayButts[6].getText().equals("X"))
			{
				for(int i=2;i<9;i=i+2)
				{
					if(!arrayButts[i].getText().equals("X"))
					{
						arrayButts[i].setDisable(true);
						arrayButts[i].setText("O");
						arrayButts[i].setStyle("-fx-base: #ff7566;");
						System.out.println("Availble button : Button id " + i);
						break;
					}
				}
			}
			else
			{
				setRandomBoxSelected();
			}
		}
	}

	/**
	 * Checks if there is a winner
	 * 
	 * Vérifie s'il y a un gagnant
	 * Modifier le couleur des boutons pour indiquer le gagnant
	 * @param a X or Y
	 * @return Who wins or if there is not a winner
	 */
	public String checkWin(String a)
	{
		if(arrayButts[0].getText()==a && arrayButts[1].getText()==a && arrayButts[2].getText()==a)
		{
			if(a=="X")
			{
				arrayButts[0].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[1].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[2].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				if(compFirst.isSelected())
				{
					btnClicked(null);
				}
				return "Player Wins";
			}
			else if(a=="O")
			{
				arrayButts[0].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[1].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[2].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				return "Computer Wins";
			}
		}
		else if(arrayButts[3].getText()==a && arrayButts[4].getText()==a && arrayButts[5].getText()==a)
		{
			if(a=="X")
			{
				if(compFirst.isSelected())
				{
					btnClicked(null);
				}
				arrayButts[3].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[4].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[5].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				return "Player Wins";
			}
			else if(a=="O")
			{
				arrayButts[3].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[4].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[5].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				return "Computer Wins";
			}
		}
		else if(arrayButts[6].getText()==a && arrayButts[7].getText()==a && arrayButts[8].getText()==a)
		{
			if(a=="X")
			{
				if(compFirst.isSelected())
				{
					btnClicked(null);
				}
				arrayButts[6].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[7].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[8].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				return "Player Wins";
			}
			else if(a=="O")
			{
				arrayButts[6].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[7].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[8].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				return "Computer Wins";
			}
		}
		else if(arrayButts[0].getText()==a && arrayButts[3].getText()==a && arrayButts[6].getText()==a)
		{
			if(a=="X")
			{
				if(compFirst.isSelected())
				{
					btnClicked(null);
				}
				arrayButts[0].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[3].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[6].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				return "Player Wins";
			}
			else if(a=="O")
			{
				arrayButts[0].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[3].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[6].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				return "Computer Wins";
			}
		}
		else if(arrayButts[1].getText()==a && arrayButts[4].getText()==a && arrayButts[7].getText()==a)
		{
			if(a=="X")
			{
				if(compFirst.isSelected())
				{
					btnClicked(null);
				}
				arrayButts[1].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[4].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[7].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				return "Player Wins";
			}
			else if(a=="O")
			{
				arrayButts[1].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[4].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[7].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				return "Computer Wins";
			}
		}
		else if(arrayButts[2].getText()==a && arrayButts[5].getText()==a && arrayButts[8].getText()==a)
		{
			if(a=="X")
			{
				if(compFirst.isSelected())
				{
					btnClicked(null);
				}
				arrayButts[2].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5pxv");
				arrayButts[5].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[8].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				return "Player Wins";
			}
			else if(a=="O")
			{
				arrayButts[2].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[5].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[8].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				return "Computer Wins";
			}
		}
		else if(arrayButts[0].getText()==a && arrayButts[4].getText()==a && arrayButts[8].getText()==a)
		{
			if(a=="X")
			{
				if(compFirst.isSelected())
				{
					btnClicked(null);
				}
				arrayButts[0].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[4].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[8].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				return "Player Wins";
			}
			else if(a=="O")
			{
				arrayButts[0].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[4].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[8].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				return "Computer Wins";
			}
		}
		else if(arrayButts[2].getText()==a && arrayButts[4].getText()==a && arrayButts[6].getText()==a)
		{
			if(a=="X")
			{
				if(compFirst.isSelected())
				{
					btnClicked(null);
				}
				arrayButts[2].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[4].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[6].setStyle("-fx-base: #66ccff; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				return "Player Wins";
			}
			else if(a=="O")
			{
				arrayButts[2].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[4].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				arrayButts[6].setStyle("-fx-base: #ff7566; -fx-border-color: #ed66ff; -fx-border-width: 5px");
				return "Computer Wins";
			}
		}
		return "";
	}

	/**
	 * Generates a random number within the bounds as parameters
	 * 
	 * Génére un nombre par hazard
	 * @param a Upper limit of wanted random numbers
	 * @return Returns the random number
	 */
	public int randomNumberGenerator(int a)
	{
		Random rand = new Random();
		return rand.nextInt(a);
	}

	/**
	 * Clears the text of all the buttons
	 * Enables click for the buttons
	 * Resets the number of turns played
	 * 
	 * Efface le texte et le couleur des boutons
	 * Permettre l'usagé de cliquer 
	 * Mettre le numTurns à 0
	 */
	public void reInitialize()
	{
		for (int i=0;i<9;i++)
		{
			arrayButts[i].setText("");
			arrayButts[i].setStyle(null);
		}
		messageLabel.setText("");
		numTurns=0;
	}

	/**
	 * Resets the score
	 * 
	 * Mettre le score à zéro
	 */
	public void resetScore()
	{
		reInitialize();
		lossLabel.setText("0");
		winLabel.setText("0");
		messageLabel.setText("");
	}

	/**
	 * Closes the program
	 * 
	 * Ferme le jeu
	 */
	public void handleClose()
	{
		System.exit(0);
	}

	/**
	 * Opens dialog about program
	 * 
	 * Ouvre un dialog à propos du jeu
	 */
	public void handleAbout()
	{
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setHeaderText("About this program");
		alert.setTitle("ABOUT");
		alert.setContentText("This program was created by Sean Huang for J.Zagabe's "
				+ "ICS3U5Oa Computer Science class at the Toronto French School "
				+ "in the 2017-2018 academic year. This is version 1.0 of the game.");
		alert.show();
	}

	/**
	 * Opens dialog with detailed instructions
	 * 
	 * Ouvre un dialog avec webview qui montre les instructions en forme de html
	 */
	public void handleInstructions()
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Instructions");
		alert.setHeaderText("Instructions");
		alert.setContentText("The instructions are below.");
		alert.getDialogPane().setPrefSize(480, 400);

		Label label = new Label("Instructions:");

		
		WebView webArea = new WebView();
		WebEngine webEngine = webArea.getEngine();
		webEngine.load(this.getClass().getResource("instructions.html").toString());
		
		webArea.setMaxWidth(Double.MAX_VALUE);
		webArea.setMaxHeight(Double.MAX_VALUE);
		GridPane.setVgrow(webArea, Priority.ALWAYS);
		GridPane.setHgrow(webArea, Priority.ALWAYS);

		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);
		expContent.add(label, 0, 0);
		expContent.add(webArea, 0, 1);
		//expContent.setExpanded(true);

		// Set expandable Exception into the dialog pane.
		alert.getDialogPane().setExpandableContent(expContent);

		alert.showAndWait();
	}

	/**
	 * Opens dialog about available difficulty settings 
	 * 
	 * Ouvre un dialog à propos des niveaux de difficultés 
	 */
	public void handleDifficulty()
	{
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Available difficulty levels");
		alert.setTitle("DIFFICULTY INFORMATION");
		alert.setContentText("Easy level has a completely random computer while Normal"
				+ "has a computer that strategizes. It is recommended to play on Normal. Hard strategy "
				+ "is completly strategy and is very difficult. ");
		alert.show();
	}

}
