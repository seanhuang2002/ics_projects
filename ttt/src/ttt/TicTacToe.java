package ttt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

/**
 * @author : jzagabe
 * @fichier :TicTacToe.java
 * @Date : Dec 17, 2013
  * @Description : Plateau pour le jeu de Tic Tac Toe avec 9 cases rangées
 * sur 3 lignes et 3 colonnes. Le jeu se passe entre un joueur et l'ordinateur
 * et permet de concourir à remplir 3 cases consécutives (avec X ou avec O)
 * La présente interface se charge  de construire le panneau du jeu et de lancer l'application.
 */
public class TicTacToe extends JFrame implements ActionListener  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panneauSup;
	private JPanel panneau;
	private JPanel panneauBas;
	private JButton btn[];
	private JButton nouveauJeu;
	private JButton resetAll;
	private JButton quitter;
	private JLabel nbVictoires;
	private JLabel nbDefaites;
	private JLabel aToi;
	private int casesRestantes=9;
	private int victoires,defaites=0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe frame = new TicTacToe();
					frame.setTitle("Jeu de Tic Tac Toe");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * Constructeur du jeu
	 */
	public TicTacToe() {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {e.printStackTrace();}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		// ajout de panneaux
		panneauSup=new JPanel();
		panneau=new JPanel();
		panneauBas=new JPanel();
		panneauSup.setLayout(new GridLayout (1,3,5,5));
		panneau.setLayout(new GridLayout (3,3,5,5));
		panneauBas.setLayout(new GridLayout (1,3,5,5));
		contentPane.add(panneauSup, "North");
		contentPane.add(panneau, "Center");
		contentPane.add(panneauBas, "South");
		btn= new JButton[9];
		for(int i=0;i<9;i++)
		{
			btn[i]=new JButton();
			panneau.add(btn[i]);
			btn[i].setBackground(Color.YELLOW);
			btn[i].addActionListener(this);
			
		}
		nouveauJeu=new JButton("Nouveau Jeu");
		nouveauJeu.addActionListener(this);
		quitter=new JButton("Quitter");
		quitter.addActionListener(this);
		resetAll=new JButton("Remise à zero");
		resetAll.addActionListener(this);
		nbVictoires=new JLabel("Victoires : ");
		nbDefaites=new JLabel("Defaites : ");
		aToi=new JLabel("À toi de jouer ! : ");
		panneauSup.add(nbVictoires);
		panneauSup.add(nouveauJeu);
		panneauSup.add(nbDefaites);
		panneauBas.add(aToi);
		panneauBas.add(resetAll);
		panneauBas.add(resetAll);
		panneauBas.add(quitter);
		setContentPane(contentPane);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * Cette méthode permet de gérer tous les évenements de la fenêtre.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//quel est le bouton qui est actif ?
		JButton btnActif=(JButton) e.getSource();
		// si le bouton commencer le jeu est appuyé
		if(btnActif== nouveauJeu)
		{
			for(int i=0;i<9;i++)
			{
				btn[i].setEnabled(true);
				btn[i].setText("");
				btn[i].setBackground(Color.YELLOW);
			}
			casesRestantes=9;
			aToi.setText("À toi de jouer !");
			nouveauJeu.setEnabled(false);
			return; // sortir de la méthode
		}
		
		String vainqueur="";
		if(btnActif==quitter)
		{
			System.exit(0);
		}
		if(btnActif==resetAll)
		{
			recommencer();
		}
		//si un des boutons du jeu est cliqué
		for(int i=0;i<9;i++)
		{
			if((btnActif==btn[i]) && (btn[i].getText().equals("")))
			{
				btn[i].setText("X");
				//verifier vainqueur
				vainqueur=checkVictoire();
				if(!vainqueur.equals(""))
				{
					resetTout();
				}
				else
				{
					tourOrdi();
					vainqueur=checkVictoire();
					if(!vainqueur.equals(""))
					{
						resetTout();
					}
					
				}break;
			}
		}
		//compter les victoires
		if(vainqueur.equals("X"))
		{
			aToi.setText("Tu as gagné");
			victoires++;
			nbVictoires.setText("Victoires : " + victoires); // afficher le nombre de victoires
		}
		else if (vainqueur.equals("O"))
		{
			aToi.setText("Tu as perdu");
			defaites++;
			nbDefaites.setText("Defaites : " + defaites); // afficher le nombre de défaites
		}
		else if (vainqueur.equals("T"))
		{
			aToi.setText("Partie nulle");
		}
	}
	//========== fin de actionPerformed =================
	/*Cette méthode permet de vérifier si deux boutons portent le même signe, soit le X, soit le O.
	 * Elle constitue la stratégie la plus importante pour ce jeu car c'est à ce niveau que l'ordinateur aura 
	 * soit à gagner en ajoutant un O sur la ligne qui en a dejà deux, soit en bloquant le joueur si celui-ci
	 * a dejà rangé deux X sur la même ligne. Un système de points sera utilisé : un X  va avoir une valeur  de 1 et un O va 
	 * avoir une valeur de -1 et une case vide aura un 0 comme valeur. Ainsi si deux cases de la même ligne ont un X et qu'une
	 * case est vide, on aura une somme de 2, et dans le cas de deux O, on aura la somme qui est de -2
	 * la méthode reçoit en paramètre un String qui sera soit un "O", soit un "X";
	 */
	 int jouerSurDeux(String tour)
	{
		int points[] = new int[9];
		//boucle pour attribuer les points
		for (int i = 0; i < 9; i++ ) {
			if (btn[i].getText().equals("O"))
				points[i] = -1;
			else if (btn[i].getText().equals("X"))
				points[i] = 1;
			else
				points[i] = 0;
		}
		int deuxpoints=0;
		if(tour.equals("O"))
			deuxpoints=-2;
		else
			deuxpoints=2;
		// Regarde si la ligne 1 a 2 btn identiques et un vide
		if (points[0] + points[1] + points[2] == deuxpoints) 
		{
			System.out.println("A");
			if (points[0] == 0)
				return 0;
			else if (points[1] == 0)
				return 1;
			else
				return 2;
			
		}

		// Regarde si la ligne 2 a 2 btn identiques et un vide
		if (points[3] + points[4] + points[5] == deuxpoints) 
		{
			System.out.println("B");
			if (points[3] == 0)
				return 3;
			else if (points[4] == 0)
				return 4;
			else
				return 5;
		}
		//Regarde si la ligne 3 a 2 btn identiques et un vide
		if (points[6] + points[7] + points[8] == deuxpoints) 
		{
			System.out.println("C");
			if (points[6] == 0)
				return 6;
			else if (points[7] == 0)
				return 7;
			else
				return 8;
		}
		
		//Regarde si la colonne 1 a 2 btn identiques et un vide
		if (points[0] + points[3] + points[6] == deuxpoints) 
		{
			System.out.println("D");
			if (points[0] == 0)
				return 0;
			else if (points[3] == 0)
				return 3;
			else
				return 6;
		}
		//Regarde si la colonne 2 a 2 btn identiques et un vide
		if (points[1] + points[4] + points[7] == deuxpoints) 
		{
			System.out.println("E");
			if (points[1] == 0)
				return 1;
			else if (points[4] == 0)
				return 4;
			else
				return 7;
		}
		//Regarde si la colonne 3 a 2 btn identiques et un vide
		if (points[2] + points[5] + points[8] == deuxpoints) 
		{
			System.out.println("F");
			if (points[2] == 0)
				return 2;
			else if (points[5] == 0)
				return 5;
			else
				return 8;
		}
		//Regarde si la diagonale 1 a 2 btn identiques et un
		//vide
		if (points[0] + points[4] + points[8] == deuxpoints) {
			System.out.println("G");
			if (points[0] == 0)
				return 0;
			else if (points[4] == 0)
				return 4;
			else
				return 8;
		}
		
		//Regarde si la diagonale 2 a 2 btn identiques et un
				//vide
		if (points[2] + points[4] + points[6] == deuxpoints) 
		{
			System.out.println("H");
			if (points[2] == 0)
				return 2;
			else if (points[4] == 0)
				return 4;
			else
				return 6;
		}

		//Il n'y a pas de btn alignees identiques
		System.out.println("I");
		return -1;	
	}
	//==========================================
