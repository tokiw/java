package practice2_5;

public class Vehicle {
	double nowSpeed;
	double nowDirection;
	String ownerName;
	static int nextID = 0;
	int vehicleID;
	
	public void show() {
		System.out.println("èäóLé“: " + this.ownerName + " ë¨ìx: " + this.nowSpeed + " ï˚å¸: " + this.nowDirection);
	}
	
	public static void main(String[] args) {
		Vehicle car = new Vehicle();
		Vehicle train = new Vehicle();
		
		car.vehicleID = nextID++;
		car.ownerName = "Tanaka";
		car.nowSpeed = 100;
		car.nowDirection = 90;
		
		train.vehicleID = nextID++;
		train.ownerName = "Satoh";
		train.nowSpeed = 200;
		train.nowDirection = 100;
		car.show();
		train.show();
		
	}
}
