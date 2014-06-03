package ex19_1;


/**
 * LinkedList
 * 
 * @version 1.0
 * @author Masafumi Tokiwa
 * 
 */
public class LinkedList {
	private Object list;
	private LinkedList nextList;

	/** 
	 * @param list The list is stored in LinkedList
	 */
	public LinkedList(Object list) {
		this.list = list;
	}
		
	/**
	 * @return String of the contents of this LinkedList
	 */
	public String toString() {
		String str = this.list.toString();
		
		return str;
	}
	
	/**
	 * @return Contents of this LinkedList
	 */
	public Object getList() {
		return list;
	}
	
	/**
	 * 
	 * @return Next LinkedList
	 */
	public LinkedList getNext() {
		return nextList;
	}
	
	/** 
	 * @param list The list is stored in LinkedList
	 */
	public void setList(Object list) {
		this.list = list;
	}
	
	/** 
	 * @param nextList The nextList is set to next LinkedList
	 */
	public void setNextList(LinkedList nextList) {
		this.nextList = nextList;
	}
	
	/** 
	 * @return The maximum number of lists
	 */
	public int maxList() {
		int max = 1;
		if (this.nextList != null) {
			max += this.nextList.maxList();
		}
		return max;
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

/**
 * Vehicle
 * 
 */
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