package ex01_14;

public class WalkmanSecond extends WalkmanFirst {
	private String status1 = "off";
	private String status2 = "off";
	
	public void out1() {
		status1 = "on";
	}
	
	public void out2() {
		status2 = "on";
	}
	
	public void outBoth() {
		out1();
		out2();
	}
	
	public static void main(String[] srgs) {
		WalkmanSecond wm = new WalkmanSecond();
		wm.setMusic("Ç”ÇÈÇ≥Ç∆");
		wm.start();
		wm.outBoth();
		System.out.println("ã»ñº: " + wm.getMusic() + " èoóÕ1: " + wm.status1 + " èoóÕ2: " + wm.status2);
	}
}