/*Cette methode applique un ensemble de regles afin de
 * trouver le meilleur coup pour l'ordinateur.
 * Si un bon
 * coup ne peut etre trouve, elle choisit une case au
 * hasard.
 */
	
	void tourOrdi()
	{
		int btnSelectionne;
		//L'ordinateur essaie d'abord de trouver une case
		//vide pres de deux case marquees "O" pour gagner
		btnSelectionne= jouerSurDeux("O");
		//S'il n'y a pas deux "O" alignes, essaie au moins
		//d'empecher l'adversaire d'aligner trois "X" en
		//mettant un "O" pres de deux "X"
		if (btnSelectionne == -1) 
		{
			btnSelectionne = jouerSurDeux("X");
		}
		//Si caseSelectionnee vaut toujours -1, essaie d'occuper
		//la case centrale
		if ((btnSelectionne == -1)
				&& (btn[4].getText().equals(""))) {
			btnSelectionne = 4;
		}
		//Pas de chance avec la case centrale non plus...
		//Choisir alors une case au hasard
		if (btnSelectionne == -1) {
			btnSelectionne = cocherHasard();
		}
		btn[btnSelectionne].setText("O");

	
	}
	
	//================================================
	/**
	 * Cette methode selectionne un bouton vide quelconque.
	 * @return un numero du bouton choisi au hasard
	 */
	int cocherHasard() 
	{
		boolean findVide = false;
		int btnCoche = -1;
		do 
		{
			btnCoche= (int) (Math.random() * 9);
			if (btn[btnCoche].getText().equals("")) {
				findVide = true; // Pour terminer la boucle
			}
		}while (!findVide);
		return btnCoche;
	}
	
	
	
