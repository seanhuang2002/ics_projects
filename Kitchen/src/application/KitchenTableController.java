package application;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class KitchenTableController {

	/*
	 * SECTION 1: TAB -> Grocery List & Money Manager
	 */

	@FXML
	private Label i1;
	@FXML
	private Label i2;
	@FXML
	private Label i3;
	@FXML
	private Label i4;
	@FXML
	private Label i5;
	@FXML
	private Label i6;
	@FXML
	private Label i7;
	@FXML
	private Label i8;
	@FXML
	private Label qu1;
	@FXML
	private Label qu2;
	@FXML
	private Label qu3;
	@FXML
	private Label qu4;
	@FXML
	private Label qu5;
	@FXML
	private Label qu6;
	@FXML
	private Label qu7;
	@FXML
	private Label qu8;
	@FXML
	private Label s1;
	@FXML
	private Label s2;
	@FXML
	private Label s3;
	@FXML
	private Label s4;
	@FXML
	private Label s5;
	@FXML
	private Label s6;
	@FXML
	private Label s7;
	@FXML
	private Label s8;
	@FXML
	private Label information;
	@FXML
	private Label information2;
	@FXML
	private TextField p1;
	@FXML
	private TextField p2;
	@FXML
	private TextField p3;
	@FXML
	private TextField p4;
	@FXML
	private TextField p5; 
	@FXML
	private TextField p6;
	@FXML
	private TextField p7;
	@FXML
	private TextField p8;
	@FXML
	private TextField t1;
	@FXML
	private TextField t2;
	@FXML
	private TextField t3;
	@FXML
	private TextField t4;
	@FXML
	private TextField t5;
	@FXML
	private TextField t6;
	@FXML
	private TextField t7;
	@FXML
	private TextField t8;
	@FXML
	private TextField q1;
	@FXML
	private TextField q2;
	@FXML
	private TextField q3;
	@FXML
	private TextField q4;
	@FXML
	private TextField q5;
	@FXML
	private TextField q6;
	@FXML
	private TextField q7;
	@FXML
	private TextField q8;
	@FXML
	private TextField budget;
	@FXML
	private Button calculate;
	@FXML
	private Button done;
	@FXML
	private Button clear;

	private Main main;

	public void setMain(Main main)
	{
		this.main=main;
	}

	/* 
	 * This method sets restrictions in order to ensure the user does not enter letters in the "quantity" fields, which can only be numerical.
	 * It uses REGULAR EXPRESSIONS.
	 */

	//Creating restrictions for the TextFields under quantity.
	
	@FXML
	private Label rest1;
	@FXML
	private Label rest2;
	@FXML
	private Label rest3;
	@FXML
	private Label rest4;
	@FXML
	private Label rest5;
	@FXML
	private Label rest6;
	@FXML
	private Label rest7;
	@FXML
	private Label rest8;
	@FXML
	private Label checkbudget;
	
	
	public void showAlert1()
	{
		Alert alert=new Alert(AlertType.WARNING);
		alert.setHeaderText("ERROR MESSAGE");
		alert.setTitle("WARNING");
		alert.setContentText("You may only enter whole numbers in this box.");
		alert.show();
	}
	
	@FXML
	public void firstQuantity() {

		q1.textProperty().addListener((arg0, oldValue, newValue) -> {  
			
			if(!newValue.matches("^[0-9]*$"))
			{
				showAlert1();
				q1.setText("");
			}
		});
	}

	@FXML
	public void secondQuantity() {
		q2.textProperty().addListener((arg0, oldValue, newValue) -> {  
			
			if(!newValue.matches("^[0-9]*$"))
			{
				showAlert1();
				q2.setText("");
			}
		});
		}

	@FXML
	public void thirdQuantity() {
		q3.textProperty().addListener((arg0, oldValue, newValue) -> {  

			if(!newValue.matches("^[0-9]*$"))
			{
				showAlert1();
				q3.setText("");
			}
		});
	}

	@FXML
	public void fourthQuantity() {
		q4.textProperty().addListener((arg0, oldValue, newValue) -> { 

			if(!newValue.matches("^[0-9]*$"))
			{
				showAlert1();
				q4.setText("");
			}
		});
	}

	@FXML
	public void fifthQuantity() {

		q5.textProperty().addListener((arg0, oldValue, newValue) -> {  
			
			if(!newValue.matches("^[0-9]*$"))
			{
				showAlert1();
				q5.setText("");
			}
		});
	}

	@FXML
	public void sixthQuantity() {
		q6.textProperty().addListener((arg0, oldValue, newValue) -> {  
			
			if(!newValue.matches("^[0-9]*$"))
			{
				showAlert1();
				q6.setText("");
			}
		});
	}

	@FXML
	public void seventhQuantity() {
		q7.textProperty().addListener((arg0, oldValue, newValue) -> {  

			if(!newValue.matches("^[0-9]*$"))
			{
				showAlert1();
				q7.setText("");
			}
		});
	}

	@FXML
	public void eighthQuantity() {
		q8.textProperty().addListener((arg0, oldValue, newValue) -> {  

			if(!newValue.matches("^[0-9]*$"))
			{
				showAlert1();
				q8.setText("");
			}
		});
	}
	
	/*
	 * Creating restrictions for the list PRICE
	 */
	
	@FXML
	public void firstPrice() {
		p1.textProperty().addListener((arg0, oldValue, newValue) -> {  
				if(!newValue.matches("\\d*\\.\\d{2}$"))
				{
					rest1.setText("X");
				}
				
				else
				{
					rest1.setText("");
				}
		});
	}
	
	@FXML
	public void secondPrice() {
		p2.textProperty().addListener((arg0, oldValue, newValue) -> {  

			if(!newValue.matches("\\d*\\.\\d{2}$"))
			{
				rest2.setText("X");
			}
			
			else
			{
				rest2.setText("");
			}
		});
	}
	
	@FXML
	public void thirdPrice() {
		p3.textProperty().addListener((arg0, oldValue, newValue) -> {  

			if(!newValue.matches("\\d*\\.\\d{2}$"))
			{
				rest3.setText("X");
			}
			
			else
			{
				rest3.setText("");
			}
		});
	}
	
	@FXML
	public void fourthPrice() {
		p4.textProperty().addListener((arg0, oldValue, newValue) -> {  

			if(!newValue.matches("\\d*\\.\\d{2}$"))
			{
				rest4.setText("X");
			}
			
			else
			{
				rest4.setText("");
			}
		});
	}
	
	@FXML
	public void fifthPrice() {
		p5.textProperty().addListener((arg0, oldValue, newValue) -> {  

			if(!newValue.matches("\\d*\\.\\d{2}$"))
			{
				rest5.setText("X");
			}
			
			else
			{
				rest5.setText("");
			}
		});
	}
	
	@FXML
	public void sixthPrice() {
		p6.textProperty().addListener((arg0, oldValue, newValue) -> {  

			if(!newValue.matches("\\d*\\.\\d{2}$"))
			{
				rest6.setText("X");
			}
			
			else
			{
				rest6.setText("");
			}
		});
	}
	
	@FXML
	public void seventhPrice() {
		p7.textProperty().addListener((arg0, oldValue, newValue) -> {  

			if(!newValue.matches("\\d*\\.\\d{2}$"))
			{
				rest7.setText("X");
			}
			
			else
			{
				rest7.setText("");
			}
		});
	}
	
	@FXML
	public void eighthPrice() {
		p8.textProperty().addListener((arg0, oldValue, newValue) -> {  

			if(!newValue.matches("\\d*\\.\\d{2}$"))
			{
				rest8.setText("X");
			}
			
			else
			{
				rest8.setText("");
			}
		});
	}
	
	@FXML
	public void textClear() {
		p1.setText("");
	}
	
	@FXML
	public void budget() {
		budget.textProperty().addListener((arg0, oldValue, newValue) -> {  

			if(!newValue.matches("\\d*\\.\\d{2}$"))
			{
				checkbudget.setText("X");
			}
			
			else
			{
				checkbudget.setText("");
			}
		});
	}
	
	@FXML
	public void milk() {
		milk.textProperty().addListener((arg0, oldValue, newValue) -> {  

			if(!newValue.matches("^\\d+(\\.\\d+)?$"))
			{
				showAlert1();
				milk.setText("");
			}
		});
	}
	
	@FXML
	public void tea() {
		tea.textProperty().addListener((arg0, oldValue, newValue) -> {  

			if(!newValue.matches("[0-9]*$"))
			{
				showAlert1();
				tea.setText("");
			}
		});
	}
	
	@FXML
	public void water() {
		water.textProperty().addListener((arg0, oldValue, newValue) -> {  

			if(!newValue.matches("[0-9]*$"))
			{
				showAlert1();
				water.setText("");
			}
		});
	}
	
	@FXML
	public void applej() {
		applej.textProperty().addListener((arg0, oldValue, newValue) -> {  

			if(!newValue.matches("[0-9]*$"))
			{
				showAlert1();
				applej.setText("");
			}
		});
	}
	
	@FXML
	public void softdrink() {
		softdrink.textProperty().addListener((arg0, oldValue, newValue) -> {  

			if(!newValue.matches("[0-9]*$"))
			{
				showAlert1();
				softdrink.setText("");
			}
		});
	}
	
	@FXML
	public void coffee() {
		coffee.textProperty().addListener((arg0, oldValue, newValue) -> {  

			if(!newValue.matches("[0-9]*$"))
			{
				showAlert1();
				coffee.setText("");
			}
		});
	}
	
	@FXML
	public void beef() {
		beef.textProperty().addListener((arg0, oldValue, newValue) -> {  

			if(!newValue.matches("[0-9]*$"))
			{
				showAlert1();
				beef.setText("");
			}
		});
	}
	
	@FXML
	public void lamb() {
		lamb.textProperty().addListener((arg0, oldValue, newValue) -> {  

			if(!newValue.matches("[0-9]*$"))
			{
				showAlert1();
				lamb.setText("");
			}
		});
	}
	
	@FXML
	public void pork() {
		pork.textProperty().addListener((arg0, oldValue, newValue) -> {  

			if(!newValue.matches("[0-9]*$"))
			{
				showAlert1();
				pork.setText("");
			}
		});
	}
	
	@FXML
	public void turkey() {
		turkey.textProperty().addListener((arg0, oldValue, newValue) -> {  

			if(!newValue.matches("[0-9]*$"))
			{
				showAlert1();
				turkey.setText("");
			}
		});
	}
	
	@FXML
	public void fish() {
		fish.textProperty().addListener((arg0, oldValue, newValue) -> {  

			if(!newValue.matches("[0-9]*$"))
			{
				showAlert1();
				fish.setText("");
			}
		});
	}
	
	@FXML
	public void chicken() {
		chicken.textProperty().addListener((arg0, oldValue, newValue) -> {  

			if(!newValue.matches("[0-9]*$"))
			{
				showAlert1();
				chicken.setText("");
			}
		});
	}
	

	/*
	 * Assigned to the "Done" button
	 * This method sets the labels for 'Item' and 'Quantity' in the 'Money Manager' section.
	 * It allows the user to have focussed goals while grocery shopping.
	 */
	@FXML
	public void getItems() {

		//Setting the labels for ITEMS
		i1.setText(t1.getText());
		i2.setText(t2.getText());
		i3.setText(t3.getText());
		i4.setText(t4.getText());
		i5.setText(t5.getText());
		i6.setText(t6.getText());
		i7.setText(t7.getText());
		i8.setText(t8.getText());

		//Setting labels for QUANTITY
		qu1.setText(q1.getText());
		qu2.setText(q2.getText());
		qu3.setText(q3.getText());
		qu4.setText(q4.getText());
		qu5.setText(q5.getText());
		qu6.setText(q6.getText());
		qu7.setText(q7.getText());
		qu8.setText(q8.getText());
	}

	/*
	 * This method allows a calculation of the total estimated cost.
	 * It also includes a tax of 13%.
	 * Assign to button "Calculate total cost"
	 */
	@FXML
	public void calculateTotal(ActionEvent event)	{
		double total1=0, total2=0, total3=0, total4=0, total5=0, total6=0, total7=0, total8=0;
		
		if(!i1.getText().equals("")&&!qu1.getText().equals("")&&!p1.getText().equals(""))
		{
			//Changing the String from the QUANTITY TextField into an integer
			int quantity1=Integer.parseInt(q1.getText());
			//Changes the String from the PRICES TextField into a double
			double price1=Double.parseDouble(p1.getText());
			//Determining the price of each item depending on quantity
			total1=quantity1*price1;
			total1=round(total1, 2);
		}

		if(!i2.getText().equals("")&&!qu2.getText().equals("")&&!p2.getText().equals(""))
		{
			int quantity2=Integer.parseInt(q2.getText());
			double price2=Double.parseDouble(p2.getText());
			total2=quantity2*price2;
			total2=round(total2,2);
		}

		if(!i3.getText().equals("")&&!qu3.getText().equals("")&&!p3.getText().equals(""))
		{
			int quantity3=Integer.parseInt(q3.getText());
			double price3=Double.parseDouble(p3.getText());
			total3=quantity3*price3;
			total3=round(total3,2);
		}

		if(!i4.getText().equals("")&&!qu1.getText().equals("")&&!p1.getText().equals(""))
		{
			int quantity4=Integer.parseInt(q4.getText());	
			double price4=Double.parseDouble(p4.getText());
			total4=quantity4*price4;
			total4=round(total4,2);
		}

		if(!i5.getText().equals("")&&!qu5.getText().equals("")&&!p5.getText().equals(""))
		{
			int quantity5=Integer.parseInt(q5.getText());
			double price5=Double.parseDouble(p5.getText());
			total5=quantity5*price5;
			total5=round(total5,2);
		}

		if(!i6.getText().equals("")&&!qu6.getText().equals("")&&!p6.getText().equals(""))
		{
			int quantity6=Integer.parseInt(q6.getText());
			double price6=Double.parseDouble(p6.getText());
			total6=quantity6*price6;
			total6=round(total6,2);
		}

		if(!i7.getText().equals("")&&!qu7.getText().equals("")&&!p7.getText().equals(""))
		{
			int quantity7=Integer.parseInt(q7.getText());
			double price7=Double.parseDouble(p7.getText());
			total7=quantity7*price7;
			total7=round(total7,2);
		}

		if(!i8.getText().equals("")&&!qu8.getText().equals("")&&!p8.getText().equals(""))
		{
			int quantity8=Integer.parseInt(q8.getText());
			double price8=Double.parseDouble(p8.getText());
			total8=quantity8*price8;	
			total8=round(total8,2);
		}
		
		//Setting labels for the breakdown of costs	
		s1.setText(Double.toString(total1));
		s2.setText(Double.toString(total2));
		s3.setText(Double.toString(total3));
		s4.setText(Double.toString(total4));
		s5.setText(Double.toString(total5));
		s6.setText(Double.toString(total6));
		s7.setText(Double.toString(total7));
		s8.setText(Double.toString(total8));
		
		//Determining the total cost plus tax
		double totalcost=(total1+total2+total3+total4+total5+total6+total7+total8)*1.13;
		totalcost=round(totalcost, 2);
		
		//Determining user's budget
		if(!budget.getText().equals(""))
		{
			double userbudget=Double.parseDouble(budget.getText());

			/*
			 * Setting labels to let user know the total cost.
			 * 3 outcomes: budget is higher than cost, budget is lower than cost, budget is equal to cost.
			 */
			if(userbudget>totalcost)
			{
				double difference=userbudget-totalcost;
				difference=round(difference,2);
				information.setText("Your purchases are within budget.");
				information2.setText("The total cost is $"+totalcost+" and you have $"+difference+" remaining.");
			}

			else if(totalcost>userbudget)
			{
				double difference=totalcost-userbudget;
				difference=round(difference,2);
				information.setText("You do not have enough money for your purchases.");
				information2.setText("Your total is $"+totalcost+" and you are missing $"+difference+".");
			}

			else if(totalcost==userbudget)
			{
				information.setText("The total cost of your purchases is $"+totalcost);
				information2.setText("It is is equal to your budget.");
			}
		}
		
		if(budget.getText().equals(""))
		{
			information.setText("The total cost of your puchases is $"+totalcost+".");
			information2.setText(" ");
		}
	}

	public static double round(double value, int places) {
	    if (places < 2) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	@FXML
	public void clearItems() {
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		t6.setText("");
		t7.setText("");
		t8.setText("");

		q1.setText("");
		q2.setText("");
		q3.setText("");
		q4.setText("");
		q5.setText("");
		q6.setText("");
		q7.setText("");
		q8.setText("");

		i1.setText("");
		i2.setText("");
		i3.setText("");
		i4.setText("");
		i5.setText("");
		i6.setText("");
		i7.setText("");
		i8.setText("");

		qu1.setText("");
		qu2.setText("");
		qu3.setText("");
		qu4.setText("");
		qu5.setText("");
		qu6.setText("");
		qu7.setText("");
		qu8.setText("");

		p1.setText("");
		p2.setText("");
		p3.setText("");
		p4.setText("");
		p5.setText("");
		p6.setText("");
		p7.setText("");
		p8.setText("");

		s1.setText("");
		s2.setText("");
		s3.setText("");
		s4.setText("");
		s5.setText("");
		s6.setText("");
		s7.setText("");
		s8.setText("");
		
		rest1.setText("");
		rest2.setText("");
		rest3.setText("");
		rest4.setText("");
		rest5.setText("");
		rest6.setText("");
		rest7.setText("");
		rest8.setText("");
		
		checkbudget.setText("");

		budget.setText("");
		information.setText("");
		information2.setText("");
	}

	/*
	 * SECTION 2: FOOD CONSUMPTION AND ENVIRONMENTAL IMPACTS TAB
	 */
	
	@FXML
	private TextField chicken;
	@FXML
	private Label chickeno;
	@FXML
	private Label chickene;
	@FXML
	private TextField beef;
	@FXML
	private Label beefo;
	@FXML
	private Label beefe;
	@FXML
	private TextField lamb;
	@FXML
	private Label lambo;
	@FXML
	private Label lambe;
	@FXML
	private TextField fish;
	@FXML
	private Label fisho;
	@FXML
	private Label fishe;
	@FXML
	private TextField pork;
	@FXML
	private Label porko;
	@FXML
	private Label porke;
	@FXML
	private TextField turkey;
	@FXML
	private Label turkeyo;
	@FXML
	private Label turkeye;
	
	@FXML
	private TextField milk;
	@FXML
	private Label milko;
	@FXML
	private Label milke;
	@FXML
	private TextField coffee;
	@FXML
	private Label coffeeo;
	@FXML
	private Label coffeee;
	@FXML
	private TextField applej;
	@FXML
	private Label applejo;
	@FXML
	private Label appleje;
	@FXML
	private TextField softdrink;
	@FXML
	private Label softdrinko;
	@FXML
	private Label softdrinke;
	@FXML
	private TextField water;
	@FXML
	private Label watero;
	@FXML
	private Label watere;
	@FXML
	private TextField tea;
	@FXML
	private Label teao;
	@FXML
	private Label teae;
	
	/*
	 * CALCULATING ENVIRONMENTAL IMPACT OF MEATS:
	 * EACH MEAT RELEASES A DIFFERENT QUANTITY OF GREENHOUSE GASES INTO TE ATMOSPHERE. 
	 * THE MORE IT RELEASES, THE MORE INFLUENCE THEIR PRESENCE HAS ON CLIMATE CHANGE.
	 * THE EXISTENCE OF THESE ANIMALS IS NOT THE PROBLEM; INSTEAD, IT IS THE CULTIVATION AND OVERPOPULATION OF ANIMALS IN THEIR FARMS.
	 * THEIR SOLE PURPOSE OF EXISTENCE IS TO BE SLAUGHTERED, AND THUS ARE NOT CONTRIBUTING TO THE NATURAL ENVIRONMENT
	 * RAISING ANIMALS FOR FOOD REQUIRED MASSIVE AMOUNTS OF LAND, FOOD, ENERGY, AND WATER. IT ALSO CAUSES IMMENSE ANIMAL SUFFERING.
	 * 
	 * WAYS IN WHICH AN ANIMAL CAN RELEASE GREENHOUSE GASES (MAINLY CO2)
	 * - FECES
	 * - BYPRODUCTS OF BASIC BIOLOGICAL PROCESSES
	 * - PROCESSING
	 * - TRANSPORT
	 * - COOKING
	 */
	
	/*
	 * Calculating environmental impact of cow
	 */
	@FXML
	public void addBeef() {
		
		//Converting inputs to String
		double a=Double.parseDouble(beefo.getText());
		double b=Double.parseDouble(beef.getText());
		
		//Adding the input to the pre-existing label value, discover how many cows have been eaten
		//Each cow is 430 kg of meat approximately
		double c=(a+b)/430;
		c=round(c, 2);
		
		//outputting number of cows eaten
		beefo.setText(Double.toString(c));
		//outputting quantity of methane emitted per year depending on quantity of beef consumed
		//around 100 kg of methane emitted per year by each cow
		beefe.setText(Double.toString(round(c*100,2)));
		//clearing beed textfield
		beef.setText("");
	}	
	
	@FXML
	public void addChicken() {

		double a=Double.parseDouble(chickeno.getText());
		double b=Double.parseDouble(chicken.getText());

		/*
		 * Varies between the bird, but about 70% of body weight
		 * In North America, Plymouth White Rock chickens are some of the most common types of chicken to eat
		 * White Rock chickens weigh about 3.4 kg. (these values are based on the average weight of a chicken being 3.4 kg)AQ
		 */
		double c=(a+b)/3.4;
		c=round(c, 2);

		chickeno.setText(Double.toString(c));

		//6.9 kg of CO2 emitted per kilogram of chicken. They are one of the "greener" meats.
		chickene.setText(Double.toString(round(b*6.9,2)));

		chicken.setText("");

	}
	
	@FXML
	public void addLamb() {
		double a=Double.parseDouble(lambo.getText());
		double b=Double.parseDouble(lamb.getText());
		
		//Lambs weigh about 54 kg but they yield around 32 kg of edible meat
		double c=(a+b)/32;
		c=round(c, 2);

		lambo.setText(Double.toString(c));

		//39.2 kg of CO2 emitted by each kilogram of lamb
		lambe.setText(Double.toString(round(b*39.2,2)));

		lamb.setText("");
	}
	
	@FXML
	public void addSalmon() {
		double a=Double.parseDouble(fisho.getText());
		double b=Double.parseDouble(fish.getText());
		
		/*
		 * Values based on the King (Chinook) Salmon
		 * Approximately 9.1 kg 
		 */
		double c=(a+b)/9.1;
		c=round(c, 2);

		fisho.setText(Double.toString(c));

		//11.9 kg of CO2 emitted per kg of farmed salmon
		fishe.setText(Double.toString(round(b*11.9,2)));

		fish.setText("");
	}
	
	@FXML
	public void addPork() {
		double a=Double.parseDouble(porko.getText());
		double b=Double.parseDouble(pork.getText());
		
		/*
		 * 81.5 out of 113 kg of pork is edible.
		 */
		double c=(a+b)/81.5;
		c=round(c, 2);

		porko.setText(Double.toString(c));

		/*
		 * 12.1 kg of CO2 emitted per kg of pork
		 * Multiply quantity of pork by quantity of CO2 emitted per kg.
		 */
		porke.setText(Double.toString(round(b*12.1,2)));

		pork.setText("");
	}
	
	@FXML
	public void addTurkey() {
		
		double a=Double.parseDouble(turkeyo.getText());
		double b=Double.parseDouble(turkey.getText());
		
		/*
		 *Values based on a 14-pound turkey. Approx 40% of turkey meat is edible, which is 5.6 kg for a 14 pound turkey.
		 */
		double c=(a+b)/5.6;
		c=round(c, 2);

		turkeyo.setText(Double.toString(c));

		/*
		 * 10.9 kg of CO2 emitted per kg of turkey.It is also considered a 'greener' meat.
		 * Multiply quantity of turkey by quantity of CO2 emitted per kg.
		 */
		turkeye.setText(Double.toString(round(b*10.9,2)));

		turkey.setText("");
	}
	
	@FXML
	public void addMilk() {
		
		double a=Double.parseDouble(milko.getText());
		double b=Double.parseDouble(milk.getText());
		
		double c=(a+b);
		c=round(c, 2);
		
		//Calculating amoung of cow milk consumed (in Litres)
		milko.setText(Double.toString(c));

		/*
		 * Approximately 6 gallons/23 Litres of milk per cow
		 */
		milke.setText(Double.toString(round(b/23,2)));

		milk.setText("");
	}
	
	@FXML
	public void addCoffee() {
		
		double a=Double.parseDouble(coffeeo.getText());
		double b=Double.parseDouble(coffee.getText());
		
		double c=(a+b);
		c=round(c, 2);
		
		//Calculating quantity of coffee in Litres
		coffeeo.setText(Double.toString(c));

		/*
		 * Approximately 140L of water per 0.125 mL of coffee consumed
		 */
		coffeee.setText(Double.toString(round(b*(140/0.125),2)));

		coffee.setText("");
	}
	
	@FXML
	public void addAppleJuice() {
		
		double a=Double.parseDouble(applejo.getText());
		double b=Double.parseDouble(applej.getText());
		
		double c=(a+b);
		c=round(c, 2);
		
		//Calculating quantity of apple juice in Litres
		applejo.setText(Double.toString(c));

		/*
		 * Approximately 500 - 1000 years for plastic to decompose
		 * Multiplying number of boxes by average of 750 years
		 */
		appleje.setText(Double.toString(round(b*(750),2)));

		applej.setText("");
	}
	
	@FXML
	public void addSoftDrink() {
			
		double c=Double.parseDouble(softdrink.getText());
			
			/*
			 * Calculating quantity of soft drink in Litres
			 * 0.7L in 24 ounce or 1 bottle
			 */
			softdrinko.setText(Double.toString(round(c/0.7,2)));

			/*
			 *0.7L per 1 bottle
			 *20 000 bottles per 1 ton of PET plastic
			 *77% of that plastic is not recycled (University of Cambridge)
			 */
			softdrinke.setText(Double.toString(round(((c/0.7)/20000)*0.77,2)));

			softdrink.setText("");
	}
	
	/*
	 * Taking into consideration the quantity of plastic not recycled, waste produced, and energy used
	 */
	@FXML
	public void addWater() {
		
		double a=Double.parseDouble(watero.getText());
		double b=Double.parseDouble(water.getText());
		
		double c=(a+b);
		c=round(c, 2);
		
		//Calculating quantity of water in Litres
		watero.setText(Double.toString(c));

		/*
		 *5.6 - 10.2 million joules of energy per litre
		 *7.9 million joules of energy per litre average (will be used for calculation purposes)
		 *
		 */
		watere.setText(Double.toString(round(b*(7.9),2)));

		water.setText("");
	}
	
	@FXML
	public void addVodka() {
		double a=Double.parseDouble(teao.getText());
		double b=Double.parseDouble(tea.getText());
		
		double c=(a+b);
		c=round(c, 2);
		
		//Calculating quantity of vodka in Litres
		teao.setText(Double.toString(c));

		/*
		 * 4.44 billion litres of vodka produced (40% pure alcohol)
		 * 1.78 billion litres of pure alcohol
		 * 3.96 million tons of grains
		 * 
		 * RATIO OF 1 VODKA LITRE ->
		 * 1 : 0.000 002 25
		 */
		teae.setText(Double.toString(round(b*(0.225),2)));

		tea.setText("");
	}
	
	//resetting the environmental impact chart
	@FXML
	public void clearData() {
		chickeno.setText("0");
		beefo.setText("0");
		fisho.setText("0");
		porko.setText("0");
		turkeyo.setText("0");
		lambo.setText("0");
		
		milko.setText("0");
		coffeeo.setText("0");
		teao.setText("0");
		applejo.setText("0");
		watero.setText("0");
		softdrinko.setText("0");
		
		chickene.setText("0");
		beefe.setText("0");
		fishe.setText("0");
		porke.setText("0");
		turkeye.setText("0");
		lambe.setText("0");
		
		milke.setText("0");
		appleje.setText("0");
		teae.setText("0");
		watere.setText("0");
		softdrinke.setText("0");
		coffeee.setText("0");
	}
	
	@FXML
	private TabPane tabpane;
	@FXML
	private Tab mm;
	@FXML
	private Tab ei;
	@FXML
	private Tab fc;
	
	//Opening 'Money Manager and Grocery List' tab
	@FXML
	public void navigateMM() {
		tabpane.getSelectionModel().select(mm);
	}
	
	//Opening the 'Environmental Impacts' tab
	@FXML
	public void navigateEI() {
		tabpane.getSelectionModel().select(ei);
	}
	
	//Opening the 'Food Consumption' tab
	@FXML
	public void navigateFC() {
		tabpane.getSelectionModel().select(fc);
	}
	
	@FXML
	public void quit() {
		System.exit(0);
	}
	

    @FXML
    private TextField txtQuantity;
    
    @FXML
    private ComboBox<Recipes> cboID;
    
    @FXML
    private Button btnDelete;
    
    @FXML
    private Button btnAdd;
    
    @FXML
    private TextField txtIngredient;
    
    @FXML
    private Button btnUpdate;
    
    @FXML
    private TextField txtResult;
    
    @FXML
    private TextField txtMeasurement;
    
    @FXML
    private TextField txtDescription;
    
    @FXML
    private Label LabelID;
    
    //initialiser les données dans le combobox
	@FXML
    private void initialize() throws Exception
    {
    	ObservableList<Recipes> RecipeList=RecipesDAO.getAllRecords();
    	//
    	cboID.setItems(RecipeList);
    	cboID.valueProperty().addListener((obs, oldVal, newVal) ->
        showDetails(newVal));
    	
    }

	  /*
     * Afficher les détails
     *
     */
    
    public void showDetails(Recipes recipe)
    {
        if(recipe!=null)
        {
            btnAdd.setDisable(true);
            //LabelID.setText(String.valueOf(recipe.getId()));//nullpointerexception here
            txtQuantity.setText(Integer.toString(recipe.getQuantity()));
            txtIngredient.setText(recipe.getIngredient());
            txtMeasurement.setText(Integer.toString(recipe.getMeasurement()));
            txtDescription.setText(recipe.getDescription());
            
        }
        else
        {
            btnAdd.setDisable(false);
            LabelID.setText("");
            txtQuantity.setText("");
            txtIngredient.setText("");
            txtMeasurement.setText("");
            txtDescription.setText("");
        }
    }

    
    /*
     * Insert a new recipe
     */
    @FXML
    private void insertRecipe (ActionEvent event) throws ClassNotFoundException, SQLException
    {
        RecipesDAO.insertRecipe(txtQuantity.getText(), txtIngredient.getText(), txtMeasurement.getText(),txtDescription.getText());
        txtResult.setText("Ingredient put into the database.");
    }
    
    /*
     * Modification de données of the recipe dans la base de données
     */
    @FXML
    private void modifyRecipe (ActionEvent event) throws ClassNotFoundException, SQLException
    {
        try
        {
            RecipesDAO.updateRecipe(Integer.parseInt(LabelID.getText()), txtQuantity.getText(), txtIngredient.getText(), txtMeasurement.getText(), txtDescription.getText());
            txtResult.setText("The values of " +txtIngredient.getText()+ " are put up to date" );
            // réinitialiser
            ObservableList<Recipes> RecipesList=RecipesDAO.getAllRecords();
            cboID.setItems(RecipesList);
            
        }
        catch(SQLException e)
        {
            System.out.println("Error - the values of "+txtIngredient +" were unable to be put up to date"+ e);
            e.printStackTrace();
            throw e;
        }
    }

    /*
     * Effacer les données
     *
     */
    @FXML
    private void deleteRecipe(ActionEvent event) throws ClassNotFoundException, SQLException
    {
        try
        {
            RecipesDAO.deleteRecipeById(Integer.parseInt(LabelID.getText()));
            txtResult.setText("Database results were erased.");
            ObservableList<Recipes> RecipesList=RecipesDAO.getAllRecords();
            cboID.setItems(RecipesList);
           
           
            
        }
        catch(SQLException e)
        {
            System.out.println("Unable to delete recipe values " + e);
            e.printStackTrace();
            throw e;
        }
    }

}
