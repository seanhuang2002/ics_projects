import java.util.Scanner;

/*
 * Author : seanhuang
 * Date : Sep 26, 2017
 */

public class TriangleMaker 
{
	public static void main(String [] args)
	{
		// p is the number of characters in the first line
		// i is the number of layers of characters minus 1 (example. i=5 has four layers of characters)
		System.out.println("Welcome to the triangle maker!");
		System.out.println();
		System.out.println("If you would like proceed with this program:");
		System.out.println("     Please input either '1' and press enter if you would like to create a triange.");
		System.out.println("     Of if you would not like to create a triangle, please input '2'.");
		System.out.println("Please input your choise below and press enter.");
		System.out.println();
		Scanner YesOrNoInput = new Scanner(System.in);
		int YesOrNo = YesOrNoInput.nextInt();
		if (YesOrNo == 1)
		{
			System.out.println();
			System.out.println("Please input which direction you would like to point the triangle.");
			System.out.println("     Input 1 if you would like the triangle to point up.");
			System.out.println("     Input 2 if you would like the triangle to point down.");
			System.out.println("Please input you choise below and press enter.");
			System.out.println();


			Scanner UpOrDownInput = new Scanner(System.in);
			int UpOrDown = UpOrDownInput.nextInt();
			if (UpOrDown == 1)
			{
				int p = 0;
				System.out.println("Please input the number of layers you would like in your triangle below and press enter.");
				System.out.println();
				Scanner numLayerInput = new Scanner(System.in);
				int numLayer = numLayerInput.nextInt();
				int i=numLayer;
				for(i++;i>0;i--)
				{
					for(int j=0;j<i;j++)
					{
						System.out.print(" ");
					}
					for(int j=0;j<p;j++)
					{
						System.out.print(" *");
					}
					System.out.println();
					p++;
				}
				System.out.println();
				System.out.println("Have a nice day!");
				UpOrDownInput.close();
				numLayerInput.close();
			}
			else
				System.out.println("Please input the number of layesr you would like in your triangle below and press enter.");
			System.out.println();
			Scanner numLayerInput = new Scanner(System.in);
			int numLayer = numLayerInput.nextInt();
			int k=numLayer, p=numLayer, z =numLayer+1;

			for(k++;k>0;k--)
			{
				for(int j=z;j>k;j--)
				{
					System.out.print(" ");
				}
				for(int j=0;j<p;j++)
				{
					System.out.print(" *");
				}
				System.out.println();
				p--;
			}
			System.out.println();
			System.out.println("Have a nice day!");
			numLayerInput.close();
		}
		else
		{
			System.out.println("Have a nice day!");
			YesOrNoInput.close();
		}

	}


}