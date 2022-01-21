package application;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class RecipesDAO
{
	public static void insertRecipe(String Quantity, String Ingredient, String Measurement, String Description) throws ClassNotFoundException, SQLException
	{
		String sql="insert into Recipes(Quantity,Ingredient,Measurement, Description) values('"+Quantity+"','"+Ingredient+"','"+Measurement+"','"+Description+"')";
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
	public static void updateRecipe(int ID, String Quantity, String Ingredient, String Measurement, String Description) throws ClassNotFoundException, SQLException
	{
		String sql="update Recipes set Quantity='"+Quantity+"', Ingredient='"+Ingredient+"', Measurement='"+Measurement+"', Description='"+Description+"' where ID= "+ ID;
		
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
	public static void deleteRecipeById(int id) throws ClassNotFoundException, SQLException
	{
		String sql="delete from Recipes where ID= "+ id;
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
	public static ObservableList<Recipes> getAllRecords() throws ClassNotFoundException, SQLException
	{
		String sql="select * from Recipes";
		try
		{
			ResultSet rsSet=DbUtilitaires.dbExecute(sql);
			ObservableList<Recipes> RecipesList=getRecipesObjects(rsSet);
			return RecipesList;
		}
		catch(SQLException e)
		{
			System.out.println("Erreur lors de la recupération de données à afficher"+e);
			e.printStackTrace();
			throw e;
		}
		
	}
	private static ObservableList<Recipes> getRecipesObjects(ResultSet rsSet) throws ClassNotFoundException, SQLException
	{
		try
		{
			ObservableList<Recipes> RecipesList=FXCollections.observableArrayList();
			while(rsSet.next())
			{
				Recipes recipe=new Recipes();
				recipe.setId(rsSet.getInt("id"));
				recipe.setQuantity(rsSet.getInt("Quantity"));
				recipe.ingredient(rsSet.getString("Ingredient"));
				recipe.setMeasurement(rsSet.getInt("Measurement"));
				recipe.setDescription(rsSet.getString("Description"));
				RecipesList.add(recipe);
			}
			return RecipesList;
		}
		catch(SQLException e)
		{
			System.out.println("Erreur au monent de l'affichage de données "+ e);
			e.printStackTrace();
			throw e;
		}
	}
	public static ObservableList<Recipes> searchRecipe(String recipeId) throws ClassNotFoundException, SQLException
	{
		String sql="select * from Recipes where id="+recipeId;
		try
		{
		 ResultSet rsSet=DbUtilitaires.dbExecute(sql)	;
		 ObservableList<Recipes> list=getRecipesObjects(rsSet);
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


