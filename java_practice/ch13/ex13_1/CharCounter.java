package ex13_1;

public class CharCounter {
	public int countStr(String str, char ch) {
		if(str == null) {
			throw new NullPointerException();
		}
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ch) {
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		CharCounter strCount = new CharCounter();
		System.out.println(strCount.countStr("asdfafaagaa", 'a'));
	}
}
