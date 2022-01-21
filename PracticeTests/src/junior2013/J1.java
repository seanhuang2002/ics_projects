package junior2013;

import java.util.Scanner;

public class J1 
{
	
	public static void main(String[] args) 
	{
		Scanner pen = new Scanner(System.in);
		int one = pen.nextInt();
		pen.nextLine();
		int two = pen.nextInt();
		pen.nextLine();
		System.out.println(two+(two-one));
	}

}
