package com.tfs.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Effacer {
	
	public static void main(String[] args) throws Exception{
		try {
			String myDriver ="com.mysql.cj.jdbc.Driver";
			String myUrl = "jdbc:mysql://lessonplus.com:3306/lessonpl_sean?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
			String myUser = "lessonpl_sean";
			String myPass = "seanTFS123!";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl,myUser,myPass);
			
			Statement st = conn.createStatement();
			st.executeUpdate("Delete from Persons where ID= 2");
			conn.close();
		} catch (Exception e) {
			System.err.println("Erreur à l'insertion");
			e.printStackTrace();
		}
		System.out.println("Succes, usager effacé");
	}
}
