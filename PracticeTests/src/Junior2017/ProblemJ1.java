package Junior2017;

import java.util.Scanner;

public class ProblemJ1 {

	public static void main(String[] args) 
	{
		Scanner pen = new Scanner(System.in);
		int one = pen.nextInt();
		pen.nextLine();
		int two = pen.nextInt();
		pen.close();
		System.out.println(Machine(one, two));
	}
	public static int Machine(int a, int b)
	{
		if(a>0 && b>0)
		{
			return 1;
		}
		else if(a>0 && b<0)
		{
			return 4;
		}
		else if(a<0 && b>0)
		{
			return 2;
		}
		else
		{
			return 3;
		}
	}
}
