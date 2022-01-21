import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Example1 {
	
	public static void main(String[] args)
	{
		FileReader ficALire;
		BufferedReader entree;
		char c;
		try{
			ficALire = new FileReader("monFichier.txt");
			entree = new BufferedReader(ficALire);
			c = (char)entree.read();
			System.out.println(c);
			c = (char)entree.read();
			System.out.println(c);
			entree.close();
			ficALire.close();
		} catch (FileNotFoundException fnf){
			System.out.println("Erreur, le fichier ne peut pas être lu !:" + fnf);
		} catch (IOException ioe) {
			System.out.println("Erreur d'entrée/sortie !:" + ioe);
		}
		
	}
	

}
