import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RentalCarCompany {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		//List of all available vehicles
		VehicleData vehicleData = new VehicleData();

		//Gets number of Passengers
		System.out.println("Please enter the number of passengers: ");
		int numOfPassengers = GetValidInt();

		//Gets number of days
		System.out.println("Please enter the number of days you plan to rent the car: ");
		int numOfDays = GetValidInt();

		//Gets number of miles
		System.out.println("Please enter the number of miles you plan to travel: ");
		double miles = GetValidDouble();

		//Gets list of possible vehicles for the customers
		ArrayList<Vehicle> filteredList = vehicleData.filterList(numOfPassengers);

		//If there are no solutions
		if (filteredList.size() == 0)
			System.out.println("There are no vehicles can fulfill your request.");

		//If there is vehicles that fit the parameters
		else {
			//Calculate the prices for all solutions
			for(int index = 0; index < filteredList.size(); index++) {
				filteredList.get(index).calculatePrice(numOfDays, miles);
			}

			//Sort the solutions
			Collections.sort(filteredList, new VehicleSorter());

			//Print the solutions
			for (int index = 0; index < filteredList.size(); index++) {
				System.out.println(filteredList.get(index));
				System.out.println();
			}
		}
	}

	/* Will execute until the user gives a double/int value greater then 0 */
	private static double GetValidDouble() {
		double input = -1.0;
		boolean isValidMiles = false;
		while (!isValidMiles) {
			while (!scan.hasNextDouble()) {
				System.out.println("Please enter a valid value!");
				scan.next();
			}

			input = scan.nextDouble();

			if (input > 0) isValidMiles = true;
			else System.out.println("Please enter a valid value (Greater then zero)!");
		}

		return input;
	}

	/* Will execute until the user gives an int value that is greater then 0 */
	private static int GetValidInt() {
		int input = -1;
		boolean isValidMiles = false;
		while (!isValidMiles) {
			while (!scan.hasNextDouble()) {
				System.out.println("Please enter a valid value!");
				scan.next();
			}

			input = scan.nextInt();

			if (input > 0) isValidMiles = true;
			else System.out.println("Please enter a valid value (Greater then zero)!");
		}

		return input;
	}
}
