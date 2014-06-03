package ex06_2;

public class Vehicle {
	private double nowSpeed;
	private double nowDirection;
	private String ownerName;
	private static int nextID = 0;
	private int vehicleID;
	enum Turn {
		LEFT,
		RIGHT,
	}
	private static final int TURN_LEFT =1;
	private static final int TURN_RIGHT = 0;
	
	public void show() {
		System.out.println("所有者: " + this.ownerName + " 速度: " + this.nowSpeed + " 方向: " + this.nowDirection);
	}
	
	public String toString() {
		String str = "所有者: " + this.ownerName + " 速度: " + this.nowSpeed + " 方向: " + this.nowDirection;
		
		return str;
	}
	
	public double getNowSpeed() {
		return nowSpeed;
	}
	public void changeSpeed(double speed) {
		nowSpeed = speed;
	}
	public void stop() {
		nowSpeed = 0;
	}
	
	public double getNowDirection() {
		return nowDirection;
	}
	
	public void turn(double direction) {
		nowDirection += direction;
	}
	public void turn(Turn direction) {
		switch (direction) {
		case LEFT:
			nowDirection -= 90;
			break;
		case RIGHT:
			nowDirection += 90;
			break;
		default:
			break;
		}
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String name) {
		ownerName = name;
	}
	
	public int getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(int id) {
		vehicleID = id;
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
		
		car.turn(45.5);
		train.turn(Turn.LEFT);
		System.out.println(car);
		System.out.println(train);
		
		System.out.println("最大識別番号: " + lastVehicleID());
	}
	
	static int lastVehicleID() {
		return nextID;
	}
}