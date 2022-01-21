package com.tfs.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Lire {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://lessonplus.com:3306/lessonpl_sean?"
				+"zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "lessonpl_sean", "seanTFS123!");

		PreparedStatement statement=con.prepareStatement("select * from Persons");
		ResultSet result = statement.executeQuery();
		while(result.next())
		{
			System.out.println(result.getString("Id")+" "+result.getString("LastName")+ " "+result.getString("PhoneNumber"));
		}
		con.close();
	}

}