import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class date {

	public static void main(String[] args) {
		Scanner pen = new Scanner(System.in);
		String input;
		System.out.println("Please enter the date");
		input = pen.nextLine();
		pen.close();
		int firstSpace = 0, dateLength = 0;
		for(int i=0;i<input.length(); i++)
		{
			if(input.charAt(i)==' ' && firstSpace==0)
			{
				firstSpace=i;
				break;
			}
		}
		if(firstSpace==1)
		{
			dateLength=1;
		}
		Pattern dateOne = Pattern.compile("\\d{"+ dateLength +"}+\\s+\\d{2}+\\s+\\d{4}", Pattern.CASE_INSENSITIVE);
		Matcher matcherOne = dateOne.matcher(input);
		Pattern dateTwo = Pattern.compile("\\d{"+ dateLength +"}+\\s+(\\w+)+\\s+\\d{4}", Pattern.CASE_INSENSITIVE);
		Matcher matcherTwo = dateTwo.matcher(input);
		if(matcherOne.matches())
		{
			System.out.println(input);
		}
		else if(matcherTwo.matches())
		{
			String output = dateFormatter(input, determineDate(input));
			System.out.println("Your properly formatted date is: " +output);
		}
		else
		{
			System.out.println("Please input a date in 'DD MonthInWords YYYY' format");
		}
	}
	public static int determineDate(String a)
	{
		int firstSpace = 0, secondSpace = 0, monthNum = 0;
		for(int i=0;i<a.length(); i++)
		{
			if(a.charAt(i)==' ' && firstSpace==0)
			{
				firstSpace=i;
			}
			else if(a.charAt(i)==' ')
			{
				secondSpace=i;
			}
		}
		String month = a.substring(firstSpace+1, secondSpace);
		switch(month)
		{
		case "january":
			monthNum=1;
			break;
		case "february":
			monthNum=2;
			break;
		case "march":
			monthNum=3;
			break;
		case "april":
			monthNum=4;
			break;
		case "may":
			monthNum=5;
			break;
		case "june":
			monthNum=6;
			break;
		case "july":
			monthNum=7;
			break;
		case "august":
			monthNum=8;
			break;
		case "september":
			monthNum=9;
			break;
		case "october":
			monthNum=10;
			break;
		case "november":
			monthNum=11;
			break;
		case "december":
			monthNum=12;
			break;
		}
		return monthNum;
		
	}
	public static String dateFormatter(String a, int b)
	{
		String date = null, month;
		int firstSpace = 0, secondSpace = 0;
		for(int i=0;i<a.length();i++)
		{
			if(a.charAt(i)==' ' && firstSpace==0)
			{
				firstSpace=i;
			}
			else if(a.charAt(i)==' ')
			{
				secondSpace=i;
			}
		}
		String day = a.toString().substring(0,firstSpace);
		String year = a.toString().substring(secondSpace+1, a.length());
		month = Integer.toString(b);
		if(month.length()==2);
		else if(month.length()==1)
		{
			month = "0" + month;
		}
		if(a.charAt(2)==' ')
			date = day + "/" + month + "/" + year;
		else if(a.charAt(1)==' ')
			date = "0" + day + "/" + month + "/" + year;
		return date;
	}

}
