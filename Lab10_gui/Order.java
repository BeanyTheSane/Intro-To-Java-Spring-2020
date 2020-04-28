import java.util.ArrayList;
import java.util.regex.Pattern;
public class Order{
	String name;
	String address;
	String phone;
	boolean isDelivery;
	
	ArrayList<Pizza> listOfPizzas = new ArrayList<Pizza>();
	
	public Order(String argName, String argPhone) throws OrderException {
		setDelivery(false);
		setName(argName);
		setAddress("N/A");
		setPhone(argPhone);
	
	}

	public Order(String argName, String argPhone, boolean argDelivery) throws OrderException {
		setDelivery(argDelivery);
		setName(argName);
		setAddress("N/A");
		setPhone(argPhone);
	
	}

	public Order(String argName, String argAddress, String argPhone, boolean argDelivery) throws OrderException {
		setDelivery(argDelivery);
		setName(argName);
		setAddress(argAddress);
		setPhone(argPhone);
	
	}
	
	//gets and sets for all attributes
	public void setName(String argName) throws OrderException {
		final Pattern regexPattern = Pattern.compile("^.{1,32}$");
		if (argName.equals("")) {
			throw new OrderException("Please Enter A Name");
		}
		if (!regexPattern.matcher(argName).matches()) {
			throw new OrderException("Please limit names to less than 32 characters for this test");
		}
			name=argName;
		
	}
	
	public void setAddress(String argAddress) throws OrderException {
		final Pattern regexPattern = Pattern.compile("^[a-zA-Z0-9., /]{1,255}$");
		if (this.isDelivery && argAddress.equals("N/A")) {
			throw new OrderException("Please Enter an Address");
		}
		if (!regexPattern.matcher(argAddress).matches()) {
			throw new OrderException("Address Must use only letters, numbers, or these special characters (. , - /) and use less than 255 Characters");
		}
			address=argAddress;
		
	}
	
	public void setPhone(String argPhone) throws OrderException {
		final Pattern regexPattern = Pattern.compile("^[0-9]{3}[-]{1}[0-9]{3}[-]{1}[0-9]{4}$");
		if (argPhone.equals("")) {
			throw new OrderException("Please Enter A Phone");
		}
		if (!regexPattern.matcher(argPhone).matches()) {
			throw new OrderException("Please use the following format ###-###-####");
		}
			phone=argPhone;
		
	}
	
	public void setDelivery(boolean argDelivery){
			isDelivery=argDelivery;
		
	}
	
	public String getName(){
		return name;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public boolean getDelivery(){
		return isDelivery;
	}
	
	public void addPizza(Pizza argPizza) {
		listOfPizzas.add(argPizza);
	
	}

	public double calculateCost() throws OrderException {
		if (listOfPizzas.isEmpty()) {
			throw new OrderException("Please Add Pizzas to the list.  Try Again");
		}
		double cost=0;
		
		//loop thru all pizzas
		for(int i=0;i<listOfPizzas.size();i++){
			//get next pizzas
			Pizza p=listOfPizzas.get(i);
			
			//add cost of that pizza to order cost
			cost=cost+p.calculateCost();
			
			//shorthand - replace 2 statements above with
			//cost=cost+listOfPizzas.get(i).calculateCost();
			
		}
		
		//if delivery, add $2
		if (isDelivery){
			cost=cost+2;
		}
		//return cost of order
		return cost;
		
	}
	
	public double calculateBakeTime() throws OrderException 
	{
		if (listOfPizzas.isEmpty()) {
			throw new OrderException("Please Add Pizzas to the list.  Try Again");
		}
			double bakeTime=0;
			for(int i=0;i<listOfPizzas.size();i++){
					Pizza p=listOfPizzas.get(i);
					if(p.calculateBakeTime()>bakeTime){
						bakeTime=p.calculateBakeTime();
					}
				
			}
			return bakeTime;
	}
	
	public void printReceipt() throws OrderException {
		if (listOfPizzas.isEmpty()) {
			throw new OrderException("Please Add Pizzas to the list.  Try Again");
		}
		for(int i=0;i<listOfPizzas.size();i++){
			System.out.println(listOfPizzas.get(i).toString());
			
		}
		System.out.println("Name: "+ name);
		System.out.println("Delivery "+ isDelivery);
	
		System.out.println("Total Cost: "+ calculateCost());
		System.out.println("Total Bake Time: "+ calculateBakeTime());
		
		
	}

	public String getOrderDetails()  throws OrderException {
		if (listOfPizzas.isEmpty()) {
			throw new OrderException("Please Add Pizzas to the list.  Try Again");
		}
		String deliveryChoice = isDelivery ? "Delivery" : "Pick-Up";
		String deliveryTime = isDelivery ? Double.valueOf(calculateBakeTime() + Double.valueOf("15")).toString() :   Double.valueOf(calculateBakeTime()).toString();
		return "Name: " + getName()
			+ "\nAddress: " + getAddress()
			+ "\nPhone: " + getPhone()
			+ "\n" + deliveryChoice
			+ "\nEST Delivery: " + deliveryTime + " minutes"
			+ "\nCost: " + calculateCost();
	}

}