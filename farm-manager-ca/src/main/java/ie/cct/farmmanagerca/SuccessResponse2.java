package ie.cct.farmmanagerca;

// this class is just to return the number of each type of animals for the 3rd operation
public class SuccessResponse2 {
	
	private int numberOfCows;
	private int numberOfPigs;
	private int numberOfChickens;
	
	public SuccessResponse2(int numberOfCows, int numberOfPigs, int numberOfChickens) {
		//super();
		this.numberOfCows = numberOfCows;
		this.numberOfPigs = numberOfPigs;
		this.numberOfChickens = numberOfChickens;
	}

	public int getNumberOfCows() {
		return numberOfCows;
	}

	public void setNumberOfCows(int numberOfCows) {
		this.numberOfCows = numberOfCows;
	}

	public int getNumberOfPigs() {
		return numberOfPigs;
	}

	public void setNumberOfPigs(int numberOfPigs) {
		this.numberOfPigs = numberOfPigs;
	}

	public int getNumberOfChickens() {
		return numberOfChickens;
	}

	public void setNumberOfChickens(int numberOfChickens) {
		this.numberOfChickens = numberOfChickens;
	}
	
	

}
