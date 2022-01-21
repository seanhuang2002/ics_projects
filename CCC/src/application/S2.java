package application;

import java.util.Scanner;

public class S2 {
	public static void main(String[] args)
	{
		Scanner pen=new Scanner(System.in);
		int T=pen.nextInt();
		pen.nextLine();
		String[] output= new String[T];
		for(int i=0;i<T;i++)
		{
			int in=((pen.nextInt()));
			pen.nextLine();
			if(in%2==0)
			{
				output[i]=primeEven(in,in);
			}
			else
			{
				int N=in*2;
				output[i]=primeOdd(N-1,1);
			}
		}
		for(int i=0;i<T;i++)
		{
			System.out.println(output[i]);
		}
	}
	
	public static String primeOdd(int N1, int N2)
	{
		if(prime(N1)==true && prime(N2)==true)
		{
			String output = N1+" "+N2;
			return output;
		}
		else
		{
			return primeOdd(N1-1,N2+1);
		}
	}
	
	public static String primeEven(int N1, int N2)
	{
		if(prime(N1)==true && prime(N2)==true)
		{
			String output = N1+" "+N2;
			return output;
		}
		else
		{
			return primeEven(N1+1,N2-1);
		}
	}
	
	public static Boolean prime(int N)
	{
		if(N==1)
		{
			return false;
		}
		else
		{
			boolean flag = false;
			for(int i = 2; i <= N/2; ++i)
			{
				if(N % i == 0)
				{
					flag = true;
                	break;
				}
			}
			if (!flag)
				return true;
			else
				return false;
		}
	}
}
