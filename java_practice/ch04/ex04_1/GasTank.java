package ex04_1;

public class GasTank implements EnergySource {
	private int tank;
	private int tankMax = 200;
	
	public GasTank() {
		tank = tankMax;
	}
	public GasTank(int value) {
		if (value <= tankMax)
			tank = value;
		else
			tank = tankMax;
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
