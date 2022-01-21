import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class sin {

	public static void main(String[] args) {
		String input;
		Scanner pen = new Scanner(System.in);
		System.out.println("Write your Social Insurance Number:");
		input=pen.nextLine();
		Pattern sinPattern = Pattern.compile("\\d{3}+\\s+\\d{3}+\\s+\\d{3}");
		Matcher matcher = sinPattern.matcher(input);
		if(matcher.matches())
		{
			System.out.println("The input is a valid SIN.");
		}
	}

}
