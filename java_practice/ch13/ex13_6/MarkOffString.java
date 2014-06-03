package ex13_6;

public class MarkOffString {

	private int breakPoint;
	private String markOffStr;
	
	public MarkOffString() {
		this.breakPoint = 3;
		this.markOffStr = ",";
	}
	
	public MarkOffString(int point, String markOffChar) {
		this.breakPoint = point;
		this.markOffStr = markOffChar;
	}
	
	public String markOff(String str) {
		StringBuilder createdStr = new StringBuilder(str);
		int point = breakPoint;
		while(point < createdStr.length()) {
			createdStr.insert(point, markOffStr);
			point += breakPoint + 1;
		}
		
		return createdStr.toString();
	}
	
	public static void main(String[] args) {
		System.out.println((new MarkOffString(2, "#")).markOff("1234567890"));
		System.out.println((new MarkOffString()).markOff("1234567890"));
	}

}
