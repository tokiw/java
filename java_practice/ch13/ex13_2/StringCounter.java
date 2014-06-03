package ex13_2;

public class StringCounter {
	public int countStr(String str, String keyword) {
		if(str == null || keyword == null) {
			throw new NullPointerException();
		}
		if(keyword == "") {
			return 0;
		}
		int count = 0;
		int start = 0;
		while(!(str.indexOf(keyword, start) < 0)) {
			start = str.indexOf(keyword, start);
			start++;
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		StringCounter strCount = new StringCounter();
		System.out.println(strCount.countStr("asdfafaagaa", "a"));
		System.out.println(strCount.countStr("", ""));
	}
}
