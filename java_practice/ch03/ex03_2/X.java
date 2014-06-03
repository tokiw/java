package ex03_2;

public class X {
	
	/* à–¾•·‚¢‚Ä’Ç‹L
	 * {
		showMask("‰Šú‰»");
	}*/
	
	protected int xMask = 0x00ff;
	protected int fullMask;
	
	public X() {
		this.showMask("X field initialization");
		fullMask = xMask;
		this.showMask("Execution X constructor");
	}
	public int mask(int orig) {
		return (orig & fullMask);
	}
	
	public void showMask(String msg) {
		System.out.printf("x y full : 0x%04x 0x%04x : %s%n", xMask, fullMask, msg);
	}
}