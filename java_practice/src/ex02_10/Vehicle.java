package ex02_10;

public class Vehicle {
	double nowSpeed;
	double nowDirection;
	String ownerName;
	static int nextID = 0;
	int vehicleID;
	
	public void show() {
		System.out.println("���L��: " + this.ownerName + " ���x: " + this.nowSpeed + " ����: " + this.nowDirection);
	}
	
	public String toString() {
		String str = "���L��: " + this.ownerName + " ���x: " + this.nowSpeed + " ����: " + this.nowDirection;
		
		return str;
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
		System.out.println(car);
		System.out.println(train);
		
		System.out.println("�ő厯�ʔԍ�: " + lastVehicleID());
	}
	
	static int lastVehicleID() {
		return nextID;
	}
}