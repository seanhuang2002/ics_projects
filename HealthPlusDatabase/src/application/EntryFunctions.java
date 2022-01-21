package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EntryFunctions {
	// id,month,day,year,height,weight,waist,bodyfat,sys,dia,bloodsugar,heartrate,bmi
	
	public static void insertEntry(String day,String month,String year,String height,String weight,String waist,String bodyFat,
			String sys,String dia,String bloodSugar,String heartRate,String BMI) throws ClassNotFoundException, SQLException
	{
		String sql="insert into HealthPlus(Month,Day,Year,Height,Weight,Waist,BodyFat,Sys,Dia,BloodSugar,HeartRate,BMI) "
				+ "values('"+month+"','"+day+"','"+year+"','"+height+"','"+weight+"','"+waist+"','"+bodyFat+"','"+sys+"','"+dia+"','"+bloodSugar+"','"+heartRate+"','"+BMI+"')";
		try
		{
			DbUtilitaires.dbExecuteQuery(sql);
		}
		catch(SQLException e)
		{
			System.out.println("Submition error:" + e);
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void updateEntry(int ID, String day,String month,String year,String height,String weight,String waist,String bodyFat,
			String sys,String dia,String bloodSugar,String heartRate,String BMI) throws ClassNotFoundException, SQLException
	{
		//TODO Make database with all these names
		String sql="update HealthPlus set Day='"+day+"', Month='"+month+"', Year='"+year+"', Height='"+height+"', Weight='"+weight+"', Waist='"+waist+"', BodyFat='"+bodyFat+"' "
				+ ", Sys='"+sys+"', Dia='"+dia+"', BloodSugar='"+bloodSugar+"', HeartRate='"+heartRate+"', BMI='"+BMI+"'where ID= "+ ID;
		
		try
		{
			DbUtilitaires.dbExecuteQuery(sql);
		}
		catch(SQLException e)
		{
			System.out.println("Update Error");
			e.printStackTrace();
			throw e;
		}
	}

	public static void deleteEntryById(int id) throws ClassNotFoundException, SQLException
	{
		String sql="delete from HealthPlus where ID= "+ id;
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

	public static ObservableList<Entry> getAllEntries() throws ClassNotFoundException, SQLException
	{
		String sql="select * from HealthPlus";
		try
		{
			ResultSet rsSet=DbUtilitaires.dbExecute(sql);
			ObservableList<Entry> EntryList=getEntryObjects(rsSet);
			return EntryList;
		}
		catch(SQLException e)
		{
			System.out.println("Error A when getting all entries:"+e);
			e.printStackTrace();
			throw e;
		}
	}
	
	public static ObservableList<Entry> getEntryObjects(ResultSet rsSet) throws ClassNotFoundException, SQLException
	{
		try
		{
			ObservableList<Entry> EntryList=FXCollections.observableArrayList();
			while(rsSet.next())
			{
				Entry entry=new Entry(rsSet.getString("Month"),rsSet.getString("Day"),rsSet.getString("Year"));
				entry.setHeight(rsSet.getString("Height"));
				entry.setWeight(rsSet.getString("Weight"));
				entry.setWaist(rsSet.getString("Waist"));
				entry.setBodyFat(rsSet.getString("BodyFat"));
				entry.setBloodSugar(rsSet.getString("BloodSugar"));
				entry.setSys(rsSet.getString("Sys"));
				entry.setDia(rsSet.getString("Dia"));
				entry.setHeartRate(rsSet.getString("HeartRate"));
				entry.setBmi(rsSet.getString("BMI"));
				entry.setId(rsSet.getInt("ID"));
				EntryList.add(entry);
			}
			return EntryList;
		}
		catch(SQLException e)
		{
			System.out.println("Error B when getting all entries:"+ e);
			e.printStackTrace();
			throw e;
		}
	}
	
	public static ObservableList<Entry> searchEntries(String entryID) throws ClassNotFoundException, SQLException
	{
		String sql="select * from HealthPlus where id="+entryID;
		try
		{
		 ResultSet rsSet=DbUtilitaires.dbExecute(sql)	;
		 ObservableList<Entry> list=getEntryObjects(rsSet);
		 return list;
		}
		catch(SQLException e)
		{
			System.out.println("Error while searching for entry:" +e);
			e.printStackTrace();
			throw e;
		}
	}
}
