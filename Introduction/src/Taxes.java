import java.util.Scanner;

/*
 * Author : shuang
 * Date : Sep 27, 2017
 */

public class Taxes
{
	public static void main(String[] args) 
	{
		String nomPersonnel;
		int sexePersonnel;

		//One Scanner only!!!

		System.out.println("Bonjour Monsieur/Madame, cette programme va calculer vos impôts personnels à payer au gouvernement.");
		System.out.println("On va vous calculer vos impôt, vous devez simplement imputer quelques donners.");

		Scanner nomPersonnelInput = new Scanner(System.in);
		//nomPersonnelInput est le variable qui est le nom de l'usagé
		Scanner sexePersonnelInput = new Scanner(System.in);
		//sexePersonnelInput est le variable qui est le sexe de l'usagé

		System.out.println("Inputez s'il vous plait votre sexe et ensuite votre nom au complet");
		System.out.println("Mode d'emploi pour inputer: ecrivez ce qui est demandé et puis appuyez sur le bouton 'return' ou 'enter'.");
		System.out.println("Sexe (1 pour les hommes et 2 pour les femmes):");
		sexePersonnel = sexePersonnelInput.nextInt();
		if (sexePersonnel == 1)
		{
			double salairePersonnel, contributionPersonnel;

			System.out.println("Bonjour Monsieur.");
			System.out.println("Imputez maintenant votre nom.");
			nomPersonnel = nomPersonnelInput.nextLine();
			System.out.println("Bonjour" +nomPersonnel+ ".");
			System.out.println("Imputez votre salaire s'il vous plait.");
			Scanner salairePersonnelInput = new Scanner(System.in);
			salairePersonnel = salairePersonnelInput.nextDouble();
			System.out.println("Votre salaire est de "+salairePersonnel+" dollars.");
			System.out.println("Imputez vos contributions de charité.");
			Scanner contributionPersonnelInput = new Scanner(System.in);
			contributionPersonnel=contributionPersonnelInput.nextDouble();
			System.out.println("Votre contribution de charité est de "+contributionPersonnel+" dollars.");
			System.out.println("On va maintenant faire les calculations.");
			if (salairePersonnel < 20000)
			{
				double salaireTaxable;
				double Impôts = salairePersonnel*0.05;
				if (contributionPersonnel > salairePersonnel*0.4)
				{
					salaireTaxable = salairePersonnel - contributionPersonnel*0.4;
				}
				else 
				{
					salaireTaxable = salairePersonnel - contributionPersonnel;
				}
				if (sexePersonnel == 1)
				{
					System.out.println("Monsieur "+nomPersonnel+ ", merci d'avoir produit votre déclaration de revenus. D'après les informations fournie, nous avons calculé votre impôt de la manière suivante:" );
					System.out.println("Revenu Brut: $" +salairePersonnel);
					System.out.println("Contributions don de charité: $"+contributionPersonnel);
					System.out.println("Impôt à payer: $" +Impôts);
					System.out.println();
					System.out.println("Merci d'avoir utilisé cette programme.");

				}
			}
			if (salairePersonnel > 20000 && salairePersonnel < 30000)
			{
				double salaireTaxable;
				double Impôts = salairePersonnel*0.1;
				if (contributionPersonnel > salairePersonnel*0.4)
				{
					salaireTaxable = salairePersonnel - contributionPersonnel*0.4;
				}
				else 
				{
					salaireTaxable = salairePersonnel - contributionPersonnel;
				}
				if (sexePersonnel == 1)
				{
					System.out.println("Monsieur "+nomPersonnel+ ", merci d'avoir produit votre déclaration de revenus. D'après les informations fournie, nous avons calculé votre impôt de la manière suivante:" );
					System.out.println("Revenu Brut: $" +salairePersonnel);
					System.out.println("Contributions don de charité: $"+contributionPersonnel);
					System.out.println("Impôt à payer: $" +Impôts);
					System.out.println();
					System.out.println("Merci d'avoir utilisé cette programme.");
				}

			}
			if (salairePersonnel > 30000 && salairePersonnel < 50000)
			{
				double salaireTaxable;
				double Impôts = salairePersonnel*0.2;
				if (contributionPersonnel > salairePersonnel*0.4)
				{
					salaireTaxable = salairePersonnel - contributionPersonnel*0.4;
				}
				else 
				{
					salaireTaxable = salairePersonnel - contributionPersonnel;
				}
				if (sexePersonnel == 1)
				{
					System.out.println("Monsieur "+nomPersonnel+ ", merci d'avoir produit votre déclaration de revenus. D'après les informations fournie, nous avons calculé votre impôt de la manière suivante:" );
					System.out.println("Revenu Brut: $" +salairePersonnel);
					System.out.println("Contributions don de charité: $"+contributionPersonnel);
					System.out.println("Impôt à payer: $" +Impôts);
					System.out.println();
					System.out.println("Merci d'avoir utilisé cette programme.");
				}

			}
			if (salairePersonnel > 50000 && salairePersonnel < 100000)
			{
				double salaireTaxable;
				double Impôts = salairePersonnel*0.3;
				if (contributionPersonnel > salairePersonnel*0.4)
				{
					salaireTaxable = salairePersonnel - contributionPersonnel*0.4;
				}
				else 
				{
					salaireTaxable = salairePersonnel - contributionPersonnel;
				}
				if (sexePersonnel == 1)
				{
					System.out.println("Monsieur "+nomPersonnel+ ", merci d'avoir produit votre déclaration de revenus. D'après les informations fournie, nous avons calculé votre impôt de la manière suivante:" );
					System.out.println("Revenu Brut: $" +salairePersonnel);
					System.out.println("Contributions don de charité: $"+contributionPersonnel);
					System.out.println("Impôt à payer: $" +Impôts);
					System.out.println();
					System.out.println("Merci d'avoir utilisé cette programme.");
				}

			}
			if (salairePersonnel > 100000)
			{
				double salaireTaxable;
				double Impôts = salairePersonnel*0.4;
				if (contributionPersonnel > salairePersonnel*0.4)
				{
					salaireTaxable = salairePersonnel - contributionPersonnel*0.4;
				}
				else 
				{
					salaireTaxable = salairePersonnel - contributionPersonnel;
				}
				if (sexePersonnel == 1)
				{
					System.out.println("Monsieur "+nomPersonnel+ ", merci d'avoir produit votre déclaration de revenus. D'après les informations fournie, nous avons calculé votre impôt de la manière suivante:" );
					System.out.println("Revenu Brut: $" +salairePersonnel);
					System.out.println("Contributions don de charité: $"+contributionPersonnel);
					System.out.println("Impôt à payer: $" +Impôts);
					System.out.println();
					System.out.println("Merci d'avoir utilisé cette programme.");
				}

			}

		}
		else
		{

			double salairePersonnel, contributionPersonnel;

			System.out.println("Bonjour Madame.");
			System.out.println("Imputez maintenant votre nom.");
			nomPersonnel = nomPersonnelInput.nextLine();
			System.out.println("Bonjour" +nomPersonnel+ ".");
			System.out.println("Imputez votre salaire s'il vous plait.");
			Scanner salairePersonnelInput = new Scanner(System.in);
			salairePersonnel = salairePersonnelInput.nextDouble();
			System.out.println("Votre salaire est de "+salairePersonnel+" dollars.");
			System.out.println("Imputez vos contributions de charité.");
			Scanner contributionPersonnelInput = new Scanner(System.in);
			contributionPersonnel=contributionPersonnelInput.nextDouble();
			System.out.println("Votre contribution de charité est de "+contributionPersonnel+" dollars.");
			System.out.println("On va maintenant faire les calculations.");
			if (salairePersonnel < 20000)
			{
				double salaireTaxable;
				double Impôts = salairePersonnel*0.05;
				if (contributionPersonnel > salairePersonnel*0.4)
				{
					salaireTaxable = salairePersonnel - contributionPersonnel*0.4;
				}
				else 
				{
					salaireTaxable = salairePersonnel - contributionPersonnel;
				}
				if (sexePersonnel == 1)
				{
					System.out.println("Madame "+nomPersonnel+ ", merci d'avoir produit votre déclaration de revenus. D'après les informations fournie, nous avons calculé votre impôt de la manière suivante:" );
					System.out.println("Revenu Brut: $" +salairePersonnel);
					System.out.println("Contributions don de charité: $"+contributionPersonnel);
					System.out.println("Impôt à payer: $" +Impôts);
					System.out.println();
					System.out.println("Merci d'avoir utilisé cette programme.");
				}

			}
			if (salairePersonnel > 20000 && salairePersonnel < 30000)
			{
				double salaireTaxable;
				double Impôts = salairePersonnel*0.1;
				if (contributionPersonnel > salairePersonnel*0.4)
				{
					salaireTaxable = salairePersonnel - contributionPersonnel*0.4;
				}
				else 
				{
					salaireTaxable = salairePersonnel - contributionPersonnel;
				}
				if (sexePersonnel == 1)
				{
					System.out.println("Madame "+nomPersonnel+ ", merci d'avoir produit votre déclaration de revenus. D'après les informations fournie, nous avons calculé votre impôt de la manière suivante:" );
					System.out.println("Revenu Brut: $" +salairePersonnel);
					System.out.println("Contributions don de charité: $"+contributionPersonnel);
					System.out.println("Impôt à payer: $" +Impôts);
					System.out.println();
					System.out.println("Merci d'avoir utilisé cette programme.");
				}

			}
			if (salairePersonnel > 30000 && salairePersonnel < 50000)
			{
				double salaireTaxable;
				double Impôts = salairePersonnel*0.2;
				if (contributionPersonnel > salairePersonnel*0.4)
				{
					salaireTaxable = salairePersonnel - contributionPersonnel*0.4;
				}
				else 
				{
					salaireTaxable = salairePersonnel - contributionPersonnel;
				}
				if (sexePersonnel == 1)
				{
					System.out.println("Madame "+nomPersonnel+ ", merci d'avoir produit votre déclaration de revenus. D'après les informations fournie, nous avons calculé votre impôt de la manière suivante:" );
					System.out.println("Revenu Brut: $" +salairePersonnel);
					System.out.println("Contributions don de charité: $"+contributionPersonnel);
					System.out.println("Impôt à payer: $" +Impôts);
					System.out.println();
					System.out.println("Merci d'avoir utilisé cette programme.");
				}

			}
			if (salairePersonnel > 50000 && salairePersonnel < 100000)
			{
				double salaireTaxable;
				double Impôts = salairePersonnel*0.3;
				if (contributionPersonnel > salairePersonnel*0.4)
				{
					salaireTaxable = salairePersonnel - contributionPersonnel*0.4;
				}
				else 
				{
					salaireTaxable = salairePersonnel - contributionPersonnel;
				}
				if (sexePersonnel == 1)
				{
					System.out.println("Madame "+nomPersonnel+ ", merci d'avoir produit votre déclaration de revenus. D'après les informations fournie, nous avons calculé votre impôt de la manière suivante:" );
					System.out.println("Revenu Brut: $" +salairePersonnel);
					System.out.println("Contributions don de charité: $"+contributionPersonnel);
					System.out.println("Impôt à payer: $" +Impôts);
					System.out.println();
					System.out.println("Merci d'avoir utilisé cette programme.");
				}

			}
			if (salairePersonnel > 100000)
			{
				double salaireTaxable;
				double Impôts = salairePersonnel*0.4;
				if (contributionPersonnel > salairePersonnel*0.4)
				{
					salaireTaxable = salairePersonnel - contributionPersonnel*0.4;
				}
				else 
				{
					salaireTaxable = salairePersonnel - contributionPersonnel;
				}
				if (sexePersonnel == 1)
				{
					System.out.println("Madame "+nomPersonnel+ ", merci d'avoir produit votre déclaration de revenus. D'après les informations fournie, nous avons calculé votre impôt de la manière suivante:" );
					System.out.println("Revenu Brut: $" +salairePersonnel);
					System.out.println("Contributions don de charité: $"+contributionPersonnel);
					System.out.println("Impôt à payer: $" +Impôts);
					System.out.println();
					System.out.println("Merci d'avoir utilisé cette programme.");
				}
			}
		}
	}
}
