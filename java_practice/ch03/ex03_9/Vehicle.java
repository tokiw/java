package ex03_9;

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
	public Vehicle() {
		ownerName = "none";
		nowSpeed = 0;
		nowDirection = 0;
		this.vehicleID = nextID++;
	}
	public Vehicle(String owner) {
		this();
		ownerName = owner;
	}
	
	public Vehicle(String owner, double speed, double direction) {
		this(owner);
		nowSpeed = speed;
		nowDirection = direction;
	}
		
	static int lastVehicleID() {
		return nextID - 1;
	}
}