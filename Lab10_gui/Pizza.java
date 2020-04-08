
public class Pizza{

	//attributes
	private String size;
	private String crust;
	private boolean hasPepperoni;
	
	public Pizza(String argSize, String argCrust, boolean argPepperoni){
		size=argSize;
		crust=argCrust;
		hasPepperoni=argPepperoni;
	}
	
	public Pizza(String argSize, String argCrust){
		size=argSize;
		crust=argCrust;
		hasPepperoni=true;
	}
	
	public void setSize(String arg){
		size=arg;
	}
	public void setCrust(String arg){
		crust=arg;
	}
	public void setHasPepperoni(boolean arg){
		hasPepperoni=arg;
	}

	public String getSize(){
		return size;
	}

	public String getCrust(){
		return crust;
	}

	public boolean getHasPepperoni(){
		return hasPepperoni;
	}

	public double calculateBakeTime(){
		double bakeTime=0;
		if (crust.toLowerCase().equals("thin")){
			bakeTime= 10;
		}
		else if (crust.toLowerCase().equals("deep dish")) {
			bakeTime= 20;
		}
		else {
			bakeTime= 16;
		}
		return bakeTime;
	}
	
	public double calculateCost(){
		double cost=0;
		
		if (size.equals("S")){
			cost=6;
		}
		
		if (size.equals("M")){
			cost=8;
		}
		
		if (size.equals("L")){
			cost=10;
		}
		
		if(hasPepperoni){
			cost=cost+2;
			
		}
		
		return cost;
	}

	public String toString(){
			String result;
			
			result="Crust: "+ crust +
					"Size: "+ size +
					"Pepperoni: "+ hasPepperoni +
					"Cost " + calculateCost();
					
			return result;
	}
}

