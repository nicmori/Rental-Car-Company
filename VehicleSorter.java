import java.util.Comparator;

public class VehicleSorter implements Comparator<Vehicle> {

	public int compare(Vehicle one, Vehicle two) {
		if (one.getTotal() == two.getTotal()) {
			return one.getComfortNum() - two.getComfortNum();
		}
		return (int) (one.getTotal() - two.getTotal());	
	}
}
