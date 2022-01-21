package adress.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import adress.util.LocalDateAdapter;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Member 
{	
	private final StringProperty prenom;
	private final StringProperty nom;
	private final StringProperty rue;
	private final StringProperty ville;
	private final StringProperty codepostal;
	private final StringProperty telephone;
	private final StringProperty email;
	private final ObjectProperty<LocalDate> anniversaire;
	
	//Constructeur par défaut
	public Member()
	{
		this(null,null);
	}
	//Constructeur pour les données initiales
	// @param prenom
	// @param nom
	public Member(String prenom, String nom)
	{
		this.prenom=new SimpleStringProperty(prenom);
		this.nom=new SimpleStringProperty(nom);
		//données initiales - seront données par défaut
		this.rue = new SimpleStringProperty("Larivière");
		this.codepostal= new SimpleStringProperty("H4L 3X3");
		this.ville= new SimpleStringProperty("Laval");
		this.telephone=new SimpleStringProperty("514 354 4423");
		this.email=new SimpleStringProperty("mccarthur@gmail.com");
		this.anniversaire= new SimpleObjectProperty<LocalDate>(LocalDate.of(2002, 2, 10));
	}
	//=====Prenom=====
	public String getPrenom()
	{
		return prenom.get();
	}
	public void setPrenom(String prenom)
	{
		this.prenom.set(prenom);
	}
	public StringProperty prenomProperty()
	{
		return prenom;
	}
	//=====Nom=====
	public String getNom()
	{
		return nom.get();
	}
	public void setNom(String nom)
	{
		this.nom.set(nom);
	}
	public StringProperty nomProperty()
	{
		return nom;
	}
	//=====Rue=====
	public String getRue()
	{
		return rue.get();
	}
	public void setRue(String rue)
	{
		this.rue.set(rue);
	}
	public StringProperty rueProperty()
	{
		return rue;
	}
	//=====CodePostale=====
	public String getCodePostal()
	{
		return codepostal.get();
	}
	public void setCodePostal(String codepostal)
	{
		this.codepostal.set(codepostal);
	}
	public StringProperty CodePostalProperty()
	{
		return codepostal;
	}
	//=====ville=====
	public String getVille()
	{
		return ville.get();
	}
	public void setVille(String ville)
	{
		this.ville.set(ville);
	}
	public StringProperty VilleProperty()
	{
		return ville;
	}
	//=====telephone=====
	public String getTelephone()
	{
		return telephone.get();
	}
	public void setTelephone(String telephone)
	{
		this.telephone.set(telephone);
	}
	public StringProperty TelephoneProperty()
	{
		return telephone;
	}
	//=====email=====
	public String getEmail()
	{
		return email.get();
	}
	public void setEmail(String email)
	{
		this.email.set(email);
	}
	public StringProperty EmailProperty()
	{
		return email;
	}
	//=====anniversaire=====
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getAnniversaire()
	{
		return anniversaire.get();
	}
	public void setAnniversaire(LocalDate anniversaire)
	{
		this.anniversaire.set(anniversaire);
	}
	public ObjectProperty<LocalDate> AnniversaireProperty()
	{
		return anniversaire;
	}
}
