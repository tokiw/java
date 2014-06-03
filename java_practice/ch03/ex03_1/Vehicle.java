package ex03_1;

public class Vehicle {
	private double nowSpeed;
	private double nowDirection;
	private String ownerName;
	private static int nextID = 1;
	private int vehicleID;
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
	public void turn(int turnDirection) {
		if (turnDirection == 1)
			nowDirection -= 90;
		if (turnDirection == 0)
			nowDirection += 90;
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
	
	/*コンストラクタ*/
	Vehicle() {
		this.vehicleID = nextID++;
	}
	Vehicle(String owner) {
		this();
		ownerName = owner;
	}
	
	Vehicle(String owner, double speed, double direction) {
		this(owner);
		nowSpeed = speed;
		nowDirection = direction;
	}
	
	/*main
	public static void main(String[] args) {
		Vehicle car = new Vehicle("Tanaka", 100, 90);
		Vehicle train = new Vehicle("Satoh", 200, 100);
		
		System.out.println(car);
		System.out.println(train);
		
		car.turn(45.5);
		train.turn(TURN_LEFT);
		System.out.println(car);
		System.out.println(train);
		
		System.out.println("最大識別番号: " + lastVehicleID());
	}
	
	static int lastVehicleID() {
		return nextID - 1;
	}*/
}