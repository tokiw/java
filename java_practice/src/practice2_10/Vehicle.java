package practice2_10;

public class Vehicle {
	double now_speed;
	double now_angle;
	String owner_name;
	static int nextID = 0;
	int vehicle_id;
	
	Vehicle() {
		
	}
	Vehicle(String owner) {
		owner_name = owner;
	}
	public static void main(String[] args) {
		Vehicle car = new Vehicle("Tanaka");
		Vehicle train = new Vehicle("Satoh");
		
		car.vehicle_id = nextID++;
		train.vehicle_id = nextID++;
		System.out.println("車: " + car);
		System.out.println("電車: " + train);
		
		System.out.println("最大識別番号: " + lastVehicleID());
	}
	
	static int lastVehicleID() {
		return nextID;
	}
	
	public String toString(){
		String desc = vehicle_id + "(" + owner_name + ")";
		return desc;
	}
}