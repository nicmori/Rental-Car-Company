import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class MyTests {
    
    @Test
  //tests filterList path coverage (1,2,7)
    public void filter_list_max() {
        
    	VehicleData vehicleData = new VehicleData();
    	
    	int numOfPassengers = 8;
    	ArrayList<Vehicle> filteredList = vehicleData.filterList(numOfPassengers);
    	
    	ArrayList<Vehicle> emptyList = new ArrayList<Vehicle>();
    	
    	assertEquals(emptyList,filteredList);
    }
    
    //tests filterList path coverage (1,2,3,5,6,7)
    @Test
    public void filter_list_van() {
        
    	VehicleData vehicleData = new VehicleData();
    	int numOfPassengers = 7;
    	ArrayList<Vehicle> filteredList = vehicleData.filterList(numOfPassengers);
    	
    	ArrayList<Vehicle> vanList = new ArrayList<Vehicle>();

		vanList.add(new Van("Van", "Honda Odyssey", 22.00));
		vanList.add(new Van("Van", "Nissan Quest", 22.00));
		
    	assertEquals(vanList.get(0).name,filteredList.get(0).name);
    }
    
    @Test
    //tests VehicleSorter path (1,2,4)
    public void sorter_test() {
    	VehicleSorter v_sorter = new VehicleSorter();

    	Vehicle one = new Van("Van ", "Honda Odyssey", 22.00);
    	Vehicle two = new Van("Van", "Nissan Quest", 22.00);
    	
    	int num = v_sorter.compare(one, two);
    	
    	assertEquals(0,num);
    }
    
    @Test
    //tests VehicleSorter path (1,2,3)
    //tests calculatePrice (1,2,3,5) and (1,2,4,5)
    //tests getComfortNum (1,3,5) 
    public void sorter_test_diff() {
    	VehicleSorter v_sorter = new VehicleSorter();

    	Vehicle one = new Intermediate("Sedan", "Honda Accord", 33.00);
    	Vehicle two = new Standard("Crossover", "Ford Edge", 24.00);
    	

    	int cfn = one.getComfortNum();
    	one.calculatePrice(5, 5);
    	two.calculatePrice(5, 500);
    	
    	int num = v_sorter.compare(two, one);
    	
    	assertEquals(59,num);
    	//System.out.println(num);
    }
    
    
    @Test
    //tests getComfortNum (1,2,5) (1,4,5)
    //tests calculatePrice (1,2,4,5)
    //adds coverage for all gets in Vehicle
    public void get_test() {
    	VehicleSorter v_sorter = new VehicleSorter();
    	
    	ArrayList<Vehicle> vanList = new ArrayList<Vehicle>();

    	Vehicle one = new Standard("Truck", "Chevrolet Silverado 1500", 20.00);
    	Vehicle two = new Standard("SUV", "Mitsubishi Outlander", 27.00);
    	Vehicle three = new Economy("Dodge Viper", 14.00);
    	
    	one.calculatePrice(5, 5);
    	one.calculatePrice(5, 500);
    	two.calculatePrice(5, 5);
    	
    	double cost_one = one.getCost();
    	String tostring_one = one.toString();
    	String comfort_lvl = one.getComfortLevel();
    	String cat = one.getCategory();
    	double mil = one.getMileage();
    	String name = one.getName();
    	int cfn = one.getComfortNum();
    	int cfn2 = two.getComfortNum();
    	int cfn3 = three.getComfortNum();
    	
    	assertEquals(2,cfn);
    	assertEquals(2,cfn2);
    	assertEquals(0,cfn3);
    	
    	assertEquals(55.0,cost_one);

    	String exp_ts ="Car: Chevrolet Silverado 1500\r\nMaximum number of passengers: 5\r\nComfort Level: Good\r\nTotal Cost: 290.06";
    	String exp_cl = "Good";
    	String exp_cat = "Truck";
    	double exp_mil = 20.0;
    	String exp_name = "Chevrolet Silverado 1500";

    	assertEquals(exp_cl,comfort_lvl);
    	assertEquals(exp_cat,cat);
    	assertEquals(exp_mil,mil);
    	assertEquals(exp_name,name);
    	

    }

    
    
	
}
