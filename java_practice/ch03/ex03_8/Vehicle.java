package ex03_8;

public class Vehicle implements Cloneable {
	private double nowSpeed;
	private double nowDirection;
	private String ownerName;
	private static int nextID = 1;
	private final int vehicleID;
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
	
	public Vehicle clone(){
		//return new Vehicle(this.ownerName, this.nowSpeed, this.nowDirection);
		try{
			Vehicle obj = (Vehicle)super.clone();
			obj.ownerName = this.ownerName;
			obj.nowSpeed = this.nowSpeed;
			obj.nowDirection = this.nowDirection;
			return obj;
		}catch(CloneNotSupportedException e){
			throw new InternalError(e.toString());
		}
	}
		
	/*コンストラクタ*/
	Vehicle() {
		ownerName = "none";
		nowSpeed = 0;
		nowDirection = 0;
		vehicleID = nextID++;
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
		
	public static int lastVehicleID() {
		return nextID - 1;
	}
}