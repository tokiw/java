package ex03_6;

public abstract class EnergySource {
	abstract boolean empty();
	abstract boolean fullTank();
	abstract int getRemain();
	abstract void supply(int value);
}
