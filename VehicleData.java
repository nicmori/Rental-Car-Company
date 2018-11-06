import java.util.ArrayList;

public class VehicleData {
	ArrayList<Vehicle> vehicleList;
	
	public VehicleData() {
		vehicleList = new ArrayList<Vehicle>();
		vehicleList.add(new Economy("Dodge Viper", 14.00));
		vehicleList.add(new Economy("Honda Civic", 34.00));
		vehicleList.add(new Economy("Dodge Challenger", 23.00));
		vehicleList.add(new Intermediate("Sedan", "Honda Accord", 33.00));
		vehicleList.add(new Intermediate("Sedan", "Dodge Charger", 23.00));
		vehicleList.add(new Intermediate("Hybrid", "Ford Fusion", 42.00));
		vehicleList.add(new Intermediate("Hybrid", "Kia Optima", 42.00));
		vehicleList.add(new Standard("Truck", "Ford F-150", 22.00));
		vehicleList.add(new Standard("Truck", "Chevrolet Silverado 1500", 20.00));
		vehicleList.add(new Standard("Crossover", "Ford Edge", 24.00));
		vehicleList.add(new Standard("Crossover", "Ford Explorer", 22.00));
		vehicleList.add(new Standard("SUV", "Honda Pilot", 22.00));
		vehicleList.add(new Standard("SUV", "Mitsubishi Outlander", 27.00));
		vehicleList.add(new Van("Van", "Honda Odyssey", 22.00));
		vehicleList.add(new Van("Van", "Nissan Quest", 22.00));
	}
	
	public ArrayList<Vehicle> filterList(int numOfPassengers){
		ArrayList<Vehicle> filteredList = new ArrayList<Vehicle>();
		for(int index = 0; index < vehicleList.size(); index++) {
			if(vehicleList.get(index).getPassengers()>=numOfPassengers) {
				filteredList.add(vehicleList.get(index));
			}
		}
		return filteredList;
	}
}
