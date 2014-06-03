package practice2_7;

public class Vehicle {
	double nowSpeed;
	double nowDirection;
	String ownerName;
	static int nextID = 0;
	int vehicleID;
	
	public void show() {
		System.out.println("èäóLé“: " + this.ownerName + " ë¨ìx: " + this.nowSpeed + " ï˚å¸: " + this.nowDirection);
	}
	
	Vehicle() {
		
	}
	Vehicle(String owner) {
		ownerName = owner;
	}
	
	public static void main(String[] args) {
		Vehicle car = new Vehicle("Tanaka");
		Vehicle train = new Vehicle("Satoh");
		
		car.vehicleID = nextID++;
		car.nowSpeed = 100;
		car.nowDirection = 90;
		
		train.vehicleID = nextID++;
		train.nowSpeed = 200;
		train.nowDirection = 100;
		car.show();
		train.show();
	}
}