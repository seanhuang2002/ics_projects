package ccc;

import java.util.Scanner;

public class CCCj4 {



	public static void main(String[] args) {
		Scanner pen = new Scanner(System.in);
		int N = pen.nextInt();
		int myArray [][] = new int[N][N];

		for(int i =0;i<N;i++)
		{
			for(int j = 0;j<N;j++)
			{
				myArray[j][i] = pen.nextInt();
			}
			pen.nextLine();
		}
		boolean flipped = false;

		if(firstColumn(myArray,N)==true)
		{
			if(rows(myArray,N)==true)
			{
				boolean one = contains(myArray,1,N);
				if(one == true)
				{

					//System.out.println("1");
					flipped=  true;
					print(myArray,N);

				}
				else if (one ==false)
				{

					//System.out.println("2");
					flipped = false;

				}
				//true
			}
			else if (rows(myArray,N)==false)
			{
				//false
				boolean one = contains(myArray,1,N);
				if(one == true)
				{

					//System.out.println("3");
					flipped=  false;

				}
				else if (one ==false)

				{

					//System.out.println("4");
					flipped = false;
				}

			}
		}
		else if(firstColumn(myArray,N)==false)
		{
			if(rows(myArray,N)==true)
			{
				boolean one = contains(myArray,1,N);
				if(one == true)
				{
					//System.out.println("5");
					flipped=  true;
					print(myArray,N);
					
				}
				else if (one==false)
				{
					//System.out.println("6");
					flipped = true;
					print(myArray,N);
					

				}


			}

			else if (rows(myArray,N)==false)
			{
				boolean one = contains(myArray,1,N);
				if(one == true)
				{
								
					if (myArray[0][0]!=1)
					{
						//System.out.println("7");
						flipped= true;
						print(myArray,N);
						
					}
					else if(myArray[0][0]==1)
					{
						//System.out.println("8");
						flipped= false;
					}

				}
				else if (one == false)
				{
					//System.out.println("9");
					flipped = false;
				}
			}
		}
		

	}
	public static void ninetydegrees(int[][]myArray,int[][]myArrayTwo,int N)
	{
		int t = N;
		for(int i = 0; i<N; i++)
		{
			for(int j= 0; j<N;j++)
			{
				myArrayTwo[j][i]=myArray[i][t];
				t =t-1;
			}
		}
		for(int i = 0; i<N;i++)
		{
			for(int j = 0; j<N;j++)
			{
				System.out.print(myArrayTwo[j][i]+" ");
			}
			System.out.println();
		}
	}
	public static void twoseventydegrees(int[][]myArray,int[][]myArrayTwo,int N)
	{
		int t = N;
		for(int i = 0; i<N; i++)
		{
			for(int j= 0; j<N;j++)
			{
				myArrayTwo[j][i]=myArray[t][i];
				t =t-1;
			}
		}
		for(int i = 0; i<N;i++)
		{
			for(int j = 0; j<N;j++)
			{
				System.out.print(myArrayTwo[j][i]+" ");
			}
			System.out.println();
		}
	}
	public static void oneeightydegrees(int[][]myArray,int[][]myArrayTwo,int N)
	{
		int t = N;
		for(int i = 0; i<N; i++)
		{
			for(int j= 0; j<N;j++)
			{
				myArrayTwo[j][i]=myArray[t][t];
				t =t-1;
			}
		}
		for(int i = 0; i<N;i++)
		{
			for(int j = 0; j<N;j++)
			{
				System.out.print(myArrayTwo[j][i]+" ");
			}
			System.out.println();
		}
	}
	public static void print(int[][]myArray,int N)
	{
		int oneCol = 0, oneRow = 0;
		for(int i=0;i<N;i++)
		{
			for(int j= 0;j<N;j++)
			{
				if(myArray[j][i]==1)
				{
					oneCol = i;
					oneRow = j;
				}
			}
		}
		int myArrayTwo [][] = new int[N][N];
		
		if(oneCol == N)
		{
			if(oneRow == N)
			{
				oneeightydegrees(myArray,myArrayTwo,N);
				
			}
			else if(oneRow == 0)
			{
				ninetydegrees(myArray,myArrayTwo,N);
			}
		}
		else if(oneCol==0)
		{
			if(oneRow==0)
			{
				for(int i = 0; i<N;i++)
				{
				for(int j = 0; j<N;j++)
				{
					System.out.print(myArray[j][i]+" ");
				}
				System.out.println();
			}
			}
			else if(oneRow == N)
			{
				twoseventydegrees(myArray,myArrayTwo,N);
				
			}
		}
		
		
		
	}
	
	
	public static boolean rows(int[][]myArray, int N)
	{
		boolean flipped;
		for(int i = 0; i<N; i++)
		{

			for(int j = 0; j<(N-1); j++)
			{
				int one = 0, two = 0;
				one=myArray[j][i];
				two=myArray[j+1][i];
				if(one>two)
				{
					flipped= true;
				}
			}
		}
		flipped = false;
		return flipped;

	}
	public static boolean firstColumn(int[][] myArray, int N)
	{
		boolean flipped;
		int a = 0, b=0;
		for(int k = 0;k<(N-1);k++)
		{
			a=myArray[k][0];
			b=myArray[k+1][0];

			if(a>b)
			{
				flipped = true;
			}
		}
		flipped = false;
		return flipped;
	}
	public static boolean contains(int[][] arr, int item, int N) {
		for (int i = 0; i<N; i++) 
		{
			for(int j= 0; j<N; j++)
			{
				int n=arr[j][i];
				if (item == n) {
					return true;
				}
			}
		}
		return false;
	}
}
