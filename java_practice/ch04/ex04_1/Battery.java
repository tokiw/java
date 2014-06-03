package ex04_1;

public class Battery implements EnergySource {
	private int tank;
	private int tankMax = 100;
	
	public Battery() {
		tank = tankMax;
	}
	
	public Battery(int value) {
		if (value == tankMax)
		tank = value;
	}
	
	public boolean empty() {
		if (tank == 0)
			return true;
		else
			return false;
	}
	
	public boolean fullTank() {
		if (tank == tankMax)
			return true;
		else
			return false;
	}
	
	public int getRemain() {
		return tank;
	}
	
	public void supply(int value) {
		tank = getRemain() + value;
		if (tank >= tankMax)
			tank = tankMax;
	}
}