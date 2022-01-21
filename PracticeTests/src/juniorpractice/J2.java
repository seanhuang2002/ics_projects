package juniorpractice;

import java.util.Scanner;

public class J2 {
	public static void main(String[] args) {
		Scanner pen = new Scanner(System.in);
		int N = pen.nextInt();
		pen.nextLine();
		int intArray1[];
		intArray1 = new int[N];
		int intArray2[];
		intArray2 = new int[N];
		for(int i =0;i<N;i++)
		{
			intArray1[i]=pen.nextInt();
		}
		pen.nextLine();
		for(int i=0;i<N;i++)
		{
			intArray2[i]=pen.nextInt();
		}
		int oneTotal = 0, twoTotal=0, ans = 0;
		for(int i=0;i<N;i++)
		{
			oneTotal = oneTotal + intArray1[i];
			twoTotal = twoTotal + intArray2[i];
			if(oneTotal == twoTotal&&oneTotal!=0)
			{
				ans = i+1;
			}
				
		}
		if(ans ==0)
		{
			System.out.println("0");
		}
		else
		{
			System.out.println(ans);
		}
		
	}

}
