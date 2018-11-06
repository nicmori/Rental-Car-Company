public class Standard extends Vehicle{
	public Standard(String carType, String carName, double carMileage) {
		maxPassengers = 5;
		rentalCost = 55.00;
		comfortLevel = "Good";
		carCategory = carType;
		name = carName;
		mileage= carMileage;
	}
}