import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner pen = new Scanner(System.in);
		String input1 = pen.nextLine();
		String input2=pen.nextLine();
		int num=0, shortLength=input1.length(), stringLength=input2.length();
		List<String> listWithoutDuplicates = permutationFinder(input1).stream().distinct().collect(Collectors.toList());
		for(int i=0;i<listWithoutDuplicates.size();i++)
		{
			String insert = listWithoutDuplicates.get(i);
			for(int j=0;j<stringLength-shortLength+1;j++)
			{
				String read="";
					read=input2.substring(j,(j+shortLength));
				if(read.equals(insert))
				{
					num++;
					break;
				}
			}
		}
		System.out.println(num);
	}
	
	public static ArrayList<String> permutationFinder(String str) {
		ArrayList<String> perm = new ArrayList<String>();
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0);
        String rem = str.substring(1);
        ArrayList<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }
}
