package ex02_8;

public class LinkedList {
	Object list;
	LinkedList nextList;
	
	public LinkedList(Object list) {
		this.list = list;
	}
	
	public static void main(String[] args) {
		Vehicle car = new Vehicle();
		car.ownerName = "Tanaka";
		car.nowSpeed = 100;
		car.nowDirection = 90;
		Vehicle train = new Vehicle();
		train.ownerName = "Satoh";
		train.nowSpeed = 200;
		train.nowDirection = 100;
		
		LinkedList vehicles = new LinkedList(car);
		vehicles.nextList = new LinkedList(train);
		((Vehicle)vehicles.list).show();
		((Vehicle)vehicles.nextList.list).show();
	}
}

class Vehicle {
	double nowSpeed;
	double nowDirection;
	String ownerName;
	static int nextID = 0;
	int vehicleID;
	
	public void show() {
		System.out.println("èäóLé“: " + this.ownerName + " ë¨ìx: " + this.nowSpeed + " ï˚å¸: " + this.nowDirection);
	}
}