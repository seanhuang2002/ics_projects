package ccc;

import java.util.Scanner;

public class CCCj2 {

	public static void main(String[] args) {
		Scanner pen = new Scanner(System.in);
		int N = 0, same=0;
		N = pen.nextInt();
		pen.nextLine();
		String dayOne = pen.nextLine();
		String dayTwo = pen.nextLine();
		for(int i = 0;i<N;i++)
		{
			char one = dayOne.charAt(i);
			char two = dayTwo.charAt(i);
			if(one != two);
			else if(one==two)
			{
				if(one=='C'&&two=='C')
				{
					same=same+1;
				}
			}
		}
		System.out.println(same);

	}

}
