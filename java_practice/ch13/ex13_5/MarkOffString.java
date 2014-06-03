package ex13_5;

public class MarkOffString {
	private final int BREAKPOINT = 3;
	
	public String markOff(String str) {
		StringBuilder createdStr = new StringBuilder(str);
		int point = BREAKPOINT;
		while(point < createdStr.length()) {
			createdStr.insert(point, ',');
			point += BREAKPOINT + 1;
		}
		
		return createdStr.toString();
	}
	
	public static void main(String[] args) {
		System.out.println((new MarkOffString()).markOff("1234567890"));
	}
}
