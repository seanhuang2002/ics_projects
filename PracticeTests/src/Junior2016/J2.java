package Junior2016;

import java.util.Scanner;

public class J2 {

	public static void main(String[] args) 
	{
		Scanner pen = new Scanner(System.in);
		int col=0,row=0;
		int[][] magicNumbers = new int[4][4];
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				magicNumbers[i][j]=pen.nextInt();	
			}
			pen.nextLine();
		}
		pen.close();
		for(int i=0;i<4;i++)
		{
			
		}
		/*for(int i=0;i<4;i++)
		{
			row=row+magicNumbers[0][i];
		}
		for(int i=0;i<4;i++)
		{
			row1=row+magicNumbers[1][i];
		}
		for(int i=0;i<4;i++)
		{
			row2=row+magicNumbers[1][i];
		}*/
		
		
	}

}
