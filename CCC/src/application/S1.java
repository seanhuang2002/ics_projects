package application;

import java.util.Scanner;

public class S1 {

	public static void main(String[] args) {
		int a=1,b=2,c=3,d=4;
		Scanner pen=new Scanner(System.in);
		String input=pen.nextLine();
		int L=input.length();
		for(int i=0;i<L;i++)
		{
			int A=0,B=0,C=0,D=0;
			if(input.charAt(i)=='H')
			{
				A=a;
				B=b;
				C=c;
				D=d;
				//ab CD
				//cd AB
				c=A;
				d=B;
				a=C;
				b=D;
			}
			else if(input.charAt(i)=='V')
			{
				A=a;
				B=b;
				C=c;
				D=d;
				//ab BA
				//cd DC
				b=A;
				a=B;
				d=C;
				c=D;
			}
		}
		System.out.println(a+" "+b);
		System.out.println(c+" "+d);
	}

}
