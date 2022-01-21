package ccc;

import java.util.Scanner;

public class CCCj1 {

	public static void main(String[] args) {
		Scanner pen = new Scanner(System.in);
		int one= 0, two=0,three=0,four=0;
		one = pen.nextInt();
		pen.nextLine();
		two = pen.nextInt();
		pen.nextLine();
		three = pen.nextInt();
		pen.nextLine();
		four = pen.nextInt();
		pen.nextLine();
		if(one ==9||one ==8)
		{
			if(four == 9||four == 8)
			{
				if(two == three)
				{
					System.out.println("ignore");
				}
				else
				{
					System.out.println("answer");
				}
			}
			else
			{
				System.out.println("answer");
			}
			
		}
		else
		{
			System.out.println("answer");
		}
		

	}

}
