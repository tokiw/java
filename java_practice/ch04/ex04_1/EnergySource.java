package ex04_1;

interface EnergySource {
	boolean empty();
	boolean fullTank();
	int getRemain();
	void supply(int value);
}
