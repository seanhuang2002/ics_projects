package application;

import java.util.Scanner;

public class S3 {

	public static void main(String[] args)
	{
		Scanner pen = new Scanner(System.in);
		String input1=pen.nextLine();
		String[][] input = new String[3][3];
		input(input1, input);
		System.out.println(checkDone(input));
		
	}
	
	public static Boolean checkDone(String[][] input)
	{
		//a1 b1 c1 00 01 02
		//a2 b2 c2 10 11 12
		//a3 b3 c3 20 21 22
		int a=0,b=0,c=0,one=0,two=0,three=0;
		one=Integer.parseInt(input[0][1])-Integer.parseInt(input[0][0]);
		two=Integer.parseInt(input[1][1])-Integer.parseInt(input[1][0]);
		three=Integer.parseInt(input[2][1])-Integer.parseInt(input[2][0]);
		a=Integer.parseInt(input[0][0])-Integer.parseInt(input[1][0]);
		b=Integer.parseInt(input[0][1])-Integer.parseInt(input[1][1]);
		c=Integer.parseInt(input[0][2])-Integer.parseInt(input[1][2]);
		if((Integer.parseInt(input[0][2])-Integer.parseInt(input[0][1]))==one&&
				(Integer.parseInt(input[1][2])-Integer.parseInt(input[1][1]))==two&&
				(Integer.parseInt(input[2][2])-Integer.parseInt(input[2][1]))==three&&
				(Integer.parseInt(input[2][0])-Integer.parseInt(input[1][0]))==a&&
				(Integer.parseInt(input[2][1])-Integer.parseInt(input[1][1]))==b&&
				(Integer.parseInt(input[2][2])-Integer.parseInt(input[1][2]))==c)
		{
			return true;
		}
		return false;
	}
	
	public static void input(String input1, String[][] input)
	{
		int space=0;
		for(int i=0;i<input1.length();i++)
		{
			if(input1.charAt(i)==' '&& input[0][0]=="")
			{
				input[0][0]=input1.substring(0, i);
				space=i;
			}
			else if(input1.charAt(i)==' '&& input[0][0]!="")
			{
				input[0][1]=input1.substring(space+1,i);
				input[0][2]=input1.substring(i+1);
			}
		}
		for(int i=0;i<input1.length();i++)
		{
			if(input1.charAt(i)==' '&& input[1][0]=="")
			{
				input[1][0]=input1.substring(0, i);
				space=i;
			}
			else if(input1.charAt(i)==' '&& input[1][0]!="")
			{
				input[1][1]=input1.substring(space+1,i);
				input[1][2]=input1.substring(i+1);
			}
		}
		for(int i=0;i<input1.length();i++)
		{
			if(input1.charAt(i)==' '&& input[2][0]=="")
			{
				input[2][0]=input1.substring(0, i);
				space=i;
			}
			else if(input1.charAt(i)==' '&& input[2][0]!="")
			{
				input[2][1]=input1.substring(space+1,i);
				input[2][2]=input1.substring(i+1);
			}
		}
	}
}
