package ex03_1;

public class passengerVehicle extends Vehicle {
	private int seatsNum;
	private int passengerNum;
	
	public passengerVehicle(String owner) {
		super(owner);
	}
	
	public passengerVehicle(String owner, int seatsNum, int passengerNum){
		super(owner);
		this.seatsNum = seatsNum;
		this.passengerNum = passengerNum;
	}
	
	public int getSeatsNum(){
		return seatsNum;
	}
	
	public int getPassengerNum(){
		return passengerNum;
	}
	
	public void setSeatsNum(int seatsNum){
		this.seatsNum = seatsNum;
	}

	public void setPassengerNum(int passengerNum){
		this.passengerNum = passengerNum;
	}

	public String toString() {
		String str = "所有者: " + this.getOwnerName() + " 座席数: " + this.seatsNum + " 乗車数: " + this.passengerNum;
		return str;
	}
	
	public static void main(String[] args) {
		passengerVehicle car = new passengerVehicle("Tanaka");
		passengerVehicle bike = new passengerVehicle("Suzuki", 1, 1);
		car.setPassengerNum(3);
		car.setSeatsNum(4);
		System.out.println(car);
		System.out.println(bike);
	}

}
