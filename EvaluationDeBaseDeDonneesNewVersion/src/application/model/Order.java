package application.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Order {

	private IntegerProperty orderIdProperty;
	private IntegerProperty cusIdProperty;
	private IntegerProperty empIdProperty;
	private StringProperty salesRepNameProperty;
	private StringProperty shipperProperty;
	private StringProperty paymentTypeProperty;
	private StringProperty dateProperty;
	private StringProperty statusProperty;
	private StringProperty supplierProperty;
	private StringProperty shippingNameProperty;
	private StringProperty shippingAddressProperty;
	private StringProperty shippingCityProperty;
	private StringProperty shippingProvinceProperty;
	private StringProperty shippingPostalCodeProperty;
	private StringProperty shippingCountryProperty;
	private StringProperty product1NameProperty;
	private IntegerProperty product1QuantityProperty;
	private StringProperty product2NameProperty;
	private IntegerProperty product2QuantityProperty;
	private StringProperty product3NameProperty;
	private IntegerProperty product3QuantityProperty;
	private StringProperty product4NameProperty;
	private IntegerProperty product4QuantityProperty;
	private StringProperty product5NameProperty;
	private IntegerProperty product5QuantityProperty;
	private StringProperty product6NameProperty;
	private IntegerProperty product6QuantityProperty;
	private Customer customerId;

	//products ordered and quantities are in order_details
	//orders had
	public Order()
	{
		this.orderIdProperty=new SimpleIntegerProperty();
		this.cusIdProperty=new SimpleIntegerProperty();
		this.empIdProperty=new SimpleIntegerProperty();
		this.salesRepNameProperty=new SimpleStringProperty();
		this.shipperProperty=new SimpleStringProperty();
		this.paymentTypeProperty=new SimpleStringProperty();
		this.dateProperty=new SimpleStringProperty();
		this.statusProperty=new SimpleStringProperty();
		this.supplierProperty=new SimpleStringProperty();
		this.shippingNameProperty=new SimpleStringProperty();
		this.shippingAddressProperty=new SimpleStringProperty();
		this.shippingCityProperty=new SimpleStringProperty();
		this.shippingProvinceProperty=new SimpleStringProperty();
		this.shippingPostalCodeProperty=new SimpleStringProperty();
		this.shippingCountryProperty=new SimpleStringProperty();
		this.product1NameProperty=new SimpleStringProperty();
		this.product1QuantityProperty=new SimpleIntegerProperty();
		this.product2NameProperty=new SimpleStringProperty();
		this.product2QuantityProperty=new SimpleIntegerProperty();
		this.product3NameProperty=new SimpleStringProperty();
		this.product3QuantityProperty=new SimpleIntegerProperty();
		this.product4NameProperty=new SimpleStringProperty();
		this.product4QuantityProperty=new SimpleIntegerProperty();
		this.product5NameProperty=new SimpleStringProperty();
		this.product5QuantityProperty=new SimpleIntegerProperty();
		this.product6NameProperty=new SimpleStringProperty();
		this.product6QuantityProperty=new SimpleIntegerProperty();
	}
	
	public Order(int cusId, int empId)
	{
		this.orderIdProperty=new SimpleIntegerProperty();
		this.cusIdProperty=new SimpleIntegerProperty(cusId);
		this.empIdProperty=new SimpleIntegerProperty(empId);
		this.salesRepNameProperty=new SimpleStringProperty();
		this.shipperProperty=new SimpleStringProperty();
		this.paymentTypeProperty=new SimpleStringProperty();
		this.dateProperty=new SimpleStringProperty();
		this.statusProperty=new SimpleStringProperty();
		this.supplierProperty=new SimpleStringProperty();
		this.shippingNameProperty=new SimpleStringProperty();
		this.shippingAddressProperty=new SimpleStringProperty();
		this.shippingCityProperty=new SimpleStringProperty();
		this.shippingProvinceProperty=new SimpleStringProperty();
		this.shippingPostalCodeProperty=new SimpleStringProperty();
		this.shippingCountryProperty=new SimpleStringProperty();
		this.product1NameProperty=new SimpleStringProperty();
		this.product1QuantityProperty=new SimpleIntegerProperty();
		this.product2NameProperty=new SimpleStringProperty();
		this.product2QuantityProperty=new SimpleIntegerProperty();
		this.product3NameProperty=new SimpleStringProperty();
		this.product3QuantityProperty=new SimpleIntegerProperty();
		this.product4NameProperty=new SimpleStringProperty();
		this.product4QuantityProperty=new SimpleIntegerProperty();
		this.product5NameProperty=new SimpleStringProperty();
		this.product5QuantityProperty=new SimpleIntegerProperty();
		this.product6NameProperty=new SimpleStringProperty();
		this.product6QuantityProperty=new SimpleIntegerProperty();
	}
	
	//customerId
	public Customer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}
	//cusIdProperty
	public int getOrderId(){
		return orderIdProperty.get();
	}
	public void setOrderId(int value){
		orderIdProperty.set(value);
	}
	public IntegerProperty orderIdProperty(){
		return orderIdProperty;
	}
	//cusIdProperty
	public int getCusId(){
		return cusIdProperty.get();
	}
	public void setCusId(int value){
		cusIdProperty.set(value);
	}
	public IntegerProperty cusIdProperty(){
		return cusIdProperty;
	}
	//empIdProperty
	public int getEmpId(){
		return empIdProperty.get();
	}
	public void setEmpId(int value){
		empIdProperty.set(value);
	}
	public IntegerProperty empIdProperty(){
		return empIdProperty;
	}
	//salesRepNameProperty
	public String getSalesRepName(){
		return salesRepNameProperty.get();
	}
	public void setSalesRepName(String value){
		salesRepNameProperty.set(value);
	}
	public StringProperty salesRepNameProperty(){
		return salesRepNameProperty;
	}
	//shipperProperty
	public String getShipper(){
		return shipperProperty.get();
	}
	public void setShipper(String value){
		shipperProperty.set(value);
	}
	public StringProperty shipperProperty(){
		return shipperProperty;
	}
	//paymentTypeProperty
	public String getPaymentType(){
		return paymentTypeProperty.get();
	}
	public void setPayment(String value){
		paymentTypeProperty.set(value);
	}
	public StringProperty paymentTypeProperty(){
		return paymentTypeProperty;
	}
	//dateProperty
	public String getDate(){
		return dateProperty.get();
	}
	public void setDate(String value){
		dateProperty.set(value);
	}
	public StringProperty dateProperty(){
		return dateProperty;
	}
	//statusProperty
	public String getStatus(){
		return statusProperty.get();
	}
	public void setStatus(String value){
		statusProperty.set(value);
	}
	public StringProperty statusProperty(){
		return statusProperty;
	}
	//supplierProperty
	public String getSupplier(){
		return supplierProperty.get();
	}
	public void setSupplier(String value){
		supplierProperty.set(value);
	}
	public StringProperty supplierProperty(){
		return supplierProperty;
	}
	//shippingNameProperty
	public String getShippingName(){
		return shippingNameProperty.get();
	}
	public void setShippingName(String value){
		shippingNameProperty.set(value);
	}
	public StringProperty shippingNameProperty(){
		return shippingNameProperty;
	}
	//shippingAddressProperty 
	public String getShippingAddress(){
		return shippingAddressProperty.get();
	}
	public void setShippingAddress(String value){
		shippingAddressProperty.set(value);
	}
	public StringProperty shippingAddressProperty(){
		return shippingAddressProperty;
	}
	//shippingCityProperty
	public String getShippingCity(){
		return shippingCityProperty.get();
	}
	public void setShippingCity(String value){
		shippingCityProperty.set(value);
	}
	public StringProperty shippingCityProperty(){
		return shippingCityProperty;
	}
	//shippingProvinceProperty
	public String getShippingProvince(){
		return shippingProvinceProperty.get();
	}
	public void setShippingProvince(String value){
		shippingProvinceProperty.set(value);
	}
	public StringProperty shippingProvinceProperty(){
		return shippingProvinceProperty;
	}
	//shippingNameProperty
	public String getShippingPostalCode(){
		return shippingPostalCodeProperty.get();
	}
	public void setShippingPostalCode(String value){
		shippingPostalCodeProperty.set(value);
	}
	public StringProperty shippingPostalCodeProperty(){
		return shippingPostalCodeProperty;
	}
	//cusNameProperty
	public String getShippingCountry(){
		return shippingCountryProperty.get();
	}
	public void setShippingCountry(String value){
		shippingCountryProperty.set(value);
	}
	public StringProperty shippingCountryProperty(){
		return shippingCountryProperty;
	}
	//product1NameProperty
	public String getProduct1Name(){
		return product1NameProperty.get();
	}
	public void setProduct1Name(String value){
		product1NameProperty.set(value);
	}
	public StringProperty product1NameProperty(){
		return product1NameProperty;
	}
	//product1QuantityProperty
	public int getProduct1Quantity(){
		return product1QuantityProperty.get();
	}
	public void setProduct1Quantity(int value){
		product1QuantityProperty.set(value);
	}
	public IntegerProperty product1QuantityProperty(){
		return product1QuantityProperty;
	}
	//product2NameProperty
	public String getProduct2Name(){
		return product2NameProperty.get();
	}
	public void setProduct2Name(String value){
		product2NameProperty.set(value);
	}
	public StringProperty product2NameProperty(){
		return product2NameProperty;
	}
	//product2QuantityProperty
	public int getProduct2Quantity(){
		return product2QuantityProperty.get();
	}
	public void setProduct2Quantity(int value){
		product2QuantityProperty.set(value);
	}
	public IntegerProperty product2QuantityProperty(){
		return product2QuantityProperty;
	}
	//product3NameProperty
	public String getProduct3Name(){
		return product3NameProperty.get();
	}
	public void setProduct3Name(String value){
		product3NameProperty.set(value);
	}
	public StringProperty product3NameProperty(){
		return product3NameProperty;
	}
	//product3QuantityProperty
	public int getProduct3Quantity(){
		return product3QuantityProperty.get();
	}
	public void setProduct3Quantity(int value){
		product3QuantityProperty.set(value);
	}
	public IntegerProperty product3QuantityProperty(){
		return product3QuantityProperty;
	}
	//product4NameProperty
	public String getProduct4Name(){
		return product4NameProperty.get();
	}
	public void setProduct4Name(String value){
		product4NameProperty.set(value);
	}
	public StringProperty product4NameProperty(){
		return product4NameProperty;
	}
	//product4QuantityProperty
	public int getProduct4Quantity(){
		return product4QuantityProperty.get();
	}
	public void setProduct4Quantity(int value){
		product4QuantityProperty.set(value);
	}
	public IntegerProperty product4QuantityProperty(){
		return product4QuantityProperty;
	}
	//product5NameProperty
	public String getProduct5Name(){
		return product5NameProperty.get();
	}
	public void setProduct5Name(String value){
		product5NameProperty.set(value);
	}
	public StringProperty product5NameProperty(){
		return product5NameProperty;
	}
	//product5QuantityProperty
	public int getProduct5Quantity(){
		return product5QuantityProperty.get();
	}
	public void setProduct5Quantity(int value){
		product5QuantityProperty.set(value);
	}
	public IntegerProperty product5QuantityProperty(){
		return product5QuantityProperty;
	}
	//product6NameProperty
	public String getProduct6Name(){
		return product6NameProperty.get();
	}
	public void setProduct6Name(String value){
		product6NameProperty.set(value);
	}
	public StringProperty product6NameProperty(){
		return product6NameProperty;
	}
	//product6QuantityProperty
	public int getProduct6Quantity(){
		return product6QuantityProperty.get();
	}
	public void setProduct6Quantity(int value){
		product6QuantityProperty.set(value);
	}
	public IntegerProperty product6QuantityProperty(){
		return product6QuantityProperty;
	}


}
