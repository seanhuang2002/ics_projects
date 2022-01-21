package application;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.model.Card;
import application.model.Deck;
import application.model.Hand;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainWindowController implements Initializable {

	private Main main;
	public void setMain(Main main) {
		this.main=main;
	}

	ArrayList<String> suitsE = new ArrayList<String>();
	/**
	 * Initialization de tout les images et labels
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		chooseSpadesE.setDisable(true);
		chooseDiaE.setDisable(true);
		chooseHeartsE.setDisable(true);
		chooseClubsE.setDisable(true);
		choosePassE.setDisable(true);
		dealE.setDisable(true);
		labelTricksWonE.setText("0");
		labelTricksLostE.setText("0");
		labelMSGE.setText("Deal");
		labelGamesWonE.setText("0");
		labelGamesLostE.setText("0");
		labelTotalMoneyE.setText(Integer.toString(totalMoneyE));
		labelBetE.setText("Place your bet");
		//BLACKJACK START
		deckBJ.shuffle();
		numTurnsBJ=1;
		labelMsgBJ.setText("Place your bet and deal");
		labelTotalMonetBJ.setText(Integer.toString(totalMoneyBJ));
		buttHitBJ.setDisable(true);
		buttStandBJ.setDisable(true);
		buttInsuranceBJ.setDisable(true);
		buttDoubleDownBJ.setDisable(true);
		buttSurrenderBJ.setDisable(true);
		buttDealBJ.setDisable(true);
		totalMoneyBJ = 2500;
		labelWinBJ.setText(Integer.toString(winBJ));
		labelLossBJ.setText(Integer.toString(lossBJ));
		labelBetBJ.setText("Place bet");
		labelPlayerBJ.setText("0");
		labelDealerBJ.setText("0");
		//BLACKJACK END
		//HIGHLOW START
		deckHL.shuffle();
		labelMSGHL.setText("Place your bet and deal");
		totalMoneyHL=2500;
		dealHL.setDisable(true);
		highHL.setDisable(true);
		lowHL.setDisable(true);
		labelWinHL.setText(Integer.toString(winHL));
		labelLossHL.setText(Integer.toString(lossHL));
		labelBetHL.setText("Place bet");
		Image backOfCard = new Image("file:resources/images/Red_back.jpg");
		viewFirstHL.setImage(backOfCard);
		viewSecondHL.setImage(backOfCard);
		//HIGHLOWEND
		suitsE.add(0, "Diamonds");
		suitsE.add(1, "Hearts");
		suitsE.add(2, "Spades");
		suitsE.add(3, "Clubs");
	}

	/**
	 * Cette méthode va mettre une image dans un ImageView 
	 * selon la carte demandé
	 * @param a La carte qui doit être mis en Image
	 * @param view L'ImageView où la carte doit être inséré
	 */
	public void setCardToImage(Card a, ImageView view)
	{
		String value = a.getValueAsString();
		System.out.println("setImageToImage value:"+value);
		String imageUrl = "";
		Image image = null;
		if(a.getSuitAsString().equals("Spades"))
		{
			switch(value){
			case "Ace": imageUrl="file:resources/images/AS.jpg";
			break;
			case "2": imageUrl="file:resources/images/2S.jpg";
			break;
			case "3": imageUrl="file:resources/images/3S.jpg";
			break;
			case "4": imageUrl="file:resources/images/4S.jpg";
			break;
			case "5": imageUrl="file:resources/images/5S.jpg";
			break;
			case "6": imageUrl="file:resources/images/6S.jpg";
			break;
			case "7": imageUrl="file:resources/images/7S.jpg";
			break;
			case "8": imageUrl="file:resources/images/8S.jpg";
			break;
			case "9": imageUrl="file:resources/images/9S.jpg";
			break;
			case "10": imageUrl="file:resources/images/10S.jpg";
			break;
			case "Jack": imageUrl="file:resources/images/JS.jpg";
			break;
			case "Queen": imageUrl="file:resources/images/QS.jpg";
			break;
			case "King": imageUrl="file:resources/images/KS.jpg";
			break;
			}
		}
		else if(a.getSuitAsString().equals("Hearts"))
		{
			switch(value){
			case "Ace": imageUrl="file:resources/images/AH.jpg";
			break;
			case "2": imageUrl="file:resources/images/2H.jpg";
			break;
			case "3": imageUrl="file:resources/images/3H.jpg";
			break;
			case "4": imageUrl="file:resources/images/4H.jpg";
			break;
			case "5": imageUrl="file:resources/images/5H.jpg";
			break;
			case "6": imageUrl="file:resources/images/6H.jpg";
			break;
			case "7": imageUrl="file:resources/images/7H.jpg";
			break;
			case "8": imageUrl="file:resources/images/8H.jpg";
			break;
			case "9": imageUrl="file:resources/images/9H.jpg";
			break;
			case "10": imageUrl="file:resources/images/10H.jpg";
			break;
			case "Jack": imageUrl="file:resources/images/JH.jpg";
			break;
			case "Queen": imageUrl="file:resources/images/QH.jpg";
			break;
			case "King": imageUrl="file:resources/images/KH.jpg";
			break;
			}
		}
		else if(a.getSuitAsString().equals("Diamonds"))
		{
			switch(value){
			case "Ace": imageUrl="file:resources/images/AD.jpg";
			break;
			case "2": imageUrl="file:resources/images/2D.jpg";
			break;
			case "3": imageUrl="file:resources/images/3D.jpg";
			break;
			case "4": imageUrl="file:resources/images/4D.jpg";
			break;
			case "5": imageUrl="file:resources/images/5D.jpg";
			break;
			case "6": imageUrl="file:resources/images/6D.jpg";
			break;
			case "7": imageUrl="file:resources/images/7D.jpg";
			break;
			case "8": imageUrl="file:resources/images/8D.jpg";
			break;
			case "9": imageUrl="file:resources/images/9D.jpg";
			break;
			case "10": imageUrl="file:resources/images/10D.jpg";
			break;
			case "Jack": imageUrl="file:resources/images/JD.jpg";
			break;
			case "Queen": imageUrl="file:resources/images/QD.jpg";
			break;
			case "King": imageUrl="file:resources/images/KD.jpg";
			break;
			}
		}
		else if(a.getSuitAsString().equals("Clubs"))
		{
			switch(value){
			case "Ace": imageUrl="file:resources/images/AC.jpg";
			break;
			case "2": imageUrl="file:resources/images/2C.jpg";
			break;
			case "3": imageUrl="file:resources/images/3C.jpg";
			break;
			case "4": imageUrl="file:resources/images/4C.jpg";
			break;
			case "5": imageUrl="file:resources/images/5C.jpg";
			break;
			case "6": imageUrl="file:resources/images/6C.jpg";
			break;
			case "7": imageUrl="file:resources/images/7C.jpg";
			break;
			case "8": imageUrl="file:resources/images/8C.jpg";
			break;
			case "9": imageUrl="file:resources/images/9C.jpg";
			break;
			case "10": imageUrl="file:resources/images/10C.jpg";
			break;
			case "Jack": imageUrl="file:resources/images/JC.jpg";
			break;
			case "Queen": imageUrl="file:resources/images/QC.jpg";
			break;
			case "King": imageUrl="file:resources/images/KC.jpg";
			break;
			}
		}
		image = new Image(imageUrl);
		view.setImage(image);
	}


	/* ============================
	 * BlackJack Start
	 * ============================
	 */

	@FXML
	private Button buttHitBJ;

	@FXML
	private Label labelBetBJ;

	@FXML
	private Button buttStandBJ;

	@FXML
	private Label labelWinBJ;

	@FXML
	private Label labelTotalMonetBJ;

	@FXML
	private Label labelLossBJ;

	@FXML
	private Label labelMsgBJ;

	@FXML
	private Label labelPlayerBJ;

	@FXML
	private Label labelDealerBJ;

	@FXML
	private Button buttInstructionsBJ;

	@FXML
	private TextField fieldBetBJ;

	@FXML
	private Button buttAboutBJ;

	@FXML
	private Button buttBetBJ;

	@FXML
	private Button buttDealBJ;

	@FXML
	private Button buttSurrenderBJ;

	@FXML
	private Button buttInsuranceBJ;

	@FXML
	private Button buttDoubleDownBJ;

	@FXML
	private Button buttSplitBJ;

	@FXML
	private ImageView viewPlayer1;

	@FXML
	private ImageView viewPlayer2;

	@FXML
	private ImageView viewPlayer3;

	@FXML
	private ImageView viewPlayer4;

	@FXML
	private ImageView viewPlayer5;

	@FXML
	private ImageView viewDealer6;

	@FXML
	private ImageView viewDealer1;

	@FXML
	private ImageView viewDealer2;

	@FXML
	private ImageView viewDealer3;

	@FXML
	private ImageView viewDealer4;

	@FXML
	private ImageView viewDealer5;

	@FXML
	private ImageView viewPlayer6;

	Card playerOneBJ, playerTwoBJ, playerThreeBJ, playerFourBJ, playerFiveBJ, playerSixBJ, dealerOneBJ, 
	dealerTwoBJ, dealerThreeBJ, dealerFourBJ, dealerFiveBJ, dealerSixBJ;

	Deck deckBJ = new Deck();

	int betBJ=0, totalMoneyBJ=2500, winBJ =0, lossBJ = 0, playerScoreBJ=0, dealerScoreBJ=0, numTurnsBJ=0;
	/**
	 * Cette méthode fait la distribution de cartes selon les règles de Blackjack
	 */
	@FXML
	public void dealBJ()
	{	
		labelPlayerBJ.setText("");
		labelDealerBJ.setText("");
		if(numTurnsBJ==1)
		{
			if(deckBJ.cardsLeft()<4)
			{
				deckBJ.shuffle();
			}
			playerOneBJ=deckBJ.dealCard();
			System.out.println("Player Cards:");
			System.out.println(playerOneBJ);
			setCardToImage(playerOneBJ, viewPlayer1);


			playerTwoBJ=deckBJ.dealCard();
			System.out.println(playerTwoBJ);
			setCardToImage(playerTwoBJ, viewPlayer2);

			dealerOneBJ=deckBJ.dealCard();
			System.out.println("Dealer Cards:");
			System.out.println(dealerOneBJ);
			setCardToImage(dealerOneBJ, viewDealer1);

			dealerTwoBJ=deckBJ.dealCard();
			System.out.println(dealerTwoBJ);
			setCardToImage(dealerTwoBJ, viewDealer2);

			playerScoreBJ = getBlackJackValue(playerOneBJ.getValueAsString()) + getBlackJackValue(playerTwoBJ.getValueAsString());
			dealerScoreBJ = getBlackJackValue(dealerOneBJ.getValueAsString()) + getBlackJackValue(dealerTwoBJ.getValueAsString());
			System.out.println("Player score" +playerScoreBJ);
			System.out.println("Dealer score" +dealerScoreBJ);

			buttDealBJ.setDisable(true);
			buttHitBJ.setDisable(false);
			buttStandBJ.setDisable(false);
			buttSurrenderBJ.setDisable(false);
			numTurnsBJ++;
			labelPlayerBJ.setText(Integer.toString(playerScoreBJ));
			labelDealerBJ.setText(Integer.toString(dealerScoreBJ));
		}
		else if(numTurnsBJ==2)
		{
			if(deckBJ.cardsLeft()<2)
			{
				deckBJ.shuffle();
			}
			playerThreeBJ=deckBJ.dealCard();
			System.out.println("Player Cards:");
			System.out.println(playerThreeBJ);
			setCardToImage(playerThreeBJ, viewPlayer3);
			playerScoreBJ = playerScoreBJ + getBlackJackValue(playerThreeBJ.getValueAsString());
			System.out.println("Player score" +playerScoreBJ);
			System.out.println("Dealer score" +dealerScoreBJ);
			numTurnsBJ++;
			labelPlayerBJ.setText(Integer.toString(playerScoreBJ));
			labelDealerBJ.setText(Integer.toString(dealerScoreBJ));
		}
		else if(numTurnsBJ==3)
		{
			if(deckBJ.cardsLeft()<2)
			{
				deckBJ.shuffle();
			}
			playerFourBJ=deckBJ.dealCard();
			System.out.println("Player Cards:");
			System.out.println(playerFourBJ);
			setCardToImage(playerFourBJ, viewPlayer4);
			playerScoreBJ = playerScoreBJ + getBlackJackValue(playerFourBJ.getValueAsString());
			System.out.println("Player score" +playerScoreBJ);
			System.out.println("Dealer score" +dealerScoreBJ);
			numTurnsBJ++;
			labelPlayerBJ.setText(Integer.toString(playerScoreBJ));
			labelDealerBJ.setText(Integer.toString(dealerScoreBJ));
		}
		else if(numTurnsBJ==4)
		{
			if(deckBJ.cardsLeft()<2)
			{
				deckBJ.shuffle();
			}
			playerFiveBJ=deckBJ.dealCard();
			System.out.println("Player Cards:");
			System.out.println(playerFiveBJ);
			setCardToImage(playerFiveBJ, viewPlayer5);
			playerScoreBJ = playerScoreBJ + getBlackJackValue(playerFiveBJ.getValueAsString());
			System.out.println("Player score" +playerScoreBJ);
			System.out.println("Dealer score" +dealerScoreBJ);
			numTurnsBJ++;
			labelPlayerBJ.setText(Integer.toString(playerScoreBJ));
			labelDealerBJ.setText(Integer.toString(dealerScoreBJ));
		}
		else if(numTurnsBJ==5)
		{
			if(deckBJ.cardsLeft()<2)
			{
				deckBJ.shuffle();
			}
			playerSixBJ=deckBJ.dealCard();
			System.out.println("Player Cards:");
			System.out.println(playerSixBJ);
			setCardToImage(playerSixBJ, viewPlayer6);
			playerScoreBJ = playerScoreBJ + getBlackJackValue(playerSixBJ.getValueAsString());
			System.out.println("Player score" +playerScoreBJ);
			System.out.println("Dealer score" +dealerScoreBJ);
			numTurnsBJ++;
			labelPlayerBJ.setText(Integer.toString(playerScoreBJ));
			labelDealerBJ.setText(Integer.toString(dealerScoreBJ));
		}
	}
	
	/**
	 * Cette méthode va ajouter une carte dans le main de l'usaer
	 * @param event
	 */
	@FXML
	public void handleHit(ActionEvent event) 
	{
		buttSurrenderBJ.setDisable(true);
		dealBJ();
		if(playerScoreBJ>21)
		{
			endOfGameBJ(false,false);
		}
		else if(playerScoreBJ<21)
		{
			if(dealerScoreBJ<17)
			{
				if(deckBJ.cardsLeft()<2)
				{
					deckBJ.shuffle();
				}
				dealerThreeBJ=deckBJ.dealCard();
				setCardToImage(dealerThreeBJ, viewDealer3);
				dealerScoreBJ =dealerScoreBJ+getBlackJackValue(dealerThreeBJ.getValueAsString());
				labelPlayerBJ.setText(Integer.toString(playerScoreBJ));
				labelDealerBJ.setText(Integer.toString(dealerScoreBJ));
				if(dealerScoreBJ<17)
				{
					if(deckBJ.cardsLeft()<2)
					{
						deckBJ.shuffle();
					}
					dealerFourBJ=deckBJ.dealCard();
					setCardToImage(dealerFourBJ, viewDealer4);
					dealerScoreBJ=dealerScoreBJ+getBlackJackValue(dealerFourBJ.getValueAsString());
					labelPlayerBJ.setText(Integer.toString(playerScoreBJ));
					labelDealerBJ.setText(Integer.toString(dealerScoreBJ));
					if(dealerScoreBJ<17)
					{
						if(deckBJ.cardsLeft()<2)
						{
							deckBJ.shuffle();
						}
						dealerFiveBJ=deckBJ.dealCard();
						setCardToImage(dealerFiveBJ, viewDealer5);
						dealerScoreBJ=dealerScoreBJ+getBlackJackValue(dealerFiveBJ.getValueAsString());
						labelPlayerBJ.setText(Integer.toString(playerScoreBJ));
						labelDealerBJ.setText(Integer.toString(dealerScoreBJ));
						if(dealerScoreBJ<17)
						{
							if(deckBJ.cardsLeft()<2)
							{
								deckBJ.shuffle();
							}
							dealerSixBJ=deckBJ.dealCard();
							setCardToImage(dealerSixBJ, viewDealer6);
							dealerScoreBJ =dealerScoreBJ+getBlackJackValue(dealerSixBJ.getValueAsString());
							labelPlayerBJ.setText(Integer.toString(playerScoreBJ));
							labelDealerBJ.setText(Integer.toString(dealerScoreBJ));
						}
					}
				}
				labelPlayerBJ.setText(Integer.toString(playerScoreBJ));
				labelDealerBJ.setText(Integer.toString(dealerScoreBJ));
			}
			if(dealerScoreBJ>=17)
			{
				if(playerScoreBJ>dealerScoreBJ)
				{
					endOfGameBJ(true,false);
				}
				else if(playerScoreBJ<=21 && dealerScoreBJ >21)
				{
					endOfGameBJ(true,false);
				}
				else if(playerScoreBJ<dealerScoreBJ && dealerScoreBJ<=21)
				{
					endOfGameBJ(false,false);
				}
			}


		}
		else if(playerScoreBJ==21)
		{
			endOfGameBJ(true,false);
		}
		if(playerScoreBJ==dealerScoreBJ)
		{
			endOfGameBJ(false,false);
		}
	}

	/**
	 * Cette méthode va pauser le joue de l'usager
	 * @param event
	 */
	@FXML
	public void handleStand(ActionEvent event) 
	{
		buttSurrenderBJ.setDisable(true);
		numTurnsBJ++;
		if(playerScoreBJ<21)
		{
			if(dealerScoreBJ<17)
			{
				if(deckBJ.cardsLeft()<2)
				{
					deckBJ.shuffle();
				}
				dealerThreeBJ=deckBJ.dealCard();
				setCardToImage(dealerThreeBJ, viewDealer3);
				dealerScoreBJ=dealerScoreBJ+getBlackJackValue(dealerThreeBJ.getValueAsString());
				labelPlayerBJ.setText(Integer.toString(playerScoreBJ));
				labelDealerBJ.setText(Integer.toString(dealerScoreBJ));
				if(dealerScoreBJ<17)
				{
					if(deckBJ.cardsLeft()<2)
					{
						deckBJ.shuffle();
					}
					dealerFourBJ=deckBJ.dealCard();
					setCardToImage(dealerFourBJ, viewDealer4);
					dealerScoreBJ=dealerScoreBJ+getBlackJackValue(dealerFourBJ.getValueAsString());
					labelPlayerBJ.setText(Integer.toString(playerScoreBJ));
					labelDealerBJ.setText(Integer.toString(dealerScoreBJ));
					if(dealerScoreBJ<17)
					{
						if(deckBJ.cardsLeft()<2)
						{
							deckBJ.shuffle();
						}
						dealerFiveBJ=deckBJ.dealCard();
						setCardToImage(dealerFiveBJ, viewDealer5);
						dealerScoreBJ=dealerScoreBJ+getBlackJackValue(dealerFiveBJ.getValueAsString());
						labelPlayerBJ.setText(Integer.toString(playerScoreBJ));
						labelDealerBJ.setText(Integer.toString(dealerScoreBJ));
						if(dealerScoreBJ<17)
						{
							if(deckBJ.cardsLeft()<2)
							{
								deckBJ.shuffle();
							}
							dealerSixBJ=deckBJ.dealCard();
							setCardToImage(dealerSixBJ, viewDealer6);
							dealerScoreBJ=dealerScoreBJ+getBlackJackValue(dealerSixBJ.getValueAsString());
							labelPlayerBJ.setText(Integer.toString(playerScoreBJ));
							labelDealerBJ.setText(Integer.toString(dealerScoreBJ));
						}
					}
				}
				labelPlayerBJ.setText(Integer.toString(playerScoreBJ));
				labelDealerBJ.setText(Integer.toString(dealerScoreBJ));
			}
			if(dealerScoreBJ>=17)
			{
				if(playerScoreBJ>dealerScoreBJ)
				{
					endOfGameBJ(true,false);
				}
				else if(playerScoreBJ<=21 && dealerScoreBJ >21)
				{
					endOfGameBJ(true,false);
				}
				else if(playerScoreBJ<dealerScoreBJ && dealerScoreBJ<=21)
				{
					endOfGameBJ(false,false);
				}
			}

		}
		else if(playerScoreBJ==21)
		{
			System.out.println("N");
			endOfGameBJ(true,false);
		}
		if(playerScoreBJ==dealerScoreBJ)
		{
			System.out.println("O");
			endOfGameBJ(false,true);
		}
	}

	/**
	 * Cette méthode va déclarer un gagnant et mettre à
	 * disable tous les boutons de jeu
	 * @param win Si il y a un gagnant
	 * @param draw Si il n'y a ni un gagnant ni une personne qui a perdu
	 */
	public void endOfGameBJ(boolean win, boolean draw)
	{
		buttHitBJ.setDisable(true);
		buttStandBJ.setDisable(true);
		buttDealBJ.setDisable(false);
		buttBetBJ.setDisable(false);
		fieldBetBJ.setDisable(false);
		if(win&&draw==false)
		{
			totalMoneyBJ = totalMoneyBJ + betBJ;
			labelWinBJ.setText(Integer.toString(winBJ +1));
			labelMsgBJ.setText("Player Wins");
			System.out.println("Player Wins");
		}
		else if(win==false&&draw==false)
		{
			totalMoneyBJ = totalMoneyBJ - betBJ;
			labelLossBJ.setText(Integer.toString(lossBJ +1));
			labelMsgBJ.setText("Dealer Wins");
			System.out.println("Dealer Wins");
		}
		else if(win==false&&draw==true)
		{
			System.out.println("Draw");
		}
		labelTotalMonetBJ.setText(Integer.toString(totalMoneyBJ));
		if(totalMoneyBJ<=0)
		{
			buttDealBJ.setDisable(true);
			buttBetBJ.setDisable(true);
			fieldBetBJ.setDisable(true);
			labelMsgBJ.setText("You have no money, game over!");
		}
		numTurnsBJ=1;
	}

	/**
	 * Cette méthode met tous les images à null pendant la distribution
	 * @param event
	 */
	@FXML
	public void handleDealBJ(ActionEvent event) 
	{
		viewPlayer1.setImage(null);
		viewPlayer2.setImage(null);
		viewPlayer3.setImage(null);
		viewPlayer4.setImage(null);
		viewPlayer5.setImage(null);
		viewDealer1.setImage(null);
		viewDealer2.setImage(null);
		viewDealer3.setImage(null);
		viewDealer4.setImage(null);
		viewDealer5.setImage(null);
		labelMsgBJ.setText("Dealing");
		dealBJ();
		labelMsgBJ.setText("Play");
	}

	/**
	 * Cette méthode va rendre un demi du pari de l'usager au premier tour seulement
	 * @param event
	 */
	@FXML
	public void handleSurrender(ActionEvent event) 
	{
		labelMsgBJ.setText("Surrender, Half of bet returned");
		int fh = (int) (totalMoneyBJ-0.5*betBJ);
		labelTotalMonetBJ.setText(Integer.toString(fh));
		buttHitBJ.setDisable(true);
		buttStandBJ.setDisable(true);
		//make deal button clickable
	}

	/**
	 * Cette méthode va prendre le pari du TextField et le mettre dans un variable et le
	 * label
	 * @param event
	 */
	@FXML
	public void handleBetBJ(ActionEvent event) 
	{
		betBJ = Integer.parseInt(fieldBetBJ.getText());
		labelBetBJ.setText(Integer.toString(betBJ));
		fieldBetBJ.setDisable(true);
		buttDealBJ.setDisable(false);
		buttBetBJ.setDisable(true);
	}

	/**
	 * Cette méthode va donner la valeur du carte dans le système de blackjack
	 * @param a La valeur en String
	 * @return La valeur dans le système de blackjack
	 */
	public int getBlackJackValue(String a)
	{
		switch (a) {
		case "Ace":   return 1;
		case "2":   return 2;
		case "3":   return 3;
		case "4":   return 4;
		case "5":   return 5;
		case "6":   return 6;
		case "7":   return 7;
		case "8":   return 8;
		case "9":   return 9;
		case "10":  return 10;
		case "Jack":  return 10;
		case "Queen":  return 10;
		case "King":  return 10;
		}
		return 0;

	}

	/**
	 * Cette méthode va ouvrir une fênetre d'instructions
	 * @param event
	 */
	@FXML
	public void handleInstructionsBJ(ActionEvent event) 
	{
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Info-flash");
		alert.setTitle("INSTRUCTIONS");
		alert.setContentText("Go to: https://www.bicyclecards.com/how-to-play/blackjack/");
		alert.show();
	}

	/**
	 * Cette méthode va ouvrir une fênetre à propos
	 * @param event
	 */
	@FXML
	public void handleAboutBJ(ActionEvent event) 
	{
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Info-flash");
		alert.setTitle("ABOUT");
		alert.setContentText("This game was created as the culminating project of grade 11 computer science.");
		alert.show();
	}

	/* ============================
	 * BlackJack End
	 * ============================
	 * HighLow Start
	 * ============================
	 */

	@FXML
	private Label labelBetHL;

	@FXML
	private Label labelWinHL;

	@FXML
	private Label labelLossHL;

	@FXML
	private Label labelTotalMonetHL;

	@FXML
	private Label labelMSGHL;

	@FXML
	private TextField fieldBetHL;

	@FXML
	private Button highHL;

	@FXML
	private Button lowHL;

	@FXML
	private Button dealHL;

	@FXML
	private Button buttBetHL;

	@FXML
	private ImageView viewFirstHL;

	@FXML
	private ImageView viewSecondHL;

	Deck deckHL = new Deck();

	Card cardOne, cardTwo;

	int betHL = 0, totalMoneyHL=2500, winHL, lossHL;
	
	/**
	 * Cette méthode va comparer les valeurs des cartes et le choix de l'usager
	 * pour déterminer si l'usager est correct
	 * @param a le bouton cliqué
	 */
	@FXML
	public void handleHL(ActionEvent a)
	{
		setCardToImage(cardTwo, viewSecondHL);
		Button sourceButton = (Button) a.getSource();
		boolean firstHigher=false;
		boolean draw=false;
		if(cardOne.getValue()>cardTwo.getValue())
		{
			firstHigher=true;
			draw=false;
		}
		else if(cardOne.getValue()==cardTwo.getValue())
		{
			firstHigher=false;
			draw=true;
		}
		else if(cardOne.getValue()<cardTwo.getValue())
		{
			firstHigher=false;
			draw=false;
		}
		if(sourceButton==highHL)
		{
			if(firstHigher==true)
			{
				labelMSGHL.setText("You lose");
				highHL.setDisable(true);
				lowHL.setDisable(true);
			}
			else if(firstHigher==false)
			{
				labelMSGHL.setText("You win");
				highHL.setDisable(true);
				lowHL.setDisable(true);
			}
		}
		else if(sourceButton==lowHL)
		{
			if(firstHigher==true)
			{
				labelMSGHL.setText("You win");
				highHL.setDisable(true);
				lowHL.setDisable(true);
			}
			else if(firstHigher==false)
			{
				labelMSGHL.setText("You lose");
				highHL.setDisable(true);
				lowHL.setDisable(true);
			}
		}
	}

	/**
	 * Cette méthode va distribuer deux cartes pour l'usager
	 */
	@FXML
	public void dealHL()
	{
		highHL.setDisable(false);
		lowHL.setDisable(false);
		labelMSGHL.setText("Please choose");
		Image backImage = new Image("file:resources/images/Red_back.jpg");
		viewSecondHL.setImage(backImage);
		if(deckHL.cardsLeft()<2)
		{
			deckHL.shuffle();
		}
		cardOne=deckHL.dealCard();
		cardTwo=deckHL.dealCard();
		setCardToImage(cardOne, viewFirstHL);
	}

	/**
	 * Cette méthode va ouvrir une fênetre d'instructions
	 * @param event
	 */
	@FXML
	public void handleInstructionsHL()
	{
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Info-flash");
		alert.setTitle("INSTRUCTIONS");
		alert.setContentText("Guess if the next card is going to be higher or lower in value regardless of suit.");
		alert.show();
	}

	/**
	 * Cette méthode va prendre le pari du TextField et le mettre dans un variable et le label
	 */
	@FXML
	public void handleBetHL()
	{
		buttBetHL.setDisable(true);
		betHL=Integer.parseInt(fieldBetHL.getText());
		labelBetHL.setText(Integer.toString(betHL));
		dealHL.setDisable(false);

	}

	/**
	 * Cette méthode va ouvrir une fênetre à propos
	 * @param event
	 */
	@FXML
	public void handleAboutHL()
	{
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Info-flash");
		alert.setTitle("ABOUT");
		alert.setContentText("This game was created as the culminating project of grade 11 computer science.");
		alert.show();
	}

	/* ============================
	 * HighLow End
	 * ============================
	 * Euchre Start
	 * ============================
	 */

	@FXML
	private Label labelBetE;

	@FXML
	private Label labelGamesWonE;

	@FXML
	private Label labelGamesLostE;

	@FXML
	private Label labelTotalMoneyE;

	@FXML
	private Label labelTricksWonE;

	@FXML
	private Label labelTricksLostE;

	@FXML
	private Label labelMSGE;

	@FXML
	private Button chooseSpadesE;

	@FXML
	private Button chooseDiaE;

	@FXML
	private Button chooseHeartsE;

	@FXML
	private Button chooseClubsE;

	@FXML
	private Button choosePassE;

	@FXML
	private Button instructionsE;

	@FXML
	private Button dealE;

	@FXML
	private Button aboutE;

	@FXML
	private Button submitBetE;

	@FXML
	private TextField fieldBetE;

	@FXML
	private RadioButton goAloneE;

	@FXML
	private ImageView centreCard1E;

	@FXML
	private ImageView centreCard2E;

	@FXML
	private ImageView centreCard3E;

	@FXML
	private ImageView centreCard4E;

	@FXML
	private ImageView playerCard1E;

	@FXML
	private ImageView playerCard2E;

	@FXML
	private ImageView playerCard3E;

	@FXML
	private ImageView playerCard4E;

	@FXML
	private ImageView playerCard5E;

	Hand playerHandE = new Hand(); 
	Hand op1HandE= new Hand();
	Hand op2HandE= new Hand();
	Hand op3HandE= new Hand(); 
	Hand kittyE= new Hand();

	Deck euchreDeck = new Deck();

	String trumpSuit="", suitToFollow="";

	Card bidTrumpE;

	boolean secondRoundBid = false, discardNeeded = false;;
	int gamesWonE=0, gamesLostE=0, tricksWonE=0, tricksLostE=0, numTricksE=0, totalMoneyE =2500, betE, roundNumE=1;
	String dealerE = "";
	String leftSuit= new String();
	
	/**
	 * Cette méthode va distribuer cinq cartes à chaque jouer et quatres cartes au Kitty
	 */
	public void dealCardsE()
	{
		chooseSpadesE.setDisable(false);
		chooseDiaE.setDisable(false);
		chooseHeartsE.setDisable(false);
		chooseClubsE.setDisable(false);
		choosePassE.setDisable(false);
		euchreDeck.shuffle();
		labelTricksWonE.setText("0");
		labelTricksLostE.setText("0");
		int a=0;
		Card tempCardE;
		while(a<5)
		{
			tempCardE=euchreDeck.dealCard();
			if(tempCardE.getValue()>=9 || tempCardE.getValue()==1)
			{
				playerHandE.addCard(tempCardE);
				a++;
			}
		}
		a=0;
		while(a<5)
		{
			tempCardE=euchreDeck.dealCard();
			if(tempCardE.getValue()>=9 || tempCardE.getValue()==1)
			{
				a++;
				op1HandE.addCard(tempCardE);
			}
		}
		a=0;
		while(a<5)
		{
			tempCardE=euchreDeck.dealCard();
			if(tempCardE.getValue()>=9 || tempCardE.getValue()==1)
			{
				a++;
				op2HandE.addCard(tempCardE);
			}
		}
		a=0;
		while(a<5)
		{
			tempCardE=euchreDeck.dealCard();
			if(tempCardE.getValue()>=9|| tempCardE.getValue()==1)
			{
				a++;
				op3HandE.addCard(tempCardE);
			}
		}
		a=0;
		while(a<4)
		{
			tempCardE=euchreDeck.dealCard();
			if(tempCardE.getValue()>8 || tempCardE.getValue()==1)
			{
				a++;
				kittyE.addCard(tempCardE);
			}
		}
		printHandCards();
		bidTrumpE=kittyE.getCard(0);
		System.out.println(bidTrumpE);
		if(roundNumE==1||roundNumE==5||roundNumE==9||roundNumE==13||roundNumE==17)
		{
			dealerE="Player";
			bidRoundOneE();
		}
		else if(roundNumE==2||roundNumE==6||roundNumE==10||roundNumE==14||roundNumE==18)
		{
			dealerE="Op1";
			bidRoundOneE();
		}
		else if(roundNumE==3||roundNumE==7||roundNumE==11||roundNumE==15||roundNumE==19)
		{
			dealerE="Op2";
			bidRoundOneE();
		}
		else if(roundNumE==4||roundNumE==8||roundNumE==12||roundNumE==16||roundNumE==20)
		{
			dealerE="Op3";
			bidRoundOneE();
		}
		roundNumE++;
		setCardToImage(playerHandE.getCard(0), playerCard1E);
		setCardToImage(playerHandE.getCard(1), playerCard2E);
		setCardToImage(playerHandE.getCard(2), playerCard3E);
		setCardToImage(playerHandE.getCard(3), playerCard4E);
		setCardToImage(playerHandE.getCard(4), playerCard5E);
		Image redCard=new Image("file:resources/images/Red_back.jpg");
		centreCard1E.setImage(redCard);
		centreCard2E.setImage(redCard);
		centreCard3E.setImage(redCard);
		centreCard4E.setImage(redCard);
		if(dealerE.equals("Player"))
		{
			setCardToImage(bidTrumpE, centreCard4E);
		}
		else if(dealerE.equals("Op1"))
		{
			setCardToImage(bidTrumpE, centreCard1E);
		}
		else if(dealerE.equals("Op2"))
		{
			setCardToImage(bidTrumpE, centreCard2E);
		}
		else if(dealerE.equals("Op3"))
		{
			setCardToImage(bidTrumpE, centreCard3E);
		}
	}
	//TODO WORKS BUT NEED TO TEST OUT DEALER CHANGES
	/*
	 * THIS IS BIDDING
	 */
	/**
	 * Cette méthode va mettre les boutons de bidding à disabled
	 */
	public void stopBidding()
	{
		chooseSpadesE.setDisable(true);
		chooseDiaE.setDisable(true);
		chooseHeartsE.setDisable(true);
		chooseClubsE.setDisable(true);
		choosePassE.setDisable(true);
	}

	/**
	 * Cette méthode contrôle le bidding avant que l'usager fait son choix de trump
	 */
	public void bidRoundOneE()
	{
		labelMSGE.setText("Do you want this to be trump?");
		if(dealerE.equals("Player"))
		{
			if(bidTrumpE.getSuitAsString().equals("Hearts"))
			{
				if(checkBidE(bidTrumpE, op1HandE)==true)
				{
					trumpSuit.equals("Hearts");
					System.out.println("op1 h");
					discardNeeded=true;
					stopBidding();
				}
				else if(checkBidE(bidTrumpE, op2HandE)==true)
				{
					trumpSuit.equals("Hearts");
					System.out.println("op2 h");
					discardNeeded=true;
					stopBidding();
				}
				else if(checkBidE(bidTrumpE, op3HandE)==true)
				{
					trumpSuit.equals("Hearts");
					System.out.println("op3 h");
					discardNeeded=true;
					stopBidding();
				}
			}
			else if(bidTrumpE.getSuitAsString().equals("Diamonds"))
			{
				if(checkBidE(bidTrumpE, op1HandE)==true)
				{
					trumpSuit.equals("Diamonds");
					System.out.println("op1 d");
					discardNeeded=true;
					stopBidding();
				}
				else if(checkBidE(bidTrumpE, op2HandE)==true)
				{
					trumpSuit.equals("Diamonds");
					System.out.println("op2 d");
					discardNeeded=true;
					stopBidding();
				}
				else if(checkBidE(bidTrumpE, op3HandE)==true)
				{
					trumpSuit.equals("Diamonds");
					System.out.println("op3 d");
					discardNeeded=true;
					stopBidding();
				}
			}
			else if(bidTrumpE.getSuitAsString().equals("Clubs"))
			{
				if(checkBidE(bidTrumpE, op1HandE)==true)
				{
					trumpSuit.equals("Clubs");
					System.out.println("op1 c");
					discardNeeded=true;
					stopBidding();
				}
				else if(checkBidE(bidTrumpE, op2HandE)==true)
				{
					trumpSuit.equals("Clubs");
					System.out.println("op2 c");
					discardNeeded=true;
					stopBidding();
				}
				else if(checkBidE(bidTrumpE, op3HandE)==true)
				{
					trumpSuit.equals("Clubs");
					System.out.println("op3 c");
					discardNeeded=true;
					stopBidding();
				}
			}
			else if(bidTrumpE.getSuitAsString().equals("Spades"))
			{
				if(checkBidE(bidTrumpE, op1HandE)==true)
				{
					trumpSuit.equals("Spades");
					System.out.println("op1 s");
					discardNeeded=true;
					stopBidding();
				}
				else if(checkBidE(bidTrumpE, op2HandE)==true)
				{
					trumpSuit.equals("Spades");
					System.out.println("op2 s");
					discardNeeded=true;
					stopBidding();
				}
				else if(checkBidE(bidTrumpE, op3HandE)==true)
				{
					trumpSuit.equals("Spades");
					System.out.println("op3 s");
					discardNeeded=true;
					stopBidding();
				}
			}
		}
		else if(dealerE.equals("Op2"))
		{
			if(bidTrumpE.getSuitAsString().equals("Hearts"))
			{
				if(checkBidE(bidTrumpE, op2HandE)==true)
				{
					trumpSuit.equals("Hearts");
					System.out.println("op2 h");
					discardNeeded=true;
					stopBidding();
				}
				else if(checkBidE(bidTrumpE, op3HandE)==true)
				{
					trumpSuit.equals("Hearts");
					System.out.println("op3 h");
					discardNeeded=true;
					stopBidding();
				}
			}
			else if(bidTrumpE.getSuitAsString().equals("Diamonds"))
			{
				if(checkBidE(bidTrumpE, op2HandE)==true)
				{
					trumpSuit.equals("Diamonds");
					System.out.println("op2 d");
					discardNeeded=true;
					stopBidding();
				}
				else if(checkBidE(bidTrumpE, op3HandE)==true)
				{
					//////
					trumpSuit.equals("Diamonds");
					System.out.println("op3 d");
					discardNeeded=true;
					stopBidding();
				}
			}
			else if(bidTrumpE.getSuitAsString().equals("Clubs"))
			{
				if(checkBidE(bidTrumpE, op2HandE)==true)
				{
					trumpSuit.equals("Clubs");
					System.out.println("op2 c");
					discardNeeded=true;
					stopBidding();
				}
				else if(checkBidE(bidTrumpE, op3HandE)==true)
				{
					trumpSuit.equals("Clubs");
					System.out.println("op3 c");
					discardNeeded=true;
					stopBidding();
				}
			}
			else if(bidTrumpE.getSuitAsString().equals("Spades"))
			{
				if(checkBidE(bidTrumpE, op2HandE)==true)
				{
					trumpSuit.equals("Spades");
					System.out.println("op2 s");
					discardNeeded=true;
					stopBidding();
				}
				else if(checkBidE(bidTrumpE, op3HandE)==true)
				{
					trumpSuit.equals("Spades");
					System.out.println("op3 s");
					discardNeeded=true;
					stopBidding();
				}
			}
		}
		else if(dealerE.equals("Op3"))
		{
			if(bidTrumpE.getSuitAsString().equals("Hearts"))
			{
				if(checkBidE(bidTrumpE, op3HandE)==true)
				{
					trumpSuit.equals("Hearts");
					System.out.println("op3 h");
					discardNeeded=true;
					stopBidding();
				}
			}
			else if(bidTrumpE.getSuitAsString().equals("Diamonds"))
			{
				if(checkBidE(bidTrumpE, op3HandE)==true)
				{
					trumpSuit.equals("Diamonds");
					System.out.println("op3 d");
					discardNeeded=true;
					stopBidding();
				}
			}
			else if(bidTrumpE.getSuitAsString().equals("Clubs"))
			{
				if(checkBidE(bidTrumpE, op3HandE)==true)
				{
					trumpSuit.equals("Clubs");
					System.out.println("op3 c");
					discardNeeded=true;
					stopBidding();
				}
			}
			else if(bidTrumpE.getSuitAsString().equals("Spades"))
			{
				if(checkBidE(bidTrumpE, op3HandE)==true)
				{
					trumpSuit.equals("Spades");
					System.out.println("op3 s");
					discardNeeded=true;
					stopBidding();
				}
			}
		}
		else if(dealerE.equals("Op4"))
		{
			//all bid in other method
		}
		if(!dealerE.equals("Player")&&!trumpSuit.equals(""))
		{
			//add for dealer is not player
		}
		if(bidTrumpE.getSuitAsString().equals("Spades"))
		{
			chooseDiaE.setDisable(true);
			chooseHeartsE.setDisable(true);
			chooseClubsE.setDisable(true);
		}
		else if(bidTrumpE.getSuitAsString().equals("Clubs"))
		{
			chooseSpadesE.setDisable(true);
			chooseDiaE.setDisable(true);
			chooseHeartsE.setDisable(true);
		}
		else if(bidTrumpE.getSuitAsString().equals("Diamonds"))
		{
			chooseSpadesE.setDisable(true);
			chooseHeartsE.setDisable(true);
			chooseClubsE.setDisable(true);
		}
		else if(bidTrumpE.getSuitAsString().equals("Hearts"))
		{
			chooseSpadesE.setDisable(true);
			chooseDiaE.setDisable(true);
			chooseClubsE.setDisable(true);
		}
		System.out.println(discardNeeded);
		if(discardNeeded==true)
		{
			labelMSGE.setText("Choose a card to discard");
		}
	}

	/**
	 * Cette méthode contrôle le bidding après que l'usager fait son choix de trump
	 * et le premier partie du deuxième rond de bidding
	 * @param selectedButt bouton sélectionné
	 */
	public void handlePlayerBidE(Button selectedButt)
	{
		labelMSGE.setText("Choose any suit for trump");
		chooseSpadesE.setDisable(false);
		chooseDiaE.setDisable(false);
		chooseHeartsE.setDisable(false);
		chooseClubsE.setDisable(false);
		choosePassE.setDisable(true);
		if(selectedButt==chooseDiaE)
		{
			trumpSuit="Diamonds";
			System.out.println("p d");
			discardNeeded=true;
			stopBidding();
		}
		else if(selectedButt==chooseSpadesE)
		{
			trumpSuit="Spades";
			System.out.println("p s");
			discardNeeded=true;
			stopBidding();
		}
		else if(selectedButt==chooseHeartsE)
		{
			trumpSuit="Hearts";
			System.out.println("p h");
			discardNeeded=true;
			stopBidding();
		}
		else if(selectedButt==chooseClubsE)
		{
			trumpSuit="Clubs";
			System.out.println("p c");
			discardNeeded=true;
			stopBidding();
		}
		else if(selectedButt==choosePassE)
		{
			if(dealerE.equals("Player"))
			{

			}
			else if(dealerE.equals("Op1"))
			{
				if(bidTrumpE.getSuitAsString().equals("Hearts"))
				{
					if(checkBidE(bidTrumpE, op3HandE)==true)
					{
						trumpSuit.equals("Hearts");
						discardNeeded=true;
					}
				}
				else if(bidTrumpE.getSuitAsString().equals("Diamonds"))
				{
					if(checkBidE(bidTrumpE, op3HandE)==true)
					{
						trumpSuit.equals("Diamonds");
						discardNeeded=true;
					}
				}
				else if(bidTrumpE.getSuitAsString().equals("Clubs"))
				{
					if(checkBidE(bidTrumpE, op3HandE)==true)
					{
						trumpSuit.equals("Clubs");
						discardNeeded=true;
					}
				}
				else if(bidTrumpE.getSuitAsString().equals("Spades"))
				{
					if(checkBidE(bidTrumpE, op3HandE)==true)
					{
						trumpSuit.equals("Spades");
						discardNeeded=true;
					}
				}
				stopBidding();
			}
			else if(dealerE.equals("Op2"))
			{
				if(bidTrumpE.getSuitAsString().equals("Hearts"))
				{
					if(checkBidE(bidTrumpE, op2HandE)==true)
					{
						trumpSuit.equals("Hearts");
						discardNeeded=true;
					}
					else if(checkBidE(bidTrumpE, op3HandE)==true)
					{
						trumpSuit.equals("Hearts");
						discardNeeded=true;
					}
				}
				else if(bidTrumpE.getSuitAsString().equals("Diamonds"))
				{
					if(checkBidE(bidTrumpE, op2HandE)==true)
					{
						trumpSuit.equals("Diamonds");
						discardNeeded=true;
					}
					else if(checkBidE(bidTrumpE, op3HandE)==true)
					{
						trumpSuit.equals("Diamonds");
						discardNeeded=true;
					}
				}
				else if(bidTrumpE.getSuitAsString().equals("Clubs"))
				{
					if(checkBidE(bidTrumpE, op2HandE)==true)
					{
						trumpSuit.equals("Clubs");
						discardNeeded=true;
					}
					else if(checkBidE(bidTrumpE, op3HandE)==true)
					{
						trumpSuit.equals("Clubs");
						discardNeeded=true;
					}
				}
				else if(bidTrumpE.getSuitAsString().equals("Spades"))
				{
					if(checkBidE(bidTrumpE, op2HandE)==true)
					{
						trumpSuit.equals("Spades");
						discardNeeded=true;
					}
					else if(checkBidE(bidTrumpE, op3HandE)==true)
					{
						trumpSuit.equals("Spades");
						discardNeeded=true;
					}
				}
				stopBidding();
			}
			else if(dealerE.equals("Op3"))
			{
				if(bidTrumpE.getSuitAsString().equals("Hearts"))
				{
					if(checkBidE(bidTrumpE, op1HandE)==true)
					{
						trumpSuit.equals("Hearts");
						discardNeeded=true;
					}
					else if(checkBidE(bidTrumpE, op2HandE)==true)
					{
						trumpSuit.equals("Hearts");
						discardNeeded=true;
					}
					else if(checkBidE(bidTrumpE, op3HandE)==true)
					{
						trumpSuit.equals("Hearts");
						discardNeeded=true;
					}
				}
				else if(bidTrumpE.getSuitAsString().equals("Diamonds"))
				{
					if(checkBidE(bidTrumpE, op1HandE)==true)
					{
						trumpSuit.equals("Diamonds");
						discardNeeded=true;
					}
					else if(checkBidE(bidTrumpE, op2HandE)==true)
					{
						trumpSuit.equals("Diamonds");
						discardNeeded=true;
					}
					else if(checkBidE(bidTrumpE, op3HandE)==true)
					{
						trumpSuit.equals("Diamonds");
						discardNeeded=true;
					}
				}
				else if(bidTrumpE.getSuitAsString().equals("Clubs"))
				{
					if(checkBidE(bidTrumpE, op1HandE)==true)
					{
						trumpSuit.equals("Clubs");
						discardNeeded=true;
					}
					else if(checkBidE(bidTrumpE, op2HandE)==true)
					{
						trumpSuit.equals("Clubs");
						discardNeeded=true;
					}
					else if(checkBidE(bidTrumpE, op3HandE)==true)
					{
						trumpSuit.equals("Clubs");
						discardNeeded=true;
					}
				}
				else if(bidTrumpE.getSuitAsString().equals("Spades"))
				{
					if(checkBidE(bidTrumpE, op1HandE)==true)
					{
						trumpSuit.equals("Spades");
						discardNeeded=true;
					}
					else if(checkBidE(bidTrumpE, op2HandE)==true)
					{
						trumpSuit.equals("Spades");
						discardNeeded=true;
					}
					else if(checkBidE(bidTrumpE, op3HandE)==true)
					{
						trumpSuit.equals("Spades");
						discardNeeded=true;
					}

				}
				stopBidding();
			}
			if(trumpSuit.equals(""))
			{
				Image redCard=new Image("file:resources/images/Red_back.jpg");
				centreCard1E.setImage(redCard);
				centreCard2E.setImage(redCard);
				centreCard3E.setImage(redCard);
				centreCard4E.setImage(redCard);
				System.out.println('a');
				secondRoundBid=true;
				if(dealerE.equals("Player"))
				{
					for(int i=0;i<4;i++)
					{
						if(checkBidWithSuitE(suitsE.get(i),op1HandE)==true)
						{
							trumpSuit.equals(suitsE.get(i));
							break;
						}
					}
					for(int i=0;i<4;i++)
					{
						if(checkBidWithSuitE(suitsE.get(i),op2HandE)==true)
						{
							trumpSuit.equals(suitsE.get(i));
							break;
						}
					}
					for(int i=0;i<4;i++)
					{
						if(checkBidWithSuitE(suitsE.get(i),op3HandE)==true)
						{
							trumpSuit.equals(suitsE.get(i));
							break;
						}
					}
				}
				else if(dealerE.equals("Op1"))
				{
					for(int i=0;i<4;i++)
					{
						if(checkBidWithSuitE(suitsE.get(i),op2HandE)==true)
						{
							trumpSuit.equals(suitsE.get(i));
							break;
						}
					}
					for(int i=0;i<4;i++)
					{
						if(checkBidWithSuitE(suitsE.get(i),op3HandE)==true)
						{
							trumpSuit.equals(suitsE.get(i));
							break;
						}
					}
				}
				else if(dealerE.equals("Op2"))
				{
					for(int i=0;i<4;i++)
					{
						if(checkBidWithSuitE(suitsE.get(i),op3HandE)==true)
						{
							trumpSuit.equals(suitsE.get(i));
							break;
						}
					}
				}
				else if(dealerE.equals("Op3"))
				{
					//with other method
				}
			}
		}
		if(discardNeeded==true)
		{
			labelMSGE.setText("Please choose a card to discard");
		}
		System.out.println(discardNeeded+"r'");
		System.out.println("Trump first round" + trumpSuit);
	}

	/**
	 * Cette méthode contrôle le bidding après que l'usager fait son choix dans le deuxième rond
	 * @param selectedButt bouton sélectionné
	 */
	public void secondRoundBidE(Button selectedButt )
	{
		choosePassE.setDisable(true);
		Image redCard=new Image("file:resources/images/Red_back.jpg");
		centreCard1E.setImage(redCard);
		centreCard2E.setImage(redCard);
		centreCard3E.setImage(redCard);
		centreCard4E.setImage(redCard);
		if(selectedButt==chooseDiaE)
		{
			trumpSuit="Diamonds";
			System.out.println("p d");
			stopBidding();
		}
		else if(selectedButt==chooseSpadesE)
		{
			trumpSuit="Spades";
			System.out.println("p s");
			stopBidding();
		}
		else if(selectedButt==chooseHeartsE)
		{
			trumpSuit="Hearts";
			System.out.println("p h");
			stopBidding();
		}
		else if(selectedButt==chooseClubsE)
		{
			trumpSuit="Clubs";
			System.out.println("p c");
			stopBidding();
		}
		if(dealerE.equals("Player"))
		{

		}
		else if(dealerE.equals("Op1"))
		{
			for(int i=0;i<4;i++)
			{
				if(checkBidWithSuitE(suitsE.get(i),op1HandE)==true)
				{
					trumpSuit.equals(suitsE.get(i));
					stopBidding();
					break;
				}
			}

		}
		else if(dealerE.equals("Op2"))
		{
			for(int i=0;i<4;i++)
			{
				if(checkBidWithSuitE(suitsE.get(i),op1HandE)==true)
				{
					trumpSuit.equals(suitsE.get(i));
					stopBidding();
					break;
				}
			}
			for(int i=0;i<4;i++)
			{
				if(checkBidWithSuitE(suitsE.get(i),op2HandE)==true)
				{
					trumpSuit.equals(suitsE.get(i));
					stopBidding();
					break;
				}
			}
		}
		else if(dealerE.equals("Op3"))
		{
			for(int i=0;i<4;i++)
			{
				if(checkBidWithSuitE(suitsE.get(i),op1HandE)==true)
				{
					trumpSuit.equals(suitsE.get(i));
					stopBidding();
					break;
				}
			}
			for(int i=0;i<4;i++)
			{
				if(checkBidWithSuitE(suitsE.get(i),op2HandE)==true)
				{
					trumpSuit.equals(suitsE.get(i));
					stopBidding();
					break;

				}
			}
			for(int i=0;i<4;i++)
			{
				if(checkBidWithSuitE(suitsE.get(i),op3HandE)==true)
				{
					trumpSuit.equals(suitsE.get(i));
					stopBidding();
					break;
				}
			}
		}
		if(trumpSuit.equals(""))
		{
			System.out.println("b");
			if(dealerE.equals("Player"))
			{
				//TODO add a choice
				//trumpSuit=playerHandE.getCard(0).getSuitAsString();
				stopBidding();
			}
			else if(dealerE.equals("Op1"))
			{
				trumpSuit=op1HandE.getCard(0).getSuitAsString();
				stopBidding();
			}
			else if(dealerE.equals("Op2"))
			{
				trumpSuit=op2HandE.getCard(0).getSuitAsString();
				stopBidding();
			}
			else if(dealerE.equals("Op3"))
			{
				trumpSuit=op3HandE.getCard(0).getSuitAsString();
				stopBidding();
			}
		}
		System.out.println("Trump second round" + trumpSuit);
		playEuchreFirstPart();
		if(trumpSuit.equals("Spades"))
		{
			leftSuit="Clubs";
		}
		else if(trumpSuit.equals("Clubs"))
		{
			leftSuit="Spades";
		}
		else if(trumpSuit.equals("Hearts"))
		{
			leftSuit="Diamonds";
		}
		else if(trumpSuit.equals("Diamonds"))
		{
			leftSuit="Hearts";
		}
		labelMSGE.setText("Trump suit is "+trumpSuit);
	}

	/**
	 * Cette méthode va diriger quel méthode est appelé selon s'il y a le besoin d'un
	 * deuxième rond de bidding
	 * @param e bouton sélectionné
	 */
	public void checkTurnForSelectionOfCard(ActionEvent e)
	{
		Button selectedButt = (Button) e.getSource();
		if(secondRoundBid==false)
		{
			handlePlayerBidE(selectedButt);
		}
		else if(secondRoundBid==true)
		{
			
			secondRoundBidE(selectedButt);
			
		}
	}
	/*
	 * THIS IS THE END OF BIDDING
	 */
	/*
	 * THIS IS DISCARDING
	 */

	/**
	 * Cettre méthode diriger le jetage d'une carte par l'usager
	 * @param view Carte sélectionné pour être jeter selon son Image view
	 * @param cardAdded Carte qui sera ajouté
	 */
	public void discardCardPlayer(ImageView view, Card cardAdded)
	{
		Card toBeDiscarded = playerHandE.getCard(0);
		if(view==playerCard1E)
		{
			toBeDiscarded=playerHandE.getCard(0);
		}
		else if(view==playerCard2E)
		{
			toBeDiscarded=playerHandE.getCard(1);
		}
		else if(view==playerCard3E)
		{
			toBeDiscarded=playerHandE.getCard(2);
		}
		else if(view==playerCard4E)
		{
			toBeDiscarded=playerHandE.getCard(3);
		}
		else if(view==playerCard5E)
		{
			toBeDiscarded=playerHandE.getCard(4);
		}
		playerHandE.removeCard(toBeDiscarded);
		playerHandE.addCard(cardAdded);
		setCardToImage(playerHandE.getCard(0), playerCard1E);
		setCardToImage(playerHandE.getCard(1), playerCard2E);
		setCardToImage(playerHandE.getCard(2), playerCard3E);
		setCardToImage(playerHandE.getCard(3), playerCard4E);
		setCardToImage(playerHandE.getCard(4), playerCard5E);
		System.out.println("New with discarded card");
		printHandCards();
		discardNeeded=false;
		playEuchreFirstPart();
	}

	/**
	 * Cettre méthode diriger le jetage d'une carte par les ordinateurs
	 * @param hand main de l'ordinateur
	 * @param cardAdded Carte qui sera ajouté
	 */
	public void discardCardComp(Hand hand, Card cardAdded)
	{
		int lowest = 0, lowestIndex=0;
		for(int i=0;i<5;i++)
		{
			Card selectedCard = hand.getCard(i);
			lowest=selectedCard.getValue();
			if(i==0)
			{
				lowest=selectedCard.getValue();
				lowestIndex=0;
			}
			else if(i!=0)
			{
				if(!selectedCard.getSuitAsString().equals(cardAdded.getSuitAsString()))
				{
					if(lowest>selectedCard.getValue())
					{
						lowest=selectedCard.getValue();
						lowestIndex=i;
					}
				}
			}
		}
		hand.removeCard(lowestIndex);
		hand.addCard(cardAdded);
		discardNeeded=false;
		System.out.println("New with discarded card");
		printHandCards();
	}

	/**
	 * Cette méthode appelle un autre selon la carte dans le view
	 */
	public void view1()
	{
		handleCardClicked(playerCard1E);
	}
	/**
	 * Cette méthode appelle un autre selon la carte dans le view
	 */
	public void view2()
	{
		handleCardClicked(playerCard2E);
	}
	/**
	 * Cette méthode appelle un autre selon la carte dans le view
	 */
	public void view3()
	{
		handleCardClicked(playerCard3E);
	}
	/**
	 * Cette méthode appelle un autre selon la carte dans le view
	 */
	public void view4()
	{
		handleCardClicked(playerCard4E);
	}
	/**
	 * Cette méthode appelle un autre selon la carte dans le view
	 */
	public void view5()
	{
		handleCardClicked(playerCard5E);
	}

	/**
	 * Cette méthode diriger et appelles des autre s'il y a le
	 * besoin de jeter une carte
	 * @param clicked
	 */
	public void handleCardClicked(ImageView clicked)
	{
		labelMSGE.setText("Trump suit is "+trumpSuit);
		if(discardNeeded==false)
		{
			playEuchreSecondPart(clicked);
		}
		else if(discardNeeded==true)
		{
			System.out.println('a');
			if(dealerE.equals("Player"))
			{
				discardCardPlayer(clicked,bidTrumpE);
			}
			else if(dealerE.equals("Op1"))
			{
				discardCardComp(op1HandE, bidTrumpE);
			}
			else if(dealerE.equals("Op2"))
			{
				discardCardComp(op2HandE, bidTrumpE);
			}
			else if(dealerE.equals("Op3"))
			{
				discardCardComp(op3HandE, bidTrumpE);
			}
		}
	}

	/**
	 * Vérifier si un trump peut être sélectionné selon la couleur
	 * @param suit couleur qui sera vérifié
	 * @param hand main qui sera vérifié
	 * @return Si le main peut avoir le trump
	 */
	public boolean checkBidWithSuitE(String suit, Hand hand)
	{
		Card tempCardBid;
		int euchreValue, pointsTrump=0;
		boolean returnValue, containsBower=false;
		for(int i = 0; i<5;i++)
		{
			tempCardBid = hand.getCard(i);
			if(tempCardBid.getSuitAsString()==suit)
			{
				euchreValue = getEuchreValue(tempCardBid.getValue());
				//all the other ones
				if(euchreValue==9||euchreValue==10||euchreValue==12)
				{
					pointsTrump=pointsTrump+1;
				}
				//king
				else if(euchreValue==13)
				{
					pointsTrump=pointsTrump+2;
				}
				//ace
				else if(euchreValue==14)
				{
					pointsTrump=pointsTrump+3;
				}
				else if(euchreValue==11)
				{
					pointsTrump=pointsTrump+5;
					containsBower=true;
				}
			}
			//leftbower
			if(suit.equals("Diamonds")&&tempCardBid.getSuitAsString().equals("Hearts")||
					suit.equals("Hearts")&&tempCardBid.getSuitAsString().equals("Diamonds"))
			{
				if(getEuchreValue(tempCardBid.getValue())==11)
				{
					pointsTrump=pointsTrump+4;
					containsBower=true;
				}
			}
			else if(suit.equals("Clubs")&&tempCardBid.getSuitAsString().equals("Spades")||
					suit.equals("Spades")&&tempCardBid.getSuitAsString().equals("Clubs"))
			{
				if(getEuchreValue(tempCardBid.getValue())==11)
				{
					pointsTrump=pointsTrump+4;
					containsBower=true;
				}
			}
		}
		if(pointsTrump>=8 &&containsBower==true)
		{
			returnValue = true;
		}
		else
		{
			returnValue = false;
		}
		return returnValue;
	}


	/*
	 * THIS IS END OF DISCARDING
	 */
	/*
	 * THIS IS PLAYING
	 */

	String suitFollow="";
	Card player,op1, op2, op3;
	int largestCard;
	int tricksPlayed=0;
	
	/**
	 * Cette méthode dirige la permière partie du jeu avant le choix de l'usager
	 */
	public void playEuchreFirstPart()
	{
			Image redCard=new Image("file:resources/images/Red_back.jpg");
			centreCard1E.setImage(redCard);
			centreCard2E.setImage(redCard);
			centreCard3E.setImage(redCard);
			centreCard4E.setImage(redCard);
		
		if(dealerE.equals("Player"))
		{
			op1=placeCardE(op1HandE,"",0);
			suitFollow=op1.getSuitAsString();
			System.out.println(suitFollow);
			largestCard=op1.getValue();
			op2=placeCardE(op2HandE,suitFollow,largestCard);
			if(op2.getValue()>largestCard)
			{
				largestCard=op2.getValue();
			}
			op3=placeCardE(op3HandE, suitFollow,largestCard);
			if(op3.getValue()>largestCard)
			{
				largestCard=op3.getValue();
			}
			setCardToImage(op1, centreCard1E);
			setCardToImage(op2, centreCard2E);
			setCardToImage(op3, centreCard3E);
			System.out.println(op1);
			System.out.println(op2);
			System.out.println(op3);
		}
		else if(dealerE.equals("Op1"))
		{
			op2=placeCardE(op2HandE,"",0);
			suitFollow=op2.getSuitAsString();
			System.out.println(suitFollow);
			largestCard=op2.getValue();
			op3=placeCardE(op3HandE, suitFollow,largestCard);
			if(op3.getValue()>largestCard)
			{
				largestCard=op3.getValue();
			}	
			System.out.println(op2);
			System.out.println(op3);
			setCardToImage(op2, centreCard3E);
			setCardToImage(op3, centreCard3E);
		}
		else if(dealerE.equals("Op2"))
		{
			op3=placeCardE(op3HandE,"",0);
			suitFollow=op3.getSuitAsString();
			System.out.println(suitFollow);
			System.out.println(op3);
			setCardToImage(op3, centreCard3E);
		}
		else if(dealerE.equals("Op3"))
		{

		}
	}

	/**
	 * Cette méthode vérifie le gagnant
	 */
	public void checkEuchreWin()
	{
		//trumps
		//leftbower
		tricksPlayed++;
		Card winner = new Card();
		Card checkPlayer, checkOp1, checkOp2, checkOp3;
		System.out.println(player);
		System.out.println(op1);
		System.out.println(op2);
		System.out.println(op3);
		Hand hand = new Hand();
		hand.addCard(player);
		hand.addCard(op1);
		hand.addCard(op2);
		hand.addCard(op3);
		
		boolean hasTrumps=false;
		
		Hand trumpHand = new Hand();
		
		for(int i=0;i<4;i++)
		{
			Card tempCard = hand.getCard(i);
			if(tempCard.getSuitAsString().equals(trumpSuit)||tempCard.getValue()==11&&tempCard.getSuitAsString().equals(leftSuit))
			{
				hasTrumps=true;
				break;
			}
		}
		if(hasTrumps==true)
		{
			if(player.getSuitAsString().equals(trumpSuit)||player.getValue()==11&&player.getSuitAsString().equals(leftSuit))
			{
				checkPlayer=player;
				trumpHand.addCard(checkPlayer);
			}
			if(op1.getSuitAsString().equals(trumpSuit)||op1.getValue()==11&&op1.getSuitAsString().equals(leftSuit))
			{
				checkOp1=op1;
				trumpHand.addCard(checkOp1);
			}
			if(op2.getSuitAsString().equals(trumpSuit)||op2.getValue()==11&&op2.getSuitAsString().equals(leftSuit))
			{
				checkOp2=op1;
				trumpHand.addCard(checkOp2);
			}
			if(op3.getSuitAsString().equals(trumpSuit)||op3.getValue()==11&&op3.getSuitAsString().equals(leftSuit))
			{
				checkOp3=op3;
				trumpHand.addCard(checkOp3);
			}
			//22 is input for left bower
			for(int i=0;i<trumpHand.getCardCount();i++)
			{
				Card tempCard = trumpHand.getCard(i);
				if(i==0)
				{
					winner=tempCard;
				}
				else if(getEuchreTrumpValue(tempCard.getValue(), tempCard.getSuitAsString())>getEuchreTrumpValue(winner.getValue(), winner.getSuitAsString()))
				{
					winner=tempCard;
				}
			}
		}
		else if(hasTrumps==false)
		{
			for(int i=0;i<4;i++)
			{
				Card tempCard = hand.getCard(i);
				if(i==0)
				{
					winner=tempCard;
				}
				else if(getEuchreValue(tempCard.getValue())>getEuchreValue(winner.getValue()))
				{
					winner=tempCard;
				}
			}
		}
		System.out.println(winner);
		if(winner==player)
		{
			System.out.println("A");
			dealerE=("Op3");
			tricksWonE++;
		}
		else if(winner==op1)
		{
			System.out.println("B");
			dealerE=("Player");
			tricksLostE++;
		}
		else if(winner==op2)
		{
			System.out.println("C");
			dealerE=("Op1");
			tricksWonE++;
		}
		else if(winner==op3)
		{
			System.out.println("D");
			dealerE=("Op2");
			tricksLostE++;
		}
		labelTricksWonE.setText(Integer.toString(tricksWonE));
		labelTricksLostE.setText(Integer.toString(tricksLostE));
		if(player==playerHandE.getCard(0))
		{
			playerCard1E.setImage(null);
		}
		else if(player==playerHandE.getCard(1))
		{
			playerCard2E.setImage(null);
		}
		else if(player==playerHandE.getCard(2))
		{
			playerCard3E.setImage(null);
		}
		else if(player==playerHandE.getCard(3))
		{
			playerCard4E.setImage(null);
		}
		else if(player==playerHandE.getCard(4))
		{
			playerCard5E.setImage(null);
		}
		
		//playerHandE.removeCard(player);
		op1HandE.removeCard(op1);
		op2HandE.removeCard(op2);
		op3HandE.removeCard(op3);
		System.out.println("win"+tricksWonE +"loss"+tricksLostE);
		
		if(tricksPlayed!=5)
		{
			playEuchreFirstPart();
		}
		else if(tricksPlayed==5)
		{
			callWinner();
		}
	}
	
	/**
	 * Cette méthode va déclarer le gagnant finale
	 */
	public void callWinner()
	{
		if(tricksWonE>tricksLostE)
		{
			gamesWonE++;
			totalMoneyE=totalMoneyE+betE;
			labelTotalMoneyE.setText(Integer.toString(totalMoneyE));
			labelGamesWonE.setText(Integer.toString(gamesWonE));
			System.out.println("win");
			labelMSGE.setText("You won, please deal");
		}
		else if(tricksWonE<tricksLostE)
		{
			gamesLostE++;
			totalMoneyE=totalMoneyE-betE;
			labelTotalMoneyE.setText(Integer.toString(totalMoneyE));
			labelGamesLostE.setText(Integer.toString(gamesLostE));
			System.out.println("loss");
			labelMSGE.setText("You lost, please deal");
		}
		reIniEuchre();
	}
	
	/**
	 * Cette méthode remet tous les valeurs à zero pour commancer un autre jeu
	 */
	public void reIniEuchre()
	{
		chooseSpadesE.setDisable(false);
		chooseDiaE.setDisable(false);
		chooseHeartsE.setDisable(false);
		chooseClubsE.setDisable(false);
		choosePassE.setDisable(false);
		playerHandE.clear();
		op1HandE.clear();
		op2HandE.clear();
		op3HandE.clear();
		kittyE.clear();
		playerCard1E.setImage(null);
		playerCard2E.setImage(null);
		playerCard3E.setImage(null);
		playerCard4E.setImage(null);
		playerCard5E.setImage(null);
		centreCard1E.setImage(null);
		centreCard2E.setImage(null);
		centreCard3E.setImage(null);
		centreCard4E.setImage(null);
	}
	
	/**
	 * Cette méthode dirige la deuxième partie du jeu après le choix de l'usager
	 * @param clicked Carte sélectionné
	 */
	public void playEuchreSecondPart(ImageView clicked)
	{
		if(clicked==playerCard1E)
		{
			player=playerHandE.getCard(0);
			setCardToImage(playerHandE.getCard(0), centreCard4E);
		}
		else if(clicked==playerCard2E)
		{
			player=playerHandE.getCard(1);
			setCardToImage(playerHandE.getCard(1), centreCard4E);
		}
		else if(clicked==playerCard3E)
		{
			player=playerHandE.getCard(2);
			setCardToImage(playerHandE.getCard(2), centreCard4E);
		}
		else if(clicked==playerCard4E)
		{
			player=playerHandE.getCard(3);
			setCardToImage(playerHandE.getCard(3), centreCard4E);
		}
		else if(clicked==playerCard5E)
		{
			player=playerHandE.getCard(4);
			setCardToImage(playerHandE.getCard(4), centreCard4E);
		}
		
		if(dealerE.equals("Player"))
		{
			checkEuchreWin();
		}
		else if(dealerE.equals("Op1"))
		{
			op1=placeCardE(op1HandE, suitFollow,largestCard);
			if(op3.getValue()>largestCard)
			{
				largestCard=op1.getValue();
			}
			setCardToImage(op1, centreCard1E);
			checkEuchreWin();
		}
		else if(dealerE.equals("Op2"))
		{
			op1=placeCardE(op1HandE, suitFollow,largestCard);
			if(op3.getValue()>largestCard)
			{
				largestCard=op1.getValue();
			}
			op2=placeCardE(op2HandE, suitFollow,largestCard);
			if(op3.getValue()>largestCard)
			{
				largestCard=op2.getValue();
			}
			setCardToImage(op1, centreCard1E);
			setCardToImage(op2, centreCard2E);
			checkEuchreWin();
		}
		else if(dealerE.equals("Op3"))
		{
			op1=placeCardE(op1HandE, "",largestCard);
			suitFollow=op1.getSuitAsString();
			System.out.println(suitFollow);
			if(op3.getValue()>largestCard)
			{
				largestCard=op1.getValue();
			}
			op2=placeCardE(op2HandE, suitFollow,largestCard);
			if(op3.getValue()>largestCard)
			{
				largestCard=op2.getValue();
			}
			op3=placeCardE(op3HandE, suitFollow,largestCard);
			if(op3.getValue()>largestCard)
			{
				largestCard=op3.getValue();
			}
			setCardToImage(op1, centreCard1E);
			setCardToImage(op2, centreCard2E);
			setCardToImage(op3, centreCard3E);
			checkEuchreWin();
		}
	}

	/**
	 * Cette méthode va placer la carte au milieu 
	 * @param hand main d'où vient la carte
	 * @param suit couleur de la carte
	 * @param valueBigCard la carte qui a la plus grande valeur
	 * @return la carte au milieu
	 */
	public Card placeCardE(Hand hand, String suit, int valueBigCard)
	{
		//TODO return trump
		boolean canFollowSuit=false;
		String leftSuit="";
		Card returnCard=playerHandE.getCard(1);
		if(suit.equals("Spades"))
		{
			leftSuit="Clubs";
		}
		else if(suit.equals("Clubs"))
		{
			leftSuit="Spades";
		}
		else if(suit.equals("Hearts"))
		{
			leftSuit="Diamonds";
		}
		else if(suit.equals("Diamonds"))
		{
			leftSuit="Hearts";
		}

		if(suit.equals(""))
		{
			boolean hasAce=false, hasRight=false, hasLeft=false, hasKing=false;
			int aceIndex=0, rightIndex=0, leftIndex=0, kingIndex=0;
			Card tempCard;
			for(int i=0;i<hand.getCardCount();i++)
			{
				tempCard=hand.getCard(i);
				if(tempCard.getValue()==1&&!tempCard.getSuitAsString().equals(suit))
				{
					hasAce=true;
					aceIndex=i;
				}
				else if(tempCard.getValue()==13&&!tempCard.getSuitAsString().equals(suit))
				{
					hasKing=true;
					kingIndex=i;
				}
				else if(tempCard.getValue()==11&&tempCard.getSuitAsString().equals(leftSuit))
				{
					hasLeft=true;
					leftIndex=i;
				}
				else if(tempCard.getValue()==11&&tempCard.getSuitAsString().equals(suit))
				{
					hasRight=true;
					leftIndex=i;
				}
			}
			if(hasAce==true)
			{
				returnCard=hand.getCard(aceIndex);
			}
			else if(hasKing==true)
			{
				returnCard=hand.getCard(kingIndex);
			}
			else if(hasLeft==true)
			{
				returnCard=hand.getCard(leftIndex);
			}
			else if(hasRight==true)
			{
				returnCard=hand.getCard(rightIndex);
			}
			else
			{
				returnCard=hand.getCard(0);
			}
		}
		else if(!suit.equals(""))
		{
			Card tempCard;
			int sameSuit;
			for(int i=0;i<hand.getCardCount();i++)
			{
				tempCard=hand.getCard(i);
				if(tempCard.getSuitAsString().equals(suit))
				{
					canFollowSuit=true;
				}
			}
			if(canFollowSuit==true)
			{
				for(int i=0;i<hand.getCardCount();i++)
				{
					tempCard=hand.getCard(i);
					if(tempCard.getSuitAsString().equals(suit))
					{
						sameSuit=i;
						if(getEuchreValue(tempCard.getValue())>valueBigCard)
						{
							returnCard=hand.getCard(i);
							break;
						}
						else
						{
							returnCard=hand.getCard(sameSuit);
							break;
						}
					}
					else if(i==4)
					{
						returnCard=hand.getCard(3);
					}
				}
			}
			else if(canFollowSuit==false)
			{
				for(int i=0;i<hand.getCardCount();i++)
				{
					tempCard=hand.getCard(i);
					if(tempCard.getSuitAsString().equals(trumpSuit))
					{
						returnCard=hand.getCard(i);
						break;
					}
				}
			}
		}
		return returnCard;
	}

	/*
	 * 9, 10, Queen trumps are 1 point
	 * King trump is 2 points
	 * Ace trump is 3 points
	 * Left bower is 4 points
	 * Right bower is five points
	 */
	/**
	 * Vérifier si un trump peut être sélectionné 
	 * @param trump la carte qui est bid
	 * @param hand la main qui sera vérifier
	 * @return si la main peut sélectioner la carte
	 */
	public boolean checkBidE(Card trump, Hand hand)
	{
		Card tempCardBid;
		int euchreValue, pointsTrump=0;
		boolean returnValue, containsBower=false;
		for(int i = 0; i<5;i++)
		{
			tempCardBid = hand.getCard(i);
			if(tempCardBid.getSuit()==trump.getSuit())
			{
				euchreValue = getEuchreValue(tempCardBid.getValue());
				//all the other ones
				if(euchreValue==9||euchreValue==10||euchreValue==12)
				{
					pointsTrump=pointsTrump+1;
				}
				//king
				else if(euchreValue==13)
				{
					pointsTrump=pointsTrump+2;
				}
				//ace
				else if(euchreValue==14)
				{
					pointsTrump=pointsTrump+3;
				}
				else if(euchreValue==11)
				{
					pointsTrump=pointsTrump+5;
					containsBower=true;
				}
			}
			//leftbower
			if(trump.getSuitAsString().equals("Diamonds")&&tempCardBid.getSuitAsString().equals("Hearts")||
					trump.getSuitAsString().equals("Hearts")&&tempCardBid.getSuitAsString().equals("Diamonds"))
			{
				if(getEuchreValue(tempCardBid.getValue())==11)
				{
					pointsTrump=pointsTrump+4;
					containsBower=true;
				}
			}
			else if(trump.getSuitAsString().equals("Clubs")&&tempCardBid.getSuitAsString().equals("Spades")||
					trump.getSuitAsString().equals("Spades")&&tempCardBid.getSuitAsString().equals("Clubs"))
			{
				if(getEuchreValue(tempCardBid.getValue())==11)
				{
					pointsTrump=pointsTrump+4;
					containsBower=true;
				}
			}
		}
		if(pointsTrump>=8 &&containsBower==true)
		{
			returnValue = true;
		}
		else
		{
			returnValue = false;
		}
		return returnValue;
	}

	/**
	 * Cette méthode imprime toutes les cartes dans le console
	 */
	public void printHandCards()
	{
		System.out.println("player");
		for(int i=0;i<5;i++)
		{
			System.out.println(playerHandE.getCard(i));
		}
		System.out.println();
		System.out.println("op 1");
		for(int i=0;i<5;i++)
		{
			System.out.println(op1HandE.getCard(i));
		}
		System.out.println();
		System.out.println("op 2");
		for(int i=0;i<5;i++)
		{
			System.out.println(op2HandE.getCard(i));
		}
		System.out.println();
		System.out.println("op 3");
		for(int i=0;i<5;i++)
		{
			System.out.println(op3HandE.getCard(i));
		}
		System.out.println();
		System.out.println("kitty");
		for(int i=0;i<4;i++)
		{
			System.out.println(kittyE.getCard(i));
		}
	}

	/**
	 * Cette méthode donne la valeur selon Euchre si la couleur n'est pas trump
	 * @param regularValue valeur régulier
	 * @return valeur euchre
	 */
	public int getEuchreValue(int regularValue)
	{
		int returnValue=0;
		switch(regularValue)
		{
		case 1:returnValue=14;break;//ace
		case 9:returnValue=9;break;//9
		case 10:returnValue=10;break;//10
		case 11:returnValue=11;break;//jack
		case 12:returnValue=12;break;//queen
		case 13:returnValue=13;break;//king
		}
		return returnValue;
	}
	
	/**
	 * Cette méthode donne la valeur selon Euchre si la couleur est trump
	 * @param regularValue valeur régulier
	 * @param suit couleur 
	 * @return valeur euchre
	 */
	public int getEuchreTrumpValue(int regularValue, String suit)
	{
		int returnValue=0;
		switch(regularValue)
		{
		case 1:returnValue=13;break;
		case 9:returnValue=9;break;
		case 10:returnValue=10;break;
		case 11:
			if(suit.equals(trumpSuit))
			{
				returnValue=15;
			}
			else if(suit.equals(leftSuit))
			{
				returnValue=14;
			}
			break;
		case 12:returnValue=11;break;
		case 13:returnValue=12;break;
		}
		return returnValue;
	}

	/**
	 * Cette méthode va prendre le pari du TextField et le mettre dans un variable et le label
	 */
	public void handleBet()
	{
		betE=Integer.parseInt(fieldBetE.getText());
		labelBetE.setText(Integer.toString(betE));
		dealE.setDisable(false);
	}

	/**
	 * Cette méthode va ouvrir une fênetre d'instructions
	 * @param event
	 */
	public void handleInstructionsE()
	{
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Info-flash");
		alert.setTitle("INSTRUCTIONS");
		alert.setContentText("Go to: http://www.dummies.com/games/card-games/euchre/the-basics-of-playing-euchre/");
		alert.show();
	}
		
	/**
	 * Cette méthode va ouvrir une fênetre à propos
	 * @param event
	 */
	public void handleAboutE()
	{
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Info-flash");
		alert.setTitle("ABOUT");
		alert.setContentText("This game was created as the culminating project of grade 11 computer science.");
		alert.show();
	}
	//======
	
	/**
	 * Cette méthode ferme l'application
	 */
	public void handleClose()
	{
		System.exit(0);
	}
	
	/**
	 * Cette méthode remet tous les argent à zero
	 */
	public void handleResetMoney()
	{
		totalMoneyBJ=2500;
		totalMoneyHL=2500;
		totalMoneyE=2500;
		labelTotalMonetBJ.setText(Integer.toString(totalMoneyBJ));
		labelTotalMoneyE.setText(Integer.toString(totalMoneyE));
		labelTotalMonetHL.setText(Integer.toString(totalMoneyHL));
	}
	
	/**
	 * Cette méthode va ouvrir une fênetre à propos
	 * @param event
	 */
	public void handleAbout()
	
	{
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Info-flash");
		alert.setTitle("ABOUT");
		alert.setContentText("This game was created as the culminating project of grade 11 computer science.");
		alert.show();
	}
}










