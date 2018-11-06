public class Van extends Vehicle{
	public Van(String carType, String carName, double carMileage) {
		maxPassengers = 7;
		rentalCost = 70.00;
		comfortLevel = "Medium";
		carCategory = carType;
		name = carName;
		mileage= carMileage;
	}
}