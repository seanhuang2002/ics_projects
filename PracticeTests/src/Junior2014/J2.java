package Junior2014;

import java.util.Scanner;

public class J2 {

	public static void main(String[] args) {
		Scanner pen = new Scanner(System.in);
		int numVotes = pen.nextInt();
		pen.nextLine();
		String votes = pen.nextLine();
		pen.close();
		
		int A = 0,B = 0;
		for(int i=0;i<numVotes;i++)
		{
			if(votes.charAt(i)=='A')
				A++;
			else
				B++;
		}
		
		if(A>B)
			System.out.println("A");
		else if(B>A)
			System.out.println("B");
		else
			System.out.println("Tie");
		
	}

}
