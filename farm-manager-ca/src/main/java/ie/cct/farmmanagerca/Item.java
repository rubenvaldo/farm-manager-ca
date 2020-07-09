package ie.cct.farmmanagerca;

// Inventory class
public class Item {
	
	// declaring the two properties 
	private String type;
	private double weight;

		
	public Item() {
	}
	
	
	
	public Item(String type, double weight) {
		//super();
		this.type = type;
		this.weight = weight;
	}



	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	

}
