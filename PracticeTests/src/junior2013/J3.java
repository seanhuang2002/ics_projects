package junior2013;

import java.util.Scanner;

public class J3 {

	public static void main(String[] args) {
		Scanner pen = new Scanner(System.in);
		int year=pen.nextInt();
		String yearString = Integer.toString(year);
		int length = yearString.length();;
		int a=0, b=0, c=0, d=0;
		for(int i=0; i<length;i++)
		{
			yearString = Integer.toString(year);
			length = yearString.length();
			char num = yearString.charAt(i);
			if(i==0)
			{
				a=Character.getNumericValue(num);
			}
			if(i==1)
			{
				b=Character.getNumericValue(num);
				if(a==b)
				{
					year++;
				}
			}
			if(i==2)
			{
				c=Character.getNumericValue(num);
				if(a==c||b==c)
				{
					year++;
				}
			}
			if(i==3)
			{
				d=Character.getNumericValue(num);
				if(a==d||b==d||c==d)
				{
					year++;
				}
			}
		}

	}

}
