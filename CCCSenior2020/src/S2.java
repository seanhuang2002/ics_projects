import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class S2 {

	public static void main(String[] args) {
		Scanner pen = new Scanner(System.in);
		int M=pen.nextInt();
		pen.nextLine();
		int N=pen.nextInt();
		pen.nextLine();
		int[][] grid=new int[M+1][N+1];
		
		for(int i=0;i<(M);i++)
		{
			String input=pen.nextLine();
			int numRead=0, indexSpace=0;
			for(int j=0;j<input.length();j++)
			{
				
				char chara=input.charAt(j);
				if(indexSpace==0&&chara==' ')
				{
					grid[i+1][numRead+1]=Integer.parseInt(input.substring(0, j));
					numRead++;
					indexSpace=j;
				}
				else if(chara==' ')
				{
						grid[i+1][numRead+1]=Integer.parseInt(input.substring(indexSpace+1, j));
						numRead++;
						indexSpace=j;
				}
				else if(j==input.length()-1)
				{
					grid[i+1][numRead+1]=Integer.parseInt(input.substring(indexSpace+1));
					numRead=0;
					indexSpace=0;
				}
			}
		}
		
		int x=grid[1][1];
		
		
	}
	
	public static ArrayList<String> combos(int x, int M, int N)
	{
		ArrayList<String> possibilities= new ArrayList();
		for(int i=M;i>0;i--)
		{
			for(int j=N;j>0;j--)
			{
				if(i*j==x)
				{
					possibilities.add(i+" "+j);
				}
			}
		}
		return possibilities;
	}
}