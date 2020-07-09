package ie.cct.farmmanagerca;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Telling Spring that this class is a controller and should be used as such
@RestController
public class FarmManagerCaController {
	
	
	private List<Item> items; // to store data in memory - using List Interface
	
	private double cowWeight, pigWeight, chiWeight; 
	private double cowPrice, pigPrice, chiPrice; 
	
	
	public FarmManagerCaController() {
		
		items = new ArrayList<Item>();
		
		//  kg		      //   €
		cowWeight = 300; cowPrice = 500;
		pigWeight =100;  pigPrice = 250;
		chiWeight = 0.5; chiPrice = 5;
	}
	
	
	
	// 1: Add a new animal
	// connecting the http into Java (into the addItem method)
	@PostMapping("add-item")  //SpringBoot and SpringWeb connect the http protocol into the java code
	public SuccessResponse addItem(@RequestBody Item item) { // need to identifying 
		items.add(item);
		return new SuccessResponse("Item " + item.getType() + " has been successfully added");
		
	}
	
	
	// 2:  Calculate the average weight of each type of animal
	@GetMapping("average-weight")
	public SuccessResponse averageWeight() {
		// firstly we detect a possible error situation
		if(items.size()==0) { // In this case it's when the arrayList is empty  
			throw new NotFoundException("No items found in the inventory"); // not really-  a checked exception. must be handled!!
			
		}
		double weight = 0.0f;
		for (Item item: items) {
			weight += item.getWeight();
		}
		double avWeight = weight/items.size();
		return new SuccessResponse("The average weight of the inventory is: " + avWeight);
	}
	
	// 3: How many animals of each type can be sold (weight requirements above) right now
	@GetMapping("number-animals")
	public SuccessResponse2 numberAnimals() { // I've created a SuccessResponse2 Class to return each type of animal
		//ArrayList<Item> itemsToSell = new ArrayList<Item>();
		int cowCount = 0;
		int pigCount = 0;
		int chiCount = 0;
		
		if(items.size()==0) {
			throw new NotFoundException("No items found in the warehouse");
		}
		for(int i=0; i<items.size(); i++) {
			if(items.get(i).getType().equalsIgnoreCase("cow")){
				if(items.get(i).getWeight()>=cowWeight) {
					//itemsToSell.add(items.get(i));
					cowCount++;
				}
			}
			else if(items.get(i).getType().equalsIgnoreCase("pig")){
				if(items.get(i).getWeight()>=pigWeight) {
					//itemsToSell.add(items.get(i)); 
					pigCount++;
				}
			}
			else if(items.get(i).getType().equalsIgnoreCase("chicken")){
				if(items.get(i).getWeight()>=chiWeight) {
					//itemsToSell.add(items.get(i));
					chiCount++;
				}	
			}
			
		}
		
		return new SuccessResponse2(cowCount, pigCount, chiCount); //using SuccessResponse2
		// If using the arrayList
		//return new SuccessResponse("The numbers of animals to sell is: " + itemsToSell.size());
		// using the SuccessResponse Class
		//return new SuccessResponse("The number of cows is " + cowCount +  ", the number of pigs: " + pigCount + " number of chicken: " + chiCount);
	}
	
	
	// 4: What is the current value of the full farm stock: That is, the price of all the animals
	//that can be sold right now.
	@GetMapping("value-stock")
	public SuccessResponse valueFullStock() {
		ArrayList<Double> valueToSell = new ArrayList<Double>();
		double valueOfStock = 0;
		
		if(items.size()==0) {
			throw new NotFoundException("No intems found in the warehouse");
		}
		for(int i=0; i<items.size(); i++) {
			if(items.get(i).getType().equalsIgnoreCase("cow")){
				if(items.get(i).getWeight()>=cowWeight) {
					valueToSell.add(cowPrice);			
				}
			}
			else if(items.get(i).getType().equalsIgnoreCase("pig")){
				if(items.get(i).getWeight()>=pigWeight) {
					valueToSell.add(pigPrice);			
				}
			}
			else if(items.get(i).getType().equalsIgnoreCase("chicken")){
				if(items.get(i).getWeight()>=chiWeight) {
					//valueToSell.add(items.get(i));
					//numChi++; I got this mistake by using the debug tool
					//double price =  chiPrice;
					valueToSell.add(chiPrice);
				}				
			}			
		}
		
		for (Double i : valueToSell) { // enhanced for-loop
			valueOfStock += i;
		}
		return new SuccessResponse("The value of the full farm is " + valueOfStock);
			
	}
		
	
	
	// 5: The current value of the farm assuming the price of each animal is set by a parameter in the HTTP request
	@GetMapping("current-value2")
	public SuccessResponse currentValue2(@RequestParam(required = true) double cow, @RequestParam(required = true) double pig, @RequestParam(required = true) double chicken) {
		double value = cow + pig + chicken;
		return new SuccessResponse("The current value of farm is " + value);

}
	}
