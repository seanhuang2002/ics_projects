import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class aReader {

	public static void main(String[] args)
	{
		FileReader ficALire;
		BufferedReader entree;
		char c;
		int number = 0;
		try{
			ficALire = new FileReader("monFichier.txt");
			entree = new BufferedReader(ficALire);
			for(int q = 0; q<250; q++){
				c = (char)entree.read();
				if(c=='a'||c=='i'||c=='u'||c=='e'||c=='o')
				{
					System.out.print(c);
				} 
			}
			entree.close();
			ficALire.close();
			System.out.println("Le nombre de caractères 'a' dans le fichier est : " +number);
		} catch (FileNotFoundException fnf){
			System.out.println("Erreur, le fichier ne peut pas être lu !:" + fnf);
		} catch (IOException ioe) {
			System.out.println("Erreur d'entrée/sortie !:" + ioe);
		}

	}

}
