package Junior2016;

import java.util.Scanner;

public class J1 {

	public static void main(String[] args) 
	{
		int w=0;
		Scanner pen = new Scanner(System.in);
		for(int i=0;i<6;i++)
		{
			String input=pen.nextLine();
			if(input=="W")
				w++;
			else;				
		}
		if(w==5||w==6)
			System.out.println("1");
		else if(w==3||w==4)
			System.out.println("2");
		else if(w==2||w==1)
			System.out.println("3");
		else
			System.out.println("-1");
		
	}

}
