package com.tfs;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class PersonsDAO 
{
	public static void insertPersons(String LastName, String FirstName, String Address, String PhoneNumber) throws ClassNotFoundException, SQLException
	{
		String sql="insert into Persons(LastName,FirstName,Address, PhoneNumber) values('"+LastName+"','"+FirstName+"','"+Address+"','"+PhoneNumber+"')";
		try
		{
			DbUtilitaires.dbExecuteQuery(sql);
		}
		catch(SQLException e)
		{
			System.out.println("Erreur à l'insertion de données " + e);
			e.printStackTrace();
			throw e;
		}
	}
	public static void updatePersons(int ID, String LastName, String FirstName, String Address, String PhoneNumber) throws ClassNotFoundException, SQLException
	{
		String sql="update Persons set LastName='"+LastName+"', FirstName='"+FirstName+"', Address='"+Address+"', PhoneNumber='"+PhoneNumber+"' where ID= "+ ID;
		
		try
		{
			DbUtilitaires.dbExecuteQuery(sql);
		}
		catch(SQLException e)
		{
			System.out.println("Erreur lors de la mise à jour");
			e.printStackTrace();
			throw e;
		}
		
	}
	public static void deletePersonById(int id) throws ClassNotFoundException, SQLException
	{
		String sql="delete from Persons where ID= "+ id;
		try
		{
			DbUtilitaires.dbExecuteQuery(sql);
		}
		catch(SQLException e)
		{
			System.out.println("Erreur lors de la suppression de données");
			e.printStackTrace();
			throw e;
		}
	}
	public static ObservableList<Persons> getAllRecords() throws ClassNotFoundException, SQLException
	{
		String sql="select * from Persons";
		try
		{
			ResultSet rsSet=DbUtilitaires.dbExecute(sql);
			ObservableList<Persons> PersonsList=getPersonsObjects(rsSet);
			return PersonsList;
		}
		catch(SQLException e)
		{
			System.out.println("Erreur lors de la recupération de données à afficher"+e);
			e.printStackTrace();
			throw e;
		}
		
	}
	private static ObservableList<Persons> getPersonsObjects(ResultSet rsSet) throws ClassNotFoundException, SQLException
	{
		try
		{
			ObservableList<Persons> PersonsList=FXCollections.observableArrayList();
			while(rsSet.next())
			{
				Persons person=new Persons();
				person.setId(rsSet.getInt("id"));
				person.setFirstName(rsSet.getString("firstName"));
				person.setLastName(rsSet.getString("lastName"));
				person.setAddress(rsSet.getString("Address"));
				person.setPhoneNumber(rsSet.getString("PhoneNumber"));
				PersonsList.add(person);
			}
			return PersonsList;
		}
		catch(SQLException e)
		{
			System.out.println("Erreur au monent de l'affichage de données "+ e);
			e.printStackTrace();
			throw e;
		}
	}
	public static ObservableList<Persons> searchPerson(String personId) throws ClassNotFoundException, SQLException
	{
		String sql="select * from Persons where id="+personId;
		try
		{
		 ResultSet rsSet=DbUtilitaires.dbExecute(sql)	;
		 ObservableList<Persons> list=getPersonsObjects(rsSet);
		 return list;
		}
		catch(SQLException e)
		{
			System.out.println("Erreur pendant la recherche de données " +e);
			e.printStackTrace();
			throw e;
		}
	}

}

