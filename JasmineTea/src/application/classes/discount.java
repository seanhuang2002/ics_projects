package application.classes;


public class discount {
	
	double percentage_;
	double fixed_; 
	double priceProduct_;
	double discount_; 
	double finalPrice_;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public double calcPercentageDiscount (double _percentage, double _priceProduct) {
		percentage_ = _percentage;
		priceProduct_ = _priceProduct;
		
		discount_ = (percentage_/100)*_priceProduct;
		
		return discount_;
	}
	
	public double calcFixedDiscount (double _fixed, double _priceProduct) {
		priceProduct_ = _priceProduct;
		fixed_ = _fixed;
		
		discount_ = priceProduct_ - fixed_;
		return discount_; 
	}
	
	public double calcFinalPrice (double _priceProduct, double _discount) {
		priceProduct_ = _priceProduct;
		discount_ = _discount;
		
		finalPrice_ = priceProduct_ - discount_;  
		return finalPrice_; 
	}
	
	
	
	

}
