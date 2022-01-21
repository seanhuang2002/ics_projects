/*
 * Author: shuang
 * Date: Nov 15, 2017
 */

package homework;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		introduction();
		boolean start = true;
		while(start == true)
		{
			String input;
			Scanner pen = new Scanner(System.in);
			System.out.println("Écrivez l'expression correctement puis appuyez sur enter.");
			input = pen.nextLine();
			try {
				calcules(input);
			} catch (Exception e) {
				System.out.println("Il y a un erreur! Verifiez si votre expréssion suivait les conditions introduit dans l'introduction.");
			}
			System.out.println("Voulez vous faire une autre calcul?");
			System.out.println("Repondez 'oui' ou 'non' et puis appuyez sur enter.");
			String ouiounon = pen.nextLine();
			if(!"oui".equals(ouiounon)&&!"non".equals(ouiounon))
			{
				System.out.println("Réponce non valide, écrivez oui ou non");
			}
			else if (ouiounon.equals("oui"))
			{
				start = true;
			}
			else if("non".equals(ouiounon))
			{
				System.out.println("Merci d'avoir utilisé cette calculatrice!");
				start = false;
				pen.close();
			}
		}
	}
	public static void introduction()
	{
		System.out.println("Cette programme a été créée par Sean Huang pour la classe d'informatique.");
		System.out.println("Bienvenue à la calculatrice. Cette calculatrice peut effectuer des simples calcules.");
		System.out.println("Le format d'une expression sera '(la première nombre) espace (opérateur) espace (la deuxième nombre)'.");
		System.out.println("Le caractère a mettre pour chaque opérateur:");
		System.out.println("     Addition = '+'");
		System.out.println("     Soustraction = '-'");
		System.out.println("     Multiplication = '*'");
		System.out.println("     Division = '/'");
		System.out.println("     Exponent = '^'");
		System.out.println("     Racine Carrée = '0 √' (Pour le signe √, cliquez sur 'option - v')");
	}
	public static void calcules(String input)
	{
		String firstnumber,secondnumber;
		int operation,lastchar,num, firstspace = 0,secondspace = 0,i,t;
		double result;
		t = input.length();
		num = t -1;
		for(i=0; num > i; i++ )
		{
			char j =input.charAt(i);
			if(j==' ')
			{
				firstspace = i;
				secondspace = i + 2;
				break;
			}
		}
		lastchar = input.length();
		operation = firstspace + 1;
		firstnumber = input.substring(0, firstspace);
		int numberone = Integer.valueOf(firstnumber).intValue();

		secondnumber = input.substring(secondspace+1, lastchar);
		int numbertwo = Integer.valueOf(secondnumber).intValue();


		switch (input.charAt(operation)){
		case '+':
			result = numberone + numbertwo;
			System.out.println(result);
			break;
		case '-':
			result = numberone - numbertwo; 
			System.out.println(result);
			break;
		case '*':
			result = numberone * numbertwo;
			System.out.println(result);
			break;
		case '/':
			result = numberone / numbertwo;
			System.out.println(result);
			break;
		case '^':
			result = Math.pow(numberone, numbertwo);
			System.out.println(result);
			break;
		case '√':
			result = Math.sqrt(numbertwo);
			System.out.println(result);
			break;
		}	
	}
}
