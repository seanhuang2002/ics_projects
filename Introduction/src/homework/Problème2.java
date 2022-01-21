/*
 * Author: shuang
 * Date: Nov 15, 2017
 */

package homework;
import java.util.Scanner;
public class Problème2 
{
	public static void main(String[] args)
	{
		int N,k;
		double result = 0;
		Scanner pen = new Scanner(System.in );
		N=pen.nextInt();
		pen.nextLine();
		k=pen.nextInt();
		pen.nextLine();
		double powers[];
		powers = new double[k+1];
		powers[0]=N;
		for (int i =1; i <= k; i++ )
		{
			double t = Math.pow(10,i);
			double j = N*t;
			powers[i]=j;
		}
		for (int i = 0;i <= k;i++)
		{
			result = result + powers[i];
		}
		System.out.println(result);
		pen.close();
	}
}
