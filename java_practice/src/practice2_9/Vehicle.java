package practice2_9;

public class Vehicle {
	double nowSpeed;
	double nowDirection;
	String ownerName;
	static int nextID = 0;
	int vehicleID;
	
	public void show() {
		System.out.println("���L��: " + this.ownerName + " ���x: " + this.nowSpeed + " ����: " + this.nowDirection);
	}
	
	Vehicle() {
		
	}
	Vehicle(String owner) {
		ownerName = owner;
	}
	
	Vehicle(String owner, double speed, double direction) {
		ownerName = owner;
		nowSpeed = speed;
		nowDirection = direction;
	}
	
	public static void main(String[] args) {
		Vehicle car = new Vehicle("Tanaka", 100, 90);
		Vehicle train = new Vehicle("Satoh", 200, 100);
		
		car.vehicleID = nextID++;
		train.vehicleID = nextID++;
		car.show();
		train.show();
		
		System.out.println("�ő厯�ʔԍ�: " + lastVehicleID());
	}
	
	static int lastVehicleID() {
		return nextID;
	}
}