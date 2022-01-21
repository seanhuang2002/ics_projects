import java.util.Scanner;

public class S1 {

	public static void main(String[] args) {
		Scanner pen = new Scanner(System.in);
		int N=pen.nextInt();
		pen.nextLine();
		double[][] input=new double[N][2];
		for(int i=0;i<N;i++)
		{
			String in=pen.nextLine();
			for(int j=0;j<in.length();j++)
			{
				char chara=in.charAt(j);
				if(chara==' ')
				{
					input[i][0]=Double.parseDouble(in.substring(0,j));
					input[i][1]=Double.parseDouble(in.substring(j+1));
				}
			}
		}
		
		java.util.Arrays.sort(input, new java.util.Comparator<double[]>() {
		    public int compare(double[] a, double[] b) {
		        return Double.compare(a[0], b[0]);
		    }
		});
		double startingPosition=0;
		double startingTime = 0;
		double fastestSpeed = 0;
		for(int i=0;i<N;i++)
		{
			if(i==0)
			{
				startingPosition=input[0][1];
				startingTime=input[0][0];
			}
			else
			{
				double travelLength=input[i][1]-startingPosition;
				double travelTime=input[i][0]-startingTime;
				double travelSpeed=travelLength/travelTime;
				if(Math.abs(travelSpeed)>fastestSpeed)
				{
					fastestSpeed=Math.abs(Double.valueOf(travelSpeed));
				}
				startingTime=input[i][0];
				startingPosition=input[i][1];
			}
		}
		pen.close();
		System.out.println(fastestSpeed);
	}

}
