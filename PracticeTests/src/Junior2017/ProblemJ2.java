package Junior2017;

import java.util.Scanner;

public class ProblemJ2 
{
	public static void main(String[] args) 
	{
		Scanner pen = new Scanner(System.in);
		int one = pen.nextInt();
		pen.nextLine();
		int two = pen.nextInt();
		pen.close();
		System.out.println(shifter(one, two));
	}
	public static int shifter(int a, int b)
	{
		int total = a, number;
		for(int i= 0; i<b; i++)
		{
			int three = (int) Math.pow(10, i+1);
			number = a * three;
			total = total + number;
		}
		return total;
	}
}
