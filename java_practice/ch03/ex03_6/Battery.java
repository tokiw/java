package ex03_6;

public class Battery extends EnergySource {
	private int tank;
	private int tankMax = 100;
	
	public Battery() {
		tank = tankMax;
	}
	public Battery(int value) {
		if (value == tankMax)
		tank = value;
	}
	
	@Override
	boolean empty() {
		if (tank == 0)
			return true;
		else
			return false;
	}
	
	@Override
	boolean fullTank() {
		if (tank == tankMax)
			return true;
		else
			return false;
	}
	
	@Override
	int getRemain() {
		return tank;
	}
	
	@Override
	void supply(int value) {
		tank = getRemain() + value;
		if (tank >= tankMax)
			tank = tankMax;
	}
}

