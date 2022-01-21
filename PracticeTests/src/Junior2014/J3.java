package Junior2014;

import java.util.Scanner;

public class J3 {

	public static void main(String[] args) {
		Scanner pen = new Scanner(System.in);
		int numRound = pen.nextInt();
		pen.nextLine();
		
		int Dtotal = 100, Atotal = 100;
		for(int i=0;i<numRound;i++)
		{
			int A = pen.nextInt();
			int D = pen.nextInt();
			pen.nextLine();
			if (A==D);
			else if (A>D)
				Dtotal=Dtotal-A;
			else
				Atotal=Atotal-D;
		}
		pen.close();
		
		System.out.println(Atotal);
		System.out.println(Dtotal);
	}

}
