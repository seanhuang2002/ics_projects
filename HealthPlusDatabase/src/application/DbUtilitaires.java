package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

public class DbUtilitaires {

	private static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	private static Connection connection=null;
	private static final String connStr="jdbc:mysql://lessonplus.com:3306/lessonpl_sean?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	/*===================================================================
	 * Paramètres de connexion à la base de données en utilisant JDBC
	 * ===================================================================
	 */

	public static void dbConnect() throws SQLException,ClassNotFoundException
	{
		try
		{
			Class.forName(JDBC_DRIVER);
		}catch(ClassNotFoundException e)
		{
			System.out.println("MySQL Class not found");
			e.printStackTrace();
			throw e;
		}
		//confirmation
		//System.out.println("Le pilote jdbc a été trouvé");

		try {
			connection=DriverManager.getConnection(connStr, "lessonpl_sean", "seanTFS123!");
		}
		catch(SQLException e)
		{
			System.out.println("Connection failed: " +e);
			throw e;
		}
	}
	/*===================================================================
	 * Fermeture de la connection si elle est ouverte
	 * ===================================================================
	 */
	public static void dbDisconnect() throws SQLException
	{
		try
		{
			if(connection != null && !connection.isClosed())
			{
				connection.close();
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	/*===================================================================
	 * Ajouter , Modifier, Effacer
	 * ===================================================================
	 */
	public static void dbExecuteQuery(String sqlStmt) throws SQLException, ClassNotFoundException
	{
		Statement stmt=null;
		try
		{
			dbConnect();
			stmt=connection.createStatement();
			stmt.executeUpdate(sqlStmt);
		}catch(SQLException e)
		{
			System.out.println("Request execution error:"+ e);
			throw e;
		}
		finally {
			if(stmt!=null)
				stmt.close();
		}
		dbDisconnect();
	}

	//Lire et afficher de la BD
	public static ResultSet dbExecute(String sqlQuery) throws ClassNotFoundException, SQLException
	{
		Statement stmt=null;
		ResultSet rs=null;
		CachedRowSet crs=null;

		try
		{
			dbConnect();
			stmt=connection.createStatement();
			rs=stmt.executeQuery(sqlQuery); 

			crs=new CachedRowSetImpl();
			crs.populate(rs);

		}catch(SQLException e)
		{
			System.out.println("dbExecute request error:" + e);
			throw e;
		}
		finally 
		{
			if(rs !=null)
			{
				rs.close();

			}
			if(stmt !=null)
			{
				stmt.close();
			} 

			dbDisconnect();
		}
		return crs; 
	}

}