import java.text.DecimalFormat;

public class Vehicle {
	protected double mileage;
	protected String name;
	protected int maxPassengers;
	protected double rentalCost;
	protected String comfortLevel;
	protected String carCategory;
	private double totalPrice;
	
	public int getPassengers() {
		return maxPassengers;
	}
	
	public double getCost() {
		return rentalCost;
	}
	
	public String getComfortLevel() {
		return comfortLevel;
	}
	
	public int getComfortNum() {
		int comfort = 0;
		if (comfortLevel.equals("Medium")) {
			comfort = 1;
		} else if (comfortLevel.equals("Good")) {
			comfort = 2;
		}
		return comfort;
	}
	
	public String getCategory() {
		return carCategory;
	}
	
	public double getMileage() {
		return mileage;
	}
	
	public String getName() {
		return name;
	}
	
	public double getTotal() {
		return totalPrice;
	}
	
	public void calculatePrice(int numberOfDays, double milesInTrip) {
		double pricePerGallon = 2.25;
		double totalPrice = numberOfDays*rentalCost + (milesInTrip/mileage) * pricePerGallon - numberOfDays/5 * rentalCost;
		if(name.contains("Honda") && (carCategory.equals("Sedan")||carCategory.equals("Hybrid")||carCategory.equals("SUV"))) {
			totalPrice *= 1.1;
		}
		else if(name.contains("Chevrolet")||name.contains("Dodge")||name.contains("Ford")) {
			totalPrice *= 1.05;
		}
		DecimalFormat format = new DecimalFormat("#.##");
		this.totalPrice = new Double(format.format(totalPrice)).doubleValue();
	}
	
	public String toString() {
		String toReturn = "Car: " + name + "\nMaximum number of passengers: " + maxPassengers + "\nComfort Level: " + comfortLevel +"\nTotal Cost: " + totalPrice;
		return toReturn;
	}
}
