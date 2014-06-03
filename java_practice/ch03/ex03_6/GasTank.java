package ex03_6;

public class GasTank extends EnergySource {
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
