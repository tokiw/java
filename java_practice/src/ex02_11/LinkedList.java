package ex02_11;

public class LinkedList {
	Object list;
	LinkedList nextList;
	
	public LinkedList(Object list) {
		this.list = list;
	}
	
	/*public LinkedList(Object list1, Object list2) {
		this.list = list1;
		this.list.nextList = new LinkedList(list2);
	}*/
	
	public String toString() {
		String str = this.list.toString();
		
		return str;
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
		
		System.out.println(vehicles);
		System.out.println(vehicles.nextList);
	}
}

class Vehicle {
	double nowSpeed;
	double nowDirection;
	String ownerName;
	static int nextID = 0;
	int vehicleID;
	
	public String toString() {
		String str = "所有者: " + this.ownerName + " 速度: " + this.nowSpeed + " 方向: " + this.nowDirection;
		
		return str;
	}
	
	public void show() {
		System.out.println("所有者: " + this.ownerName + " 速度: " + this.nowSpeed + " 方向: " + this.nowDirection);
	}
}