//========================================	
	/**
	 * Cette methode est appelee apres chaque coup joue pour
	 * voir s'il y a un gagnant. Elle verifie pour chaque ligne,
	 * colonne et diagonale, s'il y a trois symboles identiques
	 * @return "X", "O", "T" (termine, partie nulle) ou "" (pas
	 * fini)
	 */
	String checkVictoire()
	{
		String vainqueur="";
		casesRestantes--;
		//Verifie la ligne 1 - elements 0, 1 et 2 du tableau
		if (!btn[0].getText().equals("") &&
				btn[0].getText().equals(btn[1].getText()) &&
				btn[0].getText().equals(btn[2].getText())) 
			{
			vainqueur = btn[0].getText();
			declareVictoire(0, 1, 2);
					} 
		//Verifie la ligne 2 - elements 3, 4 et 5 du tableau
		else if (!btn[3].getText().equals("") &&
				btn[3].getText().equals(btn[4].getText()) &&
				btn[3].getText().equals(btn[5].getText())) {
			vainqueur = btn[3].getText();
			declareVictoire(3, 4, 5);
			
			} 
		//Verifie la ligne 3 - elements 6, 7 et 8 du tableau
		else if (!btn[6].getText().equals("") &&
				btn[6].getText().equals(btn[7].getText()) &&
				btn[6].getText().equals(btn[8].getText())) {
			vainqueur = btn[6].getText();
			declareVictoire(6, 7, 8);
			
			} 
		//Verifie la colonne 1 - elements 0, 3 et 6 du tableau
		else if (!btn[0].getText().equals("") &&
				btn[0].getText().equals(btn[3].getText()) &&
				btn[0].getText().equals(btn[6].getText())) {
			vainqueur = btn[0].getText();
			declareVictoire(0, 3, 6);
		}
		//Verifie la colonne 2 - elements 1, 4 et 7 du tableau
		 else if (!btn[1].getText().equals("") &&
					btn[1].getText().equals(btn[4].getText()) &&
					btn[1].getText().equals(btn[7].getText())) {
				vainqueur = btn[1].getText();
				declareVictoire(1, 4, 7);
				
			} 
		//Verifie la colonne 3 - elements 2, 5 et 8 du tableau
			else if (!btn[2].getText().equals("") &&
					btn[2].getText().equals(btn[5].getText()) &&
					btn[2].getText().equals(btn[8].getText())) {
				vainqueur = btn[2].getText();
				declareVictoire(2, 5, 8);
				
			}	
		//Verifie la premiere diagonale - elements 0, 4 et 8
			else if (!btn[0].getText().equals("") &&
					btn[0].getText().equals(btn[4].getText()) &&
					btn[0].getText().equals(btn[8].getText())) {
				vainqueur = btn[0].getText();
				declareVictoire(0, 4, 8);
				
			}
		//Verifie la seconde diagonale - elements 2, 4 et 6
			else if (!btn[2].getText().equals("") &&
					btn[2].getText().equals(btn[4].getText()) &&
					btn[2].getText().equals(btn[6].getText())) {
				vainqueur = btn[2].getText();
				declareVictoire(2, 4, 6);
			} 
		// nullité
		else if (casesRestantes == 0) {
					return "T"; // Partie nulle
				}
		
		return vainqueur; 
	}
//=================================
	/*
	 * Methode pour déclarer la victoire : colore les boutons en bleu
	 */
	void declareVictoire(int a1, int a2, int a3)
	{
		btn[a1].setBackground(Color.BLUE);
		btn[a2].setBackground(Color.BLUE);
		btn[a3].setBackground(Color.BLUE);
	}
	
//=============================
	
	void resetTout()
	{
		nouveauJeu.setEnabled(true);
		for(int i=0;i<9;i++)
		{
			btn[i].setEnabled(false);
		}
		
	}
	//=================================
	/*Recommencer le jeu et remettre tous les paramètres
	 * comme au début
	 * 
	 */
	void recommencer()
	{
		for (int i = 0; i < 9; i++) 
		{
			btn[i].setEnabled(true);
			btn[i].setText("");
			btn[i].setBackground(Color.YELLOW);
			
		}
		casesRestantes = 9;
		nouveauJeu.setEnabled(false);
		victoires=0;
		defaites=0;
		nbVictoires.setText("Victoires : ");
		nbDefaites.setText("Défaites : ");
		aToi.setText("A toi de jouer !");
		
	}



}