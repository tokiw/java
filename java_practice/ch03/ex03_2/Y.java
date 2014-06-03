package ex03_2;

public class Y extends X {
	protected int yMask = 0xff00;
	
	public Y() {
		super();
		this.showMask("Y field initialization");
		fullMask |= yMask;
		this.showMask("Execution Y constructor");
	}
	
	public void showMask(String msg) {
		System.out.printf("x y full : 0x%04x 0x%04x 0x%04x : %s%n", xMask, yMask, fullMask, msg);
	}
	
	public static void main (String[] args) {
		Y y = new Y();
	}
}