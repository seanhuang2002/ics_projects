/*
* Author : seanhuang
* Date : Oct 20, 2017
*/
import java.util.Scanner;

public class Multiples 
{

	public static void main(String[] args) 
	{
		int number, firstnumber, lastnumber;
		
		System.out.println("Quel est le nombre dont tu veux voir les multiples?");
		Scanner pen = new Scanner(System.in);
		number = pen.nextInt();
		pen.nextLine();
		
		System.out.println("Donner un premier chiffre.");
		firstnumber = pen.nextInt();
		pen.nextLine();
		
		System.out.println("Donner un second chiffre");
		lastnumber = pen.nextInt();
		pen.nextLine();
		
		for (int x = 0; number*x < lastnumber+1; x++)
		{
			int multiple = x*number;
			if(multiple >= firstnumber && multiple <= lastnumber)
			{
				System.out.println(multiple + " est un multiple de "+number);
			}
			
		}
		pen.close();
	}

}
