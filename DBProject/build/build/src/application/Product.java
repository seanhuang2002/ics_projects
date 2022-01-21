package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Product {
	private IntegerProperty idProperty;
	private StringProperty supplierProperty;
	private StringProperty nameProperty;
	private StringProperty codeProperty;
	private DoubleProperty standardCostProperty;
	private DoubleProperty listPriceProperty;
	private StringProperty quantityPerUnitProperty;
	private StringProperty categoryProperty;
	private IntegerProperty unitsPerOrderProperty;

	public Product()
	{
		this.idProperty=new SimpleIntegerProperty();
		this.supplierProperty=new SimpleStringProperty();
		this.nameProperty=new SimpleStringProperty();
		this.codeProperty=new SimpleStringProperty();
		this.standardCostProperty=new SimpleDoubleProperty();
		this.listPriceProperty=new SimpleDoubleProperty();
		this.quantityPerUnitProperty=new SimpleStringProperty();
		this.categoryProperty=new SimpleStringProperty();
		this.unitsPerOrderProperty=new SimpleIntegerProperty();
	}
	
	public int getId() {
		return idProperty.get();
	}
	public void setId(int id) {
		this.idProperty.set(id);
	}
	public IntegerProperty idProperty() {
		return idProperty;
	}
	public void setIdProperty(IntegerProperty idProperty) {
		this.idProperty = idProperty;
	}
	
	//
	
	public String getSupplier() {
		return supplierProperty.get();
	}
	public void setSupplier(String name) {
		this.supplierProperty.set(name);
	}
	public StringProperty supplierProperty() {
		return supplierProperty;
	}
	public void setSupplierProperty(StringProperty supplierProperty) {
		this.supplierProperty = supplierProperty;
	}
	
	//
	
	public String getName() {
		return nameProperty.get();
	}
	public void setName(String name) {
		this.nameProperty.set(name);
	}
	public StringProperty nameProperty() {
		return nameProperty;
	}
	public void setNameProperty(StringProperty nameProperty) {
		this.nameProperty = nameProperty;
	}
	
	//
	
	public String getCode() {
		return codeProperty.get();
	}
	public void setCode(String code) {
		this.codeProperty.set(code);
	}
	public StringProperty codeProperty() {
		return codeProperty;
	}
	public void setCodeProperty(StringProperty codeProperty) {
		this.codeProperty = codeProperty;
	}
	
	//
	
	public Double getStandardCost() {
		return standardCostProperty.get();
	}
	public void setStandardCost(double id) {
		this.standardCostProperty.set(id);
	}
	public DoubleProperty standardCostProperty() {
		return standardCostProperty;
	}
	public void setStandardCostProperty(DoubleProperty standardCostProperty) {
		this.standardCostProperty = standardCostProperty;
	}
	
	//
	
	public Double getListPrice() {
		return listPriceProperty.get();
	}
	public void setListPrice(double id) {
		this.listPriceProperty.set(id);
	}
	public DoubleProperty listPriceProperty() {
		return listPriceProperty;
	}
	public void setListPriceProperty(DoubleProperty listPriceProperty) {
		this.listPriceProperty = listPriceProperty;
	}
	
	//
	
	public String getQuantityPerUnit() {
		return quantityPerUnitProperty.get();
	}
	public void setQuantityPerUnit(String name) {
		this.quantityPerUnitProperty.set(name);
	}
	public StringProperty quantityPerUnitProperty() {
		return quantityPerUnitProperty;
	}
	public void setQuantityPerUnitProperty(StringProperty quantityPerUnitProperty) {
		this.quantityPerUnitProperty = quantityPerUnitProperty;
	}
	
	//
	
	public String getCategory() {
		return categoryProperty.get();
	}
	public void setCategory(String name) {
		this.categoryProperty.set(name);
	}
	public StringProperty categoryProperty() {
		return categoryProperty;
	}
	public void setCategoryProperty(StringProperty categoryProperty) {
		this.categoryProperty = categoryProperty;
	}
	
	//
	
	public int getUnitsPerOrder() {
		return unitsPerOrderProperty.get();
	}
	public void setUnitsPerOrder(int id) {
		this.unitsPerOrderProperty.set(id);
	}
	public IntegerProperty unitsPerOrderProperty() {
		return unitsPerOrderProperty;
	}
	public void setUnitsPerOrderProperty(IntegerProperty unitsPerOrderProperty) {
		this.unitsPerOrderProperty = unitsPerOrderProperty;
	}

}
