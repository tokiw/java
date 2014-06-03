package ex03_9;

public class Garage implements Cloneable {
	private Vehicle[] garages;
	private static int vehicleNum = -1;
	private static final int maxVehicleNum = 10;
	
	public void push(Vehicle vehicle) {
			garages[++vehicleNum] = vehicle;
	}
	
	public Garage clone() {
		try{
			Garage obj = (Garage) super.clone();
			obj.garages = this.garages;
			return obj;
		}catch(CloneNotSupportedException e){
			throw new InternalError(e.toString());
		}
	}
	
	public void dispOwnerName() {
		for(int i=0; i < this.garages.length; i++) {
			if (this.garages[i] != null) {
				System.out.println(this.garages[i].getOwnerName());
			}
		}
	}

	
	public Garage() {
		garages = new Vehicle[maxVehicleNum];
	}
	
	public static void main(String[] args) {
		Vehicle car = new Vehicle("Tanaka");
		Vehicle bike = new Vehicle("Suzuki");
		Vehicle bus = new Vehicle("Satoh");
		Garage garage1 = new Garage();
		garage1.push(car);
		garage1.push(bike);
		garage1.push(bus);
		
		garage1.dispOwnerName();
		Garage garage2 = garage1.clone();
		garage2.dispOwnerName();
	}
}
