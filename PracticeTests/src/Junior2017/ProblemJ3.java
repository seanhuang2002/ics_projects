package Junior2017;

import java.util.Scanner;

public class ProblemJ3 {

	public static void main(String[] args) 
	{
		int x = 0,y = 0, min = 0, xtra = 0;
		Scanner pen = new Scanner(System.in);
		int X1 = pen.nextInt();
		int Y1 = pen.nextInt();
		pen.nextLine();
		int X2 = pen.nextInt();
		int Y2 = pen.nextInt();
		pen.nextLine();
		int Battery = pen.nextInt();
		pen.close();
		
		y=Y1-Y2;
		x=X1-X2;
		
		if (x<0)
			x*=-1;
		if (y<0)
			y*=-1;
		
		min = x+y;
		
		xtra = Battery-min;
		
		if(xtra < 0)
			System.out.println("N");
		else if (xtra % 2 == 0)
			System.out.println("Y");
		else
			System.out.println("N");
	}

}
