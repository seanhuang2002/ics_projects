package application;

import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		Scanner pen=new Scanner(System.in);
		String NK = pen.nextLine(), scoresString=pen.nextLine();
		int n=findNK(NK, true),k=findNK(NK, false);
		int[] scores=new int[n];
		insertScores(scoresString,scores);
	}
	
	public static void insertScores(String input, int[] scores)
	{
		int spaceIndex=0,scoreIndex=0;
		input=input+" ";
		for(int i=0;i<input.length();i++)
		{
			char chara=input.charAt(i);
			if(chara==' '&&spaceIndex==0)
			{
				spaceIndex=i;
				scores[scoreIndex]=Integer.parseInt(input.substring(0,i));
				scoreIndex++;
			}
			else if(chara==' ')
			{
				spaceIndex=i;
				scores[scoreIndex]=Integer.parseInt(input.substring(spaceIndex+1,i));
				scoreIndex++;
			}
		}
	}
	
	public static int findNK(String input, boolean n)
	{
		int spaceIndex=0;
		for(int i=0;i<input.length();i++)
		{
			char chara=input.charAt(i);
			if(chara==' ')
			{
				spaceIndex=i;
			}
		}
		if(n)
		{
			return Integer.parseInt(input.substring(0,spaceIndex));
		}
		else
		{
			return Integer.parseInt(input.substring(spaceIndex+1));
		}
	}
	
}
