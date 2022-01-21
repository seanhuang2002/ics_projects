package application;

	import javafx.beans.property.IntegerProperty;
	import javafx.beans.property.SimpleIntegerProperty;
	import javafx.beans.property.SimpleStringProperty;
	import javafx.beans.property.StringProperty;

	public class Recipes {

		private IntegerProperty idProperty;
	    private IntegerProperty quantityProperty;
	    private StringProperty ingredientProperty;
	    private IntegerProperty measurementProperty;
	    private StringProperty descriptionProperty;

	    public Recipes() {
	    	this.idProperty = new SimpleIntegerProperty();
	        this.quantityProperty = new SimpleIntegerProperty();
	        this.ingredientProperty = new SimpleStringProperty();
	        this.measurementProperty = new SimpleIntegerProperty();
	        this.descriptionProperty= new SimpleStringProperty();
	    }

	   public int getId()
	   {
		   return idProperty.get();
	   }
	   public void setId(int id)
	   {
		   this.idProperty.set(id);
	   }
		
	    public IntegerProperty getPersonId() {
			return idProperty;
		}

		public void setIdProperty(IntegerProperty idProperty) {
			this.idProperty = idProperty;
		}
		//QUANTITY
		public int getQuantity()
		{
			return quantityProperty.get();
		}
		public void setQuantity(int quantity)
		{
			this.quantityProperty.set(quantity);
		}
		
		public IntegerProperty quantityNameProperty() {
			return quantityProperty;
		}

		public void setquantityProperty(IntegerProperty quantityProperty) {
			this.quantityProperty = quantityProperty;
		}

		//INGREDIENT
		public StringProperty getIngredientProperty() {
			return ingredientProperty;
		}

		public void setIngredientProperty(StringProperty ingredientProperty) {
			this.ingredientProperty = ingredientProperty;
		}
		
		public String getIngredient()
		{
			return ingredientProperty.get();
		}
		public void ingredient(String ingredient)
		{
			this.ingredientProperty.set(ingredient);
		}
		
		//MEASUREMENT
		public IntegerProperty getMeasurementProperty() {
			return measurementProperty;
		}

		public void setMeasurementProperty(IntegerProperty measurementProperty) {
			this.measurementProperty = measurementProperty;
		}

		public int getMeasurement()
		{
			return measurementProperty.get();
		}
		public void setMeasurement(int measurement)
		{
			this.measurementProperty.set(measurement);
		}
		
		//DESCRIPTION
		public StringProperty getdescriptionProperty() {
			return descriptionProperty;
		}

		public void setDescriptionProperty(StringProperty descriptionProperty) {
			this.descriptionProperty = descriptionProperty;
		}
		public String getDescription()
		{
			return descriptionProperty.get();
		}
		public void setDescription(String description)
		{
			this.descriptionProperty.set(description);
		}
		
		//TO GET WHAT YOU WANT IN COMBOBOX
		@Override
		public String toString() {
			String nom=this.getIngredient();
			return nom;
		}
	}
	