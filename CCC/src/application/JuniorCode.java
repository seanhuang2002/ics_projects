package application;

import java.util.Scanner;

public class JuniorCode {
	public void J1()
	{
		int a1,a2,a3,b1,b2,b3,aTotal,bTotal;
		Scanner pen=new Scanner(System.in);
		a1=pen.nextInt();
		pen.nextLine();
		a2=pen.nextInt();
		pen.nextLine();
		a3=pen.nextInt();
		pen.nextLine();
		b1=pen.nextInt();
		pen.nextLine();
		b2=pen.nextInt();
		pen.nextLine();
		b3=pen.nextInt();
		pen.nextLine();
		aTotal=(3*a1)+(2*a2)+a3;
		bTotal=(3*b1)+(2*b2)+b3;
		if(aTotal>bTotal)
		{
			System.out.println("A");
		}
		else if(bTotal>aTotal)
		{
			System.out.println("B");
		}
		else if(aTotal==bTotal)
		{
			System.out.println("T");
		}
	}
	
	public void J2()
	{
		Scanner pen=new Scanner(System.in);
		int L=pen.nextInt();
		pen.nextLine();
		int[] number= new int[L];
		String[] charac= new String[L];
		for(int i=0;i<L;i++)
		{
			int spaceIndex = 0;
			String input=pen.nextLine();
			for(int j=0; j<input.length();j++)
			{
				if(input.charAt(j)==' ')
				{
					spaceIndex=j;
				}
			}
			String num=input.substring(0,spaceIndex);
			String chara=input.substring(spaceIndex+1);
			int numb= Integer.parseInt(num);
			number[i]=numb;
			charac[i]=chara;
		}
		for(int i=0;i<L;i++)
		{
			for(int j=0;j<number[i];j++)
			{
				System.out.print(charac[i]);
			}
			System.out.println();
		}
	}

	public void J3()
	{
		Scanner pen=new Scanner(System.in);
		int N=pen.nextInt();
		pen.nextLine();
		String[] output = new String[N];
		for(int i=0; i<N;i++)//reading each line
		{
			String inputLine=pen.nextLine();
			inputLine=inputLine+" ";
			String outputLine = "";
			int num=0;
			char orgChar=inputLine.charAt(0);
			for(int j=0;j<inputLine.length();j++)//reading each character in a line
			{
				char read=inputLine.charAt(j);
				if(read!=orgChar||j==(inputLine.length()-1))
				{
					int num1=j-num;
					outputLine=outputLine + (num1) + " " + orgChar +" ";
					orgChar=read;
					num=j;
				}
			}
			output[i]=outputLine;
		}
		for(int i=0;i<N;i++)
		{
			System.out.println(output[i]);
		}
	}
	
	public void J4()

	{
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
	
	public void J5()
	{
		Scanner pen=new Scanner(System.in);
		String rule1=pen.nextLine(), rule2=pen.nextLine(), rule3=pen.nextLine();
		String[][] Rules= new String[3][2];
		for(int i=0;i<rule1.length();i++)
		{
			char chara=rule1.charAt(i);
			if(chara==' ')
			{
				Rules[1][1]=rule1.substring(0,i);
				Rules[1][2]=rule1.substring(i+1);
			}
		}
		for(int i=0;i<rule2.length();i++)
		{
			char chara=rule2.charAt(i);
			if(chara==' ')
			{
				Rules[2][1]=rule2.substring(0,i);
				Rules[2][2]=rule2.substring(i+1);
			}
		}
		for(int i=0;i<rule3.length();i++)
		{
			char chara=rule3.charAt(i);
			if(chara==' ')
			{
				Rules[3][1]=rule3.substring(0,i);
				Rules[3][2]=rule3.substring(i+1);
			}
		}
		String input=pen.nextLine();
		int S=0,firstSpace=0;
		String start, end;
		for(int i=0;i<input.length();i++)
		{
			
			char chara=input.charAt(i);
			if(chara==' '&& S==0)
			{
				S=Integer.parseInt(input.substring(0, i));
				firstSpace=i;
			}
			else if(chara==' '&& S!=0)
			{
				start=input.substring(firstSpace+1, i);
			}
			else if(chara==' '&& S!=0 && firstSpace!=0)
			{
				end=input.substring(i+1);
			}
		}
		
	}

}
