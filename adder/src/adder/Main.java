package adder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
            File fileName = new File("myfile.txt");         
            Scanner inFile = new Scanner(fileName);
            System.out.println();
             int sum=0;        
            while (inFile.hasNext())         
            {         
                 sum+= inFile.nextInt( );     
            } 
            System.out.println(sum);
          inFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
