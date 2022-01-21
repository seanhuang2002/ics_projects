import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class aPrinter {
	public static void main(String[] args){
		String filename = "mesvoyelles.txt";
		FileReader ficALire;
		BufferedReader entree;
		FileWriter writer;
		PrintWriter output;
		char c;
		try{
			ficALire = new FileReader("monFichier.txt");
			entree = new BufferedReader(ficALire);
			writer = new FileWriter(filename);
			output = new PrintWriter(writer);
			for(int q = 0; q<250; q++){
				c = (char)entree.read();
				if(c=='a'||c=='i'||c=='u'||c=='e'||c=='o')
				{
					output.print(c);
				} 
			}
			entree.close();
			ficALire.close();
			output.close();
			writer.close();
		} catch (FileNotFoundException fnf){
			System.out.println("Erreur, le fichier ne peut pas être lu !:" + fnf);
		} catch (IOException ioe) {
			System.out.println("Erreur d'entrée/sortie !:" + ioe);
		}
	}
}
