package ccc;

import java.util.Scanner;

public class CCCj3 {

	public static void main(String[] args) {
		Scanner pen = new Scanner(System.in);
		int cityDistance[] = new int[4];
		int cityOne = 0, cityTwo=0,cityThree=0,cityFour=0, cityFive = 0;
		for(int i = 0; i<4;i++)
		{
			cityDistance[i]=pen.nextInt();
		}
		cityTwo = cityOne + cityDistance[0];
		cityThree = cityTwo + cityDistance[1];
		cityFour = cityThree + cityDistance[2];
		cityFive = cityFour + cityDistance[3];
		
		System.out.println(cityOne +" "+cityTwo +" "+cityThree+" "+cityFour+" "+cityFive);
		System.out.println(cityTwo +" "+(cityTwo-cityTwo) +" "+(cityThree-cityTwo)+" "+(cityFour-cityTwo)+" "+(cityFive-cityTwo));
		System.out.println(cityThree +" "+(cityThree -cityTwo) +" "+(cityThree-cityThree)+" "+(cityFour-cityThree)+" "+(cityFive-cityThree));
		System.out.println(cityFour +" "+(cityFour -cityTwo) +" "+(cityFour -cityThree)+" "+(cityFour -cityFour)+" "+(cityFive-cityFour));
		System.out.println(cityFive +" "+(cityFive-cityTwo) +" "+(cityFive-cityThree)+" "+(cityFive-+cityFour)+" "+(cityFive-cityFive));
	}

}
