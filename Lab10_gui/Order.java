import java.util.ArrayList;
public class Order{
	String name;
	String address;
	String phone;
	boolean isDelivery;
	
	ArrayList<Pizza> listOfPizzas = new ArrayList<Pizza>();
	
	public Order(String argName, String argPhone){
		name=argName;
		phone=argPhone;
		address="N/A";
		isDelivery=false;
	
	}

	public Order(String argName, String argPhone, boolean argDelivery){
		name=argName;
		phone=argPhone;
		address="N/A";
		isDelivery=argDelivery;
	
	}

	public Order(String argName, String argAddress, String argPhone, boolean argDelivery){
		name=argName;
		phone=argPhone;
		address=argAddress;
		isDelivery=argDelivery;
	
	}
	
	//gets and sets for all attributes
	public void setName(String argName){
			name=argName;
		
	}
	
	public void setAddress(String argAddress){
			address=argAddress;
		
	}
	
	public void setPhone(String argPhone){
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
	
	public void addPizza(Pizza argPizza){
		listOfPizzas.add(argPizza);
	
	}

	public double calculateCost(){
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
	
	public double calculateBakeTime()
	{
			double bakeTime=0;
			for(int i=0;i<listOfPizzas.size();i++){
					Pizza p=listOfPizzas.get(i);
					if(p.calculateBakeTime()>bakeTime){
						bakeTime=p.calculateBakeTime();
					}
				
			}
			return bakeTime;
	}
	
	public void printReceipt(){
		for(int i=0;i<listOfPizzas.size();i++){
			System.out.println(listOfPizzas.get(i).toString());
			
		}
		System.out.println("Name: "+ name);
		System.out.println("Delivery "+ isDelivery);
	
		System.out.println("Total Cost: "+ calculateCost());
		System.out.println("Total Bake Time: "+ calculateBakeTime());
		
		
	}

	public String getOrderDetails() {
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