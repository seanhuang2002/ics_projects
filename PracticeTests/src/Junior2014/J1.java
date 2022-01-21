package Junior2014;

import java.util.Scanner;

public class J1 {

	public static void main(String[] args) {
		Scanner pen = new Scanner(System.in);
		int first = pen.nextInt();
		pen.nextLine();
		int second = pen.nextInt();
		pen.nextLine();
		int third = pen.nextInt();
		pen.close();
		
		if(first+second+third != 180)
		System.out.println("Error");
		else if(first==60 && second==60 && third==60)
			System.out.println("Equilateral");
		else if(first==second && first!=third||third==second && third!=first||first==third && first!=second)
			System.out.println("Isosceles");
		else
			System.out.println("Scalene");
	}

}
