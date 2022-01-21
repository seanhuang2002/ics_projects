package junior2013;

import java.util.Scanner;

public class J2 {

	public static void main(String[] args) {
		Scanner pen = new Scanner(System.in);
		String input = pen.nextLine();
		String nathalie= null;
		for (int i = 0; i<input.length(); i++ )
		{
			char letter = input.charAt(i);
			if(letter=='I'||letter=='O'||letter=='S'||letter=='H'||letter=='Z'||letter=='X'||letter=='N')
			{
				nathalie="Yes";
			}
			else if(letter!='I'||letter!='O'||letter!='S'||letter!='H'||letter!='Z'||letter!='X'||letter!='N')
			{
				nathalie="No";
				break;
			}
			
		}
		if(nathalie.equals("No"))
			System.out.println("NO");
		if(nathalie.equals("Yes"))
			System.out.println("YES");

	}

}
