import java.util.ArrayList;
import java.util.Scanner;

public class S5 {

	public static void main(String[] args) {
		Scanner pen = new Scanner(System.in);
		int N=pen.nextInt();
		pen.nextLine();
		String input=pen.nextLine();
		ArrayList<Integer> num = new ArrayList();
		list(input,num, N);
	}
	
	public static void list(String input,ArrayList<Integer>num, int N)//Puts it in a list and finds number of menu items
	{
		int numCount=0, spaceIndex=0, M=0;
		for(int i=0; i<input.length();i++)
		{
			char chara = input.charAt(i);
			if(i==0&&chara==' ')
			{
				int x=Integer.parseInt(input.substring(0, i));
				num.add(x);
				spaceIndex=i;
				numCount++;
				M=x;
			}
			else if(chara==' ')
			{
				int x=Integer.parseInt(input.substring(spaceIndex+1, i));
				num.add(x);
				spaceIndex=i;
				numCount++;
				if(x>M)
				{
					M=x;
				}
			}
			else if(numCount==(N-1))
			{
				int x=Integer.parseInt(input.substring(spaceIndex+1));
				num.add(x);
				if(x>M)
				{
					M=x;
				}
			}
		}
	}
}