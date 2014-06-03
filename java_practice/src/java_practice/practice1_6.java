package java_practice;

public class practice1_6 {
	static final String TITLE = "Fibonacci";
	public static void main(String[] args) {
		System.out.println(TITLE);
		int lo = 1,
			hi = 1;
		System.out.println(lo);
		while(hi < 50) {
			System.out.println(hi);
			hi = hi + lo;
			lo = hi - lo;
		}
	}
}