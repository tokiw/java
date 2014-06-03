package ex03_10;

import ex03_9.Vehicle;

public class LinkedList implements Cloneable {
	private Object list;
	private LinkedList nextList;
	
	public LinkedList(Object list) {
		this.list = list;
	}
	
	public String toString() {
		String str = this.list.toString();
		
		return str;
	}
	
	public Object getList() {
		return list;
	}
	
	public LinkedList getNext() {
		return nextList;
	}
	
	public void setList(Object list) {
		this.list = list;
	}
	
	public void setNextList(LinkedList nextList) {
		this.nextList = nextList;
	}
	
	public int maxList() {
		int max = 1;
		if (this.nextList != null) {
			max += this.nextList.maxList();
		}
		return max;
	}
	
	public LinkedList clone(){
		try{
			LinkedList obj = (LinkedList) super.clone();
			if (this.nextList != null) {
				obj.setNextList(this.nextList.clone());
			}
			return obj;	
		}catch(CloneNotSupportedException e){
			throw new InternalError(e.toString());
		}
	}
	
	public static void main(String[] args) {
		Vehicle car = new Vehicle("Tanaka");
		Vehicle train = new Vehicle("Satoh");
		
		LinkedList vehicles = new LinkedList(car);
		vehicles.nextList = new LinkedList(train);
		System.out.println(vehicles);
		System.out.println(vehicles.nextList);
		LinkedList vehiclesClone = vehicles.clone();
		System.out.println(vehiclesClone);
		System.out.println(vehiclesClone.nextList);
		car.setOwnerName("Takahashi");
		System.out.println(vehiclesClone);

	}
